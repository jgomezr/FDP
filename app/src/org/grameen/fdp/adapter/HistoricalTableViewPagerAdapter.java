package org.grameen.fdp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.grameen.fdp.R;
import org.grameen.fdp.object.HistoricalTableViewData;
import org.grameen.fdp.object.HistoricalViewPagerTableData;
import org.grameen.fdp.object.PlotMonitoringTableData;

import java.util.ArrayList;
import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;

/**
 * Created by aangjnr on 08/02/2018.
 */

public class HistoricalTableViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    List<HistoricalViewPagerTableData> historicalViewPagerTableDataList;

    public HistoricalTableViewPagerAdapter(Context context, List<HistoricalViewPagerTableData> historicalViewPagerTableDataList) {
        mContext = context;
        this.historicalViewPagerTableDataList = historicalViewPagerTableDataList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {


        HistoricalViewPagerTableData dataList = historicalViewPagerTableDataList.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_table_view_item, collection, false);
        TableView tableView = layout.findViewById(R.id.tableView);
        /*TextView titleTextView = layout.findViewById(R.id.title_view);
        titleTextView.setText(dataList.getTitle());*/
        //layout.setTag(dataList.get());
        setAdapter(tableView, dataList);
        collection.addView(layout);


        return layout;
    }




    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return historicalViewPagerTableDataList.size();
    }


    @Override
    public int getItemPosition (@NonNull Object object)
    {
        int index = historicalViewPagerTableDataList.indexOf (object);
        if (index == -1)
            return POSITION_NONE;
        else
            return index;
    }





    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    void setAdapter(TableView tableView, HistoricalViewPagerTableData data) {
        tableView.setColumnCount(1);

        String[] TABLE_HEADERS = {data.getTitle()};


        HistoricalTableHeaderAdapter headerAdapter = new HistoricalTableHeaderAdapter(mContext, TABLE_HEADERS);
        tableView.setHeaderAdapter(headerAdapter);


        HistoricalTableDataAdapter historicalTableDataAdapter = new HistoricalTableDataAdapter(mContext, data.getTableData(), tableView);
        tableView.setDataAdapter(historicalTableDataAdapter);
    }


    public void setData(List<HistoricalViewPagerTableData> historicalViewPagerTableDataList) {
        this.historicalViewPagerTableDataList = historicalViewPagerTableDataList;
    }

    public List<HistoricalViewPagerTableData> getData() {
        return historicalViewPagerTableDataList;
    }


}