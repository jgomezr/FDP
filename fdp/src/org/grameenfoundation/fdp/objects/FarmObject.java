package org.grameenfoundation.fdp.objects;

import android.text.TextUtils;

import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;

import org.json.JSONObject;

/**
 * A simple representation of Farm Object
 * Created by julian_Gf on 6/26/2016.
 */
public class FarmObject extends SalesforceObject {
    public static final String FARM_NAME = "Name";
    public static final String FARM_AGE = "farmAge__c";
    public static final String FARM_CERTIFICATIONS = "farmCertifications__c";
    public static final String FARM_GPS = "gps__c";
    public static final String TOTAL_AREA = "totalFarmArea__c";
    public static final String FARM_VILLAGE = "village__c";
    public static final String [] FARM_FIELDS_SYNC_DOWN = {
            FARM_NAME,
            FARM_AGE,
            FARM_CERTIFICATIONS,
            FARM_GPS,
            TOTAL_AREA,
            FARM_VILLAGE
    };
    public static final String [] FARM_FIELDS_SYNC_UP = {
            Constants.ID,
            FARM_NAME,
            FARM_AGE,
            FARM_CERTIFICATIONS,
            FARM_GPS,
            TOTAL_AREA,
            FARM_VILLAGE
    };

    private boolean isLocallModified;

    /**
     * Parameterized constructor.
     *
     * @param data Raw data for object.
     */
    public FarmObject(JSONObject data) {
        super(data);
        objectType = Constants.FARM;
        objectId = data.optString(Constants.ID);
        name = data.optString(FARM_NAME);
        isLocallModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED) ||
                data.optBoolean(SyncManager.LOCALLY_DELETED);
    }

    /**
     * Returns Name of the farm
     * @return Name of the farm
     */
    public String getFarmName () {return sanitizeText(rawData.optString(FARM_NAME));
    }

    /**
     * Returns Age of the farm
     * @return Age of the farm
     */
    public String getFarmAge () {return sanitizeText(rawData.optString(FARM_AGE));
    }

    /**
     * Returns certifications of the farm
     * @return certifications of the farm
     */
    public String getFarmCertifications () {return sanitizeText(rawData.optString(FARM_CERTIFICATIONS));
    }

    /**
     * Returns GPS of the farm
     * @return GPS of the farm
     */
    public String getFarmGPS() {return sanitizeText(rawData.optString(FARM_GPS));
    }

    /**
     * Returns Total Area of the farm
     * @return Total Area of the farm
     */
    public String getFarmArea() {return sanitizeText(rawData.optString(TOTAL_AREA));
    }

    /**
     * Returns Village of the farm
     * @return Village of the farm
     */
    public String getFarmVillage() {return sanitizeText(rawData.optString(FARM_VILLAGE));
    }

    private String sanitizeText(String text) {
        if (TextUtils.isEmpty(text) || text.equals(Constants.NULL_STRING)) {
            return Constants.EMPTY_STRING;
        }
        return text;
    }
}
