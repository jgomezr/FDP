package org.grameenfoundation.fdp.model;

/**
 * Created by julian on 7/06/2016.
 */
public class Practices {
    public String fdp_id;
    public String fdp_country_id;
    public String practice_name;
    public Practices (String fdp_id,String fdp_country_id, String practice_name){
        this.fdp_id = fdp_id;
        this.fdp_country_id = fdp_country_id;
        this.practice_name = practice_name;
    }
}
