package infrastructure.controllers;

import application.dto.ReservaRequest;
import application.dto.ReservaResponse;
import application.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> crearReserva(@Valid @RequestBody ReservaRequest request) {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para crear una reserva");
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponse>> listarReservas() {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para listar todas las reservas");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> obtenerReserva(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para obtener una reserva por ID");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        throw new UnsupportedOperationException("TODO(reto): Implementar la lógica para cancelar una reserva");
    }
}