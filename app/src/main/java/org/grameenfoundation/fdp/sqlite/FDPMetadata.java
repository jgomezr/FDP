package org.grameenfoundation.fdp.sqlite;
/**
 * Created by julian_Gf on 5/16/2016.
 * Clase que establece los nombres a usar en la base de datos
 * Class that contains the data storage contacts
 */
public final class FDPMetadata {

    /* Farmer Table Columns */
    public static final String FARMER_ID = "farmer_id";
    public static final String FARMER_BDAY= "bday";
    public static final String FARMER_NATIONAL_ID= "national_id";
    public static final String FARMER_REGION = "region";
    public static final String FARMER_MUNICIPALITY = "municipality";
    public static final String FARMER_COUNTRY_ID = "country_id";
    public static final String FARMER_REPORTS_ID = "reports_to_id";

    /* Country Table Columns */
    public static final String COUNTRY_ID = "country_id";
    public static final String COUNTRY_NAME = "country_name";

    /* Farmer Baseline Table Columns */
    public static final String FARMER_PARENT_ID = "farmer_parent_id";
    public static final String HOUSEHOLD_INCOME = "household_income";
    public static final String INCOME_SOURCE = "income_source";
    public static final String PERCENT_INCOME_CACAO = "percent_income_cacao";

    /* Farm Table Columns */
    public static final String FARM_ID = "farm_id";
    public static final String FARMER_OWNER_ID = "farmer_owner_id";
    public static final String FARM_REGION = "farm_region";
    public static final String FARM_MUNICIPALITY = "farm_municipality";
    public static final String FARM_COUNTRY_ID = "farm_country_id";
    public static final String TOTAL_FARM_AREA = "total_farm_area";
    public static final String FARM_AREA_UNITS = "farm_area_units";

    /* Farm Baseline Table Columns */
    public static final String FARM_OWNER_ID = "farm_owner_id";
    public static final String WATER_SOURCE = "water_source";
    public static final String DISPONSAL_SYSTEM = "disponsal_system";
    public static final String FARM_MAP = "farm_map";
    public static final String BL_DATE = "bl_date";

    /* Farm plot Table Columns */
    public static final String PLOT_ID = "plot_id";
    public static final String FARM_PARENT_ID = "farm_parent_id";
    public static final String TOTAL_PLOT_AREA = "total_plot_area";
    public static final String PLOT_AREA_UNITS = "plot_area_units";
    public static final String NUMBER_OF_TREES = "number_of_trees";
    public static final String PERCENT_SHADE = "percent_shade";

    /* FDP Practices Table Columns */
    public static final String FDP_ID = "fdp_id";
    public static final String FDP_COUNTRY_ID = "fdp_country_id";
    public static final String PRACTICE_NAME = "practice_name";

    /*  Cost Components Table Columns */
    public static final String COST_ID = "cost_id";
    public static final String CC_COUNTRY_ID = "cc_country_id";
    public static final String FDP_PARENT_ID = "fdp_practice_id";
    public static final String COMPONENT_NAME = "component_name";
    public static final String COMPONENT_COST = "component_cost";
    public static final String YEAR_IMPLEMENT = "year_implement";

    /* FDP Diagnostic Table Columns */
    public static final String FDPD_ID = "fdpd_id";
    public static final String FDP_PLOT_ID = "fdp_plot_id";
    public static final String FDP_PRACTICE_ID = "fdp_practice_id";
    public static final String DIAGNOSTIC = "diagnostic";
    public static final String FDP_DIAGNOSTIC_DATE = "fdp_diagnostic_date";

    /* FDP Follow Up Table Columns */
    public static final String FDPF_ID = "fdpf_id";
    public static final String FDPD_PARENT_ID = "fdpd_parent_id";
    public static final String PRACTICE_DIAGNOSIS = "practice_diagnosis";
    public static final String FU_DATE = "fu_date";

    /* PL Table Columns */
    public static final String PL_ID = "pl_id";
    public static final String COST_COMPONENT_ID = "cost_component_id";
    public static final String FDP_DIAGNOSTIC_ID = "fdp_diagnostic_id";
    public static final String PL_YEAR_IMPLEMENT = "pl_year_implement";

    /* Table names */
    public static final String FARMER = "farmer";
    public static final String COUNTRY = "country";
    public static final String FARMERBL = "farmerbl";
    public static final String FARM = "farm";
    public static final String FARMBL = "farmbl";
    public static final String PLOT = "plot";
    public static final String FDP_PRACTICES = "fdp_practices";
    public static final String COST_COMPONENT = "cost_component";
    public static final String FDP_DIAGNOSTIC = "fdp_diagnostic";
    public static final String FDP_FOLLOW_UP = "fdp_follow_up";
    public static final String PL = "pl";

    public static final String DATABASE_NAME = "GFFDP";
    public static final int DATABASE_VERSION = 1;

    private FDPMetadata() {
    }
}
