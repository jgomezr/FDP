package org.grameenfoundation.fdp.objects;

import android.text.TextUtils;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;
import org.json.JSONObject;

/**
 * A representation of Farm Baseline Object
 * Created by julian_Gf on 6/29/2016.
 */
public class FarmBLObject extends SalesforceObject {
    public static final String NAME = "Name";
    public static final String FARM = "farm__c";
    public static final String TOTALCOCOAAREA = "totalCocoaArea__c";
    public static final String TOTALRENOVATIONAREA = "totalRenovationArea__c";
    public static final String OTHERCROPS = "haveAditionalCrops__c";
    public static final String ADITIONALCROPS = "aditionalCrops__c";
    public static final String AREAOTHERCROPS = "totalAreaOtherCrops__c";
    public static final String FAMILYWORKONFARM = "familyMembersWorkOnFarm__c";
    public static final String HIRELABOR = "hireLabor__c";
    public static final String HIREDAYS = "howManyLaborDaysHire__c";
    public static final String PRODUCTIONCOCOALY = "productionCocoaLY__c";
    public static final String COCOAPRICE = "averageCocoaPrice__c";
    public static final String NUMBERPLOTS = "numberOfPlots__c";
    public static final String[] FARMBL_FIELDS_SYNC_DOWN ={
            NAME,
            FARM,
            TOTALCOCOAAREA,
            TOTALRENOVATIONAREA,
            OTHERCROPS,
            ADITIONALCROPS,
            AREAOTHERCROPS,
            FAMILYWORKONFARM,
            HIRELABOR,
            HIREDAYS,
            PRODUCTIONCOCOALY,
            COCOAPRICE,
            NUMBERPLOTS
    };
    public static final String[] FARMBL_FIELDS_SYNC_UP ={
            Constants.ID,
            NAME,
            FARM,
            TOTALCOCOAAREA,
            TOTALRENOVATIONAREA,
            OTHERCROPS,
            ADITIONALCROPS,
            AREAOTHERCROPS,
            FAMILYWORKONFARM,
            HIRELABOR,
            HIREDAYS,
            PRODUCTIONCOCOALY,
            COCOAPRICE,
            NUMBERPLOTS
    };

    private boolean isLocallyModified;

    /**
     * Parameterized constructor.
     * @param data Raw data for object.
     */
    public FarmBLObject(JSONObject data) {
        super(data);
        objectType = Constants.FARMBL;
        objectId = data.optString(Constants.ID);
        name = data.optString(NAME);
        isLocallyModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED);
    }

    /**
     * Returns Name Farm Baseline Record
     * @return Name Farm Baseline Record
     */
    public String getFBLName() {
        return sanitizeText(rawData.optString(NAME));
    }

    /**
     * Returns Farm id
     * @return Farm id
     */
    public String getFBLFarm() {
        return sanitizeText(rawData.optString(FARM));
    }

    /**
     * Returns total cocoa area
     * @return total cocoa area
     */
    public String getFBLTotalCocoaArea() {
        return sanitizeText(rawData.optString(TOTALCOCOAAREA));
    }

    /**
     * Returns total renovation area
     * @return total renovation area
     */
    public String getFBLTotalRenovationArea() {
        return sanitizeText(rawData.optString(TOTALRENOVATIONAREA));
    }

    /**
     * Returns other crops
     * @return other crops
     */
    public String getFBLOtherCrops() {
        return sanitizeText(rawData.optString(OTHERCROPS));
    }

    /**
     * Returns other crops names
     * @return other crops names
     */
    public String getFBLAditionalCrops() {
        return sanitizeText(rawData.optString(ADITIONALCROPS));
    }

    /**
     * Returns area other crops
     * @return area other crops
     */
    public String getFBLAreaOtherCrops() {
        return sanitizeText(rawData.optString(AREAOTHERCROPS));
    }

    /**
     * Returns Family work on farm
     * @return Family work on farm
     */
    public String getFBLFamilyWorkOnFarm() {
        return sanitizeText(rawData.optString(FAMILYWORKONFARM));
    }

    /**
     * Returns Hire Labor
     * @return Hire Labor
     */
    public String getFBLHireLabor() {
        return sanitizeText(rawData.optString(HIRELABOR));
    }

    /**
     * Returns Hire Labor Days
     * @return Hire Labor Days
     */
    public String getFBLHireDays() {
        return sanitizeText(rawData.optString(HIREDAYS));
    }

    /**
     * Returns Production Cocoa Last Year
     * @return Production Cocoa Last Year
     */
    public String getFBLProductionCocoaLY() {
        return sanitizeText(rawData.optString(PRODUCTIONCOCOALY));
    }

    /**
     * Returns Average Cocoa price last year
     * @return Average Cocoa price last year
     */
    public String getFBLCocoaPrice() {
        return sanitizeText(rawData.optString(COCOAPRICE));
    }

    /**
     * Returns number of plots
     * @return number of plots
     */
    public String getFBLNumberPlots() {
        return sanitizeText(rawData.optString(NUMBERPLOTS));
    }

    /**
     * Returns whether the Farm Baseline has been locally modified or not.
     * @return True - if the Farm Baseline has been locally modified, False - otherwise.
     */
    public boolean isLocallyModified() {
        return isLocallyModified;
    }

    private String sanitizeText(String text) {
        if (TextUtils.isEmpty(text) || text.equals(Constants.NULL_STRING)) {
            return Constants.EMPTY_STRING;
        }
        return text;
    }
}
