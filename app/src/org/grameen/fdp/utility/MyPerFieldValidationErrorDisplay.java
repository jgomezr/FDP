package org.grameen.fdp.utility;

/**
 * Created by aangjnr on 05/01/2018.
 */

import android.content.Context;
import android.content.res.Resources;

import com.github.dkharrat.nexusdialog.FormController;
import com.github.dkharrat.nexusdialog.FormElementController;
import com.github.dkharrat.nexusdialog.controllers.FormSectionController;
import com.github.dkharrat.nexusdialog.validations.ValidationError;
import com.github.dkharrat.nexusdialog.validations.ValidationErrorDisplay;

import java.util.List;

public class MyPerFieldValidationErrorDisplay implements ValidationErrorDisplay {
    private final Context context;
    private final MyFormController controller;

    public MyPerFieldValidationErrorDisplay(Context context, MyFormController controller) {
        this.context = context;
        this.controller = controller;
    }

    @Override
    public void resetErrors() {
        for (MyFormSectionController section: controller.getSections()) {
            for (MyFormElementController elementController: section.getElements()) {
                elementController.setError(null);
            }
        }
    }

    @Override
    public void showErrors(List<ValidationError> errors) {
        Resources res = context.getResources();
        MyFormElementController element;
        for (ValidationError error : errors) {
            element = controller.getElement(error.getFieldName());
            element.setError(error.getMessage(res));
        }
    }
}
