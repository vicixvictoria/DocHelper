package at.ac.tuwien.dochelper.backend.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TestResults")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @OneToMany
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "lab_measures")
    private List<LabMeasure> labMeasures;

    public TestResult(){
    }

    public TestResult(Long id, Patient patient, LocalDate date, List<LabMeasure> labMeasures) {
        this.id = id;
        this.patient = patient;
        this.date = date;
        this.labMeasures = labMeasures;
    }

    public Long getId() {
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

    public List<LabMeasure> getLabMeasures() {
        return labMeasures;
    }

    public void setLabMeasures(List<LabMeasure> labMeasures) {
        this.labMeasures = labMeasures;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", patient=" + patient +
                ", date=" + date +
                ", labMeasures=" + labMeasures +
                '}';
    }
}
