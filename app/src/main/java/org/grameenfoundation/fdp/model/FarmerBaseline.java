package org.grameenfoundation.fdp.model;

/**
 * Created by julian_Gf on 6/3/2016.
 */
public class FarmerBaseline {
    public String farmer_parent_id;
    public Integer household_income;
    public String income_source;
    public Integer percent_income_cacao;
    public FarmerBaseline(String farmer_parent_id,Integer household_income,String income_source,Integer percent_income_cacao){
        this.farmer_parent_id = farmer_parent_id;
        this.household_income = household_income;
        this.income_source = income_source;
        this.percent_income_cacao = percent_income_cacao;
    }
}
