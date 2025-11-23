package app.adapters.out.persistence.adapter;

import app.adapters.out.mapper.PilarMapper;
import app.adapters.out.persistence.entity.PilarEntity;
import app.adapters.out.persistence.repository.SpringDataPilarRepository;
import app.application.port.out.PilarRepositoryPort;
import app.domain.model.Pilar;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PilarRepositoryAdapter implements PilarRepositoryPort {

    private final SpringDataPilarRepository repository;
    private final PilarMapper mapper;

    public PilarRepositoryAdapter(SpringDataPilarRepository repository, PilarMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Pilar> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Pilar save(Pilar pilar) {
        PilarEntity entity = mapper.toEntity(pilar);
        PilarEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Pilar> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
