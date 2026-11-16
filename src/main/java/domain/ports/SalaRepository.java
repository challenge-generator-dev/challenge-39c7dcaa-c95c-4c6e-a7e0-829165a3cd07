package domain.ports;

import domain.Sala;
import java.util.List;
import java.util.Optional;

public interface SalaRepository {
    Optional<Sala> findByNombre(String nombre);
    List<Sala> findAll();
    Sala save(Sala sala);
    Optional<Sala> findById(Long id);
    void deleteById(Long id);
}