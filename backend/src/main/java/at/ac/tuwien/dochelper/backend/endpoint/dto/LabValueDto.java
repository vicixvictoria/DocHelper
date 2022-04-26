package at.ac.tuwien.dochelper.backend.endpoint.dto;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LabValueDto {

    @Nullable
    private Long labValId;

    @NotNull
    @Size(max = 64)
    private String labValName;

    @NotNull
    private  String unit ;



    public LabValueDto(@Nullable Long labValId, String labValName, String unit) {
        this.labValId = labValId;
        this.labValName = labValName;
        this.unit = unit;
    }

    @Nullable
    public Long getLabValId() {
        return labValId;
    }

    public void setLabValId(@Nullable Long labValId) {
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
        return "LabValueDto{" +
                "labValId=" + labValId +
                ", labValName='" + labValName + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
