package at.ac.tuwien.dochelper.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "LabMeasure")
public class LabMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @JoinColumn(name = "lab_value")
    @OneToOne(fetch = FetchType.EAGER)
    private LabValue labValue;

    @Column(name = "measured_value")
    private float measuredValue;

    @Column(name = "ref_value_bigger")
    private Float refValueBigger;

    @Column(name = "ref_value_lower")
    private Float refValueLower;

    @Column(name = "ref_value_from")
    private Float refValueFrom;

    @Column(name = "ref_value_to")
    private Float refValueTo;


    public LabMeasure() {
    }

    public LabMeasure(Long id, LabValue labValue, float measuredValue, Float refValueBigger, Float refValueLower, Float refValueFrom, Float refValueTo) {
        this.id = id;
        this.labValue = labValue;
        this.measuredValue = measuredValue;
        this.refValueBigger = refValueBigger;
        this.refValueLower = refValueLower;
        this.refValueFrom = refValueFrom;
        this.refValueTo = refValueTo;
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

    public float getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(float measuredValue) {
        this.measuredValue = measuredValue;
    }

    public Float getRefValueBigger() {
        return refValueBigger;
    }

    public void setRefValueBigger(Float refValueBigger) {
        this.refValueBigger = refValueBigger;
    }

    public Float getRefValueLower() {
        return refValueLower;
    }

    public void setRefValueLower(Float refValueLower) {
        this.refValueLower = refValueLower;
    }

    public Float getRefValueFrom() {
        return refValueFrom;
    }

    public void setRefValueFrom(Float refValueFrom) {
        this.refValueFrom = refValueFrom;
    }

    public Float getRefValueTo() {
        return refValueTo;
    }

    public void setRefValueTo(Float refValueTo) {
        this.refValueTo = refValueTo;
    }

    @Override
    public String toString() {
        return "LabMeasure{" +
                "id=" + id +
                ", labValue=" + labValue +
                ", measuredValue=" + measuredValue +
                ", refValueBigger=" + refValueBigger +
                ", refValueLower=" + refValueLower +
                ", refValueFrom=" + refValueFrom +
                ", refValueTo=" + refValueTo +
                '}';
    }
}
