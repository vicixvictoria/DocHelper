package at.ac.tuwien.dochelper.backend.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

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
    private String icdCode;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "pregnant")
    private boolean pregnant;

    @Column(name = "minAge")
    private int minAge;

    @Column(name = "maxAge")
    private int maxAge;

    @NotNull
    @Column(name = "threshold")
    private float threshold;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Column(name = "threshold_DiseaseValue")
    private List<TestValueThreshold> threshold_DiseaseValue;



    public Disease(){

    }

    public Disease(Long diseaseId, String diseaseName, String icdCode, String description, boolean pregnant, int minAge, int maxAge, float threshold, List<TestValueThreshold> threshold_DiseaseValue) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.icdCode = icdCode;
        this.description = description;
        this.pregnant = pregnant;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.threshold = threshold;
        this.threshold_DiseaseValue = threshold_DiseaseValue;
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

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
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

    public List<TestValueThreshold> getLab_DiseaseValue() {
        return threshold_DiseaseValue;
    }

    public void setLab_DiseaseValue(List<TestValueThreshold> lab_DiseaseValue) {
        this.threshold_DiseaseValue = lab_DiseaseValue;
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
                ", lab_DiseaseValue=" + threshold_DiseaseValue +
                '}';
    }
}
