package org.grameen.fdp.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dkharrat.nexusdialog.FormModel;
import com.github.dkharrat.nexusdialog.FormModelFragment;
import com.github.dkharrat.nexusdialog.FragmentActivityHelper;
import com.squareup.picasso.Picasso;

import org.grameen.fdp.R;
import org.grameen.fdp.activity.Add_EditFarmerDetailsActivity;
import org.grameen.fdp.utility.CustomToast;
import org.grameen.fdp.utility.ImageUtil;
import org.grameen.fdp.utility.MyFormController;

import static android.app.Activity.RESULT_OK;

/**
 * Created by aangjnr on 05/01/2018.
 */

public abstract class FormFragment extends Fragment {

    String ID;
    String TAG = "FormFragment";
    SharedPreferences preferences;
    private FormModelFragment formModelFragment;
    private MyFormController formController;
    final int PERMISSION_CAMERA = 505;
    public static int CAMERA_INTENT = 506;

    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        return inflater.inflate(com.github.dkharrat.nexusdialog.R.layout.form_activity, null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.formModelFragment = FragmentActivityHelper.getFormModelFragment(this.getActivity());
        this.formController = new MyFormController(context, formModelFragment.getModel());

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        initForm(formController);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recreateViews();
    }

    /**
     * An abstract method that must be overridden by subclasses where the form fields are initialized.
     */
    abstract public void initForm(MyFormController controller);

    /**
     * Returns the associated <code>MyFormController</code> that manages the form fields.
     */
    public MyFormController getFormController() {
        return formController;
    }

    /**
     * Returns the associated model of this form.
     */
    public FormModel getModel() {
        return formModelFragment.getModel();
    }

    /**
     * Sets the model to use for this form
     *
     * @param formModel the model to use
     */
    public void setModel(FormModel formModel) {
        this.formModelFragment.setModel(formModel);
        formController.setModel(formModel);
    }

    /**
     * Recreates the views for all the elements that are in the form. This method needs to be called when field are dynamically added or
     * removed
     */
    protected void recreateViews() {
        ViewGroup containerView = (ViewGroup) getActivity().findViewById(com.github.dkharrat.nexusdialog.R.id.form_elements_container);
        formController.recreateViews(containerView);
    }



    void startCameraIntent(String id) {


        this.ID = id;

        if (!hasPermissions(getActivity(), Manifest.permission.CAMERA)) {
             requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSION_CAMERA);
        } else {

            PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putBoolean("shouldSave", false).apply();

            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {

                Log.d(this.getClass().getSimpleName(), "Starting camera intent");

                startActivityForResult(takePictureIntent, CAMERA_INTENT);

            }


        }
    }



    boolean hasPermissions(Context context, String permission) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {

            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permission)) {


                }
                return false;
            }

        }
        return true;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {


            Log.d(TAG, "RESULT CODE = " + resultCode + " REQUEST CODE " + requestCode);


            if (resultCode == RESULT_OK) {

                Log.d(TAG, " REQUEST CODE IS OK");

                if (requestCode == CAMERA_INTENT) {


                    Log.d(TAG, "CAMERA INTENT");


                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");

                    //imageView.setImageBitmap(imageBitmap);

                    String value = ImageUtil.convert(imageBitmap);
                    getModel().setValue(ID, value);

                    Log.i(TAG, "***** Value for Photo was " + value);

                    CustomToast.makeToast(getActivity(), getResources().getString(R.string.click_photo_to_delete), Toast.LENGTH_LONG).show();

                }


            } else CustomToast.makeToast(getActivity(), getResources().getString(R.string.no_image_taken), Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
            CustomToast.makeToast(getActivity(), getResources().getString(R.string.something_went_wrong), Toast.LENGTH_LONG)
                    .show();
        }



    }
}
