package at.ac.tuwien.dochelper.backend.entity;

import at.ac.tuwien.dochelper.backend.util.LabValueCategory;
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
    private String unit ;

    @Column(name = "category")
    private LabValueCategory category;


    public LabValue(){

    }

    public LabValue(Long labValId, String labValName, String unit, LabValueCategory category) {
        this.labValId = labValId;
        this.labValName = labValName;
        this.unit = unit;
        this.category = category;
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

    public LabValueCategory getCategory() {
        return category;
    }

    public void setCategory(LabValueCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "LabValue{" +
                "labValId=" + labValId +
                ", labValName='" + labValName + '\'' +
                ", unit='" + unit + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
