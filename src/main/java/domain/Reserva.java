package domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
    private Long id;

    @NotBlank(message = "El nombre de la sala es obligatorio")
    private String nombreSala;

    @NotNull(message = "La fecha y hora de inicio son obligatorias")
    private LocalDateTime fechaHoraInicio;

    @NotNull(message = "La fecha y hora de fin son obligatorias")
    private LocalDateTime fechaHoraFin;

    @NotBlank(message = "El nombre del solicitante es obligatorio")
    private String solicitante;

    private int capacidad;

    private String estado;

    public Reserva() {
        this.estado = "ACTIVA";
    }

    public Reserva(Long id, String nombreSala, LocalDateTime fechaHoraInicio,
                   LocalDateTime fechaHoraFin, String solicitante, int capacidad) {
        this.id = id;
        this.nombreSala = nombreSala;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.solicitante = solicitante;
        this.capacidad = capacidad;
        this.estado = "ACTIVA";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}