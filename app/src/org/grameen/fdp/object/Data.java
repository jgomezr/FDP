package org.grameen.fdp.object;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by aangjnr on 18/01/2018.
 */

public class Data {


    String label;
    String tag;

    List<String> yearsDataFormula;
    String singleValue;


     public Data(String label, @Nullable  List<String> yearsDataFormula, String tag){this.label = label; this.yearsDataFormula = yearsDataFormula; this.tag = tag;}

     public Data(String label, String s) {
         this.label = label;
         this.singleValue = s;
      }

    public Data() {

    }



    public void setLabel(String name) {
        this.label = name;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLabel() {
        return label;
    }

    public String getTag() {
        return tag;
    }

    public void setYearsDataFormula(List<String> yearsDataFormula) {
        this.yearsDataFormula = yearsDataFormula;
    }

    public List<String> getYearsDataFormula() {
        return yearsDataFormula;
    }


    public void setSingleValue(String singleValue) {
        this.singleValue = singleValue;
    }

    public String getSingleValue() {
        return singleValue;
    }
}
