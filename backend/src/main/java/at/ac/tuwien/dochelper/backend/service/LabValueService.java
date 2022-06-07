package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import at.ac.tuwien.dochelper.backend.validator.LabValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LabValueService {

    private final LabValueRepository labValueRepository;
    private final LabValueValidator labValueValidator;

    @Autowired
    public LabValueService(LabValueRepository labValueRepository, LabValueValidator labValueValidator) {
        this.labValueRepository = labValueRepository;
        this.labValueValidator = labValueValidator;
    }

    public List<LabValue> getAllLabVals() {
        return labValueRepository.findAll();
    }

    @Transactional
    public LabValue createLabVal(LabValue labValue)
    {
        labValueValidator.validateNewLabVal(labValue);
        return labValueRepository.save(labValue);
    }

    public void deleteLabValue(Long labValId) {
        labValueRepository.deleteById(labValId);
    }

    public LabValue getByName(String name){
        return labValueRepository.findLabValueByLabValName(name);
    }
}
