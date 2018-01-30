package org.grameen.fdp.utility;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.github.dkharrat.nexusdialog.validations.InputValidator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/**
 * Represents a field that allows selecting a specific date via a date picker.
 * <p/>
 * For the field value, the associated FormModel must return a {@link Date} instance. No selected date can be
 * represented by returning {@code null} for the value of the field.
 */
public class ButtonController extends MyLabeledFieldController {
    private final int editTextId = MyFormController.generateViewId();

    private DatePickerDialog datePickerDialog = null;

    private final LocationListener locationListener;

    /**
     * Constructs a new instance of a date picker field.
     *
     * @param ctx               the Android context
     * @param name              the name of the field
     * @param labelText         the label to display beside the field. Set to {@code null} to not show a label.
     * @param validators        contains the validations to process on the field
     * @param displayFormat     the format of the date to show in the text box when a date is set
     */
    public ButtonController(Context ctx, String name, String labelText, Set<InputValidator> validators, LocationListener displayFormat) {
        super(ctx, name, labelText, validators);
        this.locationListener = displayFormat;
    }

    /**
     * Constructs a new instance of a date picker field.
     *
     * @param ctx               the Android context
     * @param name              the name of the field
     * @param labelText         the label to display beside the field. Set to {@code null} to not show a label.
     * @param isRequired        indicates if the field is required or not
     * @param displayFormat     the format of the date to show in the text box when a date is set
     */
    public ButtonController(Context ctx, String name, String labelText, boolean isRequired, LocationListener displayFormat) {
        super(ctx, name, labelText, isRequired);
        this.locationListener = displayFormat;
    }

    /**
     * Constructs a new instance of a date picker field, with the selected date displayed in "MMM d, yyyy" format.
     *
     * @param name              the name of the field
     * @param labelText         the label to display beside the field
     */
    public ButtonController(Context context, String name, String labelText, LocationListener locationListener) {
        this(context, name, labelText, false, locationListener);
    }

    @Override
    protected View createFieldView() {
        final EditText editText = new EditText(getContext());

        editText.setId(editTextId);

        editText.setSingleLine(true);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setKeyListener(null);
        refresh(editText);
        editText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation(getContext(), editText);


            }
        });

        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    getCurrentLocation(getContext(), editText);


                }
            }
        });

        return editText;
    }


    private void getCurrentLocation(final Context context, final EditText editText) {

        CustomToast.makeToast(getContext(), "Please make sure GPS is enabled", Toast.LENGTH_SHORT).show();

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(true);
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);


        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        // This is the Best And IMPORTANT part
        final Looper looper = null;

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            if (locationManager != null) {
                locationManager.requestSingleUpdate(criteria, locationListener, looper);
            }
        }







    }




    private EditText getEditText() {
        return (EditText)getView().findViewById(editTextId);
    }

    private void refresh(EditText editText) {
        editText.setHint("Click to obtain location");
    }

    public void refresh() {
        refresh(getEditText());
    }
}
