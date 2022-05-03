/*package at.ac.tuwien.dochelper.backend.datagenerator;

import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import at.ac.tuwien.dochelper.backend.repository.TestValue_thresholdRepository;
import at.ac.tuwien.dochelper.backend.util.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("generateData1")
@Component
public class ThresholdDataGenerator {

    @Autowired
    private final LabValueRepository labValueRepository;

    private final DiseaseRepository diseaseRepository;
    private final TestValue_thresholdRepository testValue_thresholdRepository;

    public ThresholdDataGenerator(LabValueRepository labValueRepository, DiseaseRepository diseaseRepository, TestValue_thresholdRepository testValue_thresholdRepository) {
        this.labValueRepository = labValueRepository;
        this.diseaseRepository = diseaseRepository;
        this.testValue_thresholdRepository = testValue_thresholdRepository;
    }

    //@PostConstruct
    public TestValue_threshold generateThresholdEntries(LabValue labValue, String diseaseName) {
        TestValue_threshold threshold1 = new TestValue_threshold();
        threshold1.setType(Type.ELEVATED);
        threshold1.setRefVal_overwrite(2);
        threshold1.setLabVal(labValue);
        threshold1.setWeightValue(45);
        threshold1.setDiseaseName(diseaseName);
        threshold1.setLabValName(labValue.getLabValName());
        saveThreshold(threshold1);

        return threshold1;

    }

    public void saveThreshold(TestValue_threshold testValue_threshold) {
        testValue_thresholdRepository.save(testValue_threshold);
    }
}*/
