package at.ac.tuwien.dochelper.backend.endpoint.dto;


import at.ac.tuwien.dochelper.backend.entity.Patient;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class TestResultDto {

    @Nullable
    private long id;

    @NotNull
    private Patient patient;

    @NotNull
    @PastOrPresent
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    public TestResultDto(Long id, Patient patient, LocalDate date){
        this.id = id;
        this.patient = patient;
        this.date = date;
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

    @Override
    public String toString() {
        return "TestResults{" +
                "id=" + id +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
