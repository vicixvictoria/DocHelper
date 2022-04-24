package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;

    }

    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }

    @Transactional
    public Disease createDisease(Disease disease)
    {
        //diseaseValidator.validateNewDisease(disease);
        return diseaseRepository.save(disease);
    }

    @Transactional
    public Disease updateDisease(Disease disease) {
        //diseaseValidator.validateUpdateDisease(disease);
        return diseaseRepository.save(disease);
    }
}
