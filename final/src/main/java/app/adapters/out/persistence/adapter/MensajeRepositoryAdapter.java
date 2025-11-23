package app.adapters.out.persistence.adapter;

import app.adapters.out.mapper.MensajeMapper;
import app.adapters.out.persistence.entity.MensajeEntity;
import app.adapters.out.persistence.repository.SpringDataMensajeRepository;
import app.application.port.out.MensajeRepositoryPort;
import app.domain.model.Mensaje;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MensajeRepositoryAdapter implements MensajeRepositoryPort {

    private final SpringDataMensajeRepository repository;
    private final MensajeMapper mapper;

    public MensajeRepositoryAdapter(SpringDataMensajeRepository repository, MensajeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mensaje save(Mensaje mensaje) {
        MensajeEntity entity = mapper.toEntity(mensaje);
        MensajeEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Mensaje> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    public List<Mensaje> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    }

