package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import at.ac.tuwien.dochelper.backend.repository.TestValue_thresholdRepository;
import at.ac.tuwien.dochelper.backend.validator.TestValue_tresholdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestValue_trhesholdService {

    private final TestValue_thresholdRepository testValue_thresholdRepository;
    private final TestValue_tresholdValidator testValue_tresholdValidator;

    @Autowired
    public TestValue_trhesholdService(TestValue_thresholdRepository testValue_thresholdRepository, TestValue_tresholdValidator testValue_tresholdValidator) {
        this.testValue_thresholdRepository = testValue_thresholdRepository;
        this.testValue_tresholdValidator = testValue_tresholdValidator;
    }

    public List<TestValue_threshold> getAllThresholds() {
        return testValue_thresholdRepository.findAll();
    }


    @Transactional
    public TestValue_threshold createThreshold(TestValue_threshold testValue_threshold)
    {
        testValue_tresholdValidator.validateNewThreshold(testValue_threshold);
        return testValue_thresholdRepository.save(testValue_threshold);
    }
}

