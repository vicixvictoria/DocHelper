package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.Patient;
import at.ac.tuwien.dochelper.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientValidator {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientValidator(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void validateNewPatient(Patient patient) {
        if (patient == null) {
            //throw exception
        }

        if(patient.getId() != null) {
            //throw exception
        }

        if(patient.getFirstName() == null) {
            //throw exception
        }

        if(patient.getLastName() == null) {
            //throw exception
        }

        if(patient.getSvnr() == null) {
            //throw exception
        }

        if(patient.getBirthDate() == null) {
            //throw exception
        }
    }

    public void validateUpdatePatient(Patient patient) {
        if (patient == null) {
            //throw exception
        }

        if(patient.getId() != null) {
            //throw exception
        }

        if(patient.getFirstName() == null) {
            //throw exception
        }

        if(patient.getLastName() == null) {
            //throw exception
        }

        if(patient.getSvnr() == null) {
            //throw exception
        }

        if(patient.getBirthDate() == null) {
            //throw exception
        }

        Optional<Patient> patientOptional = patientRepository.findById(patient.getId());
        if (patientOptional.isEmpty()) {
            //throw exception
        }
    }

    public boolean validateDeletePatient(Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        return patientOptional.isPresent();
    }
}
