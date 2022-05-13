package at.ac.tuwien.dochelper.backend.datagenerator;


import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("generateData1")
@Component
public class LabValueDataGenerator {

    private final LabValueRepository labValueRepository;

    @Autowired
    public LabValueDataGenerator(LabValueRepository labValueRepository) {
        this.labValueRepository = labValueRepository;
    }


    @Autowired
    @PostConstruct
    public void generateLabValEntries() {
       // labValueRepository.deleteAll();

        LabValue labVal1 = new LabValue();
        labVal1.setLabValName("Bilirubin gesamt");
        labVal1.setUnit("mg/dl");
        save(labVal1);

        LabValue labVal2 = new LabValue();
        labVal2.setLabValName("Bilirubin direkt");
        labVal2.setUnit("mg/dl");
        save(labVal2);

        LabValue labVal3 = new LabValue();
        labVal3.setLabValName("Bilirubin indirekt");
        labVal3.setUnit("mg/dl");
        save(labVal3);

        LabValue labVal4 = new LabValue();
        labVal4.setLabValName("GGT");
        labVal4.setUnit("U/l");
        save(labVal4);

        LabValue labVal5 = new LabValue();
        labVal5.setLabValName("Alkalische Phosphatase (AP)");
        labVal5.setUnit("U/l");
        save(labVal5);

        LabValue labVal6 = new LabValue();
        labVal6.setLabValName("GOT (AST)");
        labVal6.setUnit("U/l");
        save(labVal6);

        LabValue labVal7 = new LabValue();
        labVal7.setLabValName("GPT (ALT)");
        labVal7.setUnit("U/l");
        save(labVal7);

        LabValue labVal8 = new LabValue();
        labVal8.setLabValName("Kreatinin");
        labVal8.setUnit("mg/dl");
        save(labVal8);

        LabValue labVal9 = new LabValue();
        labVal9.setLabValName("Thrombozyten");
        labVal9.setUnit("G/l");
        save(labVal9);

        LabValue labVal10 = new LabValue();
        labVal10.setLabValName("Thromboplastinzeit (TPZ; Quick)");
        labVal10.setUnit("%");
        save(labVal10);

        LabValue labVal11 = new LabValue();
        labVal11.setLabValName("Glukose (nüchtern)");
        labVal11.setUnit("mg/dl");
        save(labVal11);

        LabValue labVal12 = new LabValue();
        labVal12.setLabValName("LDH");
        labVal12.setUnit("U/l");
        save(labVal12);

        LabValue labVal13 = new LabValue();
        labVal13.setLabValName("Ammoniak (NH3)");
        labVal13.setUnit("µmol/l");
        save(labVal13);

        LabValue labVal14 = new LabValue();
        labVal14.setLabValName("ANA (Antinukleare AK)");
        labVal14.setUnit("keine Einheit");
        save(labVal14);

        LabValue labVal15 = new LabValue();
        labVal15.setLabValName("Albumin abs.");
        labVal15.setUnit("g/l");
        save(labVal15);

        LabValue labVal16 = new LabValue();
        labVal16.setLabValName("Kalium");
        labVal16.setUnit("mg/l");
        save(labVal16);

        LabValue labVal17 = new LabValue();
        labVal17.setLabValName("Hämoglobin (Hb)");
        labVal17.setUnit("g/dl");
        save(labVal17);

        LabValue labVal18 = new LabValue();
        labVal18.setLabValName("HBs-Ag");
        labVal18.setUnit("keine Einheit");
        save(labVal18);

        LabValue labVal19 = new LabValue();
        labVal19.setLabValName("Anti-HBc-IgM");
        labVal19.setUnit("keine Einheit");
        save(labVal19);

        LabValue labVal20 = new LabValue();
        labVal20.setLabValName("Anti-HBc");
        labVal20.setUnit("keine Einheit");
        save(labVal20);

        LabValue labVal21 = new LabValue();
        labVal21.setLabValName("HBe-Ag");
        labVal21.setUnit("keine Einheit");
        save(labVal21);

        LabValue labVal22 = new LabValue();
        labVal22.setLabValName("Anti-HBs");
        labVal22.setUnit("keine Einheit");
        save(labVal22);

        LabValue labVal23 = new LabValue();
        labVal23.setLabValName("Anti-HBe");
        labVal23.setUnit("keine Einheit");
        save(labVal23);

        LabValue labVal24 = new LabValue();
        labVal24.setLabValName("Lymphozyten (abs.)");
        labVal24.setUnit("G/l");
        save(labVal24);

        LabValue labVal25 = new LabValue();
        labVal25.setLabValName("Lipoprotein X");
        labVal25.setUnit("mg/dl");
        save(labVal25);

        LabValue labVal26 = new LabValue();
        labVal26.setLabValName("LAP");
        labVal26.setUnit("U/l");
        save(labVal26);

        LabValue labVal27 = new LabValue();
        labVal27.setLabValName("Gallensäure");
        labVal27.setUnit("µmol/l");
        save(labVal27);

        LabValue labVal28 = new LabValue();
        labVal28.setLabValName("CRP");
        labVal28.setUnit("mg/dl");
        save(labVal28);

        LabValue labVal29 = new LabValue();
        labVal29.setLabValName("Cholesterin");
        labVal29.setUnit("mg/dl");
        save(labVal29);

        LabValue labVal30 = new LabValue();
        labVal30.setLabValName("BSG 1h");
        labVal30.setUnit("mm");
        save(labVal30);

        LabValue labVal31 = new LabValue();
        labVal31.setLabValName("BSG 2h");
        labVal31.setUnit("mm");
        save(labVal31);

        LabValue labVal32 = new LabValue();
        labVal32.setLabValName("Leukozyten");
        labVal32.setUnit("G/l");
        save(labVal32);

        LabValue labVal33 = new LabValue();
        labVal33.setLabValName("Hämatokrit");
        labVal33.setUnit("%");
        save(labVal33);

        LabValue labVal34 = new LabValue();
        labVal34.setLabValName("Erythrozyten");
        labVal34.setUnit("T/l");
        save(labVal34);

        LabValue labVal35 = new LabValue();
        labVal35.setLabValName("Fibrinogen");
        labVal35.setUnit("mg/dl");
        save(labVal35);

        LabValue labVal36 = new LabValue();
        labVal36.setLabValName("D-Dimer");
        labVal36.setUnit("mg/l");
        save(labVal36);

        LabValue labVal37 = new LabValue();
        labVal37.setLabValName("Haptoglobin");
        labVal37.setUnit("mg/dl");
        save(labVal37);

        LabValue labVal38 = new LabValue();
        labVal38.setLabValName("p-ANCA (Myeloperoxidase-AK)");
        labVal38.setUnit("keine Einheit");
        save(labVal38);

        LabValue labVal39 = new LabValue();
        labVal39.setLabValName("IgM");
        labVal39.setUnit("g/l");
        save(labVal39);

        LabValue labVal40 = new LabValue();
        labVal40.setLabValName("Gesamt Kupfer (CU)");
        labVal40.setUnit("µg/dl");
        save(labVal40);

        LabValue labVal41 = new LabValue();
        labVal41.setLabValName("Erythrozytenverteilungsbreite");
        labVal41.setUnit("%");
        save(labVal41);

        LabValue labVal42 = new LabValue();
        labVal42.setLabValName("MCH");
        labVal42.setUnit("pg");
        save(labVal42);

        LabValue labVal43 = new LabValue();
        labVal43.setLabValName("MCHC");
        labVal43.setUnit("g/dl");
        save(labVal43);

        LabValue labVal44 = new LabValue();
        labVal44.setLabValName("MCV");
        labVal44.setUnit("fl");
        save(labVal44);

        LabValue labVal45 = new LabValue();
        labVal45.setLabValName("Antithrombin (AT III)");
        labVal45.setUnit("%");
        save(labVal45);

        LabValue labVal46 = new LabValue();
        labVal46.setLabValName("INR (International Normalized Ratio)");
        labVal46.setUnit("keine Einheit");
        save(labVal46);

        LabValue labVal47 = new LabValue();
        labVal47.setLabValName("PTT");
        labVal47.setUnit("keine Einheit");
        save(labVal47);

        LabValue labVal48 = new LabValue();
        labVal48.setLabValName("berechnete GFR (MDRD Formel)");
        labVal48.setUnit("keine Einheit");
        save(labVal48);

        LabValue labVal49 = new LabValue();
        labVal49.setLabValName("Gesamteiweiß");
        labVal49.setUnit("g/l");
        save(labVal49);

        LabValue labVal50 = new LabValue();
        labVal50.setLabValName("Harnstoff");
        labVal50.setUnit("mg/dl");
        save(labVal50);

        LabValue labVal51 = new LabValue();
        labVal51.setLabValName("Mittleres Plättchenvolumen");
        labVal51.setUnit("fl");
        save(labVal51);

        LabValue labVal52 = new LabValue();
        labVal52.setLabValName("Phosphat");
        labVal52.setUnit("mg/dl");
        save(labVal52);

        LabValue labVal53 = new LabValue();
        labVal53.setLabValName("Cholinesterase (ChE)");
        labVal53.setUnit("mg/dl");
        save(labVal53);

        LabValue labVal54 = new LabValue();
        labVal54.setLabValName("Lipase");
        labVal54.setUnit("U/l");
        save(labVal54);

        LabValue labVal55 = new LabValue();
        labVal55.setLabValName("Kalzium, gesamt");
        labVal55.setUnit("mg/dl");
        save(labVal55);

        LabValue labVal56 = new LabValue();
        labVal56.setLabValName("Alpha-Amylase");
        labVal56.setUnit("U/l");
        save(labVal56);

        LabValue labVal57 = new LabValue();
        labVal57.setLabValName("Procalcitonin");
        labVal57.setUnit("ng/ml");
        save(labVal57);

        LabValue labVal58 = new LabValue();
        labVal58.setLabValName("Hb1Ac");
        labVal58.setUnit("%");
        save(labVal58);

        LabValue labVal59 = new LabValue();
        labVal59.setLabValName("HbA1c (Berechnung nach IFCC)");
        labVal59.setUnit("mmol/mol");
        save(labVal59);

        LabValue labVal60 = new LabValue();
        labVal60.setLabValName("Basophile abs.");
        labVal60.setUnit("G/l");
        save(labVal60);

        LabValue labVal61 = new LabValue();
        labVal61.setLabValName("Basophile rel.");
        labVal61.setUnit("G/l");
        save(labVal61);

        LabValue labVal62 = new LabValue();
        labVal62.setLabValName("Eosinophile abs.");
        labVal62.setUnit("/mm³");
        save(labVal62);

        LabValue labVal63 = new LabValue();
        labVal63.setLabValName("Lymphozyten abs.");
        labVal63.setUnit("/mm³");
        save(labVal63);

        LabValue labVal64 = new LabValue();
        labVal64.setLabValName("Eosinophile rel.");
        labVal64.setUnit("%");
        save(labVal64);

        LabValue labVal65 = new LabValue();
        labVal65.setLabValName("Monozyten abs.");
        labVal65.setUnit("/mm³");
        save(labVal65);

        LabValue labVal66 = new LabValue();
        labVal66.setLabValName("Monozyten rel.");
        labVal66.setUnit("%");
        save(labVal66);

        LabValue labVal67 = new LabValue();
        labVal67.setLabValName("Neutrophile abs.");
        labVal67.setUnit("G/l");
        save(labVal67);

        LabValue labVal68 = new LabValue();
        labVal68.setLabValName("Neutrophile rel.");
        labVal68.setUnit("%");
        save(labVal68);

        LabValue labVal69 = new LabValue();
        labVal69.setLabValName("Vitamin D (25-OH) total");
        labVal69.setUnit("µg/l");
        save(labVal69);

        LabValue labVal70 = new LabValue();
        labVal70.setLabValName("Vitamin D (25-OH) total IFCC");
        labVal70.setUnit("nmol/l");
        save(labVal70);

        LabValue labVal71 = new LabValue();
        labVal71.setLabValName("Thyreoidea-stimulierendes Hormon (TSH) basal");
        labVal71.setUnit("µU/ml");
        save(labVal71);

        LabValue labVal72 = new LabValue();
        labVal72.setLabValName("BUN (Harnstoff)");
        labVal72.setUnit("mg/dl");
        save(labVal72);

        LabValue labVal73 = new LabValue();
        labVal73.setLabValName("Cholesterinquotient (Chol/HDL)");
        labVal73.setUnit("mg/dl");
        save(labVal73);

        LabValue labVal74 = new LabValue();
        labVal74.setLabValName("CK-MB (Herzmuskel)");
        labVal74.setUnit("U/l");
        save(labVal74);

        LabValue labVal75 = new LabValue();
        labVal75.setLabValName("Eisen");
        labVal75.setUnit("µg/dl");
        save(labVal75);

        LabValue labVal76 = new LabValue();
        labVal76.setLabValName("Ferritin");
        labVal76.setUnit("ng/dl");
        save(labVal76);

        LabValue labVal77 = new LabValue();
        labVal77.setLabValName("HDL-Cholesterin");
        labVal77.setUnit("mg/dl");
        save(labVal77);

        LabValue labVal78 = new LabValue();
        labVal78.setLabValName("LDL-Cholesterin");
        labVal78.setUnit("mg/dl");
        save(labVal78);

        LabValue labVal79 = new LabValue();
        labVal79.setLabValName("Natrium");
        labVal79.setUnit("mmol/l");
        save(labVal79);

        LabValue labVal80 = new LabValue();
        labVal80.setLabValName("Phosphat");
        labVal80.setUnit("mmol/l");
        save(labVal80);

        LabValue labVal81 = new LabValue();
        labVal81.setLabValName("Transferrin");
        labVal81.setUnit("g/l");
        save(labVal81);

        LabValue labVal82 = new LabValue();
        labVal82.setLabValName("Transferrinsättigung");
        labVal82.setUnit("%");
        save(labVal82);

        LabValue labVal83 = new LabValue();
        labVal83.setLabValName("Triglyceride");
        labVal83.setUnit("mg/dl");
        save(labVal83);

        LabValue labVal84 = new LabValue();
        labVal84.setLabValName("C-Peptid");
        labVal84.setUnit("ng/ml");
        save(labVal84);

    }

    public void save(LabValue labValue) {
        if(labValueRepository.findLabValueByLabValName(labValue.getLabValName()) == null){
            labValueRepository.save(labValue);
        }
        }
}
