package at.ac.tuwien.dochelper.backend.endpoint;

import at.ac.tuwien.dochelper.backend.endpoint.dto.LabValueDto;
import at.ac.tuwien.dochelper.backend.endpoint.mapper.LabValueMapper;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.service.LabValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/labValues")
public class LabValueEndpoint {

    private final LabValueService labValueService;
    private final LabValueMapper labValueMapper;

    @Autowired
    public LabValueEndpoint(LabValueService labValueService, LabValueMapper labValueMapper) {
        this.labValueService = labValueService;
        this.labValueMapper = labValueMapper;
    }

   /* @GetMapping
    public List<LabValueDto> getAllLabVals() {
        return labValueMapper.labValueToLabValueDto(labValueService.getAllLabVals());
    }*/

    @GetMapping
    public LabValueDto getByName(String name){
        return labValueMapper.labValueToLabValueDto(labValueService.getByName(name));
    }


}
