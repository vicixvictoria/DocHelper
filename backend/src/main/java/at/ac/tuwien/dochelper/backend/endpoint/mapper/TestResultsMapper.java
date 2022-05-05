package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.TestResultDto;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface TestResultsMapper {

    @Named("testResults")
    TestResultDto testResultToTestResultDto(TestResult testResult);

    @IterableMapping(qualifiedByName = "testResults")
    List<TestResultDto> testResultsToTestResultsDto (List<TestResult> testResultList);

    @Named("testResultsDto")
    TestResult testResultDtoToTestResult (TestResultDto testResultDto);

    @IterableMapping(qualifiedByName = "testResultsDto")
    List<TestResult> testResultsDtoToTestResults (List<TestResultDto> testResultDtoList);

}
