package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseScoreDto;
import at.ac.tuwien.dochelper.backend.endpoint.dto.TestResultDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.DiseaseScoreMapper;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.TestResultsMapper;
import at.ac.tuwien.dochelper.backend.entity.DiseaseScore;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.service.ResultEvaluationService;
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
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/evaluation")
public class ResultEvaluationEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ResultEvaluationService resultEvaluationService;
    private final DiseaseScoreMapper diseaseScoreMapper;
    private final TestResultsMapper testResultsMapper;

    @Autowired
    public ResultEvaluationEndpoint(ResultEvaluationService resultEvaluationService, TestResultsMapper testResultsMapper, DiseaseScoreMapper diseaseScoreMapper) {
        this.resultEvaluationService = resultEvaluationService;
        this.testResultsMapper = testResultsMapper;
        this.diseaseScoreMapper = diseaseScoreMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public List<DiseaseScoreDto> evaluateTestResult(@Valid @RequestBody TestResultDto testResultDto) {
        LOGGER.info("EVALUATE api/v1/evaluation: {} ", testResultDto);
        TestResult testResult = testResultsMapper.testResultDtoToTestResult(testResultDto);
        List<DiseaseScore> diseaseScoreList = resultEvaluationService.evaluateTestResult(testResult);
        return diseaseScoreMapper.diseaseScoreToDiseaseScoreDto(diseaseScoreList);
    }

}
