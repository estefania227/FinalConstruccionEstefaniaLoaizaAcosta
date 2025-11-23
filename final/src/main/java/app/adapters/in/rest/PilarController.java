package app.adapters.in.rest;

import app.application.port.in.RegistrarPosicionUseCase;
import app.application.port.in.ConsultarPilarUseCase;
import app.domain.model.Pilar;
import app.dto.CrearPosicionRequest;
import app.dto.PilarDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilares")
public class PilarController {

    private final RegistrarPosicionUseCase registrarPosicionUseCase;
    private final ConsultarPilarUseCase consultarPilarUseCase;

    public PilarController(RegistrarPosicionUseCase registrarPosicionUseCase,
                           ConsultarPilarUseCase consultarPilarUseCase) {
        this.registrarPosicionUseCase = registrarPosicionUseCase;
        this.consultarPilarUseCase = consultarPilarUseCase;
    }

    @PostMapping
    public ResponseEntity<PilarDTO> registrar(@RequestBody CrearPosicionRequest request) {
        Pilar p = registrarPosicionUseCase.registrar(
                request.getNombre(),
                request.getPosX(),
                request.getPosY()
        );
        PilarDTO dto = new PilarDTO(
                p.getId(),
                p.getNombre(),
                p.getPosX(),
                p.getPosY(),
                p.getEstado()
        );

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilarDTO> obtener(@PathVariable Long id) {
        Pilar p = consultarPilarUseCase.findById(id);

        PilarDTO dto = new PilarDTO(
                p.getId(),
                p.getNombre(),
                p.getPosX(),
                p.getPosY(),
                p.getEstado()
        );

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<Pilar>> listar() {
        return ResponseEntity.ok(consultarPilarUseCase.findAll());
    }
}
