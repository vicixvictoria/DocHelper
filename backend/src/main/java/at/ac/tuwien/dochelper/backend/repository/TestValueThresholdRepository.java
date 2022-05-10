package at.ac.tuwien.dochelper.backend.repository;

import at.ac.tuwien.dochelper.backend.entity.TestValueThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestValueThresholdRepository extends JpaRepository<TestValueThreshold, Long> {
    TestValueThreshold findTestValue_thresholdByDiseaseNameAndLabValName(String diseaseName, String labValName);
}
