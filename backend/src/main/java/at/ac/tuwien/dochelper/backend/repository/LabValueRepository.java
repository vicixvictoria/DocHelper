package at.ac.tuwien.dochelper.backend.repository;

import at.ac.tuwien.dochelper.backend.entity.LabValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabValueRepository extends JpaRepository<LabValue, Long> {
    //List<LabValue> findAllByName(String labValueName);
}
