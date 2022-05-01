package at.ac.tuwien.dochelper.backend.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "TestResults")
public class TestResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "Patient")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    //private List<LabMeasure> labMeasures;

    public TestResults(){
    }

    public TestResults(Long id, Patient patient, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
