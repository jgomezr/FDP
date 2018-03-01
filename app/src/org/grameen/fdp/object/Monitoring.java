package org.grameen.fdp.object;

/**
 * Created by aangjnr on 08/02/2018.
 */

public class Monitoring {

    String id;
    String name;
    String json;
    String plotId;



    public Monitoring(){}


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJson() {
        return json;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public void setPlotId(String plotId) {
        this.plotId = plotId;
    }

    public String getPlotId() {
        return plotId;
    }




}
