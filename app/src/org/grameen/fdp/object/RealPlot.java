package org.grameen.fdp.object;

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

    public String getAdditionalInterventionJson() {
        return additionalIntervention;
    }

    public void setAdditionalInterventionJson(String additionalIntervention) {
        this.additionalIntervention = additionalIntervention;
    }

    public String getAdoptionObservationsJson() {
        return adoptionObservationsJson;
    }

    public void setAdoptionObservationsJson(String adoptionObservationsJson) {
        this.adoptionObservationsJson = adoptionObservationsJson;
    }

    public String getAdoptionObservationResultsJson() {
        return adoptionObservationResultsJson;
    }

    public void setAdoptionObservationResultsJson(String adoptionObservationResultsJson) {
        this.adoptionObservationResultsJson = adoptionObservationResultsJson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFarmerCode() {
        return farmerCode;
    }

    public void setFarmerCode(String farmerCode) {
        this.farmerCode = farmerCode;
    }

    public String getPlotInformationJson() {
        return plotInformationJson;
    }

    public void setPlotInformationJson(String plotInformationJson) {
        this.plotInformationJson = plotInformationJson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }
}
