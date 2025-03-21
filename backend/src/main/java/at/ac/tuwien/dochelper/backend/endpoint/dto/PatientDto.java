package at.ac.tuwien.dochelper.backend.endpoint.dto;

import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.util.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class PatientDto {

    @Nullable
    private Long id;

    @NotNull
    @Size(max = 64)
    private String firstName;

    @NotNull
    @Size(max = 64)
    private String lastName;

    @NotNull
    @Size(min = 10, max = 10)
    private String svnr;

    @NotNull
    @PastOrPresent
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull
    private Sex sex;

    @NotNull
    private boolean pregnant;

    @Nullable
    private List<TestResult> testResults;

    public PatientDto(@Nullable Long id, String firstName, String lastName, String svnr, LocalDate birthDate, Sex sex, boolean pregnant, List<TestResult> testResults) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.svnr = svnr;
        this.birthDate = birthDate;
        this.sex = sex;
        this.pregnant = pregnant;
        this.testResults = testResults;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
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

    @Nullable
    public List<TestResult> getTestResults() {
        return testResults;
    }

    public void setTestResults(@Nullable List<TestResult> testResults) {
        this.testResults = testResults;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", svnr='" + svnr + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", pregnant=" + pregnant +
                ", testResultDtoList=" + testResults +
                '}';
    }
}
