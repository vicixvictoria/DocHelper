package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.DiseaseMapper;
import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.service.DiseaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/diseases")
public class DiseaseEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final DiseaseService diseaseService;
    private final DiseaseMapper diseaseMapper;

    @Autowired
    public DiseaseEndpoint(DiseaseService diseaseService, DiseaseMapper diseaseMapper) {
        this.diseaseService = diseaseService;
        this.diseaseMapper = diseaseMapper;
    }

    @GetMapping
    public List<DiseaseDto> getAllDiseases() {
        LOGGER.info("GET api/v1/diseases");
        return diseaseMapper.diseaseToDiseaseDto(diseaseService.getAllDiseases());
    }


    /*
    @GetMapping
    public DiseaseDto getDiseaseByName(String name) {
        return diseaseMapper.diseaseToDiseaseDto(diseaseService.getDiseaseByName(name));
    }*/


    //für nice to have
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DiseaseDto createDisease(@Valid @RequestBody DiseaseDto diseaseDto) {
        LOGGER.info("POST api/v1/diseases: {} ", diseaseDto);
        Disease disease = diseaseMapper.diseaseDtoToDisease(diseaseDto);
        disease = diseaseService.createDisease(disease);
        return diseaseMapper.diseaseToDiseaseDto(disease);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{diseaseId}")
    public void deletePatient(@PathVariable Long diseaseId) {
        diseaseService.deleteDiseaseById(diseaseId);
    }



}
