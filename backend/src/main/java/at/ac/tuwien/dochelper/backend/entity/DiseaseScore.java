package at.ac.tuwien.dochelper.backend.entity;

public class DiseaseScore {

    private Disease disease;
    private Double score;

    public DiseaseScore() {
    }

    public DiseaseScore(Disease disease, Double score) {
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

    public void addScore(Double score) {
        this.score = this.score + score;
    }
    @Override
    public String toString() {
        return "DiseaseScore{" +
                "disease=" + disease +
                ", score=" + score +
                '}';
    }
}
