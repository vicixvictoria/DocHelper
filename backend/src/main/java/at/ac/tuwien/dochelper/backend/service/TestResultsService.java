package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.TestResults;
import at.ac.tuwien.dochelper.backend.repository.TestResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestResultsService {
    private final TestResultsRepository testResultsRepository;

    @Autowired
    public TestResultsService(TestResultsRepository testResultsRepository){
        this.testResultsRepository = testResultsRepository;
    }

    public List<TestResults> getAllTestResults (){
        return testResultsRepository.findAll();
    }

    @Transactional
    public TestResults createTestResults(TestResults testResults){
        return testResultsRepository.save(testResults);
    }

    @Transactional
    public TestResults updateTestResults(TestResults testResults){
        return testResultsRepository.save(testResults);
    }
}
