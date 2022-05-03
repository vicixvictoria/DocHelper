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
        //diseaseRepository.deleteAll();
        Disease disease_meulengracht = new Disease();
        List<TestValue_threshold> threshold_meulengracht = new ArrayList<>();
        disease_meulengracht.setDiseaseName("Morbus Meulengracht");
        disease_meulengracht.setDescription("Hyperbilirubinämie wobei direktes Bilirubin 2-5 mg/dl ist");
        disease_meulengracht.setIcdCode('E'); //icd code auf string geben
        disease_meulengracht.setPregnant(false);
        disease_meulengracht.setThreshold(89);
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"),"Morbus Meulengracht", 2, Type.ELEVATED, 45));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"),"Morbus Meulengracht", 3, Type.ELEVATED, 45));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"),"Morbus Meulengracht", 4, Type.ELEVATED, 10));
        disease_meulengracht.setLab_DiseaseValue(threshold_meulengracht);
        saveDisease(disease_meulengracht);

        Disease disease_pbc2 = new Disease();
        List<TestValue_threshold> threshold_pbc2 = new ArrayList<>();
        disease_pbc2.setDiseaseName("Primär biliäre Cholangitis (PBC) 2");
        disease_pbc2.setDescription("Zerstörung Lebergewebe");
        disease_pbc2.setIcdCode('E');
        disease_pbc2.setPregnant(false);
        disease_pbc2.setThreshold(91);
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"),"Primär biliäre Cholangitis (PBC) 2", 35, Type.ELEVATED, 14));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"),"Primär biliäre Cholangitis (PBC) 2", 35, Type.ELEVATED, 15));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"),"Primär biliäre Cholangitis (PBC) 2", 35, Type.ELEVATED, 15));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"),"Primär biliäre Cholangitis (PBC) 2", 2, Type.ELEVATED, 15));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"),"Primär biliäre Cholangitis (PBC) 2", 120, Type.ELEVATED, 15));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("ANA (Antinukleare AK)"),"Primär biliäre Cholangitis (PBC) 2", 120, Type.POSITIVE, 15));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Albumin abs."),"Primär biliäre Cholangitis (PBC) 2", 52, Type.ELEVATED, 6));
        threshold_pbc2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"),"Primär biliäre Cholangitis (PBC) 2", 0, Type.ELEVATED, 15));

        disease_pbc2.setLab_DiseaseValue(threshold_pbc2);
        saveDisease(disease_pbc2);

    }

    public void saveDisease(Disease disease) {
        diseaseRepository.save(disease);
    }


    //@PostConstruct
    private TestValue_threshold generateThresholdEntries(LabValue labValue, String diseaseName, float refValOverwrite, Type type, float weightValue) {
       // testValue_thresholdRepository.deleteAll();
        TestValue_threshold threshold1 = new TestValue_threshold();
            threshold1.setType(type);
            threshold1.setRefVal_overwrite(refValOverwrite);
            threshold1.setLabVal(labValue);
            threshold1.setWeightValue(weightValue);
            threshold1.setDiseaseName(diseaseName);
            threshold1.setLabValName(labValue.getLabValName());
            saveThreshold(threshold1);

        return threshold1;

    }

    public void saveThreshold(TestValue_threshold testValue_threshold) {
        testValue_thresholdRepository.save(testValue_threshold);
    }

}
