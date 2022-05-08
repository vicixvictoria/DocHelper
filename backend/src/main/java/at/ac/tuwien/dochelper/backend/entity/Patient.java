package at.ac.tuwien.dochelper.backend.entity;

import at.ac.tuwien.dochelper.backend.util.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @Column(name = "first_name", length = 64)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 64)
    private String lastName;

    @NotNull
    @Column(name="svnr", length = 10)
    private String svnr;

    @NotNull
    @PastOrPresent
    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull
    @Column(name = "sex")
    private Sex sex;

    @NotNull
    @Column(name = "pregnant")
    private boolean pregnant;

    @OneToMany
    @JoinColumn(name = "test_results")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<TestResult> testResults;


    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String svnr, LocalDate birthDate, Sex sex, boolean pregnant, List<TestResult> testResults) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.svnr = svnr;
        this.birthDate = birthDate;
        this.sex = sex;
        this.pregnant = pregnant;
        this.testResults = testResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSvnr() {
        return svnr;
    }

    public void setSvnr(String svnr) {
        this.svnr = svnr;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", svnr='" + svnr + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", pregnant=" + pregnant +
                ", test results=" + testResults +
                '}';
    }
}
