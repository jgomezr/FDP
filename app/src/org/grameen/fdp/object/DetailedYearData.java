package org.grameen.fdp.object;

import java.util.List;

/**
 * Created by aangjnr on 27/01/2018.
 */

public class DetailedYearData {

    String name;

    List<Data> dataList;


    public void setName(String name) {
        this.name = name;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public String getName() {
        return name;
    }

    public List<Data> getDataList() {
        return dataList;
    }
}
