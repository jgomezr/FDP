package org.grameenfoundation.fdp.objects;

import android.text.TextUtils;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;
import org.json.JSONObject;

/**
 * A representation of Plot Object
 * Created by julian_Gf on 6/29/2016.
 */
public class PlotObject extends SalesforceObject {
    public static final String NAME = "Name";
    public static final String FARMBL = "farmBL__c";
    public static final String PLOTGPS = "plotGPS__c";
    public static final String PLOTAGE = "plotAge__c";
    public static final String PLOTAREA = "plotArea__c";
    public static final String COCOATREES = "numberOfCocoaTrees__c";
    public static final String ESTIMATEDYIELD = "estimatedProduction__c";
    public static final String SHADETREES = "numberShadeTrees__c";
    public static final String[] PLOT_FIELDS_SYNC_DOWN ={
            NAME,
            FARMBL,
            PLOTGPS,
            PLOTAGE,
            PLOTAREA,
            COCOATREES,
            ESTIMATEDYIELD,
            SHADETREES
    };
    public static final String[] PLOT_FIELDS_SYNC_UP ={
            Constants.ID,
            NAME,
            FARMBL,
            PLOTGPS,
            PLOTAGE,
            PLOTAREA,
            COCOATREES,
            ESTIMATEDYIELD,
            SHADETREES
    };

    private boolean isLocallyModified;

    /**
     * Parameterized constructor.
     * @param data Raw data for object.
     */
    public PlotObject(JSONObject data) {
        super(data);
        objectType = Constants.PLOT;
        objectId = data.optString(Constants.ID);
        name = data.optString(NAME);
        isLocallyModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED);
    }

    /**
     * Returns name of plot
     * @return name of plot
     */
    public String getPName() {
        return sanitizeText(rawData.optString(NAME));
    }

    /**
     * Returns Farm Baseline id
     * @return Farm Baseline id
     */
    public String getPFarmBL() {
        return sanitizeText(rawData.optString(FARMBL));
    }

    /**
     * Returns plot gps position
     * @return plot gps position
     */
    public String getPGPS() {
        return sanitizeText(rawData.optString(PLOTGPS));
    }

    /**
     * Returns plot age
     * @return plot age
     */
    public String getPAge() {
        return sanitizeText(rawData.optString(PLOTAGE));
    }

    /**
     * Returns plot area
     * @return plot area
     */
    public String getPArea() {
        return sanitizeText(rawData.optString(PLOTAREA));
    }

    /**
     * Returns Number of cocoa trees
     * @return Number of cocoa trees
     */
    public String getPCocoaTrees() {
        return sanitizeText(rawData.optString(COCOATREES));
    }

    /**
     * Returns plot estimated production
     * @return plot estimated production
     */
    public String getPEstimatedYield() {
        return sanitizeText(rawData.optString(ESTIMATEDYIELD));
    }

    /**
     * Returns Shade Trees
     * @return Shade Trees
     */
    public String getPShadeTrees() {
        return sanitizeText(rawData.optString(SHADETREES));
    }
    
    /**
     * Returns whether the Plot has been locally modified or not.
     * @return True - if the Plot has been locally modified, False - otherwise.
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
