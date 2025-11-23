package app.adapters.out.persistence.repository;

import app.adapters.out.persistence.entity.MensajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMensajeRepository extends JpaRepository<MensajeEntity, Long> {

    public Object findByPilarId(Long pilarId);
}
