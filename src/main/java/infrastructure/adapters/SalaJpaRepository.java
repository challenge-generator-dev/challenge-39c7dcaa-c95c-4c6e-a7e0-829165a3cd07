package infrastructure.adapters;

import domain.Sala;
import domain.ports.SalaRepository;
import java.util.List;
import java.util.Optional;

public class SalaJpaRepository implements SalaRepository {

    @Override
    public Optional<Sala> findByNombre(String nombre) {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public List<Sala> findAll() {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public Sala save(Sala sala) {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public Optional<Sala> findById(Long id) {
        throw new UnsupportedOperationException("TODO(reto)");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("TODO(reto)");
    }
}