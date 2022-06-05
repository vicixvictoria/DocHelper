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
        labMeasureRepository.deleteAll();

        //LabMeasures für Blutbild von Christian Dorfer --> 1-30
        LabMeasure labMeasure1 = new LabMeasure();
        labMeasure1.setId(1L);
        labMeasure1.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"));
        labMeasure1.setMeasuredValue(8.6f);
        labMeasure1.setRefValueLower(1.2f);
        tryToSave(labMeasure1);

        LabMeasure labMeasure2 = new LabMeasure();
        labMeasure2.setId(2L);
        labMeasure2.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin direkt"));
        labMeasure2.setMeasuredValue(3.4f);
        labMeasure2.setRefValueLower(0.2f);
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
        labMeasure22.setId(22L);
        labMeasure22.setLabValue(labValueRepository.findLabValueByLabValName("Cholinesterase (ChE)"));
        labMeasure22.setMeasuredValue(4.79f);
        labMeasure22.setRefValueFrom(5.32f);
        labMeasure22.setRefValueTo(12.92f);
        tryToSave(labMeasure22);

        LabMeasure labMeasure23 = new LabMeasure();
        labMeasure23.setId(23L);
        labMeasure23.setLabValue(labValueRepository.findLabValueByLabValName("Gesamteiweiß"));
        labMeasure23.setMeasuredValue(56f);
        labMeasure23.setRefValueFrom(66f);
        labMeasure23.setRefValueTo(87f);
        tryToSave(labMeasure23);

        LabMeasure labMeasure24 = new LabMeasure();
        labMeasure24.setId(24L);
        labMeasure24.setLabValue(labValueRepository.findLabValueByLabValName("GOT (AST)"));
        labMeasure24.setMeasuredValue(48f);
        labMeasure24.setRefValueLower(35f);
        tryToSave(labMeasure24);

        LabMeasure labMeasure25 = new LabMeasure();
        labMeasure25.setId(25L);
        labMeasure25.setLabValue(labValueRepository.findLabValueByLabValName("GPT (ALT)"));
        labMeasure25.setMeasuredValue(39f);
        labMeasure25.setRefValueLower(35f);
        tryToSave(labMeasure25);

        LabMeasure labMeasure26 = new LabMeasure();
        labMeasure26.setId(26L);
        labMeasure26.setLabValue(labValueRepository.findLabValueByLabValName("Harnstoff"));
        labMeasure26.setMeasuredValue(67f);
        labMeasure26.setRefValueFrom(17f);
        labMeasure26.setRefValueTo(48f);
        tryToSave(labMeasure26);

        LabMeasure labMeasure27 = new LabMeasure();
        labMeasure27.setId(27L);
        labMeasure27.setLabValue(labValueRepository.findLabValueByLabValName("Kreatinin"));
        labMeasure27.setMeasuredValue(2f);
        labMeasure27.setRefValueFrom(0.5f);
        labMeasure27.setRefValueTo(0.9f);
        tryToSave(labMeasure27);

        LabMeasure labMeasure28 = new LabMeasure();
        labMeasure28.setId(28L);
        labMeasure28.setLabValue(labValueRepository.findLabValueByLabValName("LDH"));
        labMeasure28.setMeasuredValue(290f);
        labMeasure28.setRefValueFrom(0f);
        labMeasure28.setRefValueTo(262f);
        tryToSave(labMeasure28);

        LabMeasure labMeasure29 = new LabMeasure();
        labMeasure29.setId(29L);
        labMeasure29.setLabValue(labValueRepository.findLabValueByLabValName("Mittleres Plättchenvolumen"));
        labMeasure29.setMeasuredValue(12.1f);
        labMeasure29.setRefValueFrom(7.8f);
        labMeasure29.setRefValueTo(11f);
        tryToSave(labMeasure29);

        LabMeasure labMeasure30 = new LabMeasure();
        labMeasure30.setId(30L);
        labMeasure30.setLabValue(labValueRepository.findLabValueByLabValName("Phosphat"));
        labMeasure30.setMeasuredValue(12.1f);
        labMeasure30.setRefValueFrom(7.8f);
        labMeasure30.setRefValueTo(11f);
        tryToSave(labMeasure30);

        //LabMeasures für  Mona Niederhuber, Id 31-81
        LabMeasure labMeasure31 = new LabMeasure();
        labMeasure31.setId(31L);
        labMeasure31.setLabValue(labValueRepository.findLabValueByLabValName("Erythrozyten"));
        labMeasure31.setMeasuredValue(4.6f);
        labMeasure31.setRefValueFrom(3.8f);
        labMeasure31.setRefValueTo(5.2f);
        tryToSave(labMeasure31);

        LabMeasure labMeasure32 = new LabMeasure();
        labMeasure32.setId(32L);
        labMeasure32.setLabValue(labValueRepository.findLabValueByLabValName("Erythrozytenverteilungsbreite"));
        labMeasure32.setMeasuredValue(14f);
        labMeasure32.setRefValueFrom(11f);
        labMeasure32.setRefValueTo(16f);
        tryToSave(labMeasure32);

        LabMeasure labMeasure33 = new LabMeasure();
        labMeasure33.setId(33L);
        labMeasure33.setLabValue(labValueRepository.findLabValueByLabValName("Hämatokrit"));
        labMeasure33.setMeasuredValue(14f);
        labMeasure33.setRefValueFrom(11f);
        labMeasure33.setRefValueTo(16f);
        tryToSave(labMeasure33);

        LabMeasure labMeasure34 = new LabMeasure();
        labMeasure34.setId(34L);
        labMeasure34.setLabValue(labValueRepository.findLabValueByLabValName("Hämoglobin (Hb)"));
        labMeasure34.setMeasuredValue(12.9f);
        labMeasure34.setRefValueFrom(12f);
        labMeasure34.setRefValueTo(16f);
        tryToSave(labMeasure34);

        LabMeasure labMeasure35 = new LabMeasure();
        labMeasure35.setId(35L);
        labMeasure35.setLabValue(labValueRepository.findLabValueByLabValName("HbA1c"));
        labMeasure35.setMeasuredValue(8.2f);
        labMeasure35.setRefValueFrom(4f);
        labMeasure35.setRefValueTo(6f);
        tryToSave(labMeasure35);

        LabMeasure labMeasure36 = new LabMeasure();
        labMeasure36.setId(36L);
        labMeasure36.setLabValue(labValueRepository.findLabValueByLabValName("HbA1c (Berechnung nach IFCC)"));
        labMeasure36.setMeasuredValue(66f);
        labMeasure36.setRefValueFrom(22f);
        labMeasure36.setRefValueTo(42f);
        tryToSave(labMeasure36);

        LabMeasure labMeasure37 = new LabMeasure();
        labMeasure37.setId(37L);
        labMeasure37.setLabValue(labValueRepository.findLabValueByLabValName("Leukozyten"));
        labMeasure37.setMeasuredValue(8.2f);
        labMeasure37.setRefValueFrom(4f);
        labMeasure37.setRefValueTo(10f);
        tryToSave(labMeasure37);

        LabMeasure labMeasure38 = new LabMeasure();
        labMeasure38.setId(38L);
        labMeasure38.setLabValue(labValueRepository.findLabValueByLabValName("MCH"));
        labMeasure38.setMeasuredValue(30f);
        labMeasure38.setRefValueFrom(26f);
        labMeasure38.setRefValueTo(34f);
        tryToSave(labMeasure38);

        LabMeasure labMeasure39 = new LabMeasure();
        labMeasure39.setId(39L);
        labMeasure39.setLabValue(labValueRepository.findLabValueByLabValName("MCV"));
        labMeasure39.setMeasuredValue(90f);
        labMeasure39.setRefValueFrom(78f);
        labMeasure39.setRefValueTo(98f);
        tryToSave(labMeasure39);

        LabMeasure labMeasure40 = new LabMeasure();
        labMeasure40.setId(40L);
        labMeasure40.setLabValue(labValueRepository.findLabValueByLabValName("MCHC"));
        labMeasure40.setMeasuredValue(34f);
        labMeasure40.setRefValueFrom(32f);
        labMeasure40.setRefValueTo(36f);
        tryToSave(labMeasure40);

        LabMeasure labMeasure41 = new LabMeasure();
        labMeasure41.setId(41L);
        labMeasure41.setLabValue(labValueRepository.findLabValueByLabValName("Thrombozyten"));
        labMeasure41.setMeasuredValue(318f);
        labMeasure41.setRefValueFrom(150f);
        labMeasure41.setRefValueTo(350f);
        tryToSave(labMeasure41);

        LabMeasure labMeasure42 = new LabMeasure();
        labMeasure42.setId(42L);
        labMeasure42.setLabValue(labValueRepository.findLabValueByLabValName("Basophile abs."));
        labMeasure42.setMeasuredValue(0.1f);
        labMeasure42.setRefValueLower(0.2f);
        tryToSave(labMeasure42);

        LabMeasure labMeasure43 = new LabMeasure();
        labMeasure43.setId(43L);
        labMeasure43.setLabValue(labValueRepository.findLabValueByLabValName("Eosinophile abs."));
        labMeasure43.setMeasuredValue(560f);
        labMeasure43.setRefValueLower(400f);
        tryToSave(labMeasure43);

        LabMeasure labMeasure44 = new LabMeasure();
        labMeasure44.setId(44L);
        labMeasure44.setLabValue(labValueRepository.findLabValueByLabValName("Lymphozyten abs."));
        labMeasure44.setMeasuredValue(2900f);
        labMeasure44.setRefValueFrom(1500f);
        labMeasure44.setRefValueTo(4110f);
        tryToSave(labMeasure44);

        LabMeasure labMeasure45 = new LabMeasure();
        labMeasure45.setId(45L);
        labMeasure45.setLabValue(labValueRepository.findLabValueByLabValName("Lymphozyten rel."));
        labMeasure45.setMeasuredValue(36f);
        labMeasure45.setRefValueFrom(25f);
        labMeasure45.setRefValueTo(40f);
        tryToSave(labMeasure45);

        LabMeasure labMeasure46 = new LabMeasure();
        labMeasure46.setId(46L);
        labMeasure46.setLabValue(labValueRepository.findLabValueByLabValName("Monozyten abs."));
        labMeasure46.setMeasuredValue(700f);
        labMeasure46.setRefValueLower(1200f);
        tryToSave(labMeasure46);

        LabMeasure labMeasure47 = new LabMeasure();
        labMeasure47.setId(47L);
        labMeasure47.setLabValue(labValueRepository.findLabValueByLabValName("Neutrophile abs."));
        labMeasure47.setMeasuredValue(3.9f);
        labMeasure47.setRefValueFrom(2f);
        labMeasure47.setRefValueTo(7.5f);
        tryToSave(labMeasure47);

        LabMeasure labMeasure48 = new LabMeasure();
        labMeasure48.setId(48L);
        labMeasure48.setLabValue(labValueRepository.findLabValueByLabValName("Neutrophile rel."));
        labMeasure48.setMeasuredValue(48f);
        labMeasure48.setRefValueFrom(50f);
        labMeasure48.setRefValueTo(75f);
        tryToSave(labMeasure48);

        LabMeasure labMeasure49 = new LabMeasure();
        labMeasure49.setId(49L);
        labMeasure49.setLabValue(labValueRepository.findLabValueByLabValName("Vitamin D (25-OH) total"));
        labMeasure49.setMeasuredValue(21f);
        labMeasure49.setRefValueFrom(30f);
        labMeasure49.setRefValueTo(70f);
        tryToSave(labMeasure49);

        LabMeasure labMeasure50 = new LabMeasure();
        labMeasure50.setId(50L);
        labMeasure50.setLabValue(labValueRepository.findLabValueByLabValName("Vitamin D (25-OH) total IFCC"));
        labMeasure50.setMeasuredValue(53f);
        labMeasure50.setRefValueFrom(75f);
        labMeasure50.setRefValueTo(175f);
        tryToSave(labMeasure50);

        LabMeasure labMeasure51 = new LabMeasure();
        labMeasure51.setId(51L);
        labMeasure51.setLabValue(labValueRepository.findLabValueByLabValName("Thyreoidea-stimulierendes Hormon (TSH) basal"));
        labMeasure51.setMeasuredValue(1.6f);
        labMeasure51.setRefValueFrom(0.3f);
        labMeasure51.setRefValueTo(4f);
        tryToSave(labMeasure51);

        LabMeasure labMeasure52 = new LabMeasure();
        labMeasure52.setId(52L);
        labMeasure52.setLabValue(labValueRepository.findLabValueByLabValName("Albumin abs."));
        labMeasure52.setMeasuredValue(43f);
        labMeasure52.setRefValueFrom(31f);
        labMeasure52.setRefValueTo(35f);
        tryToSave(labMeasure52);

        LabMeasure labMeasure53 = new LabMeasure();
        labMeasure53.setId(53L);
        labMeasure53.setLabValue(labValueRepository.findLabValueByLabValName("Alkalische Phosphatase (AP)"));
        labMeasure53.setMeasuredValue(55f);
        labMeasure53.setRefValueFrom(30f);
        labMeasure53.setRefValueTo(104f);
        tryToSave(labMeasure53);

        LabMeasure labMeasure54 = new LabMeasure();
        labMeasure54.setId(54L);
        labMeasure54.setLabValue(labValueRepository.findLabValueByLabValName("berechnete GFR (MDRD Formel)"));
        labMeasure54.setMeasuredValue(61f);
        labMeasure54.setRefValueBigger(60f);
        tryToSave(labMeasure54);

        LabMeasure labMeasure55 = new LabMeasure();
        labMeasure55.setId(55L);
        labMeasure55.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"));
        labMeasure55.setMeasuredValue(1f);
        labMeasure55.setRefValueLower(1.2f);
        tryToSave(labMeasure55);

        LabMeasure labMeasure56 = new LabMeasure();
        labMeasure56.setId(56L);
        labMeasure56.setLabValue(labValueRepository.findLabValueByLabValName("BUN (Harnstoff-N)"));
        labMeasure56.setMeasuredValue(19f);
        labMeasure56.setRefValueFrom(8f);
        labMeasure56.setRefValueTo(23f);
        tryToSave(labMeasure56);

        LabMeasure labMeasure57 = new LabMeasure();
        labMeasure57.setId(57L);
        labMeasure57.setLabValue(labValueRepository.findLabValueByLabValName("Chlorid"));
        labMeasure57.setMeasuredValue(104f);
        labMeasure57.setRefValueFrom(101f);
        labMeasure57.setRefValueTo(109f);
        tryToSave(labMeasure57);

        LabMeasure labMeasure58 = new LabMeasure();
        labMeasure58.setId(58L);
        labMeasure58.setLabValue(labValueRepository.findLabValueByLabValName("Cholesterin"));
        labMeasure58.setMeasuredValue(247f);
        labMeasure58.setRefValueLower(200f);
        tryToSave(labMeasure58);

        LabMeasure labMeasure59 = new LabMeasure();
        labMeasure59.setId(59L);
        labMeasure59.setLabValue(labValueRepository.findLabValueByLabValName("Cholesterinquotient (Chol/HDL)"));
        labMeasure59.setMeasuredValue(4.7f);
        labMeasure59.setRefValueLower(4f);
        tryToSave(labMeasure59);

        LabMeasure labMeasure60 = new LabMeasure();
        labMeasure60.setId(60L);
        labMeasure60.setLabValue(labValueRepository.findLabValueByLabValName("Cholinesterase (ChE)"));
        labMeasure60.setMeasuredValue(8073f);
        labMeasure60.setRefValueFrom(3650f);
        labMeasure60.setRefValueTo(12920f);
        tryToSave(labMeasure60);

        LabMeasure labMeasure61 = new LabMeasure();
        labMeasure61.setId(61L);
        labMeasure61.setLabValue(labValueRepository.findLabValueByLabValName("CK-MB (Herzmuskel)"));
        labMeasure61.setMeasuredValue(64f);
        labMeasure61.setRefValueLower(170f);
        tryToSave(labMeasure61);

        LabMeasure labMeasure62 = new LabMeasure();
        labMeasure62.setId(62L);
        labMeasure62.setLabValue(labValueRepository.findLabValueByLabValName("CRP"));
        labMeasure62.setMeasuredValue(0.13f);
        labMeasure62.setRefValueLower(0.5f);
        tryToSave(labMeasure62);

        LabMeasure labMeasure63 = new LabMeasure();
        labMeasure63.setId(63L);
        labMeasure63.setLabValue(labValueRepository.findLabValueByLabValName("Eisen"));
        labMeasure63.setMeasuredValue(86f);
        labMeasure63.setRefValueFrom(37f);
        labMeasure63.setRefValueTo(145f);
        tryToSave(labMeasure63);

        LabMeasure labMeasure64 = new LabMeasure();
        labMeasure64.setId(64L);
        labMeasure64.setLabValue(labValueRepository.findLabValueByLabValName("Ferritin"));
        labMeasure64.setMeasuredValue(45f);
        labMeasure64.setRefValueFrom(30f);
        labMeasure64.setRefValueTo(300f);
        tryToSave(labMeasure64);

        LabMeasure labMeasure65 = new LabMeasure();
        labMeasure65.setId(65L);
        labMeasure65.setLabValue(labValueRepository.findLabValueByLabValName("Ferritin"));
        labMeasure65.setMeasuredValue(28f);
        labMeasure65.setRefValueLower(40f);
        tryToSave(labMeasure65);

        LabMeasure labMeasure66 = new LabMeasure();
        labMeasure66.setId(66L);
        labMeasure66.setLabValue(labValueRepository.findLabValueByLabValName("GOT (AST)"));
        labMeasure66.setMeasuredValue(19f);
        labMeasure66.setRefValueLower(35f);
        tryToSave(labMeasure66);

        LabMeasure labMeasure67 = new LabMeasure();
        labMeasure67.setId(67L);
        labMeasure67.setLabValue(labValueRepository.findLabValueByLabValName("GPT (ALT)"));
        labMeasure67.setMeasuredValue(22f);
        labMeasure67.setRefValueLower(35f);
        tryToSave(labMeasure67);

        LabMeasure labMeasure68 = new LabMeasure();
        labMeasure68.setId(68L);
        labMeasure68.setLabValue(labValueRepository.findLabValueByLabValName("Harnsaeure"));
        labMeasure68.setMeasuredValue(6f);
        labMeasure68.setRefValueFrom(2.6f);
        labMeasure68.setRefValueTo(6f);
        tryToSave(labMeasure68);

        LabMeasure labMeasure69 = new LabMeasure();
        labMeasure69.setId(69L);
        labMeasure69.setLabValue(labValueRepository.findLabValueByLabValName("Harnstoff"));
        labMeasure69.setMeasuredValue(41f);
        labMeasure69.setRefValueFrom(17f);
        labMeasure69.setRefValueTo(50f);
        tryToSave(labMeasure69);

        LabMeasure labMeasure70 = new LabMeasure();
        labMeasure70.setId(70L);
        labMeasure70.setLabValue(labValueRepository.findLabValueByLabValName("HDL-Cholesterin"));
        labMeasure70.setMeasuredValue(53f);
        labMeasure70.setRefValueBigger(50f);
        tryToSave(labMeasure70);

        LabMeasure labMeasure71 = new LabMeasure();
        labMeasure71.setId(71L);
        labMeasure71.setLabValue(labValueRepository.findLabValueByLabValName("Kalium"));
        labMeasure71.setMeasuredValue(4.5f);
        labMeasure71.setRefValueFrom(3.5f);
        labMeasure71.setRefValueTo(5.1f);
        tryToSave(labMeasure71);

        LabMeasure labMeasure72 = new LabMeasure();
        labMeasure72.setId(72L);
        labMeasure72.setLabValue(labValueRepository.findLabValueByLabValName("Kalzium, gesamt"));
        labMeasure72.setMeasuredValue(2.4f);
        labMeasure72.setRefValueFrom(2.2f);
        labMeasure72.setRefValueTo(2.65f);
        tryToSave(labMeasure72);

        LabMeasure labMeasure73 = new LabMeasure();
        labMeasure73.setId(73L);
        labMeasure73.setLabValue(labValueRepository.findLabValueByLabValName("Kreatinin"));
        labMeasure73.setMeasuredValue(0.9f);
        labMeasure73.setRefValueFrom(0.51f);
        labMeasure73.setRefValueTo(0.95f);
        tryToSave(labMeasure73);

        LabMeasure labMeasure74 = new LabMeasure();
        labMeasure74.setId(74L);
        labMeasure74.setLabValue(labValueRepository.findLabValueByLabValName("LDH"));
        labMeasure74.setMeasuredValue(161f);
        labMeasure74.setRefValueFrom(1f);
        labMeasure74.setRefValueTo(223f);
        tryToSave(labMeasure74);

        LabMeasure labMeasure75 = new LabMeasure();
        labMeasure75.setId(75L);
        labMeasure75.setLabValue(labValueRepository.findLabValueByLabValName("LDL-Cholesterin"));
        labMeasure75.setMeasuredValue(163f);
        labMeasure75.setRefValueLower(160f);
        tryToSave(labMeasure75);

        LabMeasure labMeasure76 = new LabMeasure();
        labMeasure76.setId(76L);
        labMeasure76.setLabValue(labValueRepository.findLabValueByLabValName("Lipase"));
        labMeasure76.setMeasuredValue(42f);
        labMeasure76.setRefValueLower(78f);
        tryToSave(labMeasure76);

        LabMeasure labMeasure77 = new LabMeasure();
        labMeasure77.setId(77L);
        labMeasure77.setLabValue(labValueRepository.findLabValueByLabValName("Natrium"));
        labMeasure77.setMeasuredValue(143f);
        labMeasure77.setRefValueFrom(136f);
        labMeasure77.setRefValueTo(146f);
        tryToSave(labMeasure77);

        LabMeasure labMeasure78 = new LabMeasure();
        labMeasure78.setId(78L);
        labMeasure78.setLabValue(labValueRepository.findLabValueByLabValName("Phosphat"));
        labMeasure78.setMeasuredValue(1.2f);
        labMeasure78.setRefValueFrom(0.8f);
        labMeasure78.setRefValueTo(1.6f);
        tryToSave(labMeasure78);

        LabMeasure labMeasure79 = new LabMeasure();
        labMeasure79.setId(79L);
        labMeasure79.setLabValue(labValueRepository.findLabValueByLabValName("Transferrin"));
        labMeasure79.setMeasuredValue(2.69f);
        labMeasure79.setRefValueFrom(1.42f);
        labMeasure79.setRefValueTo(3.3f);
        tryToSave(labMeasure79);

        LabMeasure labMeasure80 = new LabMeasure();
        labMeasure80.setId(80L);
        labMeasure80.setLabValue(labValueRepository.findLabValueByLabValName("Transferrinsättigung"));
        labMeasure80.setMeasuredValue(23f);
        labMeasure80.setRefValueFrom(15f);
        labMeasure80.setRefValueTo(45f);
        tryToSave(labMeasure80);

        LabMeasure labMeasure81 = new LabMeasure();
        labMeasure81.setId(81L);
        labMeasure81.setLabValue(labValueRepository.findLabValueByLabValName("Triglyceride"));
        labMeasure81.setMeasuredValue(154f);
        labMeasure81.setRefValueFrom(70f);
        labMeasure81.setRefValueTo(150f);
        tryToSave(labMeasure81);

        //Patient Anna Beiser id 82-84
        LabMeasure labMeasure82 = new LabMeasure();
        labMeasure82.setId(82L);
        labMeasure82.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"));
        labMeasure82.setMeasuredValue(3.4f);
        labMeasure82.setRefValueLower(1.2f);
        tryToSave(labMeasure82);

        LabMeasure labMeasure83 = new LabMeasure();
        labMeasure83.setId(83L);
        labMeasure83.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin indirekt"));
        labMeasure83.setMeasuredValue(3.4f);
        labMeasure83.setRefValueLower(1.2f);
        tryToSave(labMeasure83);


        LabMeasure labMeasure84 = new LabMeasure();
        labMeasure84.setId(84L);
        labMeasure84.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin direkt"));
        labMeasure84.setMeasuredValue(0.2f);
        labMeasure84.setRefValueLower(0.2f);
        tryToSave(labMeasure84);

        LabMeasure labMeasure85 = new LabMeasure();
        labMeasure85.setId(85L);
        labMeasure85.setLabValue(labValueRepository.findLabValueByLabValName("Glukose (nüchtern)"));
        labMeasure85.setMeasuredValue(230f);
        labMeasure85.setRefValueLower(95f);
        tryToSave(labMeasure85);

        LabMeasure labMeasure86 = new LabMeasure();
        labMeasure86.setId(86L);
        labMeasure86.setLabValue(labValueRepository.findLabValueByLabValName("GGT"));
        labMeasure86.setMeasuredValue(91f);
        labMeasure86.setRefValueLower(40f);
        tryToSave(labMeasure86);


    }

    public void tryToSave(LabMeasure labMeasure) {
        if (labMeasureRepository.findById(labMeasure.getId()).isEmpty() && labMeasure.getLabValue() != null) {
            labMeasureRepository.save(labMeasure);
        }
    }
}
