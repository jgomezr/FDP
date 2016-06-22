package org.grameenfoundation.fdp.objects;

import android.text.TextUtils;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;
import org.json.JSONObject;

/**
 * A simple representation of Farmer Object
 * Created by julian_Gf on 6/22/2016.
 */
public class FarmerObject extends SalesforceObject {
    public static final String NAME = "Name";
    public static final String BIRTHDAY = "birthday__c";
    public static final String EDUCATIONAL_LV = "educationalLevel__c";
    public static final String FARMER_CODE = "farmerCode__c";
    public static final String FULL_NAME = "fullName__c";
    public static final String GENDER = "gender__c";
    public static final String GPS = "gps__c";
    public static final String ADDRESS = "householdAddress__c";
    public static final String RELATION_MARS = "yearsRelationshipWithMars__c";
    public static final String SPOUSE_NAME = "spouseName__c";
    public static final String SPOUSE_ED_LV = "spouseEducationalLevel__c";
    public static final String SPOUSE_BDAY = "spouseName__c";
    public static final String VILLAGE = "village__c";
    public static final String [] FARMER_FIELDS_SYNC_DOWN = {
            NAME,
            BIRTHDAY,
            EDUCATIONAL_LV,
            FARMER_CODE,
            FULL_NAME,
            GENDER,
            GPS,
            ADDRESS,
            RELATION_MARS,
            SPOUSE_NAME,
            SPOUSE_ED_LV,
            SPOUSE_BDAY,
            VILLAGE
    };
    public static final String[] FARMER_FIELDS_SYNC_UP = {
            Constants.ID,
            NAME,
            BIRTHDAY,
            EDUCATIONAL_LV,
            FARMER_CODE,
            FULL_NAME,
            GENDER,
            GPS,
            ADDRESS,
            RELATION_MARS,
            SPOUSE_NAME,
            SPOUSE_ED_LV,
            SPOUSE_BDAY,
            VILLAGE
    };

    private boolean isLocallModified;

    /**
     * Parameterized constructor.
     *
     * @param data Raw data for object.
     */
    public FarmerObject(JSONObject data) {
        super(data);
        objectType = Constants.FARMER;
        objectId = data.optString(Constants.ID);
        name = data.optString(NAME) + " " + data.optString(FULL_NAME);
        isLocallModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED) ||
                data.optBoolean(SyncManager.LOCALLY_DELETED);
    }

    /**
     * Returns National Id of the farmer
     * @return National Id of the farmer
     */
    public String getNationalID () {return sanitizeText(rawData.optString(NAME));
    }

    /**
     * Returns Birthday of the farmer
     * @return Birthday of the farmer
     */
    public String getBirthday () {return sanitizeText(rawData.optString(BIRTHDAY));
    }

    /**
     * Returns Educational Level of the farmer
     * @return Educational Level of the farmer
     */
    public String getEducationalLV () {return sanitizeText(rawData.optString(EDUCATIONAL_LV));
    }

    /**
     * Returns Farmer Code
     * @return Farmer Code
     */
    public String getFarmerCode () {return sanitizeText(rawData.optString(FARMER_CODE));
    }

    /**
     * Returns Full Name of the farmer
     * @return Full Name of the farmer
     */
    public String getFullName () {return sanitizeText(rawData.optString(FULL_NAME));
    }

    /**
     * Returns Gender of the farmer
     * @return Gender of the farmer
     */
    public String getGender () {return sanitizeText(rawData.optString(GENDER));
    }

    private String sanitizeText(String text) {
        if (TextUtils.isEmpty(text) || text.equals(Constants.NULL_STRING)) {
            return Constants.EMPTY_STRING;
        }
        return text;
    }
}
