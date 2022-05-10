package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import at.ac.tuwien.dochelper.backend.repository.TestValueThresholdRepository;
import at.ac.tuwien.dochelper.backend.validator.TestValue_tresholdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestValueThresholdService {

    private final TestValueThresholdRepository testValue_thresholdRepository;
    private final TestValue_tresholdValidator testValue_tresholdValidator;

    @Autowired
    public TestValueThresholdService(TestValueThresholdRepository testValue_thresholdRepository, TestValue_tresholdValidator testValue_tresholdValidator) {
        this.testValue_thresholdRepository = testValue_thresholdRepository;
        this.testValue_tresholdValidator = testValue_tresholdValidator;
    }

    public List<TestValueThreshold> getAllThresholds() {
        return testValue_thresholdRepository.findAll();
    }


    @Transactional
    public TestValueThreshold createThreshold(TestValueThreshold testValue_threshold)
    {
        testValue_tresholdValidator.validateNewThreshold(testValue_threshold);
        return testValue_thresholdRepository.save(testValue_threshold);
    }
}

