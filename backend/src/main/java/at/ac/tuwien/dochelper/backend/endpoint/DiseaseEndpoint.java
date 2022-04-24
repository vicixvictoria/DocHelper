package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.DiseaseMapper;
import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/diseases")
public class DiseaseEndpoint {

    private final DiseaseService diseaseService;
    private final DiseaseMapper diseaseMapper;

    @Autowired
    public DiseaseEndpoint(DiseaseService diseaseService, DiseaseMapper diseaseMapper) {
        this.diseaseService = diseaseService;
        this.diseaseMapper = diseaseMapper;
    }

    @GetMapping
    public List<DiseaseDto> getAllDiseases() {
        return diseaseMapper.diseaseToDiseaseDto(diseaseService.getAllDiseases());
    }


    //für nice to have
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DiseaseDto createDisease(@Valid @RequestBody DiseaseDto diseaseDto) {
        Disease disease = diseaseMapper.diseaseDtoToDisease(diseaseDto);
        disease = diseaseService.createDisease(disease);
        return diseaseMapper.diseaseToDiseaseDto(disease);
    }



}
