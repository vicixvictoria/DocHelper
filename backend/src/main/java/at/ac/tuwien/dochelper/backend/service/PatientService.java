package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.Patient;
import at.ac.tuwien.dochelper.backend.repository.PatientRepository;
import at.ac.tuwien.dochelper.backend.validator.PatientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientValidator patientValidator;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientValidator patientValidator) {
        this.patientRepository = patientRepository;
        this.patientValidator = patientValidator;
    }


    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @Transactional
    public Patient createPatient(Patient patient)
    {
        patientValidator.validateNewPatient(patient);
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        if(patientValidator.validateDeletePatient(patientId)) {
            patientRepository.deleteById(patientId);
        }
    }

}
