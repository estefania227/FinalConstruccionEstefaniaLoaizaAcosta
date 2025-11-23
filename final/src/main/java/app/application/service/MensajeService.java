package app.application.service;

import app.application.port.in.RegistrarMensajeUseCase;
import app.application.port.in.ReconstruirMensajeUseCase;
import app.application.port.out.MensajeRepositoryPort;
import app.application.port.out.PilarRepositoryPort;
import app.domain.model.Mensaje;
import app.domain.model.Pilar;
import app.dto.MensajeRequest;
import app.dto.MensajeResponse;
import app.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensajeService implements RegistrarMensajeUseCase, ReconstruirMensajeUseCase {

    private final MensajeRepositoryPort mensajeRepo;
    private final PilarRepositoryPort pilarRepo;

    public MensajeService(MensajeRepositoryPort mensajeRepo, PilarRepositoryPort pilarRepo) {
        this.mensajeRepo = mensajeRepo;
        this.pilarRepo = pilarRepo;
    }

    @Override
    public MensajeResponse registrarMensaje(MensajeRequest request) {
        Pilar p = pilarRepo.findById(request.getPilarId()).orElseThrow(() -> new NotFoundException("Pilar no encontrado"));
        Mensaje m = new Mensaje();
        m.setPilarId(p.getId());
        m.setContenidoFragmentado(request.getContenidoFragmentado());
        m.setContenidoReconstruido(null);
        m.setTimestamp(LocalDateTime.now());
        Mensaje saved = mensajeRepo.save(m);
        return new MensajeResponse(saved.getId(), saved.getPilarId(), saved.getContenidoFragmentado(), saved.getContenidoReconstruido(), saved.getTimestamp());
    }

    @Override
    public MensajeResponse reconstruir(Long id, String contenidoReconstruido) {
        Mensaje m = mensajeRepo.findById(id).orElseThrow(() -> new NotFoundException("Mensaje no encontrado"));
        m.setContenidoReconstruido(contenidoReconstruido);
        Mensaje saved = mensajeRepo.save(m);
        return new MensajeResponse(saved.getId(), saved.getPilarId(), saved.getContenidoFragmentado(), saved.getContenidoReconstruido(), saved.getTimestamp());
    }
}
