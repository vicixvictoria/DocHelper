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
    @Column(name = "patient_id")
    private Long patientId;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "lab_measures")
    private List<LabMeasure> labMeasures;

    public TestResult(){
    }

    public TestResult(Long id, Long patientId, LocalDate date, List<LabMeasure> labMeasures) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.labMeasures = labMeasures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "TestResult{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", date=" + date +
                ", labMeasures=" + labMeasures +
                '}';
    }
}
