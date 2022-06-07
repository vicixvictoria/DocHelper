package at.ac.tuwien.dochelper.backend.endpoint;


import at.ac.tuwien.dochelper.backend.endpoint.dto.TestValueThresholdDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.TestValueThresholdMapper;
import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import at.ac.tuwien.dochelper.backend.service.TestValueThresholdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/thresholds")
public class TestValueThresholdEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final TestValueThresholdService testValue_thresholdService;
    private final TestValueThresholdMapper testValue_thresholdMapper;

    public TestValueThresholdEndpoint(TestValueThresholdService testValue_thresholdService, TestValueThresholdMapper testValue_thresholdMapper) {
        this.testValue_thresholdService = testValue_thresholdService;
        this.testValue_thresholdMapper = testValue_thresholdMapper;
    }


    @GetMapping
    public List<TestValueThresholdDto> getAllThresholds() {
        return testValue_thresholdMapper.testvalue_thresholdTotestvalue_thresholdDto(testValue_thresholdService.getAllThresholds());
    }

   /* @GetMapping
    public List<TestValueThresholdDto> getThresholdsByDiseaseId(long id) {
        return testValue_thresholdMapper.testvalue_thresholdTotestvalue_thresholdDto(testValue_thresholdService.getAllThresholds());
    }*/

    /*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TestValueThresholdDto createThreshold(@Valid @RequestBody TestValueThresholdDto testValue_thresholdDto) {
        TestValueThreshold testValue_threshold = testValue_thresholdMapper.testvalue_thresholdDtoTotestvalue_threshold(testValue_thresholdDto);
        testValue_threshold = testValue_thresholdService.createThreshold(testValue_threshold);
        return testValue_thresholdMapper.testvalue_thresholdTotestvalue_thresholdDto(testValue_threshold);
    }
     */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public List<TestValueThresholdDto> createThresholds(@Valid @RequestBody List<TestValueThresholdDto> testValue_thresholdDtoList) {
        LOGGER.info("POST api/v1/thresholds: {} ", testValue_thresholdDtoList);
        List<TestValueThreshold> testValue_thresholdList = testValue_thresholdMapper.testvalue_thresholdDtoTotestvalue_threshold(testValue_thresholdDtoList);
        testValue_thresholdList = testValue_thresholdService.createThresholds(testValue_thresholdList);
        return testValue_thresholdMapper.testvalue_thresholdTotestvalue_thresholdDto(testValue_thresholdList);
    }

}
