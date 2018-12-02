package org.grameen.fdp.object;

import java.util.List;

/**
 * Created by aangjnr on 27/01/2018.
 */

public class DetailedYearData {

    String name;

    List<HistoricalTableViewData> dataList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HistoricalTableViewData> getDataList() {
        return dataList;
    }

    public void setDataList(List<HistoricalTableViewData> dataList) {
        this.dataList = dataList;
    }
}
