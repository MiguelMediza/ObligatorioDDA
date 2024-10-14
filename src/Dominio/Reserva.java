package Dominio;

public class Reserva {
    private int idReserva;
    private Huesped huesped;
    private Habitacion habitacion;
    private int cantidadPersonas;
    private String fechaReserva;
    private boolean pagado;
    private String observacion;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Reserva(int idReserva, Huesped huesped, Habitacion habitacion, int cantidadPersonas, String fechaReserva, boolean pagado, String observacion) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaReserva = fechaReserva;
        this.pagado = pagado;
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", huesped=" + huesped +
                ", habitacion=" + habitacion +
                ", cantidadPersonas=" + cantidadPersonas +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", pagado=" + pagado +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
