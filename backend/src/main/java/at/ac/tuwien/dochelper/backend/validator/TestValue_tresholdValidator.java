package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import at.ac.tuwien.dochelper.backend.repository.TestValue_thresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestValue_tresholdValidator {

    private final TestValue_thresholdRepository testValue_thresholdRepository;

    @Autowired
    public TestValue_tresholdValidator(TestValue_thresholdRepository testValue_thresholdRepository) {
        this.testValue_thresholdRepository = testValue_thresholdRepository;
    }

    public void validateNewThreshold(TestValue_threshold testValue_threshold) {
        if (testValue_threshold == null) {
            //throw exception
        }
    }
}
