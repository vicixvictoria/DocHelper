package at.ac.tuwien.dochelper.backend.endpoint;


import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseDto;
import at.ac.tuwien.dochelper.backend.endpoint.dto.TestValue_tresholdDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.DiseaseMapper;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.TestValue_thresholdMapper;
import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import at.ac.tuwien.dochelper.backend.service.DiseaseService;
import at.ac.tuwien.dochelper.backend.service.TestValue_trhesholdService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/thresholds")
public class TestValue_thresholdEndpoint {

    private final TestValue_trhesholdService testValue_trhesholdService;
    private final TestValue_thresholdMapper testValue_thresholdMapper;

    public TestValue_thresholdEndpoint(TestValue_trhesholdService testValue_trhesholdService, TestValue_thresholdMapper testValue_thresholdMapper) {
        this.testValue_trhesholdService = testValue_trhesholdService;
        this.testValue_thresholdMapper = testValue_thresholdMapper;
    }


    @GetMapping
    public List<TestValue_tresholdDto> getAllThresholds() {
        return testValue_thresholdMapper.testvalue_thresholdTotestvalue_thresholdDto(testValue_trhesholdService.getAllThresholds());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TestValue_tresholdDto createThreshold(@Valid @RequestBody TestValue_tresholdDto testValue_tresholdDto) {
        TestValue_threshold testValue_threshold = testValue_thresholdMapper.testvalue_thresholdDtoTotestvalue_threshold(testValue_tresholdDto);
        testValue_threshold = testValue_trhesholdService.createThreshold(testValue_threshold);
        return testValue_thresholdMapper.testvalue_thresholdTotestvalue_thresholdDto(testValue_threshold);
    }

}
