package org.grameen.fdp.object;

import java.util.List;

/**
 * Created by aangjnr on 08/11/2017.
 */

public class RealPlot {

    String id;
    String name;
    String farmerCode;
    String recommendationId;
    String plotInformationJson;
    String adoptionObservationsJson;
    String adoptionObservationResultsJson;
    String additionalIntervention;

    int startYear = 1;


    public void setAdditionalInterventionJson(String additionalIntervention) {
        this.additionalIntervention = additionalIntervention;
    }

    public String getAdditionalInterventionJson() {
        return additionalIntervention;
    }





    public void setAdoptionObservationsJson(String adoptionObservationsJson) {
        this.adoptionObservationsJson = adoptionObservationsJson;
    }

    public void setAdoptionObservationResultsJson(String adoptionObservationResultsJson) {
        this.adoptionObservationResultsJson = adoptionObservationResultsJson;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFarmerCode(String farmerCode) {
        this.farmerCode = farmerCode;
    }

    public void setPlotInformationJson(String plotInformationJson) {
        this.plotInformationJson = plotInformationJson;
    }

    public String getAdoptionObservationsJson() {
        return adoptionObservationsJson;
    }

    public String getAdoptionObservationResultsJson() {
        return adoptionObservationResultsJson;
    }

    public String getId() {
        return id;
    }

    public String getFarmerCode() {
        return farmerCode;
    }

    public String getPlotInformationJson() {
        return plotInformationJson;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartYear() {
        return startYear;
    }


    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }
}
