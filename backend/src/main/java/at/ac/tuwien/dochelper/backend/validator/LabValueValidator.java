package at.ac.tuwien.dochelper.backend.validator;


import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LabValueValidator {

    private final LabValueRepository labValueRepository;

    @Autowired
    public LabValueValidator(LabValueRepository labValueRepository) {
        this.labValueRepository = labValueRepository;
    }

    public void validateNewLabVal(LabValue labValue) {

        if (labValue == null) {
            //throw exception
        }
        if(labValue.getLabValId() != null) {
            // exception
        }
        if(labValue.getLabValName() == null){
            //exception
        }
        if(labValue.getUnit() == null){
            //exception
        }
    }
}
