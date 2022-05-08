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
    private Patient patient;

    @NotNull
    @PastOrPresent
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @NotNull
    private List<LabMeasure> labMeasures;

    public TestResultDto(long id, Patient patient, LocalDate date, List<LabMeasure> labMeasures){
        this.id = id;
        this.patient = patient;
        this.date = date;
        this.labMeasures = labMeasures;
    }


    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient(){
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestResultDto{" +
                "id=" + id +
                ", patient=" + patient +
                ", date=" + date +
                ", labMeasures=" + labMeasures +
                '}';
    }
}
