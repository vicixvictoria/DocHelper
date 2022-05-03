package at.ac.tuwien.dochelper.backend.endpoint.dto;

import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.util.Type;
import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;

public class TestValue_tresholdDto {

    @Nullable
    private Long thresholdId;

    @NotNull
    private Type type;

    private float refVal_overwrite;

    @NotNull
    private float weightValue;

    @NotNull
    private String diseaseName;

    @NotNull
    private String labValName;

    private LabValue labVal;


    public TestValue_tresholdDto(){

    }

    public TestValue_tresholdDto(@Nullable Long thresholdId, Type type, float refVal_overwrite, LabValue labVal, float weightValue, String diseaseName, String labValName) {
        this.thresholdId = thresholdId;
        this.type = type;
        this.refVal_overwrite = refVal_overwrite;
        this.labVal = labVal;
        this.weightValue = weightValue;
        this.diseaseName = diseaseName;
        this.labValName = labValName;
    }

    @Nullable
    public Long getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(@Nullable Long thresholdId) {
        this.thresholdId = thresholdId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getRefVal_overwrite() {
        return refVal_overwrite;
    }

    public void setRefVal_overwrite(float refVal_overwrite) {
        this.refVal_overwrite = refVal_overwrite;
    }

    public LabValue getLabVal() {
        return labVal;
    }

    public void setLabVal(LabValue labVal) {
        this.labVal = labVal;
    }

    public float getWeightValue() {
        return weightValue;
    }

    public void setWeightValue(float weightValue) {
        this.weightValue = weightValue;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getLabValName() {
        return labValName;
    }

    public void setLabValName(String labValName) {
        this.labValName = labValName;
    }

    @Override
    public String toString() {
        return "TestValue_tresholdDto{" +
                "thresholdId=" + thresholdId +
                ", type=" + type +
                ", refVal_overwrite=" + refVal_overwrite +
                ", weightValue=" + weightValue +
                ", diseaseName='" + diseaseName + '\'' +
                ", labValName='" + labValName + '\'' +
                ", labVal=" + labVal +
                '}';
    }
}
