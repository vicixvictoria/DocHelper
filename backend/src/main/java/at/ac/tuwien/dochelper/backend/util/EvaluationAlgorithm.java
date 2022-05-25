package at.ac.tuwien.dochelper.backend.util;

import at.ac.tuwien.dochelper.backend.entity.DiseaseScore;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EvaluationAlgorithm {

    public List<DiseaseScore> evaluateResult(TestResult testResult) {

        List<DiseaseScore> result = new ArrayList<>();
        result.add(new DiseaseScore(null, 2.3));
        return result;
    }
}
