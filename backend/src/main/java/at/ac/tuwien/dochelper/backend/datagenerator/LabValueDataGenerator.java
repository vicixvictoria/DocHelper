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

    }

    public void save(LabValue labValue) {
        if(labValueRepository.findLabValueByLabValName(labValue.getLabValName()) == null){
            labValueRepository.save(labValue);
        }
        }
}
