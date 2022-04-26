package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.TestResultsDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.TestResultsMapper;
import at.ac.tuwien.dochelper.backend.service.TestResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api") //was gehört da hin?
public class TestResultsEndpoint {
    private final TestResultsService testResultsService;
    private final TestResultsMapper testResultsMapper;

    @Autowired
    public TestResultsEndpoint(TestResultsService testResultsService,TestResultsMapper testResultsMapper) {
        this.testResultsService = testResultsService;
        this.testResultsMapper = testResultsMapper;
    }

    @GetMapping
    public List<TestResultsDto> getAllTestResults(){
        return testResultsMapper.testResultsToTestResultsDto(testResultsService.getAllTestResults());
    }
}
