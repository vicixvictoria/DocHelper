package at.ac.tuwien.dochelper.backend.datagenerator;


import at.ac.tuwien.dochelper.backend.entity.Disease;
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
import java.util.ArrayList;
import java.util.List;

@Profile("generateData1")
@Component
public class DiseaseDataGenerator {

    @Autowired
    private final LabValueDataGenerator labValueDataGenerator;

    private final LabValueRepository labValueRepository;

    private final DiseaseRepository diseaseRepository;
    private final TestValue_thresholdRepository testValue_thresholdRepository;
    //private final ThresholdDataGenerator thresholdDataGenerator;


    public DiseaseDataGenerator(DiseaseRepository diseaseRepository, TestValue_thresholdRepository testValue_thresholdRepository, LabValueRepository labValueRepository, LabValueDataGenerator labValueDataGenerator) {
        this.diseaseRepository = diseaseRepository;
        this.testValue_thresholdRepository = testValue_thresholdRepository;
        this.labValueRepository = labValueRepository;
        this.labValueDataGenerator = labValueDataGenerator;
       // this.thresholdDataGenerator = thresholdDataGenerator;
    }


    @PostConstruct
    public void generateDiseaseEntries() {
        diseaseRepository.deleteAll();
        Disease disease_meulengracht = new Disease();
        List<TestValue_threshold> threshold_meulengracht = new ArrayList<>();
        disease_meulengracht.setDiseaseName("Morbus Meulengracht");
        disease_meulengracht.setDescription("Hyperbilirubinämie wobei direktes Bilirubin 2-5 mg/dl ist");
        disease_meulengracht.setIcdCode('E'); //icd code auf string geben
        disease_meulengracht.setPregnant(false);
        disease_meulengracht.setThreshold(89);
        /*generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Morbus Meulengracht");
        threshold_meulengracht.add(testValue_thresholdRepository.findTestValue_thresholdByDiseaseNameAndLabValName("Morbus Meulengracht", "Bilirubin gesamt"));*/

        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"),"Morbus Meulengracht"));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"),"Morbus Meulengracht"));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"),"Morbus Meulengracht"));
        disease_meulengracht.setLab_DiseaseValue(threshold_meulengracht);
        saveDisease(disease_meulengracht);

    }

    public void saveDisease(Disease disease) {
        diseaseRepository.save(disease);
    }


    //@PostConstruct
    private TestValue_threshold generateThresholdEntries(LabValue labValue, String diseaseName) {
        testValue_thresholdRepository.deleteAll();
        TestValue_threshold threshold1 = new TestValue_threshold();
      // if(labValue != null) {
            threshold1.setType(Type.ELEVATED);
            threshold1.setRefVal_overwrite(2);
            threshold1.setLabVal(labValue);
            threshold1.setWeightValue(45);
            threshold1.setDiseaseName(diseaseName);
            threshold1.setLabValName(labValue.getLabValName());
            saveThreshold(threshold1);
       // }
        return threshold1;

    }

    public void saveThreshold(TestValue_threshold testValue_threshold) {
        testValue_thresholdRepository.save(testValue_threshold);
    }

}
