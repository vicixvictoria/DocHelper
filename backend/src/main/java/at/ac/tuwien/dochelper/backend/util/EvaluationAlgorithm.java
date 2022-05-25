package at.ac.tuwien.dochelper.backend.util;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.DiseaseScore;
import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import at.ac.tuwien.dochelper.backend.entity.LabValue;
import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import at.ac.tuwien.dochelper.backend.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EvaluationAlgorithm {

    public List<DiseaseScore> evaluateResult(TestResult testResult, List<LabValue> labValueList, List<Disease> diseaseList, List<TestValueThreshold> testValueThresholdList) {

        List<DiseaseScore> result = new ArrayList<>();
        for (Disease disease : diseaseList) {
            result.add(new DiseaseScore(disease, null));
        }

        for (Disease disease : diseaseList) {

            List<TestValueThreshold> potentialThresholds = testValueThresholdList.stream()
                    .filter(th -> th.getDiseaseName().equals(disease.getDiseaseName())).collect(Collectors.toList());

            for (LabMeasure labMeasure: testResult.getLabMeasures()) {

                List<TestValueThreshold> testValueThreshold = potentialThresholds.stream()
                        .filter(th -> th.getLabVal().equals(labMeasure.getLabValue())).collect(Collectors.toList());

                if (testValueThreshold.size() != 1) {
                 throw new ValidationException("For disease: " + disease.getDiseaseName() + "and lab value: " + labMeasure.getLabValue().getLabValName()
                         + "more than one threshold exists");
                }

                //further evaluation
            }
        }


        return result;
    }
}
