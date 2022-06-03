package at.ac.tuwien.dochelper.backend.endpoint.dto;

import at.ac.tuwien.dochelper.backend.entity.Disease;

import javax.validation.constraints.NotNull;

public class DiseaseScoreDto {

    @NotNull
    private Disease disease;

    @NotNull
    private Double score;

    public DiseaseScoreDto(Disease disease, Double score) {
        this.disease = disease;
        this.score = score;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DiseaseScoreDto{" +
                "disease=" + disease +
                ", score=" + score +
                '}';
    }
}
