package domain.validation;

import domain.Reserva;
import domain.Sala;
import domain.ports.ReservaRepository;
import domain.ports.SalaRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaValidator {

    private final SalaRepository salaRepository;
    private final ReservaRepository reservaRepository;

    public ReservaValidator(SalaRepository salaRepository, ReservaRepository reservaRepository) {
        this.salaRepository = salaRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<String> validar(Reserva reserva) {
        List<String> errores = new ArrayList<>();

        if (reserva.getNombreSala() == null || reserva.getNombreSala().isBlank()) {
            errores.add("El nombre de la sala es obligatorio");
            return errores;
        }

        Optional<Sala> salaOpt = salaRepository.findByNombre(reserva.getNombreSala());
        if (salaOpt.isEmpty()) {
            errores.add("La sala no existe");
            return errores;
        }

        Sala sala = salaOpt.get();
        if (!sala.isDisponible()) {
            errores.add("La sala no está disponible");
        }

        if (reserva.getCapacidad() > sala.getCapacidad()) {
            errores.add("La capacidad requerida excede la capacidad de la sala");
        }

        if (reserva.getFechaHoraInicio() == null || reserva.getFechaHoraFin() == null) {
            errores.add("Las fechas de inicio y fin son obligatorias");
            return errores;
        }

        if (reserva.getFechaHoraInicio().isAfter(reserva.getFechaHoraFin())) {
            errores.add("La fecha de inicio no puede ser posterior a la fecha de fin");
        }

        if (reserva.getFechaHoraInicio().isBefore(LocalDateTime.now())) {
            errores.add("La fecha de inicio no puede ser en el pasado");
        }

        if (reserva.getFechaHoraInicio().equals(reserva.getFechaHoraFin())) {
            errores.add("La reserva debe tener una duración mínima");
        }

        List<Reserva> reservasExistentes = reservaRepository
            .findByNombreSalaAndFechaHoraInicioBetween(
                reserva.getNombreSala(),
                reserva.getFechaHoraInicio(),
                reserva.getFechaHoraFin()
            );

        for (Reserva existente : reservasExistentes) {
            if (existente.getEstado().equals("ACTIVA")) {
                if (hayConflicto(reserva, existente)) {
                    errores.add("Ya existe una reserva activa para este horario");
                    break;
                }
            }
        }

        return errores;
    }

    private boolean hayConflicto(Reserva nueva, Reserva existente) {
        return nueva.getFechaHoraInicio().isBefore(existente.getFechaHoraFin())
            && nueva.getFechaHoraFin().isAfter(existente.getFechaHoraInicio());
    }
}