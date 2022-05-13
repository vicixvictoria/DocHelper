package at.ac.tuwien.dochelper.backend.datagenerator;


import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import at.ac.tuwien.dochelper.backend.repository.TestValueThresholdRepository;
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
    private final TestValueThresholdRepository testValue_thresholdRepository;


    public DiseaseDataGenerator(DiseaseRepository diseaseRepository, TestValueThresholdRepository testValue_thresholdRepository, LabValueRepository labValueRepository, LabValueDataGenerator labValueDataGenerator) {
        this.diseaseRepository = diseaseRepository;
        this.testValue_thresholdRepository = testValue_thresholdRepository;
        this.labValueRepository = labValueRepository;
        this.labValueDataGenerator = labValueDataGenerator;
    }


    @PostConstruct
    public void generateDiseaseEntries() {
        testValue_thresholdRepository.deleteAll();
        diseaseRepository.deleteAll();
        //Morbus Meulengracht
        Disease disease_meulengracht = new Disease();
        List<TestValueThreshold> threshold_meulengracht = new ArrayList<>();
        disease_meulengracht.setDiseaseName("Morbus Meulengracht");
        disease_meulengracht.setDescription("Hyperbilirubinämie wobei direktes Bilirubin 2-5 mg/dl ist");
        disease_meulengracht.setIcdCode("E80.4"); //icd code auf string geben
        disease_meulengracht.setPregnant(false);
        disease_meulengracht.setThreshold(89);
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"),"Morbus Meulengracht", 2, Type.ELEVATED, 45));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"),"Morbus Meulengracht", 0, Type.ELEVATED, 45));
        threshold_meulengracht.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"),"Morbus Meulengracht", 0, Type.ELEVATED, 10));
        disease_meulengracht.setThreshold_DiseaseValues(threshold_meulengracht);
        saveDisease(disease_meulengracht);

        //PBC 2
        Disease disease_pbc2 = new Disease();
        List<TestValueThreshold> threshold_pbc2 = new ArrayList<>();
        disease_pbc2.setDiseaseName("Primär biliäre Cholangitis (PBC) 2");
        disease_pbc2.setDescription("Die primär biliäre Cholangitis (PBC) ist eine mutmaßliche autoimmunde Lebererkrankung. Es kommt zu einer chronisch verlaufenden, nicht-eitrigen granulomatösen Entzündung der kleinen intrahepatischen Gallenwege.");
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
        disease_pbc2.setThreshold_DiseaseValues(threshold_pbc2);
        saveDisease(disease_pbc2);

        //akutes Leberversagen
        Disease disease_leberversagen = new Disease();
        List<TestValueThreshold> threshold_leberversagen = new ArrayList<>();
        disease_leberversagen.setDiseaseName("akutes Leberversagen");
        disease_leberversagen.setDescription("Die akute Leberdystrophie ist eine schwere Störung oder ein Ausfall der Leberfunktion mit hepatischer Enzephalopathie die zum Tode führen kann.");
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
        disease_leberversagen.setThreshold_DiseaseValues(threshold_leberversagen);
        saveDisease(disease_leberversagen);


        //akute Virushepatitis B
        Disease disease_hepB = new Disease();
        List<TestValueThreshold> threshold_hepB = new ArrayList<>();
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
        disease_leberversagen.setThreshold_DiseaseValues(threshold_hepB);
        saveDisease(disease_hepB);


        //Cholestase
        Disease disease_chol = new Disease();
        List<TestValueThreshold> threshold_chol = new ArrayList<>();
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
        disease_chol.setThreshold_DiseaseValues(threshold_chol);
        saveDisease(disease_chol);


        //Anämie
        Disease disease_anemia = new Disease();
        List<TestValueThreshold> threshold_anemia = new ArrayList<>();
        disease_anemia.setDiseaseName("Anämie");
        disease_anemia.setDescription("Die Anämie ist eine Blutarmut bei der entweder das Hämoglobin, die Erythrozyten oder das Hämatokrit verringert ist.");
        disease_anemia.setIcdCode("D64.9");
        disease_anemia.setPregnant(false);
        disease_anemia.setThreshold(33);
        threshold_anemia.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Hämoglobin (Hb)"), "Anämie",0,Type.DECREASED,34));
        threshold_anemia.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Hämatokrit"), "Anämie",0,Type.DECREASED,33));
        threshold_anemia.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Erythrozyten"), "Anämie",0,Type.DECREASED,33));
        disease_anemia.setThreshold_DiseaseValues(threshold_anemia);
        saveDisease(disease_anemia);


        //Ikterus - Gelbsucht
        Disease disease_ikterus = new Disease();
        List<TestValueThreshold> threshold_ikterus = new ArrayList<>();
        disease_ikterus.setDiseaseName("Ikterus");
        disease_ikterus.setDescription("Der Ikterus (Gelbsucht) beschreibt eine durch Bilirubinablagerungen verursachte Gelbfärbung der Haut/ Schleimhäute und/ oder Skleren.");
        disease_ikterus.setIcdCode("R79.8");
        disease_ikterus.setPregnant(false);
        disease_ikterus.setThreshold(60);
        threshold_ikterus.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Ikterus",2,Type.ELEVATED,60));
        threshold_ikterus.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "Ikterus",0,Type.ELEVATED,20));
        threshold_ikterus.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"), "Ikterus",0,Type.ELEVATED,20));
        disease_ikterus.setThreshold_DiseaseValues(threshold_ikterus);
        saveDisease(disease_ikterus);


        //HELLP-Syndrom in der Schwangerschaft
        Disease disease_hellp = new Disease();
        List<TestValueThreshold> threshold_hellp = new ArrayList<>();
        disease_hellp.setDiseaseName("HELLP-Syndrom");
        disease_hellp.setDescription("Das HELLP-Syndrom ist eine schwerwiegende Variante der Präeklampsie, eine Schwangerschaftsbedingte Erkrankung. 3 Hauptfaktoren: H=Hämolyse, EL= Erhöhung der Leberenzyme, LP= Thrombozytopenie");
        disease_hellp.setIcdCode("O14.2");
        disease_hellp.setPregnant(true);
        disease_hellp.setThreshold(80);
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("LDH"), "HELLP-Syndrom",0,Type.ELEVATED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "HELLP-Syndrom",0,Type.ELEVATED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "HELLP-Syndrom",0,Type.ELEVATED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "HELLP-Syndrom",0,Type.ELEVATED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Fibrinogen"), "HELLP-Syndrom",0,Type.DECREASED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("D-Dimer"), "HELLP-Syndrom",0,Type.ELEVATED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Thrombozyten"), "HELLP-Syndrom",0,Type.DECREASED,11));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Haptoglobin"), "HELLP-Syndrom",0,Type.DECREASED,12));
        threshold_hellp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("CRP"), "HELLP-Syndrom",0,Type.ELEVATED,11));
        disease_hellp.setThreshold_DiseaseValues(threshold_hellp);
        saveDisease(disease_hellp);

        //Primär sklerosierende Cholangitis (PSC)
        Disease disease_psc = new Disease();
        List<TestValueThreshold> threshold_psc = new ArrayList<>();
        disease_psc.setDiseaseName("Primär sklerosierende Cholangitis (PSC)");
        disease_psc.setDescription("Die primär sklerosierende Cholangitis ist eine seltene, chronisch verlaufende Entzündung der intra- und extrahepatischen Gallengänge, die zur progressiv chronischen Cholestase mit anschließender biliärer Zirrhose führt.");
        disease_psc.setIcdCode("K83.0");
        disease_psc.setPregnant(false);
        disease_psc.setThreshold(86);
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,10));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,10));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,9));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,9));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,10));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,10));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("ANA (Antinukleare AK)"), "Primär sklerosierende Cholangitis (PSC)",0,Type.POSITIVE,9));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("p-ANCA (Myeloperoxidase-AK)"), "Primär sklerosierende Cholangitis (PSC)",0,Type.POSITIVE,19));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("IgM"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,9));
        threshold_psc.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Gesamt Kupfer (CU)"), "Primär sklerosierende Cholangitis (PSC)",0,Type.ELEVATED,5));
        disease_psc.setThreshold_DiseaseValues(threshold_psc);
        saveDisease(disease_psc);

        //Crigler-Najjar-Syndrom Typ 1
        Disease disease_cns1 = new Disease();
        List<TestValueThreshold> threshold_cns1 = new ArrayList<>();
        disease_cns1.setDiseaseName("Crigler-Najjar-Syndrom Typ 1");
        disease_cns1.setDescription("Das Crigler-Najjar-Syndrom (CNS) ist eine erbliche Störung des Bilirubinstoffwechsels und gekennzeichnet durch unkonjugierte Hyperbilirubinämie bei fehlender Aktivität der Bilirubin-Glucuronosyl-Transferase (GT) in der Leber. ");
        disease_cns1.setIcdCode("E80.5");
        disease_cns1.setPregnant(false);
        disease_cns1.setThreshold(81);
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"), "Crigler-Najjar-Syndrom Typ 1",20,Type.ELEVATED,41));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Crigler-Najjar-Syndrom Typ 1",0,Type.ELEVATED,40));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "Crigler-Najjar-Syndrom Typ 1",0,Type.NORMAL,3));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "Crigler-Najjar-Syndrom Typ 1",0,Type.NORMAL,4));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "Crigler-Najjar-Syndrom Typ 1",0,Type.NORMAL,3));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Cholinesterase (ChE)"), "Crigler-Najjar-Syndrom Typ 1",0,Type.NORMAL,3));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "Crigler-Najjar-Syndrom Typ 1",0,Type.NORMAL,3));
        threshold_cns1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "Crigler-Najjar-Syndrom Typ 1",0,Type.ELEVATED,3));
        disease_cns1.setThreshold_DiseaseValues(threshold_cns1);
        saveDisease(disease_cns1);


        //Crigler-Najjar-Syndrom Typ 1
        Disease disease_cns2 = new Disease();
        List<TestValueThreshold> threshold_cns2 = new ArrayList<>();
        disease_cns2.setDiseaseName("Crigler-Najjar-Syndrom Typ 2");
        disease_cns2.setDescription("Das Crigler-Najjar-Syndrom (CNS) ist eine erbliche Störung des Bilirubinstoffwechsels und gekennzeichnet durch unkonjugierte Hyperbilirubinämie bei fehlender Aktivität der Bilirubin-Glucuronosyl-Transferase (GT) in der Leber. ");
        disease_cns2.setIcdCode("E80.5");
        disease_cns2.setPregnant(false);
        disease_cns2.setThreshold(81);
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"), "Crigler-Najjar-Syndrom Typ 2",10,Type.ELEVATED,41));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Crigler-Najjar-Syndrom Typ 2",0,Type.ELEVATED,40));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "Crigler-Najjar-Syndrom Typ 2",0,Type.NORMAL,3));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GOT (AST)"), "Crigler-Najjar-Syndrom Typ 2",0,Type.NORMAL,4));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "Crigler-Najjar-Syndrom Typ 2",0,Type.NORMAL,3));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Cholinesterase (ChE)"), "Crigler-Najjar-Syndrom Typ 2",0,Type.NORMAL,3));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "Crigler-Najjar-Syndrom Typ 2",0,Type.NORMAL,3));
        threshold_cns2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "Crigler-Najjar-Syndrom Typ 2",0,Type.ELEVATED,3));
        disease_cns2.setThreshold_DiseaseValues(threshold_cns2);
        saveDisease(disease_cns2);


        //akute biliäre Pankreatitis
        Disease disease_abp = new Disease();
        List<TestValueThreshold> threshold_abp = new ArrayList<>();
        disease_abp.setDiseaseName("Akute biliäre Pankreatitis");
        disease_abp.setDescription("Die akute Pankreatitis wird in den meisten Fällen durch Erkrankungen der Gallenwege oder Alkoholabusus ausgelöst und ist die Entzündung der Pankreas.");
        disease_abp.setIcdCode("K85.1");
        disease_abp.setPregnant(false);
        disease_abp.setThreshold(70);
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Lipase"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,8));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("LDH"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,8));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Kalzium, gesamt"), "Akute biliäre Pankreatitis",0,Type.DECREASED,7));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GPT (ALT)"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,7));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("GGT"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,8));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("CRP"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,7));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,8));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Bilirubin direkt"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,7));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alpha-Amylase"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,8));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,13));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Leukozyten"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,7));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Procalcitonin"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,2));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Kreatinin"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,2));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Harnstoff"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,2));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Glukose (nüchtern)"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,4));
        threshold_abp.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Hämatokrit"), "Akute biliäre Pankreatitis",0,Type.ELEVATED,2));
        disease_abp.setThreshold_DiseaseValues(threshold_abp);
        saveDisease(disease_abp);


        //Diabetes mellitus Typ 1
        Disease disease_dm1 = new Disease();
        List<TestValueThreshold> threshold_dm1 = new ArrayList<>();
        disease_dm1.setDiseaseName("Diabetes mellitus Typ 1");
        disease_dm1.setDescription("Diabetes mellitus ist eine Stoffwechselerkrkankung, die auf Insulinmangel beruht und durhc einen chronsch erhöhten Blutzuckerspiegel gekennzeichnet ist.");
        disease_dm1.setIcdCode("E10");
        disease_dm1.setPregnant(false);
        disease_dm1.setMinAge(0);
        disease_dm1.setMaxAge(65);
        disease_dm1.setThreshold(40);
        threshold_dm1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Glukose (nüchtern)"), "Diabetes mellitus Typ 1",0,Type.ELEVATED,40));
        threshold_dm1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Hb1Ac"), "Diabetes mellitus Typ 1",0,Type.ELEVATED,40));
        threshold_dm1.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("C-Peptid"), "Diabetes mellitus Typ 1",0,Type.DECREASED,20));
        disease_dm1.setThreshold_DiseaseValues(threshold_dm1);
        saveDisease(disease_dm1);

        //Diabetes mellitus Typ 2
        Disease disease_dm2 = new Disease();
        List<TestValueThreshold> threshold_dm2 = new ArrayList<>();
        disease_dm2.setDiseaseName("Diabetes mellitus Typ 2");
        disease_dm2.setDescription("Diabetes mellitus ist eine Stoffwechselerkrkankung, die auf Insulinmangel beruht und durhc einen chronsch erhöhten Blutzuckerspiegel gekennzeichnet ist.");
        disease_dm2.setIcdCode("E10");
        disease_dm2.setPregnant(false);
        disease_dm2.setMinAge(18);
        disease_dm2.setMaxAge(200);
        disease_dm2.setThreshold(50);
        threshold_dm2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Glukose (nüchtern)"), "Diabetes mellitus Typ 2",0,Type.ELEVATED,50));
        threshold_dm2.add(generateThresholdEntries(labValueRepository.findLabValueByLabValName("Hb1Ac"), "Diabetes mellitus Typ 2",0,Type.ELEVATED,50));
        disease_dm2.setThreshold_DiseaseValues(threshold_dm1);
        saveDisease(disease_dm2);

    }

    public void saveDisease(Disease disease) {
        if (diseaseRepository.findDiseaseByDiseaseName(disease.getDiseaseName()) == null) {
            diseaseRepository.save(disease);
        }

    }


    private TestValueThreshold generateThresholdEntries(LabValue labValue, String diseaseName, float refValOverwrite, Type type, float weightValue) {
        TestValueThreshold threshold1 = new TestValueThreshold();
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

    public void saveThreshold(TestValueThreshold testValue_threshold) {
        testValue_thresholdRepository.save(testValue_threshold);
    }

}
