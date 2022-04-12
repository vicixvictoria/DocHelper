package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.PatientDto;
import at.ac.tuwien.dochelper.backend.entity.Patient;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface PatientMapper {

    @Named("patient")
    PatientDto patientToPatientDto(Patient patient);

    @IterableMapping(qualifiedByName = "patient")
    List<PatientDto> patientToPatientDto(List<Patient> patientList);

    @Named("patientDto")
    Patient patientDtoToPatient(PatientDto patientDto);

    @IterableMapping(qualifiedByName = "patientDto")
    List<Patient> patientDtoToPatient(List<PatientDto> patientDtoList);
}
