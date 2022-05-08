package at.ac.tuwien.dochelper.backend.validator;

import at.ac.tuwien.dochelper.backend.entity.TestResult;
import at.ac.tuwien.dochelper.backend.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import java.time.LocalDate;


@Component
public class TestResultValidator {

    private final TestResultRepository testResultRepository;


    @Autowired
    public TestResultValidator(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    public void validateNewTestResult (TestResult testResult){
        if(testResult==null|| testResult.getId()==0){
            throw new ValidationException("TestResult must not be empty.");
            //exception
        }
        if (testResult.getId()==null){
            throw new ValidationException("ResultId must not be null.");
            //exception
        }
        if (testResult.getDate() == null){
            throw new ValidationException("Date must not be null.");
            //exception
        }
        if (testResult.getDate().isAfter(LocalDate.now())){
            throw new ValidationException("Date is in the future.");
            //exception
        }
        if(testResult.getPatientId() == null) {
            throw new ValidationException("Patient id must not be null.");
            //exception
        }

    }

}
