package Dominio;

public class Habitacion {
    private int idHabitacion;
    private int capacidadCamas;
    private boolean camaMatrimonial;
    private boolean aireAcondicionado;
    private boolean balcon;
    private boolean vista;
    private String amenities;
    private boolean ocupada;
    private int idHotel;


    public int getIdHabitacion() {
        return idHabitacion;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCapacidadCamas() {
        return capacidadCamas;
    }

    public void setCapacidadCamas(int capacidadCamas) {
        this.capacidadCamas = capacidadCamas;
    }

    public boolean isCamaMatrimonial() {
        return camaMatrimonial;
    }

    public void setCamaMatrimonial(boolean camaMatrimonial) {
        this.camaMatrimonial = camaMatrimonial;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public boolean getVista() {
        return vista;
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }


    public Habitacion(int idHabitacion, int capacidadCamas, boolean camaMatrimonial, boolean aireAcondicionado, boolean balcon, boolean vista, String amenities, boolean ocupada, int idHotel) {
        this.idHabitacion = idHabitacion;
        this.capacidadCamas = capacidadCamas;
        this.camaMatrimonial = camaMatrimonial;
        this.aireAcondicionado = aireAcondicionado;
        this.balcon = balcon;
        this.vista = vista;
        this.amenities = amenities;
        this.ocupada = ocupada;
        this.idHotel = idHotel;
    }

    public Habitacion(int capacidadCamas, boolean camaMatrimonial, boolean aireAcondicionado, boolean balcon, boolean vista, String amenities, boolean ocupada, int idHotel) {
        this.capacidadCamas = capacidadCamas;
        this.camaMatrimonial = camaMatrimonial;
        this.aireAcondicionado = aireAcondicionado;
        this.balcon = balcon;
        this.vista = vista;
        this.amenities = amenities;
        this.ocupada = ocupada;
        this.idHotel = idHotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "idHabitacion=" + idHabitacion +
                ", idHotel=" + idHotel +
                ", capacidadCamas=" + capacidadCamas +
                ", camaMatrimonial=" + camaMatrimonial +
                ", aireAcondicionado=" + aireAcondicionado +
                ", balcon=" + balcon +
                ", vista=" + vista  +
                ", amenities='" + amenities + '\'' +
                ", ocupada=" + ocupada +
                '}';
    }
}

