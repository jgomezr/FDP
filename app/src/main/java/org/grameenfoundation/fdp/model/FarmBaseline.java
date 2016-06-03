package org.grameenfoundation.fdp.model;

import java.util.Date;

/**
 * Created by julian_Gf on 6/3/2016.
 */
public class FarmBaseline {
    public String farm_owner_id;
    public String water_source;
    public String disponsal_system;
    public String farm_map;
    public Date bl_date;
    public FarmBaseline (String farm_owner_id,String water_source,String disponsal_system,String farm_map,Date bl_date){
        this.farm_owner_id = farm_owner_id;
        this.water_source = water_source;
        this.disponsal_system = disponsal_system;
        this.farm_map = farm_map;
        this.bl_date = bl_date;
    }
}
