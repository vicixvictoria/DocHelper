package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.TestValueThresholdDto;
import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface TestValueThresholdMapper {

    @Named("testvalueThreshold")
    TestValueThresholdDto testvalue_thresholdTotestvalue_thresholdDto(TestValueThreshold testValue_threshold);

    @IterableMapping(qualifiedByName = "testvalueThreshold")
    List<TestValueThresholdDto> testvalue_thresholdTotestvalue_thresholdDto(List<TestValueThreshold> testValue_thresholdList);

    @Named("testvalueThresholdDto")
    TestValueThreshold testvalue_thresholdDtoTotestvalue_threshold(TestValueThresholdDto testValue_thresholdDto);

    @IterableMapping(qualifiedByName = "testvalueThresholdDto")
    List<TestValueThreshold> testvalue_thresholdDtoTotestvalue_threshold(List<TestValueThresholdDto> testValue_thresholdDtoList);
}
