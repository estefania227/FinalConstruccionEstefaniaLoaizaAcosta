package app.adapters.out.mapper;

import app.adapters.out.persistence.entity.MensajeEntity;
import app.domain.model.Mensaje;
import org.springframework.stereotype.Component;

@Component
public class MensajeMapper {

    public Mensaje toDomain(MensajeEntity entity) {
        if (entity == null) return null;

        Mensaje m = new Mensaje();
        m.setId(entity.getId());
        m.setPilarId(entity.getPilarId());
        m.setContenidoFragmentado(entity.getContenidoFragmentado());
        m.setContenidoReconstruido(entity.getContenidoReconstruido());
        m.setTimestamp(entity.getTimestamp());
        return m;
    }

    public MensajeEntity toEntity(Mensaje domain) {
        if (domain == null) return null;

        MensajeEntity e = new MensajeEntity();
        e.setId(domain.getId());
        e.setPilarId(domain.getPilarId());
        e.setContenidoFragmentado(domain.getContenidoFragmentado());
        e.setContenidoReconstruido(domain.getContenidoReconstruido());
        e.setTimestamp(domain.getTimestamp());
        return e;
    }
}
