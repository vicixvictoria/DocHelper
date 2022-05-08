package at.ac.tuwien.dochelper.backend.repository;

import at.ac.tuwien.dochelper.backend.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    List<Disease> findAllByIcdCode(String icdCode);
    Disease findDiseaseByDiseaseName(String name);

}
