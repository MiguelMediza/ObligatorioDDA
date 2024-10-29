package Persistencia;

import Controladora.Controladora;
import Dominio.Huesped;
import Utils.AppSQLException;
import Utils.Utilidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PEHuesped {
    private static Conexion conexion = new Conexion();
    private static Controladora controladora = new Controladora();

    public PEHuesped() {
    }

    public static boolean agregarHuesped(Huesped e) {
        String sql = "INSERT INTO huespedes(nombre, aPaterno, aMaterno, tipoDocumento, nroDocumento, fechaNacimiento, telefono, pais) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(e.getNombre(), e.getaPaterno(), e.getaMaterno(), e.getTipo_documento(), e.getNum_documento(), e.getFecha_nacimiento(), e.getTelefono(), e.getPais()));
        try {
            if (conexion.consulta(sql,parametros)){
                System.out.println("Se agrego el huesped con exito");
                return true;
            }
            else {
                System.out.println("Existió un problema al agregar el huesped");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException ex = var5;
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static Huesped buscarHuesped(int pIdHuedped) {
        String sql = "SELECT idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, nroDocumento, fechaNacimiento, telefono, pais FROM huespedes WHERE idHuesped=?";

        try{
            ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHuedped));
            Iterator var3 = conexion.seleccion(sql, parametros).iterator();
            if (var3.hasNext()) {
                List<Object> registro = (List)var3.next();
                int idHuesped = (Integer)registro.get(0);
                String nombre = String.valueOf(registro.get(1));
                String aPaterno = String.valueOf(registro.get(2));
                String aMaterno = String.valueOf(registro.get(3));
                String tipoDocumento = String.valueOf(registro.get(4));
                LocalDate fechaNacimiento = null;
                int numDocumento = (Integer)registro.get(5);
                try{
                    fechaNacimiento = Utilidades.validarFechaSinRestriccion(registro.get(6).toString());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }

                String telefono = String.valueOf(registro.get(7));
                String pais = String.valueOf(registro.get(8));
                Huesped unHuesped = new Huesped(idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais);
                return unHuesped;
            } else {
                System.out.println("No se encontro el huesped");
                return null;
            }
        }
        catch (AppSQLException var6) {
            System.out.println("Ocurrio un error al consultar el huesped");
            System.out.println(var6.getMessage());
            return null;
        }
    }

    public static Huesped buscarHuespedPorCi(int pHuespedCi) {
        String sql = "SELECT idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, nroDocumento, fechaNacimiento, telefono, pais FROM huespedes WHERE nroDocumento=?";

        try{
            ArrayList<Object> parametros = new ArrayList(Arrays.asList(pHuespedCi));
            Iterator var3 = conexion.seleccion(sql, parametros).iterator();
            if (var3.hasNext()) {
                LocalDate fechaNacimiento = null;
                List<Object> registro = (List)var3.next();
                int idHuesped = (Integer)registro.get(0);
                String nombre = String.valueOf(registro.get(1));
                String aPaterno = String.valueOf(registro.get(2));
                String aMaterno = String.valueOf(registro.get(3));
                String tipoDocumento = String.valueOf(registro.get(4));
                int numDocumento = (Integer)registro.get(5);
                try{
                    fechaNacimiento = Utilidades.validarFechaSinRestriccion(registro.get(6).toString());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                String telefono = String.valueOf(registro.get(7));
                String pais = String.valueOf(registro.get(8));
                Huesped unHuesped = new Huesped(idHuesped, nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais);
                return unHuesped;
            } else {
                return null;
            }
        }
        catch (AppSQLException var6) {
            System.out.println("Ocurrio un error al consultar el huesped");
            System.out.println(var6.getMessage());
            return null;
        }

    }

    public static boolean eliminarHuesped(int pIdHuesped) {
        String sql = "DELETE FROM huespedes WHERE idHuesped=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHuesped));
        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se eliminó el huesped con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar el huesped");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Huesped> listarHuespedes() {
        String sql = "SELECT * FROM huespedes";
        try{
            List<List<Object>> resultado = conexion.seleccion(sql, (List)null);
            ArrayList<Huesped> Huespedes = new ArrayList();
            Iterator var3 = resultado.iterator();

            while(var3.hasNext()) {
                LocalDate fechaNacimiento = null;
                List<Object> registro = (List)var3.next();
                int idHuesped = (Integer)registro.get(0);
                String nombre = String.valueOf(registro.get(1));
                String aPaterno = String.valueOf(registro.get(2));
                String aMaterno = String.valueOf(registro.get(3));
                String tipoDocumento = String.valueOf(registro.get(4));
                int numDocumento = (Integer)registro.get(5);
                try{
                    fechaNacimiento = Utilidades.validarFechaSinRestriccion(registro.get(6).toString());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                String telefono = String.valueOf(registro.get(7));
                String pais = String.valueOf(registro.get(8));
                Huespedes.add(new Huesped(idHuesped,nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais));
            }

            return Huespedes;
        } catch (AppSQLException var11) {
            AppSQLException e = var11;
            System.out.println(e.getMessage());
            return null;
        }
    }



    public static boolean modificarHuesped(Huesped e) {
        String sql = "UPDATE huespedes SET nombre=?, aPaterno=?, aMaterno=?, tipoDocumento=?, nroDocumento=?, fechaNacimiento=?, telefono=?, pais=? WHERE idHuesped=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(e.getNombre(), e.getaPaterno(), e.getaMaterno(), e.getTipo_documento(), e.getNum_documento(), e.getFecha_nacimiento(), e.getTelefono(), e.getPais(), e.getIdHuesped()));
        try{
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se modificó el huesped con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar el huesped");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException ex = var5;
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
