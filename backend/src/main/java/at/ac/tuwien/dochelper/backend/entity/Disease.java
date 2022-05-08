package at.ac.tuwien.dochelper.backend.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Disease")
public class Disease {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "diseaseId", updatable = false)
    private Long diseaseId;

    @NotNull
    @Column(name = "diseaseName", length = 64)
    private String diseaseName;

    @NotNull
    @Column(name = "icdCode")
    private char icdCode;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "pregnant")
    private boolean pregnant;

    @NotNull
    @Column(name = "minAge")
    private int minAge;

    @NotNull
    @Column(name = "maxAge")
    private int maxAge;

    @NotNull
    @Column(name = "threshold")
    private float threshold;

     /*
    private List<TestValue_threshold> lab_DiseaseValue;
    */


    public Disease(){

    }

    public Disease(Long diseaseId, String diseaseName, char icdCode, String description, boolean pregnant, int minAge, int maxAge, float threshold) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.icdCode = icdCode;
        this.description = description;
        this.pregnant = pregnant;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.threshold = threshold;
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public char getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(char icdCode) {
        this.icdCode = icdCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }


    @Override
    public String toString() {
        return "Disease{" +
                "diseaseId=" + diseaseId +
                ", diseaseName='" + diseaseName + '\'' +
                ", icdCode=" + icdCode +
                ", description='" + description + '\'' +
                ", pregnant=" + pregnant +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", threshold=" + threshold +
                '}';
    }
}
