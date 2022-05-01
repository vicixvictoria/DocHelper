package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.TestResultsDto;
import at.ac.tuwien.dochelper.backend.entity.TestResults;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface TestResultsMapper {

    @Named("testResults")
    TestResultsDto testResultsToTestResultsDto(TestResults testResults);

    @IterableMapping(qualifiedByName = "testResults")
    List<TestResultsDto> testResultsToTestResultsDto (List<TestResults> testResultsList);

    @Named("testResultsDto")
    TestResults testResultsDtoToTestResults (TestResultsDto testResultsDto);

    @IterableMapping(qualifiedByName = "testResultsDto")
    List<TestResults> testResultsDtoToTestResults (List<TestResultsDto> testResultsDtoList);

}
