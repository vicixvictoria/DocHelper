package at.ac.tuwien.dochelper.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
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
    private Date birthDate;

    @NotNull
    @Column(name = "pregnant")
    private boolean pregnant;

    /*
    private List<TestResult> testResult;
    */

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String svnr, Date birthDate, boolean pregnant) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.svnr = svnr;
        this.birthDate = birthDate;
        this.pregnant = pregnant;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", svnr='" + svnr + '\'' +
                ", birthDate=" + birthDate +
                ", pregnant=" + pregnant +
                '}';
    }
}
