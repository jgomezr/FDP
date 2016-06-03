package org.grameenfoundation.fdp.model;

import java.util.Date;

/**
 * Created by julian_Gf on 6/2/2016.
 */
public class Farmer {
    public String farmer_id;
    public Date bday;
    public String national_id;
    public String region;
    public String municipality;
    public String country_id;

    public Farmer(String farmer_id, Date bday, String national_id,String region, String municipality, String country_id ){
        this.country_id = country_id;
        this.farmer_id = farmer_id;
        this.bday = bday;
        this.national_id = national_id;
        this.region = region;
        this.municipality = municipality;
    }
}
