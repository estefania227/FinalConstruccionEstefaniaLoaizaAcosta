package app.application.port.in;

import app.dto.CrearPosicionRequest;
import app.dto.PilarDTO;

public interface RegistrarPosicionUseCase {
    PilarDTO registrarPosicion(CrearPosicionRequest request);
}
