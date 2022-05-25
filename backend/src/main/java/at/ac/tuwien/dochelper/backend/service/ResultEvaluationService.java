package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.DiseaseScore;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.exception.ValidationException;
import at.ac.tuwien.dochelper.backend.util.EvaluationAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultEvaluationService {

    private final EvaluationAlgorithm evaluationAlgorithm;

    @Autowired
    public ResultEvaluationService(EvaluationAlgorithm evaluationAlgorithm) {
        this.evaluationAlgorithm = evaluationAlgorithm;
    }

    public List<DiseaseScore> evaluateTestResult(TestResult testResult) {
        if (testResult.getLabMeasures() == null) {
            throw new ValidationException("test result must contain measures to be analyzed");
        }
        return evaluationAlgorithm.evaluateResult(testResult);
    }

}
