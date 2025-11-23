package app.adapters.in.rest;

import app.application.port.in.TriangulacionUseCase;
import app.dto.TriangulacionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inteligencia")
public class InteligenciaController {

    private final TriangulacionUseCase triangulacionUseCase;

    public InteligenciaController(TriangulacionUseCase triangulacionUseCase) {
        this.triangulacionUseCase = triangulacionUseCase;
    }

    @PostMapping("/triangulacion")
    public ResponseEntity<TriangulacionResponse> triangulacion() {

        TriangulacionResponse response = triangulacionUseCase.triangulacion();

        return ResponseEntity.ok(response);
    }
}
