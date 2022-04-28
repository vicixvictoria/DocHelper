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

    @NotNull
    private float refVal_overwrite;

    private LabValue labVal;


    public TestValue_tresholdDto(){

    }

    public TestValue_tresholdDto(@Nullable Long thresholdId, Type type, float refVal_overwrite, LabValue labVal) {
        this.thresholdId = thresholdId;
        this.type = type;
        this.refVal_overwrite = refVal_overwrite;
        this.labVal = labVal;
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

    @Override
    public String toString() {
        return "TestValue_tresholdDto{" +
                "thresholdId=" + thresholdId +
                ", type=" + type +
                ", refVal_overwrite=" + refVal_overwrite +
                ", labVal=" + labVal +
                '}';
    }
}
