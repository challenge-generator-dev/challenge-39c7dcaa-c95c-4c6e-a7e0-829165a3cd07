package domain.ports;

import domain.Reserva;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Optional<Reserva> findById(Long id);
    List<Reserva> findByNombreSalaAndFechaHoraInicioBetween(String nombreSala,
                                                            LocalDateTime start,
                                                            LocalDateTime end);
    List<Reserva> findAll();
    Reserva save(Reserva reserva);
    void deleteById(Long id);
}