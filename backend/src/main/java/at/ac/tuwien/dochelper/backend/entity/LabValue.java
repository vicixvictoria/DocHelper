package at.ac.tuwien.dochelper.backend.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "LabValue")
public class LabValue {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "labValId", updatable = false)
    private Long labValId;

    @NotNull
    @Column(name = "labValName", length = 64)
    private String labValName;

    @NotNull
    @Column(name = "unit")
    private  String unit ;


    public LabValue(){

    }

    public LabValue(Long labValId, String labValName, String unit) {
        this.labValId = labValId;
        this.labValName = labValName;
        this.unit = unit;
    }


    public Long getLabValId() {
        return labValId;
    }

    public void setLabValId(Long labValId) {
        this.labValId = labValId;
    }

    public String getLabValName() {
        return labValName;
    }

    public void setLabValName(String labValName) {
        this.labValName = labValName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "LabValue{" +
                "labValId=" + labValId +
                ", labValName='" + labValName + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
