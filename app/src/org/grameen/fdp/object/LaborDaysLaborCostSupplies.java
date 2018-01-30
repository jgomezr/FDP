package org.grameen.fdp.object;

/**
 * Created by aangjnr on 22/01/2018.
 */

public class LaborDaysLaborCostSupplies {


    String laborDays;
    String laborCost;
    String suppliesCost;



    public LaborDaysLaborCostSupplies(){}


    public void setLaborCost(String laborCost) {
        this.laborCost = laborCost;
    }

    public void setLaborDays(String laborDays) {
        this.laborDays = laborDays;
    }

    public void setSuppliesCost(String supplies) {
        this.suppliesCost = supplies;
    }

    public String getLaborCost() {
        return laborCost;
    }

    public String getLaborDays() {
        return laborDays;
    }

    public String getSuppliesCost() {
        return suppliesCost;

    }




}
