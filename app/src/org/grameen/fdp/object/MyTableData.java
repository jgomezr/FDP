package org.grameen.fdp.object;

import android.util.Log;
import android.widget.EditText;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.List;

/**
 * Created by aangjnr on 17/01/2018.
 */

public class MyTableData {


    List<Data> dataList;


    public MyTableData(List<Data> dataList){this.dataList = dataList;}


    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }


    public List<Data> getDataList() {
        return dataList;
    }


}
