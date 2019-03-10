package org.grameen.fdp.sync; // change the package if is needed


import android.text.TextUtils;

import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;

import org.grameen.fdp.utility.Constants;
import org.json.JSONObject;

import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCALLY_CREATED;
import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCALLY_DELETED;
import static com.salesforce.androidsdk.smartsync.target.SyncTarget.LOCALLY_UPDATED;
import static com.salesforce.androidsdk.smartsync.util.Constants.ID;

/**
 * A simple representation of a Answer object.
 *
 * @author bhariharan
 */
public class AnswerObject extends SalesforceObject {

	public static final String NAME = "Name"; //text with the answer
	public static final String ANSWER = "Answer__c"; //text with the answer
	public static final String FARMER = "Farmer__c"; // Id of the farmer object in SF
	public static final String FARMER_ID = "Farmer_ID__c";// text with the farmer code
	public static final String QUESTION = "Question__c";// Id of the question object in SF
	public static final String SUBMISSION = "Submission__c"; // Id of the submission object in SF

	public static final String[] ANSWER_FIELDS_SYNC_DOWN = { //the "ANSWER_FIELDS_SYNC_DOWN" is a variable need to be declared
        NAME,
        ANSWER,
        FARMER,
        FARMER_ID,
        QUESTION,
        SUBMISSION
    };

    private boolean isLocallyModified;

    /**
     * Parameterized constructor.
     *
     * @param data Raw data.
     */
    public AnswerObject(JSONObject data) {
        super(data);
        objectType = Constants.ANSWERS;//create the constant public static final String ANSWERS = "fpd_Answer__c";
        objectId = data.optString(ID);
        name = data.optString(NAME) + " - " + data.optString(QUESTION);
        isLocallyModified = data.optBoolean(LOCALLY_UPDATED) ||
                data.optBoolean(LOCALLY_CREATED) ||
                data.optBoolean(LOCALLY_DELETED);
    }

    /**
     * Returns Name of the answer.
     *
     * @return Name of the answer.
     */
    public String getName() {
        return sanitizeText(rawData.optString(NAME));
    }

    /**
     * Returns Answer of the answer.
     *
     * @return Name of the Answer.
     */
    public String getAnswer() {
        return sanitizeText(rawData.optString(ANSWER));
    }

    /**
     * Returns Farmer Id of the answer.
     *
     * @return the Farmer Id.
     */
    public String getFarmer() {
        return sanitizeText(rawData.optString(FARMER));
    }

    /**
     * Returns Farmer code of the answer.
     *
     * @return the Farmer code.
     */
    public String getFarmerId() {
        return sanitizeText(rawData.optString(FARMER_ID));
    }

    /**
     * Returns Question Id of the answer.
     *
     * @return Question Id.
     */
    public String getQuestion() {
        return sanitizeText(rawData.optString(QUESTION));
    }

    /**
     * Returns Submission Id of the answer.
     *
     * @return Submission Id.
     */
    public String getSubmission() {
        return sanitizeText(rawData.optString(SUBMISSION));
    }

	private String sanitizeText(String text) {
        if (TextUtils.isEmpty(text) || text.equals(Constants.NULL_STRING)) { // create the in the constants public static final String NULL_STRING = "null";
            return Constants.EMPTY_STRING; // create in the constants public static final String EMPTY_STRING = "";
        }
        return text;
    }
}