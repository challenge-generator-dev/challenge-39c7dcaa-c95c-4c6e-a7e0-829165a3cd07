package infrastructure.adapters;

import domain.Reserva;
import domain.ports.ReservaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaJpaRepository implements ReservaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Reserva> findById(Long id) {
        Reserva reserva = entityManager.find(Reserva.class, id);
        return Optional.ofNullable(reserva);
    }

    @Override
    public List<Reserva> findByNombreSalaAndFechaHoraInicioBetween(String nombreSala,
                                                                    LocalDateTime start,
                                                                    LocalDateTime end) {
        TypedQuery<Reserva> query = entityManager.createQuery(
            "SELECT r FROM Reserva r WHERE r.nombreSala = :nombreSala " +
            "AND r.fechaHoraInicio < :end AND r.fechaHoraFin > :start",
            Reserva.class
        );
        query.setParameter("nombreSala", nombreSala);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }

    @Override
    public List<Reserva> findAll() {
        TypedQuery<Reserva> query = entityManager.createQuery(
            "SELECT r FROM Reserva r",
            Reserva.class
        );
        return query.getResultList();
    }

    @Override
    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            entityManager.persist(reserva);
            return reserva;
        } else {
            return entityManager.merge(reserva);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Reserva> reservaOpt = findById(id);
        reservaOpt.ifPresent(reserva -> entityManager.remove(reserva));
    }
}