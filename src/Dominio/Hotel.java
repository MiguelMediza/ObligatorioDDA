package Dominio;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int idHotel;
    private String nombre;
    private String ciudad;
    private String pais;
    private int cantidadEstrellas;
    private String direccion;
    private String zona;
    private List<Habitacion> habitacionesDisponibles;
    private List<Habitacion> habitacionesOcupadas;


    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantidadEstrellas() {
        return cantidadEstrellas;
    }

    public void setCantidadEstrellas(int cantidadEstrellas) {
        this.cantidadEstrellas = cantidadEstrellas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(List<Habitacion> habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public List<Habitacion> getHabitacionesOcupadas() {
        return habitacionesOcupadas;
    }

    public void setHabitacionesOcupadas(List<Habitacion> habitacionesOcupadas) {
        this.habitacionesOcupadas = habitacionesOcupadas;
    }

    public Hotel(String nombre, String ciudad, String pais,
                 int cantidadEstrellas, String direccion, String zona) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cantidadEstrellas = cantidadEstrellas;
        this.direccion = direccion;
        this.zona = zona;
        this.habitacionesDisponibles = new ArrayList<>();
        this.habitacionesOcupadas = new ArrayList<>();
    }

    public Hotel(int idHotel, String nombre, String ciudad, String pais,
                 int cantidadEstrellas, String direccion, String zona) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cantidadEstrellas = cantidadEstrellas;
        this.direccion = direccion;
        this.zona = zona;
        this.habitacionesDisponibles = new ArrayList<>();
        this.habitacionesOcupadas = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "idHotel='" + idHotel + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", cantidadEstrellas=" + cantidadEstrellas +
                ", direccion='" + direccion + '\'' +
                ", zona='" + zona + '\'' +
                ", habitacionesDisponibles=" + habitacionesDisponibles +
                ", habitacionesOcupadas=" + habitacionesOcupadas +
                '}';
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitacionesDisponibles.add(habitacion);
    }
    public void agregarHabitacionOcupada(Habitacion habitacion) {
        habitacionesOcupadas.add(habitacion);
    }


    public void eliminarHabitacion(Habitacion habitacion) {
        this.habitacionesDisponibles.remove(habitacion);
    }

    public void reservarHabitacion(Habitacion habitacion) {
        if (habitacionesDisponibles.contains(habitacion) && !habitacionesOcupadas.contains(habitacion)) {
            habitacionesDisponibles.remove(habitacion);
            habitacionesOcupadas.add(habitacion);
            habitacion.setOcupada(true);
        }
    }
}
