package Persistencia;
import Dominio.Habitacion;
import Dominio.Hotel;

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
        return conexion.consulta(sql, parametros);
    }

    public static Hotel buscarHotel(int pIdHotel) {
        String sql = "SELECT idHotel, nombre, ciudad, pais, cantidadEstrellas, direccion, zona FROM hoteles WHERE idHotel=?";

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

    public static boolean eliminarHotel(int pIdHotel) {
        String sql = "DELETE FROM hoteles WHERE idHotel=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(pIdHotel));
        return conexion.consulta(sql, parametros);
    }

    public static ArrayList<Hotel> listarHoteles() {
        String sql = "SELECT * FROM hoteles";
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
    }

    public static boolean modificarHotel(Hotel h) {
        String sql = "UPDATE hoteles SET nombre=?, ciudad=?, pais=?, cantidadEstrellas=?, direccion=?, zona=? WHERE idHotel=?";
        ArrayList<Object> parametros = new ArrayList(Arrays.asList(h.getNombre(), h.getCiudad(), h.getPais(), h.getCantidadEstrellas(), h.getDireccion(), h.getZona(), h.getIdHotel()));
        return conexion.consulta(sql, parametros);
    }

//    public static void listarHotelesConHabitaciones() {
//        String sql = "SELECT h.idHotel, h.nombre AS hotelNombre, h.ciudad, h.pais, h.cantidadEstrellas, "
//                + "h.direccion, h.zona, "
//                + "hb.idHabitacion, hb.capacidadCamas, hb.camaMatrimonial, hb.aireAcondicionado, "
//                + "hb.balcon, hb.vista, hb.amenities, hb.ocupada "
//                + "FROM hoteles h "
//                + "LEFT JOIN habitaciones hb ON h.idHotel = hb.idHotel "
//                + "ORDER BY h.idHotel, hb.idHabitacion";
//
//        // Conexión a la base de datos
//        try (Connection conexion = DriverManager.getConnection(Conexion.getCadenaDeConexion());
//             PreparedStatement comando = conexion.prepareStatement(sql);
//             ResultSet resultSet = comando.executeQuery()) {
//
//            int lastHotelId = -1;
//
//            // Procesar los resultados
//            while (resultSet.next()) {
//                int currentHotelId = resultSet.getInt("idHotel");
//
//                // Si el hotel cambia, imprimimos los datos del nuevo hotel
//                if (currentHotelId != lastHotelId) {
//                    System.out.println("\nHotel: " + resultSet.getString("hotelNombre")
//                            + " (" + resultSet.getInt("cantidadEstrellas") + " estrellas), "
//                            + resultSet.getString("ciudad") + ", " + resultSet.getString("pais"));
//                    System.out.println("Dirección: " + resultSet.getString("direccion")
//                            + ", Zona: " + resultSet.getString("zona"));
//                    System.out.println("Habitaciones disponibles:");
//                    lastHotelId = currentHotelId;
//                }
//
//                // Si tiene habitaciones asociadas, imprimimos sus detalles
//                if (resultSet.getInt("idHabitacion") > 0) {
//                    System.out.println("- Habitación " + resultSet.getInt("idHabitacion")
//                            + ": " + resultSet.getInt("capacidadCamas") + " camas, "
//                            + (resultSet.getBoolean("camaMatrimonial") ? "Matrimonial" : "Individuales") + ", "
//                            + (resultSet.getBoolean("aireAcondicionado") ? "Con Aire Acondicionado, " : "Sin Aire Acondicionado, ")
//                            + (resultSet.getBoolean("balcon") ? "Con Balcón, " : "Sin Balcón, ")
//                            + (resultSet.getBoolean("vista") ? "Con vista, " : "Sin Vista, ")
//                            + "Amenities: " + resultSet.getString("amenities") + ", "
//                            + (resultSet.getBoolean("ocupada") ? "Ocupada" : "Disponible"));
//                } else {
//                    System.out.println("- No hay habitaciones disponibles.");
//                }
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error al listar hoteles con habitaciones: " + e.getMessage());
//        }
//    }

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

            // Procesar los resultados
            while (resultSet.next()) {
                int currentHotelId = resultSet.getInt("idHotel");

                // Si es un nuevo hotel, creamos el objeto Hotel
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

                // Agregar habitaciones a la lista correspondiente
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
