package org.grameenfoundation.fdp.model;

/**
 * Created by julian on 7/06/2016.
 */
public class Plot {
    public String plot_id;
    public String farm_parent_id;
    public Integer total_plot_area;
    public String plot_area_units;
    public Integer number_of_trees;
    public Plot(String plot_id, String farm_parent_id, Integer total_plot_area, String plot_area_units, Integer number_of_trees){
        this.plot_id = plot_id;
        this.farm_parent_id = farm_parent_id;
        this.total_plot_area = total_plot_area;
        this.plot_area_units = plot_area_units;
        this.number_of_trees = number_of_trees;
    }
}
