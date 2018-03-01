package org.grameen.fdp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ApiVersionStrings;

import org.grameen.fdp.R;
import org.grameen.fdp.fragment.LogoutDialogFragment;
import org.grameen.fdp.fragment.MonitoringFormFragment;
import org.grameen.fdp.fragment.MyFormFragment;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RealPlot;
import org.grameen.fdp.object.SkipLogic;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DatabaseHelper;
import org.json.JSONException;
import org.json.JSONObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private static final String DOUBLE_LINE = "==============================================================================";
    private static final String SINGLE_LINE = "------------------------------------------------------------------------------";


    SharedPreferences prefs;
    DatabaseHelper databaseHelper;
    ScriptEngine engine;
    static String TAG = "BASE ACTIVITY";
    private String apiVersion;

    public static void showError(Context context, Exception e) {
        Toast toast = Toast.makeText(context,
                context.getString(
                        SalesforceSDKManager.getInstance().
                                getSalesforceR().stringGenericError(),
                        e.toString()),
                Toast.LENGTH_LONG);
        toast.show();
    }

    public static ProgressDialog showProgress(Context context, String title, String message, Boolean cancelable) {

        ProgressDialog progressDialog = new ProgressDialog(context, R.style.DialogTheme);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(cancelable);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        return progressDialog;


    }

    public static void printRequestInfo(long nanoDuration, int characterLength, int statusCode) {
        System.out.println(SINGLE_LINE);
        System.out.println("Time (ms): " + nanoDuration / 1000000);
        System.out.println("Size (chars): " + characterLength);
        System.out.println("Status code: " + statusCode);
    }

    public static void printException(Exception e) {
        System.out.println("Error: " + e.getClass().getSimpleName());
        System.out.println(e.getMessage());
        e.printStackTrace();

    }

    public static void printHeader(Object obj) {
        System.out.println(DOUBLE_LINE);
        System.out.println(obj.toString());
        System.out.println(SINGLE_LINE);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.right_slide, R.anim.slide_out_left);


        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        apiVersion = ApiVersionStrings.getVersionNumber(this);

        databaseHelper = DatabaseHelper.getInstance(this);


    }

    Toolbar setToolbar(String title) {

        Toolbar toolbar = null;
        try {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_white_24dp);


            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

        return toolbar;

    }

    public void showAlertDialog(Boolean cancelable, @Nullable String title, @Nullable String message,
                                @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                @NonNull String positiveText,
                                @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                @NonNull String negativeText, @Nullable int icon_drawable) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppDialog);
        builder.setTitle(title);
        builder.setCancelable(cancelable);


        if (icon_drawable != 0) builder.setIcon(icon_drawable);
        builder.setMessage(message);

        if (onPositiveButtonClickListener != null)
            builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        if (onNegativeButtonClickListener != null)
            builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // I do not want this...
                // Home as up button is to navigate to Home-Activity not previous acitivity
                super.onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);


    }

    void showSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    void hideSoftKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
    }

    public void logOut(final AppCompatActivity context) {


        LogoutDialogFragment logoutDialogFragment = new LogoutDialogFragment();
        logoutDialogFragment.show(getSupportFragmentManager(), "logoutDialog");


    }

    void onBackClicked() {

        try {

            findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onBackPressed();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    boolean hasPermissions(Context context, String permission) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {

            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {


                }
                return false;
            }

        }
        return true;
    }

    void loadDynamicView(MyFormFragment formFragment1, int layout1) {

        //Todo add parameter to load data from the database, if is in editing mode else display default forms with their resp values


        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(layout1, formFragment1, formFragment1.getClass().getSimpleName())
                //.add(layout2, formFragment2, formFragment2.getClass().getSimpleName())
                .commit();


    }

    void loadDynamicView(MonitoringFormFragment formFragment1, int layout1) {

        //Todo add parameter to load data from the database, if is in editing mode else display default forms with their resp values


        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(layout1, formFragment1, formFragment1.getClass().getSimpleName())
                //.add(layout2, formFragment2, formFragment2.getClass().getSimpleName())
                .commit();


    }
    String calculate(String equation) throws ScriptException {
        Double value = 0.0;
        try {
            value = (Double) new ScriptEngineManager().getEngineByName("rhino").eval(equation.trim());
        } catch (Exception e) {
            e.printStackTrace();
            value = 0.0;
        }

        return (new DecimalFormat("#.00").format(value));
    }


    Double calculateDouble(String equation){
        Log.i(TAG, "Evaluating " + equation);
        Double value = 0.0;
        try {
            value = (Double) new ScriptEngineManager().getEngineByName("rhino").eval(equation.trim());
        } catch (Exception e) {
            e.printStackTrace();
            value = null;
        }

        return value;
    }

    Boolean compareValues(SkipLogic sl, String newValue) {

        engine = new ScriptEngineManager().getEngineByName("rhino");

        String equation = sl.getAnswerValue() + sl.getLogicalOperator() + String.valueOf(newValue);

        Log.i("BASE ACTIVITY", "Equation is " + equation);

        boolean value = false;

        try {
            value = (Boolean) engine.eval(equation);

        } catch (ScriptException | NumberFormatException e) {
            System.out.println("******* EXCEPTION ****** " + e.getMessage());

            if(sl.getLogicalOperator().equalsIgnoreCase("=="))
            value = sl.getAnswerValue().equalsIgnoreCase(newValue);
            else value = !sl.getAnswerValue().equalsIgnoreCase(newValue);

        } finally {
            System.out.println(equation + " = " + value);
        }
        return value;
    }





    String applyCalculation(String equation) {

        System.out.println("EQUATION IS " + equation);

        String calculatedValue = "0";
        try {

            calculatedValue = calculate(equation);


        } catch (ScriptException e) {
            e.printStackTrace();
        }

        System.out.println("####### NEW VALUE IS " + calculatedValue);

        return calculatedValue;

    }

    public static class SpacesGridItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public SpacesGridItemDecoration(int space) {
            this.mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {


            outRect.bottom = mSpace;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildAdapterPosition(view) == 0 || parent.getChildAdapterPosition(view) == 1 || parent.getChildAdapterPosition(view) == 2) {
                outRect.top = mSpace * 2;
            } else {

                outRect.top = mSpace;

            }

            if (parent.getChildAdapterPosition(view) % 3 == 0) {
                outRect.right = mSpace * 2;
                outRect.left = mSpace;

            } else if (parent.getChildAdapterPosition(view) % 3 == 2) {
                outRect.left = mSpace * 2;
                outRect.right = mSpace;

            }

        }

    }


    public String toCamelCase(String value){

        if(value == null || value.equals("null")) return "";
        else {

            if(Character.isUpperCase(value.codePointAt(0)))
            return value;

            else
            return (value.substring(0, 1).toUpperCase() + value.substring(1, value.length()).toLowerCase());

        }
    }


    public void checkIfFarmProductionCorresponds(String farmerCode){

        Double totalFarmProduction = null;
        String totalUnit = "--";

        try{

            JSONObject farmingEconomicProfileJson = new JSONObject(databaseHelper.getFarmingEconomicProfileJson(farmerCode));
            totalFarmProduction = Double.parseDouble(farmingEconomicProfileJson.get(prefs.getString("totalProduction", "")).toString());

            totalUnit = farmingEconomicProfileJson.getString(prefs.getString("totalWeightUnit", ""));

        }catch(Exception e){
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringUnitBuilder = new StringBuilder();


        List<RealPlot> plots = databaseHelper.getAllFarmerPlots(farmerCode);




        for(RealPlot plot : plots){

            try {
                JSONObject jsonObject = new JSONObject(plot.getPlotInformationJson());

                String[] estimatedProductions = jsonObject.get("estimatedProduction").toString().split(" ");

                stringBuilder.append(estimatedProductions[0]).append("+");

                stringUnitBuilder.append(estimatedProductions[1]);


            } catch (JSONException  | NullPointerException e) {
                e.printStackTrace();
            }

        }


        stringBuilder.append("0");

        Double totalPlotsProduction = calculateDouble(stringBuilder.toString());

        Log.i(TAG, "$$$$$$$$$$$$$    TOTAL UNITS " + totalUnit + " AND TOTAL WEIGHTS " + stringUnitBuilder.toString());

        Log.i(TAG, "$$$$$$$$$$$$$    TOTAL FARM PROD " + totalFarmProduction + " AND TOTAL PLOTS PROD " + totalPlotsProduction);

        if(stringUnitBuilder.toString().toLowerCase().contains(totalUnit.toLowerCase())) {
            if (totalPlotsProduction != null && totalFarmProduction != null) {
                if (totalPlotsProduction > totalFarmProduction)

                    CustomToast.makeToast(this, getResources(R.string.error_total_plot_estimated_production), Toast.LENGTH_LONG).show();
            } else
                CustomToast.makeToast(this, getResources(R.string.error_missing_estimated_production), Toast.LENGTH_LONG).show();
        }else{
            CustomToast.makeToast(this, getResources(R.string.error_invalid_units), Toast.LENGTH_LONG).show();
        }




    }



    public String getResources(int resource){
        return getString(resource);
    }

   public  String parseIfFormula(String formula, JSONObject jsonObject) {

        String operator = "+";

        if(formula.contains("+")) operator = "+";
        else if (formula.contains("*")) operator = "*";
        else if (formula.contains("-")) operator = "-";
        else if (formula.contains("/")) operator = "/";

       Log.i(TAG, "OPERATOR IS IS " + operator);




       StringBuilder parsedFormula = new StringBuilder();

        Double finalValue = -1.0;

        try{

            List<String> questionNames = new ArrayList<>();
            List<String> valueToCompare = new ArrayList<>();
            List<String> trueValues = new ArrayList<>();
            List<String> falseValues = new ArrayList<>();


            String[] sections = formula.split("[-+*/]");
            Log.i(TAG, "FORMULA SECTIONS SIZE IS " + sections.length);

            for (int i = 0; i < sections.length; i++) {

                sections[i] = sections[i].replace("IF", "");
                sections[i] = sections[i].replace("(", "");
                sections[i] = sections[i].replace(")", "");
                sections[i] = sections[i].replace(" ", "");


                //Log.i(TAG, "AFTER CLEANSING " + sections[i]);

                String[] discard = sections[i].split("==");
                questionNames.add(discard[0]);
                //Log.i(TAG, "QUESTION NAME " + discard[0]);


                String[] values = discard[1].split(",");

                valueToCompare.add(values[0]);
                //Log.i(TAG, "VALUE TO COMPARE " + values[0]);

                trueValues.add(values[1]);
                //Log.i(TAG, "TRUE VALUE " + values[1]);

                falseValues.add(values[2]);
                // Log.i(TAG, "FALSE VALUE " + values[2]);




            }

            // Log.i(TAG, "QUESTION NAMES SIZE = " + questionNames.size());
            // Log.i(TAG, "VALUES SIZE = " + valueToCompare.size());
            //  Log.i(TAG, "TRUE VALUES SIZE = " + trueValues.size());
            //  Log.i(TAG, "FALSE VALUES SIZE = " + falseValues.size());



            for(int i=0; i < sections.length; i++) {

                String value = getValue(databaseHelper.getQuestionByName(questionNames.get(i)).getId(), jsonObject);
                if(!value.equals("--")) {

                    if (value.equalsIgnoreCase(valueToCompare.get(i))) {

                        parsedFormula.append(trueValues.get(i)).append(operator);

                    } else
                        parsedFormula.append(falseValues.get(i)).append(operator);

                }else parsedFormula.append("-1").append(operator);
            }

            parsedFormula.append("0");



            engine = new ScriptEngineManager().getEngineByName("rhino");
            finalValue = (Double) engine.eval(parsedFormula.toString());

            Log.i(TAG, "PARSED FORMULA IS " + parsedFormula.toString() + " = " + finalValue);

        }catch(Exception e){e.printStackTrace();

        }

        return String.valueOf(finalValue.intValue());
    }



    String getValue(String id, JSONObject jsonObject){
        String value = null;


        try {

            value = jsonObject.get(id).toString();


        } catch (JSONException e) {
            e.printStackTrace();
            value = "--";
        }


        return value;
    }







}
