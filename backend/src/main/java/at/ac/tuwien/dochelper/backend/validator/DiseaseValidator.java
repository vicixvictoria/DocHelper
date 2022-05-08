package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiseaseValidator {

    private final DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseValidator(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public void validateNewDisease(Disease disease) {
        if (disease == null) {
            //throw exception
        }

        if(disease.getDiseaseId() != null) {
            // exception
        }
        if(disease.getDiseaseName() == null){
            //exception
        }
        if(disease.getThreshold() <0){
            //exception
        }
        if(disease.getMaxAge()<0 || disease.getMaxAge()<disease.getMinAge()){
            //exception
        }
        if(disease.getMinAge()<0){
            //exception
        }

    }

}
