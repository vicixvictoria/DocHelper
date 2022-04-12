package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.PatientDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.PatientMapper;
import at.ac.tuwien.dochelper.backend.service.PatientService;
import at.ac.tuwien.dochelper.backend.entity.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientEndpoint {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientEndpoint(PatientService patientService, PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDto> getPatients() {
        return patientMapper.patientToPatientDto(patientService.getPatients());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PatientDto createPatient(@RequestBody PatientDto patientDto) {
        Patient patient = patientMapper.patientDtoToPatient(patientDto);
        patient = patientService.createPatient(patient);
        return patientMapper.patientToPatientDto(patient);
    }



}
