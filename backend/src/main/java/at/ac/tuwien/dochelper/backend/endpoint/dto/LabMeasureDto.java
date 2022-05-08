package at.ac.tuwien.dochelper.backend.endpoint.dto;

import at.ac.tuwien.dochelper.backend.entity.LabValue;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class LabMeasureDto {

    @Nullable
    private Long id;

    @NotNull
    private LabValue labValue;

    @NotNull
    private float measuredValue;

    @NotNull
    private Float refValueBigger;

    @NotNull
    private Float refValueLower;

    @NotNull
    private Float refValueFrom;

    @NotNull
    private Float refValueTo;

    public LabMeasureDto() {
    }

    public LabMeasureDto(@Nullable Long id, LabValue labValue, float measuredValue, Float refValueBigger, Float refValueLower, Float refValueFrom, Float refValueTo) {
        this.id = id;
        this.labValue = labValue;
        this.measuredValue = measuredValue;
        this.refValueBigger = refValueBigger;
        this.refValueLower = refValueLower;
        this.refValueFrom = refValueFrom;
        this.refValueTo = refValueTo;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
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
        return "LabMeasureDto{" +
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
