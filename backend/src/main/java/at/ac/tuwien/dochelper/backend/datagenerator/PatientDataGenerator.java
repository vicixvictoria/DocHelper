package at.ac.tuwien.dochelper.backend.datagenerator;

import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.entity.Patient;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.repository.PatientRepository;
import at.ac.tuwien.dochelper.backend.repository.TestResultRepository;
import at.ac.tuwien.dochelper.backend.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Profile("generateData1")
@Component
public class PatientDataGenerator {

    @Autowired
    private TestResultDataGenerator testResultDataGenerator;

    private final TestResultRepository testResultRepository;
    private final PatientRepository patientRepository;

    public PatientDataGenerator(TestResultRepository testResultRepository, PatientRepository patientRepository) {
        this.testResultRepository = testResultRepository;
        this.patientRepository = patientRepository;
    }

    @PostConstruct
    public void generatePatientEntries() {
        patientRepository.deleteAll();

        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setFirstName("Anna");
        patient1.setLastName("Beiser");
        patient1.setSvnr("8353130879");
        patient1.setBirthDate(LocalDate.parse("1979-08-13"));
        patient1.setSex(Sex.FEMALE);
        patient1.setPregnant(false);
        List<TestResult> testResultList1 = new ArrayList<>(Collections.emptyList());
        testResultList1.add(testResultRepository.getById(1L));
        patient1.setTestResults(testResultList1);
        save(patient1);

        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setFirstName("Christian");
        patient2.setLastName("Dorfer");
        patient2.setSvnr("9262010366");
        patient2.setBirthDate(LocalDate.parse("1966-03-01"));
        patient2.setSex(Sex.MALE);
        patient2.setPregnant(false);
        List<TestResult> testResultList2 = new ArrayList<>(Collections.emptyList());
        testResultList2.add(testResultRepository.getById(2L));
        patient2.setTestResults(testResultList2);
        save(patient2);

        Patient patient3 = new Patient();
        patient3.setFirstName("Emil");
        patient3.setLastName("Freitag");
        patient3.setSvnr("3009150299");
        patient3.setBirthDate(LocalDate.parse("1999-02-15"));
        patient3.setSex(Sex.MALE);
        patient3.setPregnant(false);
        save(patient3);

        Patient patient4 = new Patient();
        patient4.setFirstName("Gabriele");
        patient4.setLastName("Heimburg");
        patient4.setSvnr("2314300696");
        patient4.setBirthDate(LocalDate.parse("1996-06-30"));
        patient4.setSex(Sex.FEMALE);
        patient4.setPregnant(true);
        save(patient4);

        Patient patient5 = new Patient();
        patient5.setFirstName("Igor");
        patient5.setLastName("Jammernick");
        patient5.setSvnr("9112060385");
        patient5.setBirthDate(LocalDate.parse("1985-03-06"));
        patient5.setSex(Sex.MALE);
        patient5.setPregnant(false);
        save(patient5);

        Patient patient6 = new Patient();
        patient6.setFirstName("Katharina");
        patient6.setLastName("Lujkovic");
        patient6.setSvnr("6752240565");
        patient6.setBirthDate(LocalDate.parse("1965-05-24"));
        patient6.setSex(Sex.FEMALE);
        patient6.setPregnant(false);
        save(patient6);

        Patient patient7 = new Patient();
        patient7.setFirstName("Mona");
        patient7.setLastName("Niederhuber");
        patient7.setSvnr("4929080845");
        patient7.setBirthDate(LocalDate.parse("1945-08-08"));
        patient7.setSex(Sex.FEMALE);
        patient7.setPregnant(false);
        save(patient7);

        Patient patient8 = new Patient();
        patient8.setFirstName("Olaf");
        patient8.setLastName("Petrowitsch");
        patient8.setSvnr("1123260285");
        patient8.setBirthDate(LocalDate.parse("1985-02-26"));
        patient8.setSex(Sex.MALE);
        patient8.setPregnant(false);
        save(patient8);

        Patient patient9 = new Patient();
        patient9.setFirstName("Quentin");
        patient9.setLastName("Remali");
        patient9.setSvnr("8263040444");
        patient9.setBirthDate(LocalDate.parse("1944-04-04"));
        patient9.setSex(Sex.MALE);
        patient9.setPregnant(false);
        save(patient9);

        Patient patient10 = new Patient();
        patient10.setFirstName("Siegrid");
        patient10.setLastName("Thaler");
        patient10.setSvnr("9982211100");
        patient10.setBirthDate(LocalDate.parse("2000-11-21"));
        patient10.setSex(Sex.FEMALE);
        patient10.setPregnant(true);
        save(patient10);
    }

    public void save(Patient patient) {
        if (patientRepository.findAllBySvnr(patient.getSvnr()).isEmpty()) {
            patientRepository.save(patient);
        }
    }
}
