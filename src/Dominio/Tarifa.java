package Dominio;

import java.time.LocalDate;

public class Tarifa {
    private int id;
    private int monto;
    private LocalDate fechaVigencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Tarifa(int id, int monto, LocalDate fechaVigencia) {
        this.id = id;
        this.monto = monto;
        this.fechaVigencia = fechaVigencia;
    }

    public Tarifa(int monto, LocalDate fechaVigencia) {
        this.monto = monto;
        this.fechaVigencia = fechaVigencia;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "id=" + id +
                ", monto=" + monto +
                ", fechaVigencia='" + fechaVigencia + '\'' +
                '}';
    }
}
