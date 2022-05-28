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

    public List<DiseaseScore> evaluateResult(TestResult testResult, List<Disease> diseaseList) {

        // for every disease a pair of disease and score is created
        List<DiseaseScore> result = new ArrayList<>();
        for (Disease disease : diseaseList) {
            result.add(new DiseaseScore(disease, 0.0));
        }

        // iterate through every possible disease
        for (DiseaseScore diseaseScore: result) {

            // filter the thresholds for the specific disease
            List<TestValueThreshold> potentialThresholds = diseaseScore.getDisease().getThreshold_DiseaseValues();


            // for a specific disease look at every lab measure
            for (LabMeasure labMeasure: testResult.getLabMeasures()) {

                // get the threshold for the specific disease and lab value
                List<TestValueThreshold> testValueThreshold = potentialThresholds.stream()
                        .filter(th -> th.getLabValName().equals(labMeasure.getLabValue().getLabValName())).toList();


                if (testValueThreshold.size() > 1) {
                    throw new ValidationException("For disease: \"" + diseaseScore.getDisease().getDiseaseName() + "\" and lab value: \"" + labMeasure.getLabValue().getLabValName()
                            + "\" more than one threshold exists");
                }

                if (testValueThreshold.size() == 1) {



                    TestValueThreshold testValueThreshold1 = testValueThreshold.get(0);

                    // ----------------------------------------
                    //evaluation

                    // if refValue is overwritten
                    if (testValueThreshold1.getRefVal_overwrite() != 0) {

                        // elevated
                        if (testValueThreshold1.getType() == Type.ELEVATED) {
                            if (labMeasure.getMeasuredValue() > testValueThreshold1.getRefVal_overwrite()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // decreased
                        if (testValueThreshold1.getType() == Type.DECREASED) {
                            if (labMeasure.getMeasuredValue() < testValueThreshold1.getRefVal_overwrite()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // not 0
                        if (testValueThreshold1.getType() == Type.NOTZERO) {
                            if (labMeasure.getMeasuredValue() != 0) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // not elevated
                        if (testValueThreshold1.getType() == Type.NOTELEVATED) {
                            if (!(labMeasure.getMeasuredValue() > testValueThreshold1.getRefVal_overwrite())) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // not decreased
                        if (testValueThreshold1.getType() == Type.NOTDECREASED) {
                            if (!(labMeasure.getMeasuredValue() < testValueThreshold1.getRefVal_overwrite())) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // normal
                        if (testValueThreshold1.getType() == Type.NORMAL) {
                            throw new ValidationException("Wups, dachte den Fall gibts nicht");
                        }

                    }

                    // if refValue is not overwritten

                    if (testValueThreshold1.getRefVal_overwrite() == 0) {

                        // positive
                        if (testValueThreshold1.getType() == Type.POSITIVE) {
                            if (labMeasure.getMeasuredValue() == Float.MAX_VALUE) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // negative
                        if (testValueThreshold1.getType() == Type.NEGATIVE) {
                            if (labMeasure.getMeasuredValue() == Float.MIN_VALUE) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // elevated
                        if (testValueThreshold1.getType() == Type.ELEVATED) {
                            if (labMeasure.getRefValueBigger() != null &&
                                    labMeasure.getMeasuredValue() > labMeasure.getRefValueBigger()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueLower() != null &&
                                    labMeasure.getMeasuredValue() >= labMeasure.getRefValueLower()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueFrom() != null &&
                                    labMeasure.getRefValueTo() != null &&
                                    labMeasure.getMeasuredValue() > labMeasure.getRefValueTo()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // decreased
                        if (testValueThreshold1.getType() == Type.DECREASED) {
                            if (labMeasure.getRefValueBigger() != null &&
                                    labMeasure.getMeasuredValue() <= labMeasure.getRefValueBigger()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueLower() != null &&
                                    labMeasure.getMeasuredValue() < labMeasure.getRefValueLower()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueFrom() != null &&
                                    labMeasure.getRefValueTo() != null &&
                                    labMeasure.getMeasuredValue() < labMeasure.getRefValueFrom()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // normal
                        if (testValueThreshold1.getType() == Type.NORMAL) {
                            if (labMeasure.getRefValueBigger() != null &&
                                    labMeasure.getMeasuredValue() > labMeasure.getRefValueBigger()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueLower() != null &&
                                    labMeasure.getMeasuredValue() < labMeasure.getRefValueLower()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueFrom() != null &&
                                    labMeasure.getRefValueTo() != null &&
                                    labMeasure.getMeasuredValue() <= labMeasure.getRefValueTo() &&
                                    labMeasure.getMeasuredValue() >= labMeasure.getRefValueFrom()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // not zero
                        if (testValueThreshold1.getType() == Type.NOTZERO) {
                            if (labMeasure.getMeasuredValue() != 0) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // not elevated
                        if (testValueThreshold1.getType() == Type.NOTELEVATED) {
                            if (labMeasure.getRefValueBigger() != null &&
                                    labMeasure.getMeasuredValue() <= labMeasure.getRefValueBigger()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueLower() != null &&
                                    labMeasure.getMeasuredValue() <= labMeasure.getRefValueLower()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueFrom() != null &&
                                    labMeasure.getRefValueTo() != null &&
                                    labMeasure.getMeasuredValue() <= labMeasure.getRefValueTo()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                        // not decreased
                        if (testValueThreshold1.getType() == Type.NOTDECREASED) {
                            if (labMeasure.getRefValueBigger() != null &&
                                    labMeasure.getMeasuredValue() >= labMeasure.getRefValueBigger()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueLower() != null &&
                                    labMeasure.getMeasuredValue() >= labMeasure.getRefValueLower()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }

                            if (labMeasure.getRefValueFrom() != null &&
                                    labMeasure.getRefValueTo() != null &&
                                    labMeasure.getMeasuredValue() >= labMeasure.getRefValueFrom()) {
                                diseaseScore.addScore((double) testValueThreshold1.getWeightValue());
                            }
                        }

                    }


                }



            }
        }

        // removes Disease Score if score is under disease specific threshold
        return result.stream().filter(r -> r.getScore() > r.getDisease().getThreshold()).toList();
    }
}
