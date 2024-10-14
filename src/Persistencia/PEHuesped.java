package Persistencia;

import Dominio.Huesped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PEHuesped {
    private static Conexion conexion = new Conexion();

    public PEHuesped() {
    }

    public static boolean agregarHuesped(Huesped e) {
        String sql = "INSERT INTO huespedes(nombre, aPaterno, aMaterno, tipoDocumento, nroDocumento, fechaNacimiento, telefono, pais) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(e.getNombre(), e.getaPaterno(), e.getaMaterno(), e.getTipo_documento(), e.getNum_documento(), e.getFecha_nacimiento(), e.getTelefono(), e.getPais()));
        return conexion.consulta(sql, parametros);
    }

    public static Huesped buscarHuesped(int pIdHuedped) {
        String sql = "SELECT idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, nroDocumento, fechaNacimiento, telefono, pais FROM huespedes WHERE idHuesped=?";

        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHuedped));
        Iterator var3 = conexion.seleccion(sql, parametros).iterator();
        if (var3.hasNext()) {
            List<Object> registro = (List)var3.next();
            int idHuesped = (Integer)registro.get(0);
            String nombre = String.valueOf(registro.get(1));
            String aPaterno = String.valueOf(registro.get(2));
            String aMaterno = String.valueOf(registro.get(3));
            String tipoDocumento = String.valueOf(registro.get(4));
            int numDocumento = (Integer)registro.get(5);
            String fechaNacimiento = String.valueOf(registro.get(6));
            String telefono = String.valueOf(registro.get(7));
            String pais = String.valueOf(registro.get(8));
            Huesped unHuesped = new Huesped(idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais);
            return unHuesped;
        } else {
            return null;
        }
    }

    public static Huesped buscarHuespedPorCi(int pHuespedCi) {
        String sql = "SELECT idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, nroDocumento, fechaNacimiento, telefono, pais FROM huespedes WHERE nroDocumento=?";

        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pHuespedCi));
        Iterator var3 = conexion.seleccion(sql, parametros).iterator();
        if (var3.hasNext()) {
            List<Object> registro = (List)var3.next();
            int idHuesped = (Integer)registro.get(0);
            String nombre = String.valueOf(registro.get(1));
            String aPaterno = String.valueOf(registro.get(2));
            String aMaterno = String.valueOf(registro.get(3));
            String tipoDocumento = String.valueOf(registro.get(4));
            int numDocumento = (Integer)registro.get(5);
            String fechaNacimiento = String.valueOf(registro.get(6));
            String telefono = String.valueOf(registro.get(7));
            String pais = String.valueOf(registro.get(8));
            Huesped unHuesped = new Huesped(idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais);
            return unHuesped;
        } else {
            return null;
        }
    }

    public static boolean eliminarHuesped(int pIdHuesped) {
        String sql = "DELETE FROM huespedes WHERE idHuesped=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHuesped));
        return conexion.consulta(sql, parametros);
    }

    public static ArrayList<Huesped> listarHuespedes() {
        String sql = "SELECT * FROM huespedes";
        List<List<Object>> resultado = conexion.seleccion(sql, (List)null);
        ArrayList<Huesped> Huespedes = new ArrayList();
        Iterator var3 = resultado.iterator();

        while(var3.hasNext()) {
            List<Object> registro = (List)var3.next();
            int idHuesped = (Integer)registro.get(0);
            String nombre = String.valueOf(registro.get(1));
            String aPaterno = String.valueOf(registro.get(2));
            String aMaterno = String.valueOf(registro.get(3));
            String tipoDocumento = String.valueOf(registro.get(4));
            int numDocumento = (Integer)registro.get(5);
            String fechaNacimiento = String.valueOf(registro.get(6));
            String telefono = String.valueOf(registro.get(7));
            String pais = String.valueOf(registro.get(8));
            Huespedes.add(new Huesped(idHuesped,nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais));
        }

        return Huespedes;
    }

    public static boolean modificarHuesped(Huesped e) {
        String sql = "UPDATE huespedes SET nombre=?, aPaterno=?, aMaterno=?, tipoDocumento=?, nroDocumento=?, fechaNacimiento=?, telefono=?, pais=? WHERE idHuesped=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(e.getNombre(), e.getaPaterno(), e.getaMaterno(), e.getTipo_documento(), e.getNum_documento(), e.getFecha_nacimiento(), e.getTelefono(), e.getPais(), e.getIdHuesped()));
        return conexion.consulta(sql, parametros);
    }
}
