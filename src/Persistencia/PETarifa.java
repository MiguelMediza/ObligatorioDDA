package Persistencia;


import Dominio.Tarifa;
import Utils.AppSQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PETarifa {
    private static Conexion conexion = new Conexion();
    public static boolean agregarTarifa(Tarifa t) {
        String sql = "INSERT INTO tarifas(monto, fechaVigencia) VALUES(?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                t.getMonto(),
                t.getFechaVigencia()
        ));
        try {
            if (conexion.consulta(sql,parametros)){
                System.out.println("Se agrego la tarifa con exito");
                return true;
            }
            else {
                System.out.println("Existió un problema al agregar la tarifa");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Tarifa buscarTarifa(int pidTarifa) {
        String sql = "SELECT idTarifa, monto, fechaVigencia FROM tarifas WHERE idTarifa=?";
        try{
            ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidTarifa));
            Iterator var3 = conexion.seleccion(sql, parametros).iterator();
            if (var3.hasNext()) {
                List<Object> registro = (List) var3.next();
                int idTarifa = (Integer) registro.get(0);
                int monto = (Integer) (registro.get(1));
                String fechaVigencia = String.valueOf(registro.get(2));

                Tarifa unaTarifa = new Tarifa(idTarifa, monto, fechaVigencia);

                return unaTarifa;

            } else {
                System.out.println("No se encontro la tarifa");
                return null;

            }
        }
        catch (AppSQLException var6) {
            System.out.println("Ocurrio un error al consultar la tarifa");
            System.out.println(var6.getMessage());
            return null;
        }
    }

    public static boolean eliminarTarifa(int pidTarifa) {
        String sql = "DELETE FROM tarifas WHERE idTarifa=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidTarifa));
        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se eliminó la tarifa con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar la tarifa");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Tarifa> listarTarifas() {
        String sql = "SELECT * FROM tarifas";
        try {
            List<List<Object>> resultado = conexion.seleccion(sql, (List) null);
            ArrayList<Tarifa> Tarifas = new ArrayList();
            Iterator var3 = resultado.iterator();

            while (var3.hasNext()) {
                List<Object> registro = (List) var3.next();
                int idTarifa = (Integer) registro.get(0);
                int monto = (Integer) (registro.get(1));
                String fechaVigencia = String.valueOf(registro.get(2));
                Tarifas.add(new Tarifa(idTarifa, monto, fechaVigencia));
            }

            return Tarifas;
        } catch (AppSQLException var11) {
            AppSQLException e = var11;
            System.out.println(e.getMessage());
            return null;
        }

    }
}
