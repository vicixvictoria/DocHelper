package at.ac.tuwien.dochelper.backend.repository;

import at.ac.tuwien.dochelper.backend.entity.TestValue_threshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestValue_thresholdRepository extends JpaRepository<TestValue_threshold, Long> {
    TestValue_threshold findTestValue_thresholdByDiseaseNameAndLabValName(String diseaseName, String labValName);
}
