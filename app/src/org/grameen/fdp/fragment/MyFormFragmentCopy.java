package org.grameen.fdp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.SkipLogic;
import org.grameen.fdp.utility.CheckBoxController;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.DatabaseHelper;
import org.grameen.fdp.utility.DatePickerController;
import org.grameen.fdp.utility.EditTextController;
import org.grameen.fdp.utility.MyFormController;
import org.grameen.fdp.utility.MyFormSectionController;
import org.grameen.fdp.utility.SelectionController;
import org.grameen.fdp.utility.TimePickerController;
import org.json.JSONException;
import org.json.JSONObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * Created by aangjnr on 01/12/2017.
 */


public class MyFormFragmentCopy extends FormFragment {


    List<Question> questions;
    MyFormSectionController formSectionController;
    DatabaseHelper databaseHelper;
    String formName = "";
    String farmerCode = "";
    boolean shouldLoadOldValues = false;
    boolean isEnabled;



    MyFormSectionController AO_SECTION_CONTROLLER;
    MyFormSectionController AO_RESULTS_SECTION_CONTROLLER;
    MyFormSectionController ADDITIONAL_INTERVENTION_CONTROLLER;

    List<Question> aoQuestions;
    List<Question> aoResultsQuestions;
    List<Question> additionalInterventionQuestions;



    public MyFormFragmentCopy(){

    }


    public static MyFormFragmentCopy newInstance(String formName, boolean shouldLoadOldValues, @Nullable String farmerCode, boolean disableFormControlller){


        MyFormFragmentCopy formFragment = new MyFormFragmentCopy();

        Bundle bundle = new Bundle();
        bundle.putString("formName", formName);
        bundle.putBoolean("loadValues", shouldLoadOldValues);
        bundle.putBoolean("disable", disableFormControlller);

        bundle.putString("code", farmerCode);

        formFragment.setArguments(bundle);
        return formFragment;


    }

    @Override
    public void onAttach(Context context) {

        formName = getArguments().getString("formName");
        shouldLoadOldValues = getArguments().getBoolean("loadValues");
        isEnabled = getArguments().getBoolean("disable");

        farmerCode = getArguments().getString("code");

        databaseHelper = DatabaseHelper.getInstance(context);


        super.onAttach(context);
    }



    @Override
    public void initForm(MyFormController controller) {

        Context context = getContext();

        JSONObject jsonObject = null;
        String jsonString = "";

         // Add new Questions with data model of Question.class
        // The Question data model takes 2 or more parameters based on the type value



        if(formName.equals(Constants.ADOPTION_OBSERVATIONS))
        {



            if (!shouldLoadOldValues) {

                AO_SECTION_CONTROLLER = new MyFormSectionController(context, Constants.ADOPTION_OBSERVATIONS);
                aoQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.ADOPTION_OBSERVATIONS);

                Log.d("MYFORMFRAG", "NO DEFAULT VALUES TO LOAD");
                loadQuestions(context, aoQuestions, AO_SECTION_CONTROLLER);




                AO_RESULTS_SECTION_CONTROLLER = new MyFormSectionController(context, Constants.ADOPTION_OBSERVATION_RESULTS);
                aoResultsQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.ADOPTION_OBSERVATION_RESULTS);

                Log.d("MYFORMFRAG", "NO DEFAULT VALUES TO LOAD");
                loadQuestions(context, aoResultsQuestions, AO_RESULTS_SECTION_CONTROLLER);



                ADDITIONAL_INTERVENTION_CONTROLLER = new MyFormSectionController(context, Constants.ADDITIONAL_INTERVENTION);
                additionalInterventionQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.ADDITIONAL_INTERVENTION);

                Log.d("MYFORMFRAG", "NO DEFAULT VALUES TO LOAD");
                loadQuestions(context, additionalInterventionQuestions, ADDITIONAL_INTERVENTION_CONTROLLER);







            } else {

                Log.d("MYFORMFRAG", "LOAD DEFAULT VALUES");

                AO_SECTION_CONTROLLER = new MyFormSectionController(context, Constants.ADOPTION_OBSERVATIONS);
                aoQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.ADOPTION_OBSERVATIONS);

                 jsonString = databaseHelper.getSpecificFarmerDetails(formName, farmerCode);
                if (jsonString != null && !jsonString.isEmpty()) {

                    try {
                        jsonObject = new JSONObject(jsonString);
                        loadQuestionsWithValues(context, aoQuestions, jsonObject, AO_SECTION_CONTROLLER);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        loadQuestions(context, aoQuestions, AO_SECTION_CONTROLLER);
                    }
                } else loadQuestions(context, aoQuestions, AO_SECTION_CONTROLLER);




                Log.d("MYFORMFRAG", "LOAD DEFAULT VALUES");
                AO_RESULTS_SECTION_CONTROLLER = new MyFormSectionController(context, Constants.ADOPTION_OBSERVATION_RESULTS);
                aoResultsQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.ADOPTION_OBSERVATION_RESULTS);

                   jsonString = databaseHelper.getSpecificFarmerDetails(Constants.ADOPTION_OBSERVATION_RESULTS, farmerCode);
                if (jsonString != null && !jsonString.isEmpty()) {

                    try {
                        jsonObject = new JSONObject(jsonString);
                        loadQuestionsWithValues(context, aoResultsQuestions, jsonObject, AO_RESULTS_SECTION_CONTROLLER);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        loadQuestions(context, aoResultsQuestions, AO_RESULTS_SECTION_CONTROLLER);
                    }
                } else loadQuestions(context, aoResultsQuestions, AO_RESULTS_SECTION_CONTROLLER);





                Log.d("MYFORMFRAG", "LOAD DEFAULT VALUES");
                ADDITIONAL_INTERVENTION_CONTROLLER = new MyFormSectionController(context, Constants.ADDITIONAL_INTERVENTION);
                additionalInterventionQuestions = databaseHelper.getSpecificSetOfQuestions(Constants.ADDITIONAL_INTERVENTION);

                jsonString = databaseHelper.getSpecificFarmerDetails(Constants.ADDITIONAL_INTERVENTION, farmerCode);
                if (jsonString != null && !jsonString.isEmpty()) {

                    try {
                        jsonObject = new JSONObject(jsonString);
                        loadQuestionsWithValues(context, additionalInterventionQuestions, jsonObject, ADDITIONAL_INTERVENTION_CONTROLLER);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        loadQuestions(context, additionalInterventionQuestions, ADDITIONAL_INTERVENTION_CONTROLLER);
                    }
                } else loadQuestions(context, additionalInterventionQuestions, ADDITIONAL_INTERVENTION_CONTROLLER);

            }


            controller.addSection(AO_SECTION_CONTROLLER);
            controller.addSection(AO_RESULTS_SECTION_CONTROLLER);
            controller.addSection(ADDITIONAL_INTERVENTION_CONTROLLER);



////////////////////////////////////////








        }else {

            questions = databaseHelper.getSpecificSetOfQuestions(formName);
            if(questions != null) {
                Log.d("FORM FRAGMENT", "QUESTIONS SIZE IS " + questions.size());

            }else{
                Log.d("FORM FRAGMENT", "QUESTIONS SIZE IS NULLLLL");
            }

            formSectionController = new MyFormSectionController(getContext(), formName);


            if (!shouldLoadOldValues) {

                Log.d("MYFORMFRAG", "NO DEFAULT VALUES TO LOAD");
                loadQuestions(context, questions, formSectionController);


            } else {

                Log.d("MYFORMFRAG", "LOAD DEFAULT VALUES");

                   jsonString = databaseHelper.getSpecificFarmerDetails(formName, farmerCode);
                if (jsonString != null && !jsonString.isEmpty()) {

                    try {
                        jsonObject = new JSONObject(jsonString);
                        loadQuestionsWithValues(context,questions, jsonObject, formSectionController);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        loadQuestions(context, questions, formSectionController);
                    }
                } else loadQuestions(context, questions, formSectionController);


            }


            controller.addSection(formSectionController);



        }






    }



    public boolean validate() throws JSONException {
        getFormController().resetValidationErrors();
        if (getFormController().isValidInput()) {

            //Send data to server here after getting JSON string

            //Toast.makeText(getContext(), getAllAnswersInJSON(), Toast.LENGTH_LONG).show();

            CustomToast.makeToast(getActivity(), getAllAnswersInJSON(), Toast.LENGTH_LONG).show();

        } else {

            // Whoaaaaaaa! There were some invalid inputs
            getFormController().showValidationErrors();

        }
        return true;
    }


    // This method iterates through the questions list, append their respective answers and
    // parses the list into a JSON string

    public String getAllAnswersInJSON()   {


        if(formName.equalsIgnoreCase(Constants.ADOPTION_OBSERVATIONS)){
            String value1 = "", value2 = "", value3 = "";


            JSONObject jsonObject;

            try {
                jsonObject = new JSONObject();
                for (Question q : aoQuestions) {
                    jsonObject.put(q.getId(), getModel().getValue(q.getId()));
                }

                value1 = jsonObject.toString();


                jsonObject = new JSONObject();
                for (Question q : aoResultsQuestions) {
                    jsonObject.put(q.getId(), getModel().getValue(q.getId()));
                }

                value2 = jsonObject.toString();


                jsonObject = new JSONObject();
                for (Question q : additionalInterventionQuestions) {
                    jsonObject.put(q.getId(), getModel().getValue(q.getId()));
                }

                value3 = jsonObject.toString();


            }catch
                 (JSONException e) {
                    e.printStackTrace();
                }

                return value1 + "#" + value2 + "#" + value3;

            }
        else {


            JSONObject jsonObject = new JSONObject();

            for (Question q : questions) {


                try {
                    jsonObject.put(q.getId(), getModel().getValue(q.getId()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            return jsonObject.toString();

        }


    }



    void loadQuestions(Context context, List<Question> questions, MyFormSectionController formSectionController){


        for (Question q : questions) {

            Log.d("MYFORMFRAG ", "TYPE IS " + q.getType__c());
            switch (q.getType__c().toLowerCase()) {

                case Constants.TYPE_TEXT:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT, !isEnabled));

                    break;
                case Constants.TYPE_NUMBER:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_NUMBER, !isEnabled));

                    break;
                case Constants.TYPE_SELECTABLE:
                    formSectionController.addElement(new SelectionController(context, q.getId(), q.getCaption__c(), true, "Select", q.formatQuestionOptions(), true, !isEnabled));

                    break;
                case Constants.TYPE_CHECKBOX:
                    formSectionController.addElement(new CheckBoxController(context, q.getId(), q.getCaption__c(), true, q.formatQuestionOptions(), true, !isEnabled));

                    break;
                case Constants.TYPE_TIMEPICKER:
                    formSectionController.addElement(new TimePickerController(context, q.getId(), q.getCaption__c()));

                    break;
                case Constants.TYPE_DATEPICKER:
                    formSectionController.addElement(new DatePickerController(context, q.getId(), q.getCaption__c()));
                    break;

                case Constants.TYPE_MATH_FORMULA:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT, false));
                    isEnabled = true;

                    break;

                case Constants.TYPE_LOGIC_FORMULA:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT, false));
                    isEnabled = true;
                    break;

            }


            setUpSkipLogics(q);


        }


    }



    void loadQuestionsWithValues(Context context,  List<Question> questions,  JSONObject jsonObject, MyFormSectionController formSectionController){

        for (Question q : questions) {
            Log.d("MYFORMFRAG ", "TYPE IS " + q.getType__c());
            switch (q.getType__c().toLowerCase()) {

                case Constants.TYPE_TEXT:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT, !isEnabled));
                    getValue(q, jsonObject);

                    break;
                case Constants.TYPE_NUMBER:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_NUMBER, !isEnabled));
                    getValue(q, jsonObject);

                    break;
                case Constants.TYPE_SELECTABLE:
                    formSectionController.addElement(new SelectionController(context, q.getId(), q.getCaption__c(), true, "Select", q.formatQuestionOptions(), true, !isEnabled));
                    getValue(q, jsonObject);

                    break;
                case Constants.TYPE_CHECKBOX:
                    formSectionController.addElement(new CheckBoxController(context, q.getId(), q.getCaption__c(), true, q.formatQuestionOptions(), true, !isEnabled));
                    getValue(q, jsonObject);

                    break;
                case Constants.TYPE_TIMEPICKER:
                    formSectionController.addElement(new TimePickerController(context, q.getId(), q.getCaption__c()));
                    getValue(q, jsonObject);

                    break;
                case Constants.TYPE_DATEPICKER:
                    formSectionController.addElement(new DatePickerController(context, q.getId(), q.getCaption__c()));
                    getValue(q, jsonObject);

                    break;

                case Constants.TYPE_MATH_FORMULA:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT, false));
                    break;

                case Constants.TYPE_LOGIC_FORMULA:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT, false));
                     break;

            }


             setUpSkipLogics(q);


        }

    }



    String getValue(Question q, JSONObject jsonObject){

        String defVal;
        try {
            defVal = jsonObject.get(q.getId()).toString();
            getModel().setValue(q.getId(), defVal);
            return defVal;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }




    void setUpSkipLogics(Question q){


        final List<SkipLogic> skipLogics = databaseHelper.doesQuestionHaveSkipLogics(q.getId());

        if(skipLogics != null && skipLogics.size() > 0){

            final String caption = q.getCaption__c();

            getModel().addPropertyChangeListener(q.getId(), new PropertyChangeListener() {
                @Override public void propertyChange(PropertyChangeEvent event) {


                    Log.i("PROPERTY CHANGE ", " FOR QUESTION " + caption + "Value was: " + event.getOldValue() + ", now: " + event.getNewValue());
                    for (SkipLogic sl : skipLogics) {

                        if(sl.getAnswerValue().equalsIgnoreCase(String.valueOf(event.getNewValue()))){


                            if(sl.getActionToBeTaken().equalsIgnoreCase(Constants.HIDE)){

                                getFormController().getElement(sl.getQuestionShowHide()).getView().setVisibility(View.GONE);


                            }else{

                                getFormController().getElement(sl.getQuestionShowHide()).getView().setVisibility(View.VISIBLE);

                            }

                        }else{
                            getFormController().getElement(sl.getQuestionShowHide()).getView().setVisibility(View.VISIBLE);

                        }
                    }
                }
            });




        }
    }
}