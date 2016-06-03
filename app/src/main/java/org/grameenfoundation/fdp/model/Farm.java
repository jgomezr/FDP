package org.grameenfoundation.fdp.model;

/**
 * Created by julian_Gf on 6/3/2016.
 */
public class Farm {
    public String farm_id;
    public String farmer_owner_id;
    public String farm_region;
    public String farm_municipality;
    public String farm_country_id;
    public Integer total_farm_area;
    public String farm_area_units;
    public Farm (String farm_id, String farmer_owner_id, String farm_region, String farm_municipality, String farm_country_id, Integer total_farm_area, String farm_area_units){
        this.farm_id = farm_id;
        this.farmer_owner_id = farmer_owner_id;
        this.farm_region = farm_region;
        this.farm_municipality = farm_municipality;
        this.farm_country_id = farm_country_id;
        this.total_farm_area = total_farm_area;
        this.farm_area_units = farm_area_units;
    }
}
