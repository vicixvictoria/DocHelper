package at.ac.tuwien.dochelper.backend.endpoint.dto;

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
    private char icdCode;

    @NotNull
    private String description;

    @NotNull
    private boolean pregnant;

    @NotNull
    private int minAge;

    @NotNull
    private int maxAge;

    @NotNull
    private float threshold;

    private List<LabValueDto> lab_DiseaseValue;


    public DiseaseDto(@Nullable Long diseaseId, String diseaseName, char icdCode, String description,  boolean pregnant,
                      int minAge, int maxAge, float threshold, List<LabValueDto> lab_DiseaseValue) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.icdCode = icdCode;
        this.description = description;
        this.minAge = minAge;
        this.pregnant = pregnant;
        this.maxAge = maxAge;
        this.threshold = threshold;
        this.lab_DiseaseValue = lab_DiseaseValue;
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
        return "DiseaseDto{" +
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
