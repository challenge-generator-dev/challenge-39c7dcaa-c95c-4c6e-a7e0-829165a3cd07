package application.dto;

import java.time.LocalDateTime;

public record ReservaResponse(
    Long id,
    String nombreSala,
    LocalDateTime fechaHoraInicio,
    LocalDateTime fechaHoraFin,
    String solicitante,
    int capacidad,
    String estado
) {
}