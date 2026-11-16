package application;

import application.dto.ReservaRequest;
import application.dto.ReservaResponse;
import domain.Reserva;
import domain.Sala;
import domain.ports.ReservaRepository;
import domain.ports.SalaRepository;
import domain.validation.ReservaValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;
    private final ReservaValidator reservaValidator;

    public ReservaService(ReservaRepository reservaRepository,
                          SalaRepository salaRepository,
                          ReservaValidator reservaValidator) {
        this.reservaRepository = reservaRepository;
        this.salaRepository = salaRepository;
        this.reservaValidator = reservaValidator;
    }

    public ReservaResponse crearReserva(ReservaRequest request) {
        Optional<Sala> salaOpt = salaRepository.findByNombre(request.nombreSala());
        
        if (salaOpt.isEmpty()) {
            throw new SalaNoEncontradaException("La sala '" + request.nombreSala() + "' no existe");
        }

        Sala sala = salaOpt.get();
        
        if (!sala.isDisponible()) {
            throw new SalaNoDisponibleException("La sala '" + request.nombreSala() + "' no está disponible");
        }

        if (request.capacidadRequerida() > sala.getCapacidad()) {
            throw new CapacidadInsuficienteException(
                "La capacidad requerida (" + request.capacidadRequerida() + 
                ") excede la capacidad de la sala (" + sala.getCapacidad() + ")"
            );
        }

        Reserva reserva = new Reserva();
        reserva.setNombreSala(request.nombreSala());
        reserva.setFechaHoraInicio(request.fechaHoraInicio());
        reserva.setFechaHoraFin(request.fechaHoraFin());
        reserva.setSolicitante(request.solicitante());
        reserva.setCapacidad(request.capacidadRequerida());
        reserva.setEstado("ACTIVA");

        List<String> erroresValidacion = reservaValidator.validar(reserva);
        if (!erroresValidacion.isEmpty()) {
            throw new ValidacionReservaException(String.join("; ", erroresValidacion));
        }

        Reserva reservaGuardada = reservaRepository.save(reserva);
        
        return mapToResponse(reservaGuardada);
    }

    public List<ReservaResponse> listarReservas() {
        return reservaRepository.findAll().stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    public ReservaResponse obtenerReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        
        if (reservaOpt.isEmpty()) {
            throw new ReservaNoEncontradaException("La reserva con ID " + id + " no existe");
        }
        
        return mapToResponse(reservaOpt.get());
    }

    public void cancelarReserva(Long id) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        
        if (reservaOpt.isEmpty()) {
            throw new ReservaNoEncontradaException("La reserva con ID " + id + " no existe");
        }

        Reserva reserva = reservaOpt.get();
        
        if ("CANCELADA".equals(reserva.getEstado())) {
            throw new ReservaYaCanceladaException("La reserva ya está cancelada");
        }

        reserva.setEstado("CANCELADA");
        reservaRepository.save(reserva);
    }

    private ReservaResponse mapToResponse(Reserva reserva) {
        return new ReservaResponse(
            reserva.getId(),
            reserva.getNombreSala(),
            reserva.getFechaHoraInicio(),
            reserva.getFechaHoraFin(),
            reserva.getSolicitante(),
            reserva.getCapacidad(),
            reserva.getEstado()
        );
    }

    public static class SalaNoEncontradaException extends RuntimeException {
        public SalaNoEncontradaException(String message) {
            super(message);
        }
    }

    public static class SalaNoDisponibleException extends RuntimeException {
        public SalaNoDisponibleException(String message) {
            super(message);
        }
    }

    public static class CapacidadInsuficienteException extends RuntimeException {
        public CapacidadInsuficienteException(String message) {
            super(message);
        }
    }

    public static class ValidacionReservaException extends RuntimeException {
        public ValidacionReservaException(String message) {
            super(message);
        }
    }

    public static class ReservaNoEncontradaException extends RuntimeException {
        public ReservaNoEncontradaException(String message) {
            super(message);
        }
    }

    public static class ReservaYaCanceladaException extends RuntimeException {
        public ReservaYaCanceladaException(String message) {
            super(message);
        }
    }
}