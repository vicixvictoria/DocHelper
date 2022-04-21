package at.ac.tuwien.dochelper.backend.endpoint.dto;

import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;

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

    private boolean pregnant;

    private int minAge;
    private int maxAge;
    private float threshold;
    //private object labDiseaseValue;


    public DiseaseDto(@Nullable Long diseaseId, String diseaseName, char icdCode, String description,  boolean pregnant,
                      int minAge, int maxAge, float threshold) {
        this.diseaseId = diseaseId;
        this.diseaseName = diseaseName;
        this.icdCode = icdCode;
        this.description = description;
        this.minAge = minAge;
        this.pregnant = pregnant;
        this.maxAge = maxAge;
        this.threshold = threshold;
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
        return "PatientDto{" +
                "id=" + diseaseId +
                ", name='" + diseaseName + '\'' +
                '}';
    }
}
