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

        LabMeasure labMeasure1 = new LabMeasure();
        labMeasure1.setId(1L);
        labMeasure1.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"));
        labMeasure1.setMeasuredValue(123f);
        labMeasure1.setRefValueBigger(130f);
        tryToSave(labMeasure1);

        LabMeasure labMeasure2 = new LabMeasure();
        labMeasure2.setId(2L);
        labMeasure2.setLabValue(labValueRepository.findLabValueByLabValName("Bilirubin gesamt"));
        labMeasure2.setMeasuredValue(135f);
        labMeasure2.setRefValueBigger(130f);
        tryToSave(labMeasure2);

        LabMeasure labMeasure3 = new LabMeasure();
        labMeasure3.setId(3L);
        labMeasure3.setLabValue(labValueRepository.findLabValueByLabValName("GGT"));
        labMeasure3.setMeasuredValue(56f);
        labMeasure3.setRefValueLower(70f);
        tryToSave(labMeasure3);
    }

    public void tryToSave(LabMeasure labMeasure) {
        if (labMeasureRepository.findById(labMeasure.getId()).isEmpty()) {
            labMeasureRepository.save(labMeasure);
        }
    }
}
