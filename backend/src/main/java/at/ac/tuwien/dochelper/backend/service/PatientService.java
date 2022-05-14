package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.Patient;
import at.ac.tuwien.dochelper.backend.exception.NotFoundException;
import at.ac.tuwien.dochelper.backend.repository.PatientRepository;
import at.ac.tuwien.dochelper.backend.validator.PatientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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

    public Patient getPatientById(Long patientId) {
        Optional<Patient> optional = patientRepository.findById(patientId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Patient was not found");
        }
    }

    @Transactional
    public Patient createPatient(Patient patient)
    {
        patientValidator.validateNewPatient(patient);
        return patientRepository.save(patient);
    }

    @Transactional
    public Patient updatePatient(Patient patient) {
        patientValidator.validateUpdatePatient(patient);
        return patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        if(patientValidator.validateDeletePatient(patientId)) {
            patientRepository.deleteById(patientId);
        }
    }

}
