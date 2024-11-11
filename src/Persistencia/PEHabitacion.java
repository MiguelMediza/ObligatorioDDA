package Persistencia;


import Dominio.Habitacion;
import Dominio.Hotel;
import Utils.AppSQLException;

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

        try {
            if (conexion.consulta(sql,parametros)){
                return true;
            }
            else {
                System.out.println("Existió un problema al agregar el estudiante");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }



    public static Habitacion buscarHabitacion(int pIdHabitacion) {
        String sql = "SELECT idHabitacion,capacidadCamas, camaMatrimonial, aireAcondicionado, balcon, vista, amenities, ocupada, idHotel FROM habitaciones WHERE idHabitacion=?";

        try{
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
        catch (AppSQLException var6) {
            System.out.println("Ocurrio un error al consultar la habitacion");
            System.out.println(var6.getMessage());
            return null;
        }
    }

    public static boolean ActualizarDisponibilidad(boolean disponibilidad, int idHabitacion) {
        Habitacion h = buscarHabitacion(idHabitacion);
        if(h != null) {
                String sql = "UPDATE habitaciones SET ocupada=? WHERE idHabitacion=?";
                ArrayList<Object> parametros = new ArrayList(Arrays.asList(disponibilidad, idHabitacion));
            try {
                if (conexion.consulta(sql, parametros)) {
                    return true;
                } else {
                    System.out.println("Existió un problema al actualizar el estado de la habitación");
                    return false;
                }
            } catch (AppSQLException var5) {
                AppSQLException e = var5;
                System.out.println(e.getMessage());
                return false;
            }
        }
        System.out.println("-ERROR La habitación ingresada se encuentra ocupada");
        return false;
    }

    public static boolean eliminarHabitacion(int pidHabitacion) {
        String sql = "DELETE FROM habitaciones WHERE idHabitacion=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidHabitacion));

        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se eliminó la habitación con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar la habitación");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Habitacion> listarHabitaciones() {
        String sql = "SELECT * FROM habitaciones";
        try{
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
        } catch (AppSQLException var11) {
            AppSQLException e = var11;
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static boolean modificarHabitacion(Habitacion h) {
        String sql = "UPDATE habitaciones SET capacidadCamas=?, camaMatrimonial=?, aireAcondicionado=?, balcon=?, vista=?, amenities=?, ocupada=?, idHotel=? WHERE idHabitacion=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(h.getCapacidadCamas(), h.isCamaMatrimonial(), h.isAireAcondicionado(), h.isBalcon(), h.getVista(), h.getAmenities(), h.isOcupada(), h.getIdHotel(), h.getIdHabitacion()));
        try{
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se modificó la habitación con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar la habitacion");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

}

