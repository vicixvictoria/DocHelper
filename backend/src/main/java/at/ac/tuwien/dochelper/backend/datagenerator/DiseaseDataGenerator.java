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
        //Morbus Meulengracht
        Disease disease_meulengracht = new Disease();
        List<TestValue_threshold> threshold_meulengracht = new ArrayList<>();
        disease_meulengracht.setDiseaseName("Morbus Meulengracht");
        disease_meulengracht.setDescription("Hyperbilirubinämie wobei direktes Bilirubin 2-5 mg/dl ist");
        disease_meulengracht.setIcdCode("E80.4"); //icd code auf string geben
        disease_meulengracht.setPregnant(false);
        disease_meulengracht.setThreshold(89);
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"),"Morbus Meulengracht", 2, Type.ELEVATED, 45));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"),"Morbus Meulengracht", 0, Type.ELEVATED, 45));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"),"Morbus Meulengracht", 0, Type.ELEVATED, 10));
        disease_meulengracht.setLab_DiseaseValue(threshold_meulengracht);
        saveDisease(disease_meulengracht);

        //PBC 2
        Disease disease_pbc2 = new Disease();
        List<TestValue_threshold> threshold_pbc2 = new ArrayList<>();
        disease_pbc2.setDiseaseName("Primär biliäre Cholangitis (PBC) 2");
        disease_pbc2.setDescription("Zerstörung Lebergewebe");
        disease_pbc2.setIcdCode("K74.3");
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

        //akutes Leberversagen
        Disease disease_leberversagen = new Disease();
        List<TestValue_threshold> threshold_leberversagen = new ArrayList<>();
        disease_leberversagen.setDiseaseName("akutes Leberversagen");
        disease_leberversagen.setDescription("Zerstörung Lebergewebe mit Leberversagen");
        disease_leberversagen.setIcdCode("K72.0");
        disease_leberversagen.setPregnant(false);
        disease_leberversagen.setThreshold(90);
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "akutes Leberversagen",0,Type.ELEVATED,12));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "akutes Leberversagen",0,Type.ELEVATED,12));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "akutes Leberversagen",0,Type.ELEVATED,12));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Thromboplastinzeit (TPZ; Quick)"), "akutes Leberversagen",0,Type.DECREASED,12));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Thrombozyten"), "akutes Leberversagen",0,Type.DECREASED,9));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Ammoniak (NH3)"), "akutes Leberversagen",0,Type.ELEVATED,9));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "akutes Leberversagen",0,Type.ELEVATED,12));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Kalium"), "akutes Leberversagen",0,Type.DECREASED,1));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("LDH"), "akutes Leberversagen",0,Type.ELEVATED,6));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Glukose (nüchtern)"), "akutes Leberversagen",0,Type.DECREASED,1));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Kreatinin"), "akutes Leberversagen",0,Type.ELEVATED,1));
        threshold_leberversagen.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "akutes Leberversagen",0,Type.ELEVATED,12));
        disease_leberversagen.setLab_DiseaseValue(threshold_leberversagen);
        saveDisease(disease_leberversagen);


        //akute Virushepatitis B
        Disease disease_hepB = new Disease();
        List<TestValue_threshold> threshold_hepB = new ArrayList<>();
        disease_hepB.setDiseaseName("akute Virushepatitis B");
        disease_hepB.setDescription("Die Virushepatitis ist als systemische, akute oder chronische Virusinfektion mit überwiegender Entzündung des Leberparenchyms definiert.");
        disease_hepB.setIcdCode("B18.1");
        disease_hepB.setPregnant(false);
        disease_hepB.setThreshold(68);
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "akute Virushepatitis B",0,Type.ELEVATED,14));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "akute Virushepatitis B",0,Type.ELEVATED,14));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "akute Virushepatitis B",0,Type.NORMAL,10));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "akute Virushepatitis B",0,Type.ELEVATED,10));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "akute Virushepatitis B",0,Type.ELEVATED,10));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "akute Virushepatitis B",0,Type.NORMAL,1));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Hämoglobin (Hb)"), "akute Virushepatitis B",0,Type.DECREASED,1));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Lymphozyten (abs.)"), "akute Virushepatitis B",0,Type.DECREASED,1));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("HBs-Ag"), "akute Virushepatitis B",0,Type.POSITIVE,31));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Anti-HBc"), "akute Virushepatitis B",0,Type.POSITIVE,31));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Anti-HBc-IgM"), "akute Virushepatitis B",0,Type.POSITIVE,1));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("HBe-Ag"), "akute Virushepatitis B",0,Type.POSITIVE,1));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Anti-HBs"), "akute Virushepatitis B",0,Type.POSITIVE,1));
        threshold_hepB.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Anti-HBe"), "akute Virushepatitis B",0,Type.POSITIVE,1));
        disease_leberversagen.setLab_DiseaseValue(threshold_hepB);
        saveDisease(disease_hepB);


        //Cholestase
        Disease disease_chol = new Disease();
        List<TestValue_threshold> threshold_chol = new ArrayList<>();
        disease_chol.setDiseaseName("Cholestase (Gallenstau)");
        disease_chol.setDescription("Die Cholestase ist der Stau von Gallenflüssigkeit innerhalb der Gallengänge.");
        disease_chol.setIcdCode("K71/K80");
        disease_chol.setPregnant(false);
        disease_chol.setThreshold(87);
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "Cholestase (Gallenstau)",0,Type.ELEVATED,20));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Cholestase (Gallenstau)",0,Type.ELEVATED,20));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "Cholestase (Gallenstau)",0,Type.ELEVATED,40));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Lipoprotein X"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("LAP"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "Cholestase (Gallenstau)",0,Type.ELEVATED,2));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "Cholestase (Gallenstau)",0,Type.ELEVATED,2));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "Cholestase (Gallenstau)",0,Type.ELEVATED,7));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Gallensäure"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("CRP"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Cholesterin"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("BSG 1h"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("BSG 2h"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        threshold_chol.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Leukozyten"), "Cholestase (Gallenstau)",0,Type.ELEVATED,1));
        disease_chol.setLab_DiseaseValue(threshold_chol);
        saveDisease(disease_chol);

    }

    public void saveDisease(Disease disease) {
        diseaseRepository.save(disease);
    }


    //@PostConstruct
    private TestValue_threshold generateThresholdEntries(LabValue labValue, String diseaseName, float refValOverwrite, Type type, float weightValue) {
       // testValue_thresholdRepository.deleteAll();
        TestValue_threshold threshold1 = new TestValue_threshold();
            threshold1.setType(type);
            if(refValOverwrite > 0) {
                threshold1.setRefVal_overwrite(refValOverwrite);
            }
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
