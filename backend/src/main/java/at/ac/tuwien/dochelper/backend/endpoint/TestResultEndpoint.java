package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.TestResultDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.TestResultsMapper;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.service.TestResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/results")
public class TestResultEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final TestResultService testResultService;
    private final TestResultsMapper testResultsMapper;

    @Autowired
    public TestResultEndpoint(TestResultService testResultService, TestResultsMapper testResultsMapper) {
        this.testResultService = testResultService;
        this.testResultsMapper = testResultsMapper;
    }

    @GetMapping
    public List<TestResultDto> getAllTestResults(){
        LOGGER.info("GET /api/v1/results");
        return testResultsMapper.testResultsToTestResultsDto(testResultService.getAllTestResults());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TestResultDto createTestResult(@Valid @RequestBody TestResultDto testResultDto) {
        LOGGER.info("POST /api/v1/results {} ", testResultDto);

        TestResult testResult = testResultsMapper.testResultDtoToTestResult(testResultDto);
        testResult = testResultService.createTestResult(testResult);
        return testResultsMapper.testResultToTestResultDto(testResult);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public TestResultDto updateTestResult(@Valid @RequestBody TestResultDto testResultDto) {
        LOGGER.info("PUT /api/v1/entries: {} ", testResultDto);

        TestResult testResult = testResultsMapper.testResultDtoToTestResult(testResultDto);
        testResult = testResultService.updateTestResult(testResult);
        return testResultsMapper.testResultToTestResultDto(testResult);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{resultId}")
    public void deleteTestResult(@PathVariable Long resultId) {
        LOGGER.info("DELETE /api/v1/results/{} ", resultId);
        testResultService.deleteTestResult(resultId);
    }


    @GetMapping("/{resultId}")
    public TestResultDto getTestResultById(@PathVariable Long resultId){
        LOGGER.info("GET /api/v1/results/{}", resultId);
        return testResultsMapper.testResultToTestResultDto(testResultService.getTestResultById(resultId));
    }

    @GetMapping("/patients/{patientId}")
    public List<TestResultDto> getTestResultsByPatientId(@PathVariable Long patientId){
      LOGGER.info("GET /api/v1/results/patients/{}", patientId);
      return testResultsMapper.testResultsToTestResultsDto(testResultService.getByPatientId(patientId));
    }


}
