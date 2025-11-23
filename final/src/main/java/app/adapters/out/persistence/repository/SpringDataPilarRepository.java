package app.adapters.out.persistence.repository;

import app.adapters.out.persistence.entity.PilarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPilarRepository extends JpaRepository<PilarEntity, Long> {}
