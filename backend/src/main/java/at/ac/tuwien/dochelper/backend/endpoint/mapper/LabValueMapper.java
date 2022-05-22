package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.LabValueDto;
import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface LabValueMapper {

    @Named("labValue")
    LabValueDto labValueToLabValueDto(LabValue labValue);

    @IterableMapping(qualifiedByName = "labValue")
    List<LabValueDto> labValueToLabValueDto(List<LabValue> labValueList);

    @Named("labValueDto")
    LabValue labValueDtoToLabValue(LabValueDto labValueDto);

    @IterableMapping(qualifiedByName = "labValueDto")
    List<LabValue> labValueDtoToLabValue(List<LabValueDto> labValueDtoList);
}
