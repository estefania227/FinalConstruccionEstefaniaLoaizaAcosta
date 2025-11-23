package app.application.port.in;

import app.dto.PilarDTO;

public interface ConsultarPilarUseCase {
    PilarDTO consultarPilar(Long id);
}
