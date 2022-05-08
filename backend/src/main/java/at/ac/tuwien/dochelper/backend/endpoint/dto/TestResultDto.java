package at.ac.tuwien.dochelper.backend.endpoint.dto;


import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.entity.Patient;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

public class TestResultDto {

    @Nullable
    private Long id;

    @NotNull
    private Long patientId;

    @NotNull
    @PastOrPresent
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @NotNull
    private List<LabMeasure> labMeasures;

    public TestResultDto(@Nullable Long id, Long patientId, LocalDate date, List<LabMeasure> labMeasures) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.labMeasures = labMeasures;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<LabMeasure> getLabMeasures() {
        return labMeasures;
    }

    public void setLabMeasures(List<LabMeasure> labMeasures) {
        this.labMeasures = labMeasures;
    }

    @Override
    public String toString() {
        return "TestResultDto{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", date=" + date +
                ", labMeasures=" + labMeasures +
                '}';
    }
}
