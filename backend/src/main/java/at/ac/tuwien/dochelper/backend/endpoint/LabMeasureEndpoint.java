package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.LabMeasureDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.LabMeasureMapper;
import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.service.LabMeasureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path = "api/v1/measures")
public class LabMeasureEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final LabMeasureService labMeasureService;
    private final LabMeasureMapper labMeasureMapper;

    @Autowired
    public LabMeasureEndpoint(LabMeasureService labMeasureService, LabMeasureMapper labMeasureMapper) {
        this.labMeasureService = labMeasureService;
        this.labMeasureMapper = labMeasureMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LabMeasureDto createLabMeasure(@Valid @RequestBody LabMeasureDto labMeasureDto) {
        LOGGER.info("POST /api/v1/measures: {} ", labMeasureDto.toString());
        LabMeasure labMeasure = labMeasureMapper.labMeasureDtoToLabMeasure(labMeasureDto);
        labMeasure = labMeasureService.createLabMeasure(labMeasure);
        return labMeasureMapper.labMeasureToLabMeasureDto(labMeasure);
    }
}
