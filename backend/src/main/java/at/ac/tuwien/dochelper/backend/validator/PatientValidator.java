package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientValidator {

    public PatientValidator() {
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
}
