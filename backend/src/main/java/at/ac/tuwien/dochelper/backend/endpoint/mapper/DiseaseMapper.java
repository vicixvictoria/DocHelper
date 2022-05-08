package at.ac.tuwien.dochelper.backend.endpoint.mapper;
import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseDto;
import at.ac.tuwien.dochelper.backend.entity.Disease;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface DiseaseMapper {

    @Named("disease")
    DiseaseDto diseaseToDiseaseDto(Disease disease);

    @IterableMapping(qualifiedByName = "disease")
    List<DiseaseDto> diseaseToDiseaseDto(List<Disease> diseaseList);

    @Named("diseaseDto")
    Disease diseaseDtoToDisease(DiseaseDto diseaseDto);

    @IterableMapping(qualifiedByName = "diseaseDto")
    List<Disease> diseaseDtoToDisease(List<DiseaseDto> diseaseDtoList);
}

