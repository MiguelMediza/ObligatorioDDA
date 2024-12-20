package Persistencia;

import Dominio.Habitacion;
import Dominio.Hotel;
import Dominio.Huesped;
import Dominio.Reserva;
import Utils.AppSQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PEReserva {
    private static Conexion conexion = new Conexion();
    public static boolean agregarReserva(Reserva r) {
        String sql = "INSERT INTO reservas(responsable, habitacion, cantidadPersonas, fechaReserva, seniaPago, pagado, observaciones) VALUES(?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                r.getHuesped().getIdHuesped(),
                r.getHabitacion().getIdHabitacion(),
                r.getCantidadPersonas(),
                r.getFechaReserva(),
                r.getSeniaValor(),
                r.isPagado(),
                r.getObservacion()
        ));
        try {
            if (conexion.consulta(sql,parametros)){
                return true;
            }
            else {
                System.out.println("Existió un problema al agregar la reserva");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Reserva buscarReserva(int pidReserva) {
        String sql = "SELECT idReserva, responsable, habitacion, cantidadPersonas, fechaReserva, seniaPago, pagado, observaciones FROM reservas WHERE idReserva=?";
        try{
            ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidReserva));
            Iterator var3 = conexion.seleccion(sql, parametros).iterator();
            if (var3.hasNext()) {
                List<Object> registro = (List)var3.next();
                int idReserva = (Integer) registro.get(0);
                int idResponsable = (Integer) registro.get(1);
                int idHabitacion = (Integer) registro.get(2);
                int cantidadPersonas = (Integer) registro.get(3);
                String fechaReserva = String.valueOf(registro.get(4));
                double seniaValor = (Double) registro.get(5);
                boolean pagado = (Boolean) registro.get(6);
                String observaciones = String.valueOf(registro.get(7));

                Huesped responsable = PEHuesped.buscarHuesped(idResponsable);
                Habitacion habitacion = PEHabitacion.buscarHabitacion(idHabitacion);
                Reserva unaReserva = new Reserva(idReserva, responsable, habitacion, cantidadPersonas, fechaReserva, seniaValor, pagado, observaciones);
                return unaReserva;

            } else {
                System.out.println("No se encontro una reserva");
                return null;
            }
        }
        catch (AppSQLException var6) {
            System.out.println("Ocurrio un error al consultar la reserva");
            System.out.println(var6.getMessage());
            return null;
        }

    }

    public static boolean eliminarReserva(int pIdReserva) {
        String sql = "DELETE FROM reservas WHERE idReserva=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdReserva));
        try {
            if (conexion.consulta(sql, parametros)) {
                return true;
            } else {
                System.out.println("Existió un problema al eliminar la reserva");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean ActualizarPago(int pIdReserva) {
        String sql = "UPDATE reservas SET pagado=? WHERE idReserva=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(true, pIdReserva));
        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se actualizo el pago de la reserva con exito");
                return true;
            } else {
                System.out.println("Existió un problema al actualizar el pago de la reserva");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }


    }

    public static ArrayList<Reserva> listarReservas() {
        String sql = "SELECT * FROM reservas";
        try{
            List<List<Object>> resultado = conexion.seleccion(sql, (List)null);
            ArrayList<Reserva> Reservas = new ArrayList();
            Iterator var3 = resultado.iterator();

            while(var3.hasNext()) {
                List<Object> registro = (List)var3.next();
                int idReserva = (Integer) registro.get(0);
                int idResponsable = (Integer) registro.get(1);
                int idHabitacion = (Integer) registro.get(2);
                int cantidadPersonas = (Integer) registro.get(3);
                String fechaReserva = String.valueOf(registro.get(4));
                double seniaValor = (Double) registro.get(5);
                boolean pagado = (Boolean) registro.get(6);
                String observaciones = String.valueOf(registro.get(7));

                Huesped responsable = PEHuesped.buscarHuesped(idResponsable);
                Habitacion habitacion = PEHabitacion.buscarHabitacion(idHabitacion);

                Reservas.add(new Reserva(idReserva, responsable, habitacion, cantidadPersonas, fechaReserva, seniaValor, pagado, observaciones));
            }

            return Reservas;
        } catch (AppSQLException var11) {
            AppSQLException e = var11;
            System.out.println(e.getMessage());
            return null;
        }
    }



//    public static void RealizarPago(){
//        String sql = "UPDATE reservas SET responsable=?, habitacion=?, cantidadPersonas=?, fechaReserva=?, pagado=?, observaciones=? WHERE idReserva=?";
//        ArrayList<Object> parametros = new ArrayList(Arrays.asList(r.getHuesped(), r.getHabitacion(), r.getCantidadPersonas(), r.getFechaReserva(), r.isPagado(), r.getObservacion()));
//        return conexion.consulta(sql, parametros);
//    }

    public static boolean modificarReserva(Reserva r) {
        String sql = "UPDATE reservas SET responsable=?, habitacion=?, cantidadPersonas=?, fechaReserva=?, pagado=?, observaciones=? WHERE idReserva=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(r.getHuesped(), r.getHabitacion(), r.getCantidadPersonas(), r.getFechaReserva(), r.isPagado(), r.getObservacion()));
        try{
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se modificó la reserva con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar la reserva");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException ex = var5;
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
