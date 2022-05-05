package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestResultService {
    private final TestResultRepository testResultRepository;

    @Autowired
    public TestResultService(TestResultRepository testResultRepository){
        this.testResultRepository = testResultRepository;
    }

    public List<TestResult> getAllTestResults (){
        return testResultRepository.findAll();
    }

    @Transactional
    public TestResult createTestResult(TestResult testResult){
        return testResultRepository.save(testResult);
    }

    @Transactional
    public TestResult updateTestResult(TestResult testResult){
        return testResultRepository.save(testResult);
    }

    public void deleteTestResult(Long resultId) {testResultRepository.deleteById(resultId);}
}
