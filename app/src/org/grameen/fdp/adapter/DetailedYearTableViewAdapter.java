package org.grameen.fdp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.object.Data;
import org.grameen.fdp.object.DetailedYearData;
import org.grameen.fdp.object.MyTableData;

import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.LongPressAwareTableDataAdapter;

import static org.grameen.fdp.utility.Constants.TAG_OTHER_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_RESULTS;
import static org.grameen.fdp.utility.Constants.TAG_TITLE_TEXT_VIEW;
import static org.grameen.fdp.utility.Constants.TAG_VIEW;

/**
 * Created by aangjnr on 17/01/2018.
 */

public class DetailedYearTableViewAdapter extends LongPressAwareTableDataAdapter<DetailedYearData> {

    private static final int TEXT_SIZE = 12;
    private static final int TITLE_TEXT_SIZE = 14;
    static MaterialSpinner.OnItemSelectedListener  itemSelectedListener;

    Context context;


    public void setItemClickListener(final MaterialSpinner.OnItemSelectedListener mItemSelectedListener) {
        this.itemSelectedListener = mItemSelectedListener;
    }


    public DetailedYearTableViewAdapter(final Context context, final List<DetailedYearData> data, final TableView<DetailedYearData> tableView) {
        super(context, data, tableView);

        this.context = context;




    }






    @Override
    public View getDefaultCellView(int i, int i1, ViewGroup viewGroup) {

        final DetailedYearData myTableData = getRowData(i);
        View renderedView = new View(getContext());


        if(i1 == 0){
            //Todo set questions here

            renderedView = renderColumn0Values(myTableData);

        }else
            //Todo set Answer Values here
            renderedView = renderCalculatedValuesForYear(myTableData, i1);


        return renderedView;
    }

    @Override
    public View getLongPressCellView(int i, int i1, ViewGroup viewGroup) {
        return null;
    }




    private View renderCalculatedValuesForYear(final DetailedYearData data, int index) {

         TextView  textView = new TextView(getContext());
        List<Data> calculationsForTheYears = data.getDataList();

        if(calculationsForTheYears != null) {

            String text = calculationsForTheYears.get(index).getLabel() + "\n\n" +calculationsForTheYears.get(index).getSingleValue();
            textView.setText(text);
            textView.setPadding(20, 10, 20, 10);
            textView.setTextSize(TEXT_SIZE);

        }


        return textView;
    }



    private View renderColumn0Values(final DetailedYearData data) {

        View view = null;


                TextView textView = new TextView(getContext());
                textView.setText(data.getName());
                textView.setPadding(20, 10, 20, 10);
                textView.setTextSize(TITLE_TEXT_SIZE);
                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

                view = textView;


        return view;
    }









}
