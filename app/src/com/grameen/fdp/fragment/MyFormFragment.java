package com.grameen.fdp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.widget.Toast;

import com.github.dkharrat.nexusdialog.FormController;
import com.github.dkharrat.nexusdialog.FormFragment;
import com.github.dkharrat.nexusdialog.controllers.CheckBoxController;
import com.github.dkharrat.nexusdialog.controllers.DatePickerController;
import com.github.dkharrat.nexusdialog.controllers.EditTextController;
import com.github.dkharrat.nexusdialog.controllers.FormSectionController;
import com.github.dkharrat.nexusdialog.controllers.SelectionController;
import com.github.dkharrat.nexusdialog.controllers.TimePickerController;
import com.google.gson.Gson;
import com.grameen.fdp.object.Question;
import com.grameen.fdp.utility.Constants;
import com.grameen.fdp.utility.CustomToast;
import com.grameen.fdp.utility.DatabaseHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aangjnr on 01/12/2017.
 */


public class MyFormFragment extends FormFragment {


    List<Question> questions;
    FormSectionController formSectionController;
    DatabaseHelper databaseHelper;
    String formName = "";

    public MyFormFragment(){

    }


    public static MyFormFragment newInstance(String formName){


        MyFormFragment formFragment = new MyFormFragment();

        Bundle bundle = new Bundle();
        bundle.putString("formName", formName);
        formFragment.setArguments(bundle);
        return formFragment;


    }

    @Override
    public void onAttach(Context context) {

        formName = getArguments().getString("formName");
        databaseHelper = DatabaseHelper.getInstance(context);
        questions = databaseHelper.getSpecificSetOfQuestions(formName);

        if(questions != null) {
            Log.d("FORM FRAGMENT", "QUESTIONS SIZE IS " + questions.size());

        }else{

            Log.d("FORM FRAGMENT", "QUESTIONS SIZE IS NULLLLL");

        }


        super.onAttach(context);
    }



    @Override
    public void initForm(FormController controller) {

        Context context = getContext();
        // Add new Questions with data model of Question.class
        // The Question data model takes 2 or more parameters based on the type value




        formSectionController = new FormSectionController(getContext(), formName);

        for (Question q : questions) {
            Log.d("MYFORMFRAG", "TYPE IS " + q.getType__c());

            switch (q.getType__c()) {

                case Constants.TYPE_TEXT:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_TEXT));
                    break;

                case Constants.TYPE_NUMBER:
                    formSectionController.addElement(new EditTextController(context, q.getId(), q.getCaption__c(), null, true, InputType.TYPE_CLASS_NUMBER));
                    break;


                case Constants.TYPE_SELECTABLE:
                    formSectionController.addElement(new SelectionController(context, q.getId(), q.getCaption__c(), true, "Select", q.formatQuestionOptions(), true));
                    break;

                case Constants.TYPE_CHECKBOX:
                    formSectionController.addElement(new CheckBoxController(context, q.getId(), q.getCaption__c(), true, q.formatQuestionOptions(), true));
                    break;

                case Constants.TYPE_TIMEPICKER:
                    formSectionController.addElement(new TimePickerController(context, q.getId(), q.getCaption__c()));
                    break;

                case Constants.TYPE_DATEPICKER:
                    formSectionController.addElement(new DatePickerController(context, q.getId(), q.getCaption__c()));
                    break;


            }

        }

        // End for loop


        controller.addSection(formSectionController);


    }


    public boolean validate() {
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

    String getAllAnswersInJSON() {

        for (Question q : questions) {
            q.setAnswer(getModel().getValue(q.getType__c()));
        }

        return new Gson().toJson(questions);
    }


}