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
    private Float measuredValue;

    @NotNull
    private Float referenceValue;

    public LabMeasureDto(@Nullable Long id, LabValue labValue, Float measuredValue, Float referenceValue) {
        this.id = id;
        this.labValue = labValue;
        this.measuredValue = measuredValue;
        this.referenceValue = referenceValue;
    }

    @Override
    public String toString() {
        return "LabMeasureDto{" +
                "id=" + id +
                ", labValue=" + labValue +
                ", measuredValue=" + measuredValue +
                ", referenceValue=" + referenceValue +
                '}';
    }
}
