package app.application.port.in;

import app.dto.MensajeResponse;

public interface ReconstruirMensajeUseCase {
    MensajeResponse reconstruir(Long id, String contenidoReconstruido);
}
