package application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record ReservaRequest(
    @NotBlank(message = "El nombre de la sala es obligatorio")
    String nombreSala,

    @NotNull(message = "La fecha y hora de inicio son obligatorias")
    LocalDateTime fechaHoraInicio,

    @NotNull(message = "La fecha y hora de fin son obligatorias")
    LocalDateTime fechaHoraFin,

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    String solicitante,

    @Positive(message = "La capacidad debe ser un número positivo")
    int capacidadRequerida
) {
}