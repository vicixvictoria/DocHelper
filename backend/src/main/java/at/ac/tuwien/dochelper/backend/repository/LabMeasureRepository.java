package at.ac.tuwien.dochelper.backend.repository;

import at.ac.tuwien.dochelper.backend.entity.LabMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabMeasureRepository extends JpaRepository<LabMeasure, Long> {
}
