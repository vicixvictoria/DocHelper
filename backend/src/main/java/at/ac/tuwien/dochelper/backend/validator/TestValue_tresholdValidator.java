package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import at.ac.tuwien.dochelper.backend.repository.TestValueThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestValue_tresholdValidator {

    private final TestValueThresholdRepository testValue_thresholdRepository;

    @Autowired
    public TestValue_tresholdValidator(TestValueThresholdRepository testValue_thresholdRepository) {
        this.testValue_thresholdRepository = testValue_thresholdRepository;
    }

    public void validateNewThreshold(TestValueThreshold testValue_threshold) {
        if (testValue_threshold == null) {
            //throw exception
        }
    }
}
