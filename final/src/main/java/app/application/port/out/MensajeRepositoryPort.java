package app.application.port.out;

import app.domain.model.Mensaje;
import java.util.Optional;

public interface MensajeRepositoryPort {
    Mensaje save(Mensaje mensaje);
    Optional<Mensaje> findById(Long id);
}
