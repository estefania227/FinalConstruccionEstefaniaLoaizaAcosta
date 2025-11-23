package app.application.service;

import app.application.port.in.TriangulacionUseCase;
import app.application.port.out.PilarRepositoryPort;
import app.domain.model.Pilar;
import app.dto.TriangulacionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteligenciaService implements TriangulacionUseCase {

    private final PilarRepositoryPort pilarRepo;

    public InteligenciaService(PilarRepositoryPort pilarRepo) { this.pilarRepo = pilarRepo; }

    /**
     * Triangulación sencilla: promedio ponderado por "estado".
     * Estados ejemplo: "Perfecto" -> peso 1.0, "Dañado" -> 0.7, "Herido" -> 0.5, "Desconocido" -> 0.3
     */
    @Override
    public TriangulacionResponse triangulacion() {
        List<Pilar> pilares = pilarRepo.findAll();
        if (pilares.isEmpty()) {
            return new TriangulacionResponse(0.0, 0.0, 0.0, "No hay pilares registrados");
        }

        double sumWX = 0.0, sumWY = 0.0, sumW = 0.0;
        double minW = Double.MAX_VALUE, maxW = Double.MIN_VALUE;
        for (Pilar p : pilares) {
            double w = pesoPorEstado(p.getEstado());
            if (w < minW) minW = w;
            if (w > maxW) maxW = w;
            sumWX += (p.getPosX() == null ? 0 : p.getPosX()) * w;
            sumWY += (p.getPosY() == null ? 0 : p.getPosY()) * w;
            sumW += w;
        }
        double posX = sumW == 0 ? 0.0 : sumWX / sumW;
        double posY = sumW == 0 ? 0.0 : sumWY / sumW;

        // nivel de confianza: función simple basada en distribución de pesos
        double nivel = Math.max(0.0, Math.min(1.0, (sumW / (pilares.size())))); // promedio de pesos normalizado (aprox)
        String desc = (nivel > 0.75) ? "Alto" : (nivel > 0.4) ? "Medio" : "Bajo";

        return new TriangulacionResponse(posX, posY, nivel, "Confianza: " + desc);
    }

    private double pesoPorEstado(String estado) {
        if (estado == null) return 0.4;
        String e = estado.toLowerCase();
        if (e.contains("perfect") || e.contains("perfecto") || e.contains("activo")) return 1.0;
        if (e.contains("dan") || e.contains("dañado") || e.contains("dano")) return 0.7;
        if (e.contains("herid") || e.contains("herido")) return 0.5;
        if (e.contains("desconoc") || e.contains("unknown")) return 0.3;
        return 0.6;
    }
}
