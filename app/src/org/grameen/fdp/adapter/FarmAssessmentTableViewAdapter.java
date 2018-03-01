package org.grameen.fdp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.object.Data2;

import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.LongPressAwareTableDataAdapter;

import static org.grameen.fdp.utility.Constants.BUTTON_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_OTHER_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_RESULTS;
import static org.grameen.fdp.utility.Constants.TAG_TITLE_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_VIEW;

/**
 * Created by aangjnr on 17/01/2018.
 */

public class FarmAssessmentTableViewAdapter extends LongPressAwareTableDataAdapter<Data2> {

    String TAG = FarmAssessmentTableViewAdapter.class.getSimpleName();
    private static final int TEXT_SIZE = 10;
    private static final int TITLE_TEXT_SIZE = 11;
    static MaterialSpinner.OnItemSelectedListener itemSelectedListener;
    static View.OnClickListener mOnClickListener;

    Context context;

    Integer dataSize;

    public FarmAssessmentTableViewAdapter(final Context context, final List<Data2> data, final TableView<Data2> tableView) {
        super(context, data, tableView);

        this.dataSize = data.size();
        this.context = context;


    }

    public void setItemSelectedListener(final MaterialSpinner.OnItemSelectedListener mItemSelectedListener) {
        this.itemSelectedListener = mItemSelectedListener;
    }

    public void setClickistener(final View.OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    @Override
    public View getDefaultCellView(int i, int i1, ViewGroup viewGroup) {

        final Data2 myTableData = getRowData(i);
        View renderedView = new View(context);


           //// Log.i(TAG, "COLUMN COUNT LESS THAN 3 " +  getColumnModel().getColumnCount());


            if (i1 == 0) {
                //Todo set questions here

                renderedView = renderColumnLabelValues(myTableData);

            } else if (i1 == 1) {
                //Todo set Answer Values here
                renderedView = renderColumnSingleValues(myTableData);

            }




        return renderedView;
    }

    @Override
    public View getLongPressCellView(int i, int i1, ViewGroup viewGroup) {
        return null;
    }





    private View renderColumnLabelValues(final Data2 data) {

        View view = null;


            TextView textView = new TextView(getContext());
            textView.setText(data.getLabel());
            textView.setPadding(20, 10, 20, 10);
            textView.setTextSize(TITLE_TEXT_SIZE);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black_87));
            view = textView;

        return view;

    }



    private View renderColumnSingleValues(final Data2 data) {

        View view = null;

            TextView textView = new TextView(getContext());
            String text = "\n"+data.getSingleValue()+"\n";
            textView.setText(text);
            textView.setPadding(20, 10, 20, 10);
            textView.setTextSize(TITLE_TEXT_SIZE);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
            textView.setBackgroundColor(ContextCompat.getColor(getContext(),getBackgroundColor(data.getSingleValue())));
            view = textView;

        return view;

    }



    int getBackgroundColor(final String result){


        switch(result){

            case "Fail":

                return R.color.fail;
            case "Pass":

                return R.color.pass;

            case "Non-Critical Fail":
                return R.color.non_critical_fail;

                default: return R.color.transparent;
        }





    }








}
