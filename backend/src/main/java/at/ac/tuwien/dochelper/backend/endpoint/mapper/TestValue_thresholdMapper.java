package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseDto;
import at.ac.tuwien.dochelper.backend.endpoint.dto.TestValue_tresholdDto;
import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface TestValue_thresholdMapper {

    @Named("testvalue_threshold")
    TestValue_tresholdDto testvalue_thresholdTotestvalue_thresholdDto(TestValue_threshold testValue_threshold);

    @IterableMapping(qualifiedByName = "testvalue_threshold")
    List<TestValue_tresholdDto> testvalue_thresholdTotestvalue_thresholdDto(List<TestValue_threshold> testValue_thresholdList);

    @Named("testvalue_thresholdDto")
    TestValue_threshold testvalue_thresholdDtoTotestvalue_threshold(TestValue_tresholdDto testValue_tresholdDto);

    @IterableMapping(qualifiedByName = "testvalue_thresholdDto")
    List<TestValue_threshold> testvalue_thresholdDtoTotestvalue_threshold(List<TestValue_tresholdDto> testValue_tresholdDtoList);
}
