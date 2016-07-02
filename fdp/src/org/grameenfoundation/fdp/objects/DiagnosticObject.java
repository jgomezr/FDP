package org.grameenfoundation.fdp.objects;

import android.text.TextUtils;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;
import org.json.JSONObject;

/**
 * A represetacion of AODiagnostic object
 * Created by julian_Gf on 6/29/2016.
 */
public class DiagnosticObject extends SalesforceObject {
    public static final String NAME = "Name";
    public static final String PLOT = "plot__c";
    public static final String AGREE = "agreedRecommendations__c";
    public static final String REASONNOTAGREE = "reasonsNotAgreed__c";
    public static final String SURVEYOR = "surveyor__c";
    public static final String PLANTINGMATERIAL = "plantingMaterial__c";
    public static final String FARMCONDITION = "farmCondition__c";
    public static final String TREEDENSITY = "treeDensity__c";
    public static final String TREEEAGE = "treeAge__c";
    public static final String TREEHEALTH = "treeHealth__c";
    public static final String DEBILITATINGDESEASE = "debilitatingDisease__c";
    public static final String PRUNING = "pruning__c";
    public static final String PESTDISEASESANITATION = "pestDiseaseSanitation__c";
    public static final String WEEDING = "weeding__c";
    public static final String HARVESTING = "harvesting__c";
    public static final String SHADEMANAGEMENT = "shadeManagement__c";
    public static final String SOILCONDITION = "soilCondition__c";
    public static final String ORGANICMATTER = "organicMatter__c";
    public static final String FERTILIZERFORMULATION = "fertilizerFormulation__c";
    public static final String FERTILIZERAPPLICATIION = "fertilizerApplication__c";
    public static final String LIMENEED = "limeNeed__c";
    public static final String DRAINAGENEED = "drainnageNeed__c";
    public static final String FILLINGOPTION = "fillingOption__c";
    public static final String HIRELABOR = "hireLabor__c";
    public static final String[] DIAGNOSTIC_FIELDS_SYNC_DOWN ={
            NAME,
            PLOT,
            AGREE,
            REASONNOTAGREE,
            SURVEYOR,
            PLANTINGMATERIAL,
            FARMCONDITION,
            TREEDENSITY,
            TREEEAGE,
            TREEHEALTH,
            DEBILITATINGDESEASE,
            PRUNING,
            PESTDISEASESANITATION,
            WEEDING,
            HARVESTING,
            SHADEMANAGEMENT,
            SOILCONDITION,
            ORGANICMATTER,
            FERTILIZERFORMULATION,
            FERTILIZERAPPLICATIION,
            LIMENEED,
            DRAINAGENEED,
            FILLINGOPTION,
            HIRELABOR
    };
    public static final String[] DIAGNOSTIC_FIELDS_SYNC_UP ={
            Constants.ID,
            NAME,
            PLOT,
            AGREE,
            REASONNOTAGREE,
            SURVEYOR,
            PLANTINGMATERIAL,
            FARMCONDITION,
            TREEDENSITY,
            TREEEAGE,
            TREEHEALTH,
            DEBILITATINGDESEASE,
            PRUNING,
            PESTDISEASESANITATION,
            WEEDING,
            HARVESTING,
            SHADEMANAGEMENT,
            SOILCONDITION,
            ORGANICMATTER,
            FERTILIZERFORMULATION,
            FERTILIZERAPPLICATIION,
            LIMENEED,
            DRAINAGENEED,
            FILLINGOPTION,
            HIRELABOR
    };

    private boolean isLocallyModified;

    /**
     * Parameterized constructor.
     * @param data Raw data for object.
     */
    public DiagnosticObject(JSONObject data) {
        super(data);
        objectType = Constants.DIAGNOSTIC;
        objectId = data.optString(Constants.ID);
        name = data.optString(NAME);
        isLocallyModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED);
    }

    /**
     * Returns Name of Diagnostic
     * @return Name of Diagnostic
     */
    public String getDName() {
        return sanitizeText(rawData.optString(NAME));
    }

    /**
     * Returns Plot id
     * @return Plot id
     */
    public String getDPlot() {
        return sanitizeText(rawData.optString(PLOT));
    }

    /**
     * Returns farmer agree with recommendations
     * @return farmer agree with recommendations
     */
    public String getDAgree() {
        return sanitizeText(rawData.optString(AGREE));
    }

    /**
     * Returns farmer reason not agree
     * @return farmer reason not agree
     */
    public String getDReasonNotAgree() {
        return sanitizeText(rawData.optString(REASONNOTAGREE));
    }

    /**
     * Returns surveyor
     * @return surveyor
     */
    public String getDSurveyor() {
        return sanitizeText(rawData.optString(SURVEYOR));
    }

    /**
     * Returns Planting material
     * @return Planting material
     */
    public String getDPlantingMaterial() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL));
    }

    /**
     * Returns Farm Condition
     * @return Farm Condition
     */
    public String getDFarmCondition() {return sanitizeText(rawData.optString(FARMCONDITION));}

    /**
     * Returns Tree Density
     * @return Tree Density
     */
    public String getDTreeDensity() {return sanitizeText(rawData.optString(TREEDENSITY));}

    /**
     * Returns Tree Age
     * @return Tree Age
     */
    public String getDTreeAge() {return sanitizeText(rawData.optString(TREEEAGE));}

    /**
     * Returns Tree Health
     * @return Tree Health
     */
    public String getDTreeHealth() {return sanitizeText(rawData.optString(TREEHEALTH));}

    /**
     * Returns Debilitating Disease
     * @return Debilitating Disease
     */
    public String getDDebilitatingDisease() {return sanitizeText(rawData.optString(DEBILITATINGDESEASE));}

    /**
     * Returns pruning
     * @return pruning
     */
    public String getDPruning() {return sanitizeText(rawData.optString(PRUNING));}

    /**
     * Returns pest disease sanitation
     * @return pest disease sanitation
     */
    public String getDPestDiseaseSanitation() {return sanitizeText(rawData.optString(PESTDISEASESANITATION));}

    /**
     * Returns weeding
     * @return weeding
     */
    public String getDWeeding() {return sanitizeText(rawData.optString(WEEDING));}

    /**
     * Returns Harvesting
     * @return Harvesting
     */
    public String getDHarvesting() {return sanitizeText(rawData.optString(HARVESTING));}

    /**
     * Returns Shade Management
     * @return Shade Management
     */
    public String getDShadeManagement() {return sanitizeText(rawData.optString(SHADEMANAGEMENT));}

    /**
     * Returns Soil Condition
     * @return Soil Condition
     */
    public String getDSoilCondition() {return sanitizeText(rawData.optString(SOILCONDITION));}

    /**
     * Returns Organic Matter
     * @return Organic Matter
     */
    public String getDOrganicMatter() {return sanitizeText(rawData.optString(ORGANICMATTER));}

    /**
     * Returns Fertilizer formulation
     * @return Fertilizer formulation
     */
    public String getDFertilizerFormulation() {return sanitizeText(rawData.optString(FERTILIZERFORMULATION));}

    /**
     * Returns Fertilizer application
     * @return Fertilizer application
     */
    public String getDFertilizerApplication() {return sanitizeText(rawData.optString(FERTILIZERAPPLICATIION));}

    /**
     * Returns lime Need
     * @return lime Need
     */
    public String getDLimeNeed() {return sanitizeText(rawData.optString(LIMENEED));}

    /**
     * Returns drainage Need
     * @return drainage Need
     */
    public String getDDrainageNeed() {return sanitizeText(rawData.optString(DRAINAGENEED));}

    /**
     * Returns Filling option
     * @return Filling option
     */
    public String getDFillingOption() {return sanitizeText(rawData.optString(FILLINGOPTION));}

    /**
     * Returns Hire Labor
     * @return Hire Labor
     */
    public String getDHireLabor() {return sanitizeText(rawData.optString(HIRELABOR));}


    /**
     * Returns whether the Diagnostic has been locally modified or not.
     * @return True - if the Diagnostic has been locally modified, False - otherwise.
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
