package at.ac.tuwien.dochelper.backend.datagenerator;

import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.repository.LabMeasureRepository;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("generateData1")
@Component
public class LabMeasureDataGenerator {

    @Autowired
    private LabValueDataGenerator labValueDataGenerator;

    private final LabValueRepository labValueRepository;
    private final LabMeasureRepository labMeasureRepository;

    public LabMeasureDataGenerator(LabValueRepository labValueRepository, LabMeasureRepository labMeasureRepository) {
        this.labValueRepository = labValueRepository;
        this.labMeasureRepository = labMeasureRepository;
    }

    @PostConstruct
    public void generateLabMeasureEntries() {

        //LabMeasures für Blutbild von Christian Dorfer
        LabMeasure labMeasure1 = new LabMeasure();
        labMeasure1.setId(1L);
        labMeasure1.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"));
        labMeasure1.setMeasuredValue(8.6f);
        labMeasure1.setRefValueBigger(1.2f);
        tryToSave(labMeasure1);

        LabMeasure labMeasure2 = new LabMeasure();
        labMeasure2.setId(2L);
        labMeasure2.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin direkt"));
        labMeasure2.setMeasuredValue(2.33f);
        labMeasure2.setRefValueBigger(0.3f);
        tryToSave(labMeasure2);

        LabMeasure labMeasure3 = new LabMeasure();
        labMeasure3.setId(3L);
        labMeasure3.setLabValue(labValueRepository.findLabValueByLabValName("GGT"));
        labMeasure3.setMeasuredValue(91f);
        labMeasure3.setRefValueLower(40f);
        tryToSave(labMeasure3);

        LabMeasure labMeasure4 = new LabMeasure();
        labMeasure4.setId(4L);
        labMeasure4.setLabValue(labValueRepository.findLabValueByLabValName("Erythrozyten"));
        labMeasure4.setMeasuredValue(2.26f);
        labMeasure4.setRefValueFrom(4.9f);
        labMeasure4.setRefValueTo(5.9f);
        tryToSave(labMeasure4);

        LabMeasure labMeasure5 = new LabMeasure();
        labMeasure5.setId(5L);
        labMeasure5.setLabValue(labValueRepository.findLabValueByLabValName("Erythrozytenverteilungsbreite"));
        labMeasure5.setMeasuredValue(16.7f);
        labMeasure5.setRefValueFrom(11.5f);
        labMeasure5.setRefValueTo(14.5f);
        tryToSave(labMeasure5);

        LabMeasure labMeasure6 = new LabMeasure();
        labMeasure6.setId(6L);
        labMeasure6.setLabValue(labValueRepository.findLabValueByLabValName("Hämatokrit"));
        labMeasure6.setMeasuredValue(20f);
        labMeasure6.setRefValueFrom(41f);
        labMeasure6.setRefValueTo(53f);
        tryToSave(labMeasure6);

        LabMeasure labMeasure7 = new LabMeasure();
        labMeasure7.setId(7L);
        labMeasure7.setLabValue(labValueRepository.findLabValueByLabValName("Hämoglobin (Hb)"));
        labMeasure7.setMeasuredValue(7f);
        labMeasure7.setRefValueFrom(14f);
        labMeasure7.setRefValueTo(18f);
        tryToSave(labMeasure7);

        LabMeasure labMeasure8 = new LabMeasure();
        labMeasure8.setId(8L);
        labMeasure8.setLabValue(labValueRepository.findLabValueByLabValName("Leukozyten"));
        labMeasure8.setMeasuredValue(1.6f);
        labMeasure8.setRefValueFrom(4f);
        labMeasure8.setRefValueTo(10f);
        tryToSave(labMeasure8);

        LabMeasure labMeasure9 = new LabMeasure();
        labMeasure9.setId(9L);
        labMeasure9.setLabValue(labValueRepository.findLabValueByLabValName("MCH"));
        labMeasure9.setMeasuredValue(31f);
        labMeasure9.setRefValueFrom(27f);
        labMeasure9.setRefValueTo(33f);
        tryToSave(labMeasure9);

        LabMeasure labMeasure10 = new LabMeasure();
        labMeasure10.setId(10L);
        labMeasure10.setLabValue(labValueRepository.findLabValueByLabValName("MCHC"));
        labMeasure10.setMeasuredValue(34f);
        labMeasure10.setRefValueFrom(31f);
        labMeasure10.setRefValueTo(37f);
        tryToSave(labMeasure10);

        LabMeasure labMeasure11 = new LabMeasure();
        labMeasure11.setId(11L);
        labMeasure11.setLabValue(labValueRepository.findLabValueByLabValName("MCV"));
        labMeasure11.setMeasuredValue(90f);
        labMeasure11.setRefValueFrom(80f);
        labMeasure11.setRefValueTo(99f);
        tryToSave(labMeasure11);

        LabMeasure labMeasure12 = new LabMeasure();
        labMeasure12.setId(12L);
        labMeasure12.setLabValue(labValueRepository.findLabValueByLabValName("Thrombozyten"));
        labMeasure12.setMeasuredValue(25f);
        labMeasure12.setRefValueFrom(140f);
        labMeasure12.setRefValueTo(400f);
        tryToSave(labMeasure12);

        LabMeasure labMeasure13 = new LabMeasure();
        labMeasure13.setId(13L);
        labMeasure13.setLabValue(labValueRepository.findLabValueByLabValName("Antithrombin (AT III)"));
        labMeasure13.setMeasuredValue(59f);
        labMeasure13.setRefValueFrom(79f);
        labMeasure13.setRefValueTo(112f);
        tryToSave(labMeasure13);

        LabMeasure labMeasure14 = new LabMeasure();
        labMeasure14.setId(14L);
        labMeasure14.setLabValue(labValueRepository.findLabValueByLabValName("D-Dimer"));
        labMeasure14.setMeasuredValue(11f);
        labMeasure14.setRefValueLower(0.5f);
        tryToSave(labMeasure14);

        LabMeasure labMeasure15 = new LabMeasure();
        labMeasure15.setId(15L);
        labMeasure15.setLabValue(labValueRepository.findLabValueByLabValName("Fibrinogen"));
        labMeasure15.setMeasuredValue(233f);
        labMeasure15.setRefValueFrom(180f);
        labMeasure15.setRefValueTo(400f);
        tryToSave(labMeasure15);

        LabMeasure labMeasure16 = new LabMeasure();
        labMeasure16.setId(16L);
        labMeasure16.setLabValue(labValueRepository.findLabValueByLabValName("INR (International Normalized Ratio)"));
        labMeasure16.setMeasuredValue(1.74F);
        labMeasure16.setRefValueFrom(0.85F);
        labMeasure16.setRefValueTo(1.15f);
        tryToSave(labMeasure16);

        LabMeasure labMeasure17 = new LabMeasure();
        labMeasure17.setId(17L);
        labMeasure17.setLabValue(labValueRepository.findLabValueByLabValName("PTT"));
        labMeasure17.setMeasuredValue(56f);
        labMeasure17.setRefValueLower(34f);
        tryToSave(labMeasure17);

        LabMeasure labMeasure18 = new LabMeasure();
        labMeasure18.setId(18L);
        labMeasure18.setLabValue(labValueRepository.findLabValueByLabValName("Thromboplastinzeit (TPZ; Quick)"));
        labMeasure18.setMeasuredValue(39f);
        labMeasure18.setRefValueFrom(70f);
        labMeasure18.setRefValueTo(130f);
        tryToSave(labMeasure18);

        LabMeasure labMeasure19 = new LabMeasure();
        labMeasure19.setId(19L);
        labMeasure19.setLabValue(labValueRepository.findLabValueByLabValName("Albumin abs."));
        labMeasure19.setMeasuredValue(35f);
        labMeasure19.setRefValueFrom(35f);
        labMeasure19.setRefValueTo(52f);
        tryToSave(labMeasure19);

        LabMeasure labMeasure20 = new LabMeasure();
        labMeasure20.setId(20L);
        labMeasure20.setLabValue(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"));
        labMeasure20.setMeasuredValue(289f);
        labMeasure20.setRefValueFrom(40f);
        labMeasure20.setRefValueTo(129f);
        tryToSave(labMeasure20);

        LabMeasure labMeasure21 = new LabMeasure();
        labMeasure21.setId(21L);
        labMeasure21.setLabValue(labValueRepository.findLabValueByLabValName("berechnete GFR (MDRD Formel)"));
        labMeasure21.setMeasuredValue(34f);
        labMeasure21.setRefValueBigger(80f);
        tryToSave(labMeasure21);

        LabMeasure labMeasure22 = new LabMeasure();
        labMeasure22.setId(21L);
        labMeasure22.setLabValue(labValueRepository.findLabValueByLabValName("Cholinesterase (ChE)"));
        labMeasure22.setMeasuredValue(4.79f);
        labMeasure22.setRefValueFrom(5.32f);
        labMeasure22.setRefValueTo(12.92f);
        tryToSave(labMeasure22);


    }

    public void tryToSave(LabMeasure labMeasure) {
        if (labMeasureRepository.findById(labMeasure.getId()).isEmpty()) {
            labMeasureRepository.save(labMeasure);
        }
    }
}
