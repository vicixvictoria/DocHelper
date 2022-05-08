package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.Patient;
import at.ac.tuwien.dochelper.backend.exception.NotFoundException;
import at.ac.tuwien.dochelper.backend.exception.ValidationException;
import at.ac.tuwien.dochelper.backend.repository.PatientRepository;
import at.ac.tuwien.dochelper.backend.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
            throw new ValidationException("Patient must not be null.");
        }

        if(patient.getFirstName() == null) {
            throw new ValidationException("Patient must have a first name.");
        }

        if(patient.getLastName() == null) {
            throw new ValidationException("Patient must have a last name.");
        }

        if(patient.getSvnr() == null) {
            throw new ValidationException("Patient must have a social insurance number.");
        }

        if(patient.getBirthDate() == null) {
            throw new ValidationException("Patient must have a birth date.");
        }

        if(!patient.getBirthDate().isBefore(LocalDate.now())) {
            throw new ValidationException("Patient birth date must be in the past.");
        }

        if(patient.getSex() == null) {
            throw new ValidationException("Patient must have a gender.");
        }

        if(patient.getSex().equals(Sex.MALE) && patient.isPregnant()) {
            throw new ValidationException("Male patient must not be pregnant.");
        }
    }

    public void validateUpdatePatient(Patient patient) {
       validateNewPatient(patient);

        Optional<Patient> patientOptional = patientRepository.findById(patient.getId());
        if (patientOptional.isEmpty()) {
            throw new NotFoundException("Patient to update cannot be found.");
        }
    }

    public boolean validateDeletePatient(Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        return patientOptional.isPresent();
    }
}
