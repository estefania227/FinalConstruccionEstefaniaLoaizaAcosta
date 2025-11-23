package app.adapters.out.mapper;

import app.adapters.out.persistence.entity.PilarEntity;
import app.domain.model.Pilar;
import org.springframework.stereotype.Component;

@Component
public class PilarMapper {

    public Pilar toDomain(PilarEntity entity) {
        if (entity == null) return null;

        return new Pilar(
                entity.getId(),
                entity.getNombre(),
                entity.getPosX(),
                entity.getPosY(),
                entity.getEstado()
        );
    }

    public PilarEntity toEntity(Pilar domain) {
        if (domain == null) return null;

        PilarEntity entity = new PilarEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setPosX(domain.getPosX());
        entity.setPosY(domain.getPosY());
        entity.setEstado(domain.getEstado());
        return entity;
    }
}
