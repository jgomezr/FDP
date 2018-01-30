package org.grameen.fdp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.github.dkharrat.nexusdialog.FormController;
import com.github.dkharrat.nexusdialog.FormModel;
import com.github.dkharrat.nexusdialog.FormModelFragment;
import com.github.dkharrat.nexusdialog.FragmentActivityHelper;
import com.salesforce.androidsdk.security.PasscodeManager;

import org.grameen.fdp.utility.MyFormController;

/**
 * Created by aangjnr on 05/01/2018.
 */

public abstract class FormFragment extends Fragment {
    private FormModelFragment formModelFragment;
    private MyFormController formController;

    SharedPreferences preferences;

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
}
