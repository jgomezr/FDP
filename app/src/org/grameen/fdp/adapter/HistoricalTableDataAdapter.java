package org.grameen.fdp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import org.grameen.fdp.R;
import org.grameen.fdp.object.HistoricalData;
import org.grameen.fdp.object.HistoricalTableViewData;

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

public class HistoricalTableDataAdapter extends LongPressAwareTableDataAdapter<List<String>> {

    String TAG = HistoricalTableDataAdapter.class.getSimpleName();
    private static final int TEXT_SIZE = 10;
    private static final int TITLE_TEXT_SIZE = 11;
    static MaterialSpinner.OnItemSelectedListener itemSelectedListener;
    static View.OnClickListener mOnClickListener;

    Context context;
    Integer dataSize;

    public HistoricalTableDataAdapter(final Context context, final List<List<String>> data, final TableView<List<String>> tableView) {
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

        final List<String> myTableData = getRowData(i);

        return renderColumnValues(myTableData, i1);


    }

    @Override
    public View getLongPressCellView(int i, int i1, ViewGroup viewGroup) {
        return null;
    }


    private View renderColumnValues(List<String> data, int cellPosition) {


        TextView textView = new TextView(getContext());
        textView.setText(data.get(cellPosition));
        textView.setMaxLines(2);
        textView.setMinLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);

        if (cellPosition == 0 && getColumnModel().getColumnCount() == 2) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black_87));

        }

        return textView;
    }


}
