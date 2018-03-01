package org.grameen.fdp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
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

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.grameen.fdp.R;
import org.grameen.fdp.object.Cell;
import org.grameen.fdp.object.ColumnHeader;
import org.grameen.fdp.object.Question;
import org.grameen.fdp.object.RowHeader;
import org.grameen.fdp.utility.Constants;
import org.grameen.fdp.viewholder.CellViewHolder;
import org.grameen.fdp.viewholder.CheckBoxViewHolder;
import org.grameen.fdp.viewholder.ColumnHeaderViewHolder;
import org.grameen.fdp.viewholder.RowHeaderViewHolder;
import org.grameen.fdp.viewholder.SpinnerViewHolder;
import org.json.JSONException;

import java.util.List;

/**
 * Created by aangjnr on 22/02/2018.
 */


public class FineTableViewAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {

    // Cell View Types by Column Position
    private static final int MOOD_CELL_TYPE = 1;
    private static final int GENDER_CELL_TYPE = 2;

    // add new one if it necessary..











    private static final int TEXT_SIZE = 10;
    private static final int TITLE_TEXT_SIZE = 14;
    List<Question> questions;
    Context context;


    private static final String LOG_TAG = FineTableViewAdapter.class.getSimpleName();

    public FineTableViewAdapter(Context p_jContext, List<Question> questionList) {
        super(p_jContext);
        this.context = p_jContext;
        this.questions = questionList;

    }

    /**
     * This is where you create your custom Cell ViewHolder. This method is called when Cell
     * RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given type to
     * represent an item.
     *
     * @param viewType : This value comes from "getCellItemViewType" method to support different
     *                 type of viewHolder as a Cell item.
     *
     * @see #getCellItemViewType(int);
     */
    @Override
    public RecyclerView.ViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {



        String TYPE = questions.get(viewType).getType__c().toLowerCase();
        Log.i("FINE TABLE ADAPTER", "TYPE = " + TYPE);

        if(TYPE.equalsIgnoreCase(Constants.TYPE_TEXT))
                return new CellViewHolder(getLayoutView(parent, Constants.TYPE_TEXT), Constants.TYPE_TEXT);

        else if (TYPE.equalsIgnoreCase(Constants.TYPE_SELECTABLE))
            return new SpinnerViewHolder(getLayoutView(parent, Constants.TYPE_SELECTABLE), Constants.TYPE_SELECTABLE);

        else if (TYPE.equalsIgnoreCase(Constants.TYPE_CHECKBOX))
            return new CheckBoxViewHolder(getLayoutView(parent, Constants.TYPE_CHECKBOX), Constants.TYPE_SELECTABLE);

        else
            return new CellViewHolder(getLayoutView(parent, Constants.TYPE_TEXT), Constants.TYPE_TEXT);



    }

    /**
     * That is where you set Cell View Model data to your custom Cell ViewHolder. This method is
     * Called by Cell RecyclerView of the TableView to display the data at the specified position.
     * This method gives you everything you need about a cell item.
     *
     * @param holder         : This is one of your cell ViewHolders that was created on
     *                       ```onCreateCellViewHolder``` method. In this example we have created
     *                       "CellViewHolder" holder.
     * @param cellItemModel  : This is the cell view model located on this X and Y position. In this
     *                       example, the model class is "Cell".
     * @param columnPosition : This is the X (Column) position of the cell item.
     * @param rowPosition    : This is the Y (Row) position of the cell item.
     *
     * @see #onCreateCellViewHolder(ViewGroup, int) ;
     */
    @Override
    public void onBindCellViewHolder(AbstractViewHolder holder, Object cellItemModel, int columnPosition, int rowPosition) {

           Cell cell = (Cell) cellItemModel;

        Log.i("FINE TABLE ADAPTER", "COLUMN POSITION = " + columnPosition);
        Log.i("FINE TABLE ADAPTER", "ROW POSITION = " + rowPosition);

        if(holder instanceof CellViewHolder) {

            CellViewHolder viewHolder = (CellViewHolder) holder;
            viewHolder.setData(rowPosition, (Question) cell.getData());
        }else if (holder instanceof CheckBoxViewHolder)
        {
            CheckBoxViewHolder viewHolder = (CheckBoxViewHolder) holder;
            viewHolder.setData(rowPosition, (Question) cell.getData());

        }else if (holder instanceof  SpinnerViewHolder){

            SpinnerViewHolder viewHolder = (SpinnerViewHolder) holder;
            viewHolder.setData(rowPosition, (Question) cell.getData());

        }







    }

    /**
     * This is where you create your custom Column Header ViewHolder. This method is called when
     * Column Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getColumnHeaderItemViewType" method to support
     *                 different type of viewHolder as a Column Header item.
     *
     * @see #getColumnHeaderItemViewType(int);
     */
    @Override
    public RecyclerView.ViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {

        // Get Column Header xml Layout
        View layout = LayoutInflater.from(mContext).inflate(R.layout
                .table_view_column_header_layout, parent, false);

        // Create a ColumnHeader ViewHolder
        return new ColumnHeaderViewHolder(layout, getTableView());
    }

    /**
     * That is where you set Column Header View Model data to your custom Column Header ViewHolder.
     * This method is Called by ColumnHeader RecyclerView of the TableView to display the data at
     * the specified position. This method gives you everything you need about a column header
     * item.
     *
     * @param holder                : This is one of your column header ViewHolders that was created
     *                              on ```onCreateColumnHeaderViewHolder``` method. In this example
     *                              we have created "ColumnHeaderViewHolder" holder.
     * @param columnHeaderItemModel : This is the column header view model located on this X
     *                              position. In this example, the model class is "ColumnHeader".
     * @param columnPosition        : This is the X (Column) position of the column header item.
     *
     * @see #onCreateColumnHeaderViewHolder(ViewGroup, int) ;
     */
    @Override
    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, Object
            columnHeaderItemModel, int columnPosition) {
        ColumnHeader columnHeader = (ColumnHeader) columnHeaderItemModel;

        // Get the holder to update cell item text
        ColumnHeaderViewHolder columnHeaderViewHolder = (ColumnHeaderViewHolder) holder;
        columnHeaderViewHolder.setColumnHeader(columnHeader);
    }

    /**
     * This is where you create your custom Row Header ViewHolder. This method is called when
     * Row Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getRowHeaderItemViewType" method to support
     *                 different type of viewHolder as a row Header item.
     *
     * @see #getRowHeaderItemViewType(int);
     */
    @Override
    public RecyclerView.ViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {

        // Get Row Header xml Layout
        View layout = LayoutInflater.from(mContext).inflate(R.layout
                .table_view_row_header_layout, parent, false);

        // Create a Row Header ViewHolder
        return new RowHeaderViewHolder(layout);
    }


    /**
     * That is where you set Row Header View Model data to your custom Row Header ViewHolder. This
     * method is Called by RowHeader RecyclerView of the TableView to display the data at the
     * specified position. This method gives you everything you need about a row header item.
     *
     * @param holder             : This is one of your row header ViewHolders that was created on
     *                           ```onCreateRowHeaderViewHolder``` method. In this example we have
     *                           created "RowHeaderViewHolder" holder.
     * @param rowHeaderItemModel : This is the row header view model located on this Y position. In
     *                           this example, the model class is "RowHeader".
     * @param rowPosition        : This is the Y (row) position of the row header item.
     *
     * @see #onCreateRowHeaderViewHolder(ViewGroup, int) ;
     */
    @Override
    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, Object rowHeaderItemModel,
                                          int rowPosition) {
        RowHeader rowHeader = (RowHeader) rowHeaderItemModel;

        // Get the holder to update row header item text
        RowHeaderViewHolder rowHeaderViewHolder = (RowHeaderViewHolder) holder;
        rowHeaderViewHolder.row_header_textview.setText(String.valueOf(rowHeader.getData()));
    }


    @Override
    public View onCreateCornerView() {
        // Get Corner xml layout
        View corner = LayoutInflater.from(mContext).inflate(R.layout.table_view_corner_layout, null);

        return corner;
    }

    @Override
    public int getColumnHeaderItemViewType(int position) {
        // The unique ID for this type of column header item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int position) {
        // The unique ID for this type of row header item
        // If you have different items for Row Header View by Y (Row) position,
        // then you should fill this method to be able create different
        // type of RowHeaderViewHolder on "onCreateRowHeaderViewHolder"
        return 0;
    }

    @Override
    public int getCellItemViewType(int column) {

        Log.i("getCellItemViewType", "*** COLUMN IS " + column );
        // The unique ID for this type of cell item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
       /* switch (column) {
            case MainFragment.MOOD_COLUMN_INDEX:
                return MOOD_CELL_TYPE;
            case MainFragment.GENDER_COLUMN_INDEX:
                return GENDER_CELL_TYPE;
            default:
                // Default view type
                return 0;
        }*/

        return column;
    }









    View getLayoutView(ViewGroup parent, String TYPE){

        View layout = null;
        switch (TYPE) {

            case Constants.TYPE_TEXT:
              layout = LayoutInflater.from(mContext).inflate(R.layout
                    .table_view_edittext, parent, false);
            layout.setTag(TYPE);

            break;

            case Constants.TYPE_SELECTABLE:
                  layout = LayoutInflater.from(mContext).inflate(R.layout
                        .table_view_spinner, parent, false);
                layout.setTag(TYPE);

            break;

            case Constants.TYPE_CHECKBOX:
                 layout = LayoutInflater.from(mContext).inflate(R.layout
                        .table_view_checkbox, parent, false);
                layout.setTag(TYPE);
            break;



            default:
                layout = LayoutInflater.from(mContext).inflate(R.layout
                        .table_view_cell_layout, parent, false);
                layout.setTag(TYPE);



        }


        return layout;
    }







}