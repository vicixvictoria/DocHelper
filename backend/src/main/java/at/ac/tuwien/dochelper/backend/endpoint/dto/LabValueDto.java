package at.ac.tuwien.dochelper.backend.endpoint.dto;

import at.ac.tuwien.dochelper.backend.util.LabValueCategory;
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

    private LabValueCategory category;



    public LabValueDto(@Nullable Long labValId, String labValName, String unit, LabValueCategory category) {
        this.labValId = labValId;
        this.labValName = labValName;
        this.unit = unit;
        this.category = category;
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

    public LabValueCategory getCategory() {
        return category;
    }

    public void setCategory(LabValueCategory category) {
        this.category = category;
    }
}
