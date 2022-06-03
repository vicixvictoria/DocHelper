package at.ac.tuwien.dochelper.backend.endpoint.mapper;

import at.ac.tuwien.dochelper.backend.endpoint.dto.DiseaseScoreDto;
import at.ac.tuwien.dochelper.backend.entity.DiseaseScore;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface DiseaseScoreMapper {

    @Named("diseaseScore")
    DiseaseScoreDto diseaseScoreToDiseaseScoreDto(DiseaseScore diseaseScore);

    @IterableMapping(qualifiedByName = "diseaseScore")
    List<DiseaseScoreDto> diseaseScoreToDiseaseScoreDto(List<DiseaseScore> diseaseScoreList);

}
