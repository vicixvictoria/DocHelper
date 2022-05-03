package at.ac.tuwien.dochelper.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LabMeasure")
public class LabMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @JoinColumn(name = "lab_value")
    @OneToOne
    private LabValue labValue;

    @Column(name = "measured_value")
    private Float measuredValue;

    @Column(name = "reference_value")
    private Float referenceValue;

    public LabMeasure() {
    }

    public LabMeasure(Long id, LabValue labValue, Float measuredValue, Float referenceValue) {
        this.id = id;
        this.labValue = labValue;
        this.measuredValue = measuredValue;
        this.referenceValue = referenceValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LabValue getLabValue() {
        return labValue;
    }

    public void setLabValue(LabValue labValue) {
        this.labValue = labValue;
    }

    public Float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(Float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public Float getReferenceValue() {
        return referenceValue;
    }

    public void setReferenceValue(Float referenceValue) {
        this.referenceValue = referenceValue;
    }

    @Override
    public String toString() {
        return "LabMeasure{" +
                "id=" + id +
                ", labValue=" + labValue +
                ", measuredValue=" + measuredValue +
                ", referenceValue=" + referenceValue +
                '}';
    }
}
