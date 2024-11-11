package Persistencia;
import Dominio.Habitacion;
import Dominio.Hotel;
import Utils.AppSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PEHotel {
    private static Conexion conexion = new Conexion();

    public static boolean agregarHotel(Hotel h) {
        String sql = "INSERT INTO hoteles(nombre, ciudad, pais, cantidadEstrellas, direccion, zona) VALUES(?, ?, ?, ?, ?, ?)";
        ArrayList<Object> parametros = new ArrayList<>(Arrays.asList(
                h.getNombre(),
                h.getCiudad(),
                h.getPais(),
                h.getCantidadEstrellas(),
                h.getDireccion(),
                h.getZona()
        ));
        try {
            if (conexion.consulta(sql,parametros)){
                return true;
            }
            else {
                System.out.println("Existió un problema al agregar el hotel");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static Hotel buscarHotel(int pIdHotel) {
        String sql = "SELECT idHotel, nombre, ciudad, pais, cantidadEstrellas, direccion, zona FROM hoteles WHERE idHotel=?";

        try{
            ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHotel));
            Iterator var3 = conexion.seleccion(sql, parametros).iterator();
            if (var3.hasNext()) {
                List<Object> registro = (List)var3.next();
                int idHotel = (Integer) registro.get(0);
                String nombre = String.valueOf(registro.get(1));
                String ciudad = String.valueOf(registro.get(2));
                String pais = String.valueOf(registro.get(3));
                int cantidadEstrellas = (Integer) registro.get(4);
                String direccion = String.valueOf(registro.get(5));
                String zona = String.valueOf(registro.get(6));

                Hotel unHotel = new Hotel(idHotel, nombre, ciudad, pais, cantidadEstrellas, direccion, zona);
                return unHotel;

            } else {
                return null;
            }

        }
        catch (AppSQLException var6) {
            System.out.println("Ocurrio un error al consultar el hotel");
            System.out.println(var6.getMessage());
            return null;
        }

    }

    public static boolean eliminarHotel(int pIdHotel) {
        String sql = "DELETE FROM hoteles WHERE idHotel=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHotel));
        try {
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se eliminó el hotel con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al eliminar el hotel");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static ArrayList<Hotel> listarHoteles() {
        String sql = "SELECT * FROM hoteles";
        try{
            List<List<Object>> resultado = conexion.seleccion(sql, (List)null);
            ArrayList<Hotel> Hoteles = new ArrayList();
            Iterator var3 = resultado.iterator();

            while(var3.hasNext()) {
                List<Object> registro = (List)var3.next();
                int idHotel = (Integer)registro.get(0);
                String nombre = String.valueOf(registro.get(1));
                String ciudad = String.valueOf(registro.get(2));
                String pais = String.valueOf(registro.get(3));
                int cantidadDeEstrellas = (Integer)registro.get(4);
                String direccion = String.valueOf(registro.get(5));
                String zona = String.valueOf(registro.get(6));
                Hoteles.add(new Hotel(idHotel,nombre, ciudad, pais, cantidadDeEstrellas, direccion, zona));
            }

            return Hoteles;
        } catch (AppSQLException var11) {
            AppSQLException e = var11;
            System.out.println(e.getMessage());
            return null;
        }
    }



    public static boolean modificarHotel(Hotel h) {
        String sql = "UPDATE hoteles SET nombre=?, ciudad=?, pais=?, cantidadEstrellas=?, direccion=?, zona=? WHERE idHotel=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(h.getNombre(), h.getCiudad(), h.getPais(), h.getCantidadEstrellas(), h.getDireccion(), h.getZona(), h.getIdHotel()));
        try{
            if (conexion.consulta(sql, parametros)) {
                System.out.println("Se modificó el hotel con éxito");
                return true;
            } else {
                System.out.println("Existió un problema al modificar el hotel");
                return false;
            }
        } catch (AppSQLException var5) {
            AppSQLException e = var5;
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static List<Hotel> listarHotelesConHabitaciones() {
        String sql = "SELECT h.idHotel, h.nombre AS hotelNombre, h.ciudad, h.pais, h.cantidadEstrellas, "
                + "h.direccion, h.zona, "
                + "hb.idHabitacion, hb.capacidadCamas, hb.camaMatrimonial, hb.aireAcondicionado, "
                + "hb.balcon, hb.vista, hb.amenities, hb.ocupada "
                + "FROM hoteles h "
                + "LEFT JOIN habitaciones hb ON h.idHotel = hb.idHotel "
                + "ORDER BY h.idHotel, hb.idHabitacion";

        List<Hotel> listaHoteles = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(Conexion.getCadenaDeConexion());
             PreparedStatement comando = conexion.prepareStatement(sql);
             ResultSet resultSet = comando.executeQuery()) {

            Hotel hotelActual = null;

            while (resultSet.next()) {
                int currentHotelId = resultSet.getInt("idHotel");


                if (hotelActual == null || currentHotelId != hotelActual.getIdHotel()) {
                    hotelActual = new Hotel(
                            currentHotelId,
                            resultSet.getString("hotelNombre"),
                            resultSet.getString("ciudad"),
                            resultSet.getString("pais"),
                            resultSet.getInt("cantidadEstrellas"),
                            resultSet.getString("direccion"),
                            resultSet.getString("zona")
                    );
                    listaHoteles.add(hotelActual);
                }

                
                if (resultSet.getInt("idHabitacion") > 0) {
                    Habitacion habitacion = new Habitacion(
                            resultSet.getInt("idHabitacion"),
                            resultSet.getInt("capacidadCamas"),
                            resultSet.getBoolean("camaMatrimonial"),
                            resultSet.getBoolean("aireAcondicionado"),
                            resultSet.getBoolean("balcon"),
                            resultSet.getBoolean("vista"),
                            resultSet.getString("amenities"),
                            resultSet.getBoolean("ocupada"),
                            resultSet.getInt("idHotel")
                            //DUDANDO
                    );

                    if (resultSet.getBoolean("ocupada")) {
                        hotelActual.agregarHabitacionOcupada(habitacion);
                    } else {
                        hotelActual.agregarHabitacion(habitacion);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al listar hoteles con habitaciones: " + e.getMessage());
        }

        return listaHoteles;
    }


}
