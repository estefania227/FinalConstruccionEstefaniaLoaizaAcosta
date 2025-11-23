package app.adapters.in.rest;

import app.application.port.in.RegistrarMensajeUseCase;
import app.application.port.in.ReconstruirMensajeUseCase;
import app.application.port.in.ConsultarMensajeUseCase;
import app.domain.model.Mensaje;
import app.dto.MensajeRequest;
import app.dto.MensajeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final RegistrarMensajeUseCase registrarMensajeUseCase;
    private final ConsultarMensajeUseCase consultarMensajeUseCase;
    private final ReconstruirMensajeUseCase reconstruirMensajeUseCase;

    public MensajeController(RegistrarMensajeUseCase registrarMensajeUseCase,
                             ConsultarMensajeUseCase consultarMensajeUseCase,
                             ReconstruirMensajeUseCase reconstruirMensajeUseCase) {
        this.registrarMensajeUseCase = registrarMensajeUseCase;
        this.consultarMensajeUseCase = consultarMensajeUseCase;
        this.reconstruirMensajeUseCase = reconstruirMensajeUseCase;
    }

    @PostMapping
    public ResponseEntity<MensajeResponse> registrar(@RequestBody MensajeRequest request) {
        Mensaje mensaje = registrarMensajeUseCase.registrar(
                request.getPilarId(),
                request.getFragmento()
        );

        return ResponseEntity.ok(
                new MensajeResponse(
                        mensaje.getId(),
                        mensaje.getPilarId(),
                        mensaje.getContenidoFragmentado(),
                        mensaje.getContenidoReconstruido(),
                        mensaje.getTimestamp()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeResponse> obtener(@PathVariable Long id) {
        Mensaje mensaje = consultarMensajeUseCase.findById(id);

        return ResponseEntity.ok(
                new MensajeResponse(
                        mensaje.getId(),
                        mensaje.getPilarId(),
                        mensaje.getContenidoFragmentado(),
                        mensaje.getContenidoReconstruido(),
                        mensaje.getTimestamp()
                )
        );
    }

    @GetMapping("/pilar/{pilarId}")
    public ResponseEntity<List<Mensaje>> obtenerPorPilar(@PathVariable Long pilarId) {
        return ResponseEntity.ok(consultarMensajeUseCase.findByPilarId(pilarId));
    }

    @PostMapping("/reconstruir")
    public ResponseEntity<String> reconstruir() {
        return ResponseEntity.ok(reconstruirMensajeUseCase.reconstruirMensaje());
    }
}
