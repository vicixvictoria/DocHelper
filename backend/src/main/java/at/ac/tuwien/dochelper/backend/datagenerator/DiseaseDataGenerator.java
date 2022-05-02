package at.ac.tuwien.dochelper.backend.datagenerator;


import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import at.ac.tuwien.dochelper.backend.repository.TestValue_thresholdRepository;
import at.ac.tuwien.dochelper.backend.util.Type;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Profile("generateData2")
@Component
public class DiseaseDataGenerator {

    private final DiseaseRepository diseaseRepository;
    private final TestValue_thresholdRepository testValue_thresholdRepository;

    public DiseaseDataGenerator(DiseaseRepository diseaseRepository, TestValue_thresholdRepository testValue_thresholdRepository) {
        this.diseaseRepository = diseaseRepository;
        this.testValue_thresholdRepository = testValue_thresholdRepository;
    }

    @PostConstruct
    public void generateDiseaseEntries() {
        Disease disease_meulengracht = new Disease();
        disease_meulengracht.setDiseaseName("Morbus Meulengracht");
        disease_meulengracht.setDescription("Hyperbilirubinämie wobei direktes Bilirubin 2-5 mg/dl ist");
        disease_meulengracht.setIcdCode('E'); //icd code auf string geben
        disease_meulengracht.setPregnant(false);
        disease_meulengracht.setThreshold(89);
        List<TestValue_threshold> threshold_meulengracht = null;
        threshold_meulengracht.add(generateThresholdEntries());
        //disease_meulengracht.setLab_DiseaseValue();
        saveDisease(disease_meulengracht);

    }

    public void saveDisease(Disease disease) {
        diseaseRepository.save(disease);
    }


    @PostConstruct
    public void generateThresholdEntries(LabValue labValue) {
        TestValue_threshold threshold1 = new TestValue_threshold();
        //LabValue labval =
        threshold1.setType(Type.ELEVATED);
        threshold1.setRefVal_overwrite(2);
        threshold1.setLabVal(labValue);
        threshold1.setWeightValue(45);
    }

    public void saveThreshold(TestValue_threshold testValue_threshold) {
        testValue_thresholdRepository.save(testValue_threshold);
    }

}
