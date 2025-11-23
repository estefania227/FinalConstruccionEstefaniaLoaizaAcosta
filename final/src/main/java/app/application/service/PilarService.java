package app.application.service;

import app.application.port.in.ConsultarPilarUseCase;
import app.application.port.in.RegistrarPosicionUseCase;
import app.application.port.out.PilarRepositoryPort;
import app.domain.model.Pilar;
import app.dto.CrearPosicionRequest;
import app.dto.PilarDTO;
import app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PilarService implements ConsultarPilarUseCase, RegistrarPosicionUseCase {

    private final PilarRepositoryPort repo;

    public PilarService(PilarRepositoryPort repo) { this.repo = repo; }

    @Override
    public PilarDTO consultarPilar(Long id) {
        Pilar p = repo.findById(id).orElseThrow(() -> new NotFoundException("Pilar no encontrado"));
        return new PilarDTO(p.getId(), p.getNombre(), p.getPosX(), p.getPosY(), p.getEstado());
    }

    @Override
    public PilarDTO registrarPosicion(CrearPosicionRequest request) {
        Pilar p = repo.findById(request.getPilarId()).orElseThrow(() -> new NotFoundException("Pilar no encontrado"));
        p.setPosX(request.getPosX());
        p.setPosY(request.getPosY());
        p.setEstado(request.getEstado());
        Pilar saved = repo.save(p);
        return new PilarDTO(saved.getId(), saved.getNombre(), saved.getPosX(), saved.getPosY(), saved.getEstado());
    }
}
