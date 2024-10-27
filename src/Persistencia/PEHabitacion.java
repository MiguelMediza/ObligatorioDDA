package Persistencia;


import Dominio.Habitacion;
import Dominio.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PEHabitacion {
    private static Conexion conexion = new Conexion();
    public static boolean agregarHabitacon(Habitacion h) {
        String sql = "INSERT INTO habitaciones(capacidadCamas, camaMatrimonial, aireAcondicionado, balcon, vista, amenities, ocupada, idHotel) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                h.getCapacidadCamas(),
                h.isCamaMatrimonial(),
                h.isAireAcondicionado(),
                h.isBalcon(),
                h.getVista(),
                h.getAmenities(),
                h.isOcupada(),
                h.getIdHotel()
        ));
        return conexion.consulta(sql, parametros);
    }

    public static Habitacion buscarHabitacion(int pIdHabitacion) {
        String sql = "SELECT idHabitacion,capacidadCamas, camaMatrimonial, aireAcondicionado, balcon, vista, amenities, ocupada, idHotel FROM habitaciones WHERE idHabitacion=?";

        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHabitacion));
        Iterator var3 = conexion.seleccion(sql, parametros).iterator();
        if (var3.hasNext()) {
            List<Object> registro = (List) var3.next();
            int idHabitacion = (Integer) registro.get(0);
            int capacidadCamas = (Integer) (registro.get(1));
            Boolean camaMatrimonial = (Boolean) (registro.get(2));
            Boolean aireAcondicionado = (Boolean) (registro.get(3));
            Boolean balcon = (Boolean) (registro.get(4));
            Boolean vista = (Boolean) (registro.get(5));
            String amenities = String.valueOf(registro.get(6));
            Boolean ocupada = (Boolean) (registro.get(7));
            int idHotel = (Integer) registro.get(8);

            Habitacion unaHabitacion = new Habitacion(idHabitacion, capacidadCamas, camaMatrimonial, aireAcondicionado, balcon, vista, amenities, ocupada, idHotel);
            return unaHabitacion;

        } else {
            System.out.println("No se encontro la habitacion");
            return null;

        }

    }

    public static boolean ActualizarDisponibilidad(boolean disponibilidad, int idHabitacion) {
        Habitacion h = buscarHabitacion(idHabitacion);
        if(h != null) {
                String sql = "UPDATE habitaciones SET ocupada=? WHERE idHabitacion=?";
                ArrayList<Object> parametros = new ArrayList(Arrays.asList(disponibilidad, idHabitacion));
                return conexion.consulta(sql, parametros);
        }
        System.out.println("-ERROR La habitaciones ingresada se encuentra ocupada");
        return false;
    }

    public static boolean eliminarHabitacion(int pidHabitacion) {
        String sql = "DELETE FROM habitaciones WHERE idHabitacion=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidHabitacion));
        return conexion.consulta(sql, parametros);
    }

    public static ArrayList<Habitacion> listarHabitaciones() {
        String sql = "SELECT * FROM habitaciones";
        List<List<Object>> resultado = conexion.seleccion(sql, (List)null);
        ArrayList<Habitacion> Habitaciones = new ArrayList();
        Iterator var3 = resultado.iterator();

        while(var3.hasNext()) {
            List<Object> registro = (List)var3.next();
            int idHabitacion = (Integer)registro.get(0);
            int capacidadCamas = (Integer) (registro.get(1));
            Boolean camaMatrimonial = (Boolean) (registro.get(2));
            Boolean aireAcondicionado = (Boolean) (registro.get(3));
            Boolean balcon = (Boolean)registro.get(4);
            Boolean vista = (Boolean) (registro.get(5));
            String amenities = String.valueOf(registro.get(6));
            Boolean ocupada = (Boolean) (registro.get(7));
            int idHotel = (Integer)registro.get(8);
            Habitaciones.add(new Habitacion(idHabitacion, capacidadCamas, camaMatrimonial, aireAcondicionado, balcon, vista, amenities, ocupada, idHotel));
        }

        return Habitaciones;
    }

    public static boolean modificarHabitacion(Habitacion h) {
        String sql = "UPDATE habitaciones SET capacidadCamas=?, camaMatrimonial=?, aireAcondicionado=?, balcon=?, vista=?, amenities=?, ocupada=?, idHotel=? WHERE idHabitacion=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(h.getCapacidadCamas(), h.isCamaMatrimonial(), h.isAireAcondicionado(), h.isBalcon(), h.getVista(), h.getAmenities(), h.isOcupada(), h.getIdHotel(), h.getIdHabitacion()));
        return conexion.consulta(sql, parametros);
    }
}
