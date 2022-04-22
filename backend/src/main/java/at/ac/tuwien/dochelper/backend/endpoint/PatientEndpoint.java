package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.PatientDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.PatientMapper;
import at.ac.tuwien.dochelper.backend.service.PatientService;
import at.ac.tuwien.dochelper.backend.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/patients")
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
    public PatientDto createPatient(@Valid @RequestBody PatientDto patientDto) {
        Patient patient = patientMapper.patientDtoToPatient(patientDto);
        patient = patientService.createPatient(patient);
        return patientMapper.patientToPatientDto(patient);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{patientId}")
    public PatientDto updatePatient(@Valid @RequestBody PatientDto patientDto, @PathVariable Long patientId) {
        if(!patientId.equals(patientDto.getId())) {
            //throw exception
        }
        Patient patient = patientMapper.patientDtoToPatient(patientDto);
        patient = patientService.updatePatient(patient);
        return patientMapper.patientToPatientDto(patient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
    }


}
