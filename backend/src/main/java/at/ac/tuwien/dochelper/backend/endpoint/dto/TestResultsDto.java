package at.ac.tuwien.dochelper.backend.endpoint.dto;


import at.ac.tuwien.dochelper.backend.entity.Patient;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TestResultsDto {

    @Nullable
    private long id;

    @NotNull
    private Patient patient;

    @NotNull
    private Date dayof;

    public TestResultsDto(long id, Patient patient, Date dayof){
        this.id = id;
        this.patient = patient;
        this.dayof = dayof;
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

    public Date getDayof() {
        return dayof;
    }

    public void setDayof(Date dayof) {
        this.dayof = dayof;
    }

    @Override
    public String toString() {
        return "TestResults{" +
                "id=" + id +
                ", patient=" + patient +
                ", dayof=" + dayof +
                '}';
    }
}
