package at.ac.tuwien.dochelper.backend.service;

import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.exception.NotFoundException;
import at.ac.tuwien.dochelper.backend.repository.LabValueRepository;
import at.ac.tuwien.dochelper.backend.repository.TestResultRepository;
import at.ac.tuwien.dochelper.backend.validator.TestResultValidator;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TestResultService {
    private final TestResultRepository testResultRepository;
    private final TestResultValidator testResultValidator;
    private final LabValueRepository labValueRepository;
    private final LabValueService labValueService;

    @Autowired
    public TestResultService(TestResultRepository testResultRepository, TestResultValidator testResultValidator, LabValueRepository labValueRepository, LabValueService labValueService){
        this.testResultRepository = testResultRepository;
        this.testResultValidator = testResultValidator;
        this.labValueRepository = labValueRepository;
        this.labValueService = labValueService;
    }

    public List<TestResult> getAllTestResults (){
        return testResultRepository.findAll();
    }

    public TestResult getTestResultById(Long resultId) {
        Optional<TestResult> optional = testResultRepository.findById(resultId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("TestResult was not found");
        }
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

    @Transactional
    public List<TestResult> getByPatientId(Long patientId){
        Hibernate.initialize(labValueRepository.findAll());
        Hibernate.initialize(labValueService.getAllLabVals());
        return testResultRepository.findAllById(patientId);
    }

}
