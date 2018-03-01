package org.grameen.fdp.utility;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.github.dkharrat.nexusdialog.validations.InputValidator;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Set;

/**
 * Created by aangjnr on 05/01/2018.
 */

public class EditTextController extends MyLabeledFieldController {
    private final int editTextId = MyFormController.generateViewId();
    private final String placeholder;
    boolean IS_ENABLED = true;
    private int inputType;

    String helpertext;

    /**
     * Constructs a new instance of an edit text field.
     *
     * @param ctx         the Android context
     * @param name        the name of the field
     * @param labelText   the label to display beside the field. Set to {@code null} to not show a label.
     * @param placeholder a placeholder text to show when the input field is empty. If null, no placeholder is displayed
     * @param validators  contains the validations to process on the field
     * @param inputType   the content type of the text box as a mask; possible values are defined by {@link InputType}.
     *                    For example, to enable multi-line, enable {@code InputType.TYPE_TEXT_FLAG_MULTI_LINE}.
     */
    public EditTextController(Context ctx, String name, String labelText, String placeholder, Set<InputValidator> validators, int inputType, boolean isEnabled) {
        super(ctx, name, labelText, validators, isEnabled);
        this.placeholder = placeholder;
        this.inputType = inputType;
        this.IS_ENABLED = isEnabled;

    }

    /**
     * Constructs a new instance of an edit text field.
     *
     * @param ctx         the Android context
     * @param name        the name of the field
     * @param labelText   the label to display beside the field
     * @param placeholder a placeholder text to show when the input field is empty. If null, no placeholder is displayed
     * @param validators  contains the validations to process on the field
     */
    public EditTextController(Context ctx, String name, String labelText, String placeholder, Set<InputValidator> validators, boolean isEnabled) {
        this(ctx, name, labelText, placeholder, validators, InputType.TYPE_CLASS_TEXT, isEnabled);
    }

    /**
     * Constructs a new instance of an edit text field.
     *
     * @param ctx         the Android context
     * @param name        the name of the field
     * @param labelText   the label to display beside the field. Set to {@code null} to not show a label.
     * @param placeholder a placeholder text to show when the input field is empty. If null, no placeholder is displayed
     * @param isRequired  indicates if the field is required or not
     * @param inputType   the content type of the text box as a mask; possible values are defined by {@link InputType}.
     *                    For example, to enable multi-line, enable {@code InputType.TYPE_TEXT_FLAG_MULTI_LINE}.
     */
    public EditTextController(Context ctx, String name, String labelText, String placeholder, boolean isRequired, int inputType, boolean isEnabled) {
        super(ctx, name, labelText, isRequired, isEnabled);
        this.placeholder = placeholder;
        this.inputType = inputType;
        this.IS_ENABLED = isEnabled;

    }

    /**
     * Constructs a new instance of an edit text field.
     *
     * @param ctx         the Android context
     * @param name        the name of the field
     * @param labelText   the label to display beside the field
     * @param placeholder a placeholder text to show when the input field is empty. If null, no placeholder is displayed
     * @param isRequired  indicates if the field is required or not
     */
    public EditTextController(Context ctx, String name, String labelText, String placeholder, boolean isRequired, boolean isEnabled, String helperText) {
        this(ctx, name, labelText, placeholder, isRequired, InputType.TYPE_CLASS_TEXT, isEnabled);
        this.helpertext = helperText;
    }

    /**
     * Constructs a new instance of an edit text field.
     *
     * @param ctx         the Android context
     * @param name        the name of the field
     * @param labelText   the label to display beside the field
     * @param placeholder a placeholder text to show when the input field is empty. If null, no placeholder is displayed
     */
    public EditTextController(Context ctx, String name, String labelText, String placeholder, boolean isEnabled) {
        this(ctx, name, labelText, placeholder, false, InputType.TYPE_CLASS_TEXT, isEnabled);
    }

    /**
     * Constructs a new instance of an edit text field.
     *
     * @param ctx       the Android context
     * @param name      the name of the field
     * @param labelText the label to display beside the field
     */
    public EditTextController(Context ctx, String name, String labelText, boolean isEnabled) {
        this(ctx, name, labelText, null, false, InputType.TYPE_CLASS_TEXT, isEnabled);
    }

    public EditTextController(Context context, String id, String caption__c, String default_value__c, boolean b, int typeClassText, boolean b1, String help_text__c) {
        this(context, id, caption__c, default_value__c, b, typeClassText, b1);
        this.helpertext = help_text__c;

    }

    /**
     * Returns the EditText view associated with this element.
     *
     * @return the EditText view associated with this element
     */
    public EditText getEditText() {
        return (EditText) getView().findViewById(editTextId);
    }

    /**
     * Returns a mask representing the content input type. Possible values are defined by {@link InputType}.
     *
     * @return a mask representing the content input type
     */
    public int getInputType() {
        return inputType;
    }

    private void setInputTypeMask(int mask, boolean enabled) {
        if (enabled) {
            inputType = inputType | mask;
        } else {
            inputType = inputType & ~mask;
        }
        if (isViewCreated()) {
            getEditText().setInputType(inputType);
        }
    }

    /**
     * Indicates whether this text box has multi-line enabled.
     *
     * @return true if this text box has multi-line enabled, or false otherwise
     */
    public boolean isMultiLine() {
        return (inputType | InputType.TYPE_TEXT_FLAG_MULTI_LINE) != 0;
    }

    /**
     * Enables or disables multi-line input for the text field. Default is false.
     *
     * @param multiLine if true, multi-line input is allowed, otherwise, the field will only allow a single line.
     */
    public void setMultiLine(boolean multiLine) {
        setInputTypeMask(InputType.TYPE_TEXT_FLAG_MULTI_LINE, multiLine);
    }

    /**
     * Indicates whether this text field hides the input text for security reasons.
     *
     * @return true if this text field hides the input text, or false otherwise
     */
    public boolean isSecureEntry() {
        return (inputType | InputType.TYPE_TEXT_VARIATION_PASSWORD) != 0;
    }

    /**
     * Enables or disables secure entry for this text field. If enabled, input will be hidden from the user. Default is
     * false.
     *
     * @param isSecureEntry if true, input will be hidden from the user, otherwise input will be visible.
     */
    public void setSecureEntry(boolean isSecureEntry) {
        setInputTypeMask(InputType.TYPE_TEXT_VARIATION_PASSWORD, isSecureEntry);
    }

    @Override
    protected View createFieldView() {

        final MaterialEditText editText = new MaterialEditText(getContext());
        editText.setId(editTextId);
        editText.setFloatingLabel(MaterialEditText.FLOATING_LABEL_NONE);


        editText.setSingleLine(!isMultiLine());
        editText.setInputType(inputType);


        if(placeholder != null) {
            if(getModel().getValue(getName()) == null || getModel().getValue(getName()).toString().equalsIgnoreCase(""))
                getModel().setValue(getName(), placeholder);
            else
                getModel().setValue(getName(), getModel().getValue(getName()));

            //editText.setHint(placeholder);
        }



        refresh(editText);



        if (helpertext != null) {
            editText.setHelperText(helpertext);
            editText.setHelperTextAlwaysShown(true);

        }



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {


                getModel().setValue(getName(), editText.getText().toString());


            }
        });


        editText.setEnabled(IS_ENABLED);


        return editText;
    }

    private void refresh(EditText editText) {
        Object value = getModel().getValue(getName());



        String valueStr = value != null ? value.toString() : placeholder;

        if (!valueStr.equals(editText.getText().toString()))
            editText.setHint(valueStr);





    }

    @Override
    public void refresh() {
        refresh(getEditText());
    }
}
