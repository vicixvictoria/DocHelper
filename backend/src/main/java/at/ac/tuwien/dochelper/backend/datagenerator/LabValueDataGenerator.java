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

    }

    public void save(LabValue labValue) {
        if(labValueRepository.findLabValueByLabValName(labValue.getLabValName()) == null){
            labValueRepository.save(labValue);
        }
        }
}
