package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.repository.TestResultRepository;
import at.ac.tuwien.dochelper.backend.validator.TestResultValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestResultService {
    private final TestResultRepository testResultRepository;
    private final TestResultValidator testResultValidator;

    @Autowired
    public TestResultService(TestResultRepository testResultRepository, TestResultValidator testResultValidator){
        this.testResultRepository = testResultRepository;
        this.testResultValidator = testResultValidator;
    }

    public List<TestResult> getAllTestResults (){
        return testResultRepository.findAll();
    }

    @Transactional
    public TestResult createTestResult(TestResult testResult){
        testResultValidator.validateNewTestResult(testResult);
        return testResultRepository.save(testResult);
    }

    @Transactional
    public TestResult updateTestResult(TestResult testResult){
        testResultValidator.validateNewTestResult(testResult);
        return testResultRepository.save(testResult);
    }

    public void deleteTestResult(Long resultId) {
        testResultRepository.deleteById(resultId);}

    public List<TestResult> getByPatientId(Long patientId){
        return testResultRepository.findAllById(patientId);
    }
}
