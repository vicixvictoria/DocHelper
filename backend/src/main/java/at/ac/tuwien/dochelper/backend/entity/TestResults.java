package at.ac.tuwien.dochelper.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import at.ac.tuwien.dochelper.backend.entity.Patient;

@Entity
@Table(name = "TestResults")
public class TestResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @Column(name = "Patient")
    private Patient patient;

    @NotNull
    @Column(name = "dayof")
    private Date date;

    //private List<LabMeassure> labMeassures;

    public TestResults(){
    }

    public TestResults(Long id, Patient patient, Date date) {
        this.id = id;
        this.patient = patient;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDate(Date date) {
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
