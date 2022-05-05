package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import at.ac.tuwien.dochelper.backend.validator.DiseaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseValidator diseaseValidator;

    @Autowired
    public DiseaseService(DiseaseRepository diseaseRepository, DiseaseValidator diseaseValidator) {
        this.diseaseRepository = diseaseRepository;
        this.diseaseValidator = diseaseValidator;

    }

    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }

    public Disease getDiseaseByName(String name){return diseaseRepository.findDiseaseByDiseaseName(name);}

    @Transactional
    public Disease createDisease(Disease disease)
    {
        diseaseValidator.validateNewDisease(disease);
        return diseaseRepository.save(disease);
    }

    /*
    @Transactional
    public Disease updateDisease(Disease disease) {
        diseaseValidator.validateUpdateDisease(disease);
        return diseaseRepository.save(disease);
    }*/
}
