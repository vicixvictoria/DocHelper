package at.ac.tuwien.dochelper.backend.entity;

import at.ac.tuwien.dochelper.backend.util.Type;
import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "TestValue_Threshold")
public class TestValue_threshold {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "thresholdId", updatable = false)
    private Long thresholdId;

    @NotNull
    @Column(name = "type", length = 64)
    private Type type;

    @Column(name = "refVal_overwrite")
    private float refVal_overwrite;

    @NotNull
    @Column(name = "weightValue")
    private float weightValue;

    @NotNull
    @Column(name = "diseaseName")
    private String diseaseName;

    @NotNull
    @Column(name = "labValName")
    private String labValName;

    @ManyToOne(cascade = CascadeType.MERGE)
    //Many to Many?
   // @Column(name = "labVal", length = 64)
    private LabValue labVal;


    public TestValue_threshold(){

    }

    public TestValue_threshold(Long thresholdId, Type type, float refVal_overwrite, LabValue labVal, float weightValue, String diseaseName, String labValName) {
        this.thresholdId = thresholdId;
        this.type = type;
        this.refVal_overwrite = refVal_overwrite;
        this.labVal = labVal;
        this.weightValue = weightValue;
        this.diseaseName = diseaseName;
        this.labValName = labValName;
    }

    public Long getThresholdId() {
        return thresholdId;
    }

    public void setThresholdId(Long thresholdId) {
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
        return "TestValue_threshold{" +
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
