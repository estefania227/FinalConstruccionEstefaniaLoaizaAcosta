package app.application.port.in;

import app.dto.MensajeRequest;
import app.dto.MensajeResponse;

public interface RegistrarMensajeUseCase {
    MensajeResponse registrarMensaje(MensajeRequest request);
}
