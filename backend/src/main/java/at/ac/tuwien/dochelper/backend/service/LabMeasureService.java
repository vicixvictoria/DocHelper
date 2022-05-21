package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.repository.LabMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LabMeasureService {

    private final LabMeasureRepository labMeasureRepository;

        @Autowired
        public LabMeasureService(LabMeasureRepository labMeasureRepository) {
            this.labMeasureRepository = labMeasureRepository;
        }

        @Transactional
        public LabMeasure createLabMeasure(LabMeasure labMeasure)
        {
            return labMeasureRepository.save(labMeasure);
        }


}
