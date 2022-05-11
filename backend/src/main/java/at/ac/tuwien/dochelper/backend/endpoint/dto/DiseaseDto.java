package at.ac.tuwien.dochelper.backend.endpoint.dto;

import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;
import java.util.List;

public class DiseaseDto {

    @Nullable
    private Long diseaseId;

    @NotNull
    @Size(max = 64)
    private String diseaseName;

    @NotNull
    private String icdCode;

    @NotNull
    private String description;

    @NotNull
    private boolean pregnant;

    //@NotNull
    private int minAge;

   // @NotNull
    private int maxAge;

    @NotNull
    private float threshold;

    @Nullable
    private List<TestValueThreshold> threshold_DiseaseValues;


    public DiseaseDto(@Nullable Long diseaseId, String diseaseName, String icdCode, String description, boolean pregnant,
                      int minAge, int maxAge, float threshold, List<TestValueThreshold> threshold_DiseaseValues) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.icdCode = icdCode;
        this.description = description;
        this.minAge = minAge;
        this.pregnant = pregnant;
        this.maxAge = maxAge;
        this.threshold = threshold;
        this.threshold_DiseaseValues = threshold_DiseaseValues;
    }

    @Nullable
    public Long getId() {
        return diseaseId;
    }

    public void setId(@Nullable Long id) {
        this.diseaseId = id;
    }

    public String getName() {
        return diseaseName;
    }

    public void setName(String name) {
        this.diseaseName = name;
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

    @Nullable
    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(@Nullable Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Nullable
    public List<TestValueThreshold> getThreshold_DiseaseValues() {
        return threshold_DiseaseValues;
    }

    public void setThreshold_DiseaseValues(@Nullable List<TestValueThreshold> threshold_DiseaseValues) {
        this.threshold_DiseaseValues = threshold_DiseaseValues;
    }

    @Override
    public String toString() {
        return "DiseaseDto{" +
                "diseaseId=" + diseaseId +
                ", diseaseName='" + diseaseName + '\'' +
                ", icdCode='" + icdCode + '\'' +
                ", description='" + description + '\'' +
                ", pregnant=" + pregnant +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", threshold=" + threshold +
                ", threshold_DiseaseValues=" + threshold_DiseaseValues +
                '}';
    }
}
