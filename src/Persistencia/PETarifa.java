package Persistencia;


import Dominio.Tarifa;

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
        return conexion.consulta(sql, parametros);
    }

    public static Tarifa buscarTarifa(int pidTarifa) {
        String sql = "SELECT idTarifa, monto, fechaVigencia WHERE idTarifa=?";

        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidTarifa));
        Iterator var3 = conexion.seleccion(sql, parametros).iterator();
        if (var3.hasNext()) {
            List<Object> registro = (List) var3.next();
            int idTarifa = (Integer) registro.get(0);
            int monto = (Integer) (registro.get(1));
            String fechaVigencia = String.valueOf(registro.get(2));

            Tarifa unaTarifa = new Tarifa(idTarifa, monto, fechaVigencia);
            System.out.println(unaTarifa.toString());
            return unaTarifa;

        } else {
            System.out.println("No se encontro la tarifa");
            return null;

        }

    }

    public static boolean eliminarTarifa(int pidTarifa) {
        String sql = "DELETE FROM tarifas WHERE idTarifa=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pidTarifa));
        return conexion.consulta(sql, parametros);
    }

    public static ArrayList<Tarifa> listarTarifas() {
        String sql = "SELECT * FROM tarifas";
        List<List<Object>> resultado = conexion.seleccion(sql, (List)null);
        ArrayList<Tarifa> Tarifas = new ArrayList();
        Iterator var3 = resultado.iterator();

        while(var3.hasNext()) {
            List<Object> registro = (List)var3.next();
            int idTarifa = (Integer)registro.get(0);
            int monto = (Integer) (registro.get(1));
            String fechaVigencia = String.valueOf(registro.get(2));
            Tarifas.add(new Tarifa(idTarifa, monto, fechaVigencia));
        }

        return Tarifas;
    }
}
