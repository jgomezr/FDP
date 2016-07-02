package org.grameenfoundation.fdp.objects;

import android.text.TextUtils;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;
import org.json.JSONObject;

/**
 * A representation of Farmer Baseline Object
 * Created by julian_Gf on 6/29/2016.
 */
public class FarmerBLObject extends SalesforceObject {
    public static final String NAME = "Name";
    public static final String FARMER = "farmer__c";
    public static final String UNDER17 = "under17__c";
    public static final String UNDER17SCHOOL = "under17InSchool__c";
    public static final String FAMILIMEMBERS = "familyMembers__c";
    public static final String DEPENDECONOMICALLY = "dependEconomically__c";
    public static final String PAYMENTLABOR = "receivesPaymentFarmLabor__c";
    public static final String SPOUSEPAID = "spouseHavePaidWork__c";
    public static final String FAMILYPAID = "familyMembersPaidWork__c";
    public static final String EXPENSESCOCOALY = "expensesCocoaLY__c";
    public static final String GROSSINCOMECOCOALY = "grossIncomeCocoaLY__c";
    public static final String INCOMEOTHERCROPS = "incomeOtherCrops__c";
    public static final String INCOMEFARMLABOR = "incomeFarmLabor__c";
    public static final String SPOUSEINCOME = "spouseIncome__c";
    public static final String FAMILYMEMBERSINCOME = "familyMembersIncome__c";
    public static final String LIVINGEXPENSES = "annualLivingExpenses__c";
    public static final String HOUSINGCOST = "annualCostOfHousing__c";
    public static final String OTHEREXPENSES ="annualOtherExpenses__c";
    public static final String PLANNEDINVESTMENTS = "plannedInvestments__c";
    public static final String EDUCATIONEXPENSES = "expectedEducationExpenses__c";
    public static final String HAVECREDIT = "haveCredit__c";
    public static final String PAYFORCREDIT = "howMuchPayForCredit__c";
    public static final String GIVELOAN = "givenSomeoneALoan__c";
    public static final String AMMOUNTLOAN = "amountOfLoan__c";
    public static final String LOANINCOME = "loanMoneyGetBack__c";
    public static final String HOUSESAVINGS = "householdSavings__c";
    public static final String COMMENTS = "farmerComments__c";
    public static final String[] FARMERBL_FIELDS_SYNC_DOWN ={
            NAME,
            FARMER,
            UNDER17,
            UNDER17SCHOOL,
            FAMILIMEMBERS,
            DEPENDECONOMICALLY,
            PAYMENTLABOR,
            SPOUSEPAID,
            FAMILYPAID,
            EXPENSESCOCOALY,
            GROSSINCOMECOCOALY,
            INCOMEOTHERCROPS,
            INCOMEFARMLABOR,
            SPOUSEINCOME,
            FAMILYMEMBERSINCOME,
            LIVINGEXPENSES,
            HOUSINGCOST,
            OTHEREXPENSES,
            PLANNEDINVESTMENTS,
            EDUCATIONEXPENSES,
            HAVECREDIT,
            PAYFORCREDIT,
            GIVELOAN,
            AMMOUNTLOAN,
            LOANINCOME,
            HOUSESAVINGS,
            COMMENTS
    };
    public static final String[] FARMERBL_FIELDS_SYNC_UP = {
            Constants.ID,
            NAME,
            FARMER,
            UNDER17,
            UNDER17SCHOOL,
            FAMILIMEMBERS,
            DEPENDECONOMICALLY,
            PAYMENTLABOR,
            SPOUSEPAID,
            FAMILYPAID,
            EXPENSESCOCOALY,
            GROSSINCOMECOCOALY,
            INCOMEOTHERCROPS,
            INCOMEFARMLABOR,
            SPOUSEINCOME,
            FAMILYMEMBERSINCOME,
            LIVINGEXPENSES,
            HOUSINGCOST,
            OTHEREXPENSES,
            PLANNEDINVESTMENTS,
            EDUCATIONEXPENSES,
            HAVECREDIT,
            PAYFORCREDIT,
            GIVELOAN,
            AMMOUNTLOAN,
            LOANINCOME,
            HOUSESAVINGS,
            COMMENTS
    };

    private boolean isLocallyModified;

    /**
     * Parameterized constructor.
     * @param data Raw data for ct.
     */
    public FarmerBLObject(JSONObject data) {
        super(data);
        objectType = Constants.FARMERBL;
        objectId = data.optString(Constants.ID);
        name = data.optString(NAME);
        isLocallyModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED);
    }

    /**
     * Returns Name Farmer Baseline Record
     * @return Name Farmer Baseline Record
     */
    public String getFMBLName() {
        return sanitizeText(rawData.optString(NAME));
    }

    /**
     * Returns Farmer Id
     * @return Farmer Id
     */
    public String getFMBLFarmer() {
        return sanitizeText(rawData.optString(FARMER));
    }

    /**
     * Returns Number of members under 17 years old
     * @return Number of members under 17 years old
     */
    public String getFMBLUnder17() {
        return sanitizeText(rawData.optString(UNDER17));
    }

    /**
     * Returns Number of members under 17 years old atends school
     * @return Number of members under 17 years old atends school
     */
    public String getFMBLUnder17School() {
        return sanitizeText(rawData.optString(UNDER17SCHOOL));
    }

    /**
     * Returns Number of family members
     * @return Number of family members
     */
    public String getFMBLFamilyMembers() {
        return sanitizeText(rawData.optString(FAMILIMEMBERS));
    }

    /**
     * Returns Number of family members depends economically
     * @return Number of family members depends economically
     */
    public String getFMBLDependsEconomically() {
        return sanitizeText(rawData.optString(DEPENDECONOMICALLY));
    }

    /**
     * Returns Farmer receive payment for labor
     * @return Farmer receive payment for labor
     */
    public String getFMBLPaymentLabor() {
        return sanitizeText(rawData.optString(PAYMENTLABOR));
    }

    /**
     * Returns Farmer spouse receive any paid
     * @return Farmer spouse receive any paid
     */
    public String getFMBLSposePaid() {
        return sanitizeText(rawData.optString(SPOUSEPAID));
    }

    /**
     * Returns Family member receive paid
     * @return Family member receive paid
     */
    public String getFMBLFamilyPaid() {
        return sanitizeText(rawData.optString(FAMILYPAID));
    }

    /**
     * Returns Expenses Cocoa Last Year
     * @return Expenses Cocoa Last Year
     */
    public String getFMBLExpensesCocoaLY() {
        return sanitizeText(rawData.optString(EXPENSESCOCOALY));
    }

    /**
     * Returns Gross income cocoa last year
     * @return Gross income cocoa last year
     */
    public String getFMBLGrossIncomeCocoaLY() {
        return sanitizeText(rawData.optString(GROSSINCOMECOCOALY));
    }

    /**
     * Returns income other crops
     * @return income other crops
     */
    public String getFMBLIncomeOtherCrops() {
        return sanitizeText(rawData.optString(INCOMEOTHERCROPS));
    }

    /**
     * Returns income farm labor
     * @return income farm labor
     */
    public String getFMBLIncomeFarmLabor() {
        return sanitizeText(rawData.optString(INCOMEFARMLABOR));
    }

    /**
     * Returns income spouse
     * @return income spouse
     */
    public String getFMBLSpouseIncome() {
        return sanitizeText(rawData.optString(SPOUSEINCOME));
    }

    /**
     * Returns income other family members
     * @return income other family members
     */
    public String getFMBLFamilyMembersIncome() {
        return sanitizeText(rawData.optString(FAMILYMEMBERSINCOME));
    }

    /**
     * Returns living expenses
     * @return living expenses
     */
    public String getFMBLLivingExpenses() {
        return sanitizeText(rawData.optString(LIVINGEXPENSES));
    }

    /**
     * Returns cost of housing
     * @return cost of housing
     */
    public String getFMBLHousingCost() {
        return sanitizeText(rawData.optString(HOUSINGCOST));
    }

    /**
     * Returns other expenses
     * @return other expenses
     */
    public String getFMBLOtherExpenses() {
        return sanitizeText(rawData.optString(OTHEREXPENSES));
    }

    /**
     * Returns Planned investments
     * @return Planned investments
     */
    public String getFMBLPlannedInvestments() {
        return sanitizeText(rawData.optString(PLANNEDINVESTMENTS));
    }

    /**
     * Returns educational expenses
     * @return educational expenses
     */
    public String getFMBLEducationalExpenses() {
        return sanitizeText(rawData.optString(EDUCATIONEXPENSES));
    }

    /**
     * Returns farmer have a credit
     * @return farmer have a credit
     */
    public String getFMBLHaveCredit() {
        return sanitizeText(rawData.optString(HAVECREDIT));
    }

    /**
     * Returns ammount pay for credit
     * @return ammount pay for credit
     */
    public String getFMBLPayForCredit() {
        return sanitizeText(rawData.optString(PAYFORCREDIT));
    }

    /**
     * Returns farmer give a loan
     * @return farmer give a loan
     */
    public String getFMBLGiveLoan() {
        return sanitizeText(rawData.optString(GIVELOAN));
    }

    /**
     * Returns ammount of loan
     * @return ammount of loan
     */
    public String getFMBLAmmountLoan() {
        return sanitizeText(rawData.optString(AMMOUNTLOAN));
    }

    /**
     * Returns loan income
     * @return loan income
     */
    public String getFMBLLoanIncome() {
        return sanitizeText(rawData.optString(LOANINCOME));
    }

    /**
     * Returns House Savings
     * @return House Savings
     */
    public String getFMBLHouseSavings() {
        return sanitizeText(rawData.optString(HOUSESAVINGS));
    }

    /**
     * Returns farmer comments
     * @return farmer comments
     */
    public String getFMBLComments() {
        return sanitizeText(rawData.optString(COMMENTS));
    }

    /**
     * Returns whether the Farmer Baseline has been locally modified or not.
     *
     * @return True - if the Farmer Baseline has been locally modified, False - otherwise.
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
