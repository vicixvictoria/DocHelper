package at.ac.tuwien.dochelper.backend.datagenerator;

import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.repository.LabMeasureRepository;
import at.ac.tuwien.dochelper.backend.repository.TestResultRepository;
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
public class TestResultDataGenerator {

    @Autowired
    private LabMeasureDataGenerator labMeasureDataGenerator;

    private final LabMeasureRepository labMeasureRepository;
    private final TestResultRepository testResultRepository;

    public TestResultDataGenerator(LabMeasureRepository labMeasureRepository, TestResultRepository testResultRepository) {
        this.labMeasureRepository = labMeasureRepository;
        this.testResultRepository = testResultRepository;
    }

    @PostConstruct
    public void generateTestResults() {

        TestResult testResult1 = new TestResult();
        testResult1.setId(1L);
        testResult1.setPatientId(2L);
        testResult1.setDate(LocalDate.parse("2020-04-14"));
        List<LabMeasure> measureList1 = new ArrayList<>(Collections.emptyList());
        for(long i=1; i<22; i++) {
            measureList1.add(labMeasureRepository.getById(i));
        }
        testResult1.setLabMeasures(measureList1);
        tryToSave(testResult1);

        TestResult testResult2 = new TestResult();
        testResult2.setId(2L);
        testResult2.setPatientId(4L);
        testResult2.setDate(LocalDate.parse("2020-06-18"));
        List<LabMeasure> measureList2 = new ArrayList<>(Collections.emptyList());
        measureList2.add(labMeasureRepository.getById(2L));
        measureList2.add(labMeasureRepository.getById(3L));
        testResult2.setLabMeasures(measureList2);
        tryToSave(testResult2);

        TestResult testResult3 = new TestResult();
        testResult3.setId(3L);
        testResult3.setPatientId(1L);
        testResult3.setDate(LocalDate.parse("2020-06-10"));
        List<LabMeasure> measureList3 = new ArrayList<>(Collections.emptyList());
        measureList3.add(labMeasureRepository.getById(1L));
        testResult3.setLabMeasures(measureList1);
        tryToSave(testResult3);

    }

    public void tryToSave(TestResult testResult) {
        if (testResultRepository.findById(testResult.getId()).isEmpty()) {
            testResultRepository.save(testResult);
        }
    }
}
