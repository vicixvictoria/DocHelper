package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.DiseaseScore;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import at.ac.tuwien.dochelper.backend.exception.ValidationException;
import at.ac.tuwien.dochelper.backend.repository.DiseaseRepository;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import at.ac.tuwien.dochelper.backend.repository.TestValueThresholdRepository;
import at.ac.tuwien.dochelper.backend.util.EvaluationAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultEvaluationService {

    private final EvaluationAlgorithm evaluationAlgorithm;
    private final DiseaseRepository diseaseRepository;

    @Autowired
    public ResultEvaluationService(EvaluationAlgorithm evaluationAlgorithm, DiseaseRepository diseaseRepository) {
        this.evaluationAlgorithm = evaluationAlgorithm;
        this.diseaseRepository = diseaseRepository;
    }




    public List<DiseaseScore> evaluateTestResult(TestResult testResult) {
        if (testResult.getLabMeasures() == null) {
            throw new ValidationException("test result must contain measures to be analyzed");
        }
        List<Disease> diseaseList = diseaseRepository.findAll();

        return evaluationAlgorithm.evaluateResult(testResult, diseaseList);
    }

}
