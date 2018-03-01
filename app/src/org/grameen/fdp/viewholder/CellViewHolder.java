package org.grameen.fdp.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.grameen.fdp.R;
import org.grameen.fdp.activity.FamilyMembersActivity_v2;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.utility.Callbacks;
import org.grameen.fdp.utility.Constants;

import java.util.List;

/**
 * Created by aangjnr on 22/02/2018.
 */

public class CellViewHolder extends AbstractViewHolder {
    static Callbacks.UpdateJsonArray updateJsonArrayListener;

    public final LinearLayout cell_container;

    private static final int TEXT_SIZE = 10;
    private static final int TITLE_TEXT_SIZE = 14;


    MaterialEditText editText = null;


    public static void UpdateJsonArrayListener(Callbacks.UpdateJsonArray listener)
    {
        updateJsonArrayListener = listener;

    }


    public CellViewHolder(View itemView, String type) {
        super(itemView);
        Log.i("CELL VIEW HOLDER TAG", itemView.getTag().toString());
        Log.i("CELL VIEW HOLDER TYPE", type);

        cell_container = itemView.findViewById(R.id.cell_container);




                editText = itemView.findViewById(R.id.cell_data);


    }

    public void setData(int rowPosition, Question data) {

        //cell_textview.setText(String.valueOf(data));


        if(editText != null)
            bindEditTextView(editText, data, rowPosition);





    }




    void bindEditTextView(MaterialEditText editText, final Question q, final int rowPosition){

        Log.i("Edittext Cell VH", "NOT NULL");
       /* if(updateJsonArrayListener != null)
            updateJsonArrayListener.onItemValueChanged(rowPosition, q.getId(), q.getDefault_value__c());
*/

              if(q.getType__c().equalsIgnoreCase(Constants.TYPE_NUMBER))
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            else if(q.getType__c().equalsIgnoreCase(Constants.TYPE_TEXT))
                editText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);


            editText.setHint(FamilyMembersActivity_v2.getValue(rowPosition, q.getId()));
            editText.setError(q.getHelp_Text__c());
            editText.setErrorColor(R.color.divider_2);
            //editText.setHelperTextAlwaysShown(true);
            editText.setTextSize(12);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {


                    //q.setDefault_value__c(s.toString());

                    if(updateJsonArrayListener != null)
                        updateJsonArrayListener.onItemValueChanged(rowPosition, q.getId(), s.toString());




                }
            });


        cell_container.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        cell_container.getLayoutParams().height = 70;

        editText.requestLayout();




    }








}