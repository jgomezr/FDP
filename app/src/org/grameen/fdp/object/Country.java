package org.grameen.fdp.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aangjnr on 30/01/2018.
 */

public class Country {


    String Id;

    String Name;

    @SerializedName("currencySign__c")
    String currency;

    @SerializedName("ISO_code__c")
    String isoCode;

    @SerializedName("Avg_Price_Kg__c")
    String averageGatePrice;


    public Country() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAverageGatePrice() {
        return averageGatePrice;
    }

    public void setAverageGatePrice(String averageGatePrice) {
        this.averageGatePrice = averageGatePrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
