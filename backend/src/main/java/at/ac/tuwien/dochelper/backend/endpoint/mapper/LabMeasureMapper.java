package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.LabMeasureDto;
import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface LabMeasureMapper {

    @Named("labMeasure")
    LabMeasureDto labMeasureToLabMeasureDto(LabMeasure labMeasure);

    @IterableMapping(qualifiedByName = "labMeasure")
    List<LabMeasureDto> labMeasureToLabMeasureDto (List<LabMeasure> labMeasureList);

    @Named("labMeasureDto")
    LabMeasure labMeasureDtoToLabMeasure(LabMeasureDto labMeasureDto);

    @IterableMapping(qualifiedByName = "labMeasureDto")
    List<LabMeasure> labMeasureDtoToLabMeasure(List<LabMeasureDto> labMeasureDtoList);

}
