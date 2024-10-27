import Dominio.Hotel;
import Persistencia.Conexion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Controladora.Controladora;
import Persistencia.PEHotel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner escaner;
    private static Controladora controladora;

    public Main() {
    }

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            System.out.println("Ingrese una opción");
            opcion = Integer.parseInt(escaner.nextLine());
            switch (opcion) {
                case 1:
                    controladora.agregarHuesped();
                    break;
                case 2:
                    controladora.eliminarHuesped();
                    break;
                case 3:
                    controladora.listarHuespedes();
                    break;
                case 4:
                    controladora.modificarHuesped();
                    break;
                case 5:
                    controladora.traerHuesped();
                    break;
                case 6:
                    controladora.agregarHotel();
                    break;
                case 7:
                    controladora.eliminarHotel();
                    break;
                case 8:
                    List<Hotel> hoteles = PEHotel.listarHotelesConHabitaciones();
                    controladora.imprimirHotelesConHabitaciones(hoteles);
                    break;
                case 9:
                    controladora.listarHoteles();
                    break;
                case 10:
                    controladora.modificarHotel();
                    break;
                case 11:
                    controladora.agregarHabitacion();
                    break;
                case 12:
                    controladora.eliminarHabitacion();
                    break;
                case 13:
                    controladora.listarHabitaciones();
                    break;
                case 14:
                    controladora.modificarHabitacion();
                    break;
                case 15:
                    controladora.agregarTarifa();
                    break;
                case 16:
                    controladora.eliminarTarifa();
                    break;
                case 17:
                    controladora.listarTarifas();
                    break;
                case 18:
                    controladora.agregarReserva();
                    break;
                case 19:
                    controladora.eliminarReserva();
                    break;
                case 20:
                    controladora.listarReservas();
                    break;
                case 21:
                    controladora.RealizarPago();
                    break;
                case 22:
                    System.out.println("CONSULTAS");
                    System.out.println("Ingrese la opcion deseada");
                    System.out.println("1. Consulta de Hoteles");
                    System.out.println("2. Reserva por periodo de fechas");
                    System.out.println("3. Habitaciones con y sin reservas");
                    System.out.println("4. Salir");
                    int opcion2 = Integer.parseInt(escaner.nextLine());

                    do {
                        switch (opcion2){
                            case 1:
                                controladora.ConsultaDeHoteles();
                                break;
                            case 2:
                                System.out.println(controladora.listarReservasEnRangoFechas());
                                break;
                            case 3:
                                controladora.ConsultaDeHabitaciones();
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                opcion2 = 4;
                                break;

                        }
                    }
                    while (opcion2 != 4);


            }
        } while(opcion != -1);

    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Agregar huesped");
        System.out.println("2. Eliminar huesped");
        System.out.println("3. Listar huespedes");
        System.out.println("4. Modificar huesped");
        System.out.println("5. Buscar huesped por cédula");
        System.out.println("6. Agregar Hotel");
        System.out.println("7. Eliminar Hotel");
        System.out.println("8. Listar Hoteles con Habitaciones");
        System.out.println("9. Listar Hoteles");
        System.out.println("10. Modificar Hotel");
        System.out.println("11. Agregar Habitación");
        System.out.println("12. Eliminar Habitación");
        System.out.println("13. Listar Habitaciones");
        System.out.println("14. Modificar Habitación");
        System.out.println("15. Agregar Tarifa");
        System.out.println("16. Eliminar Tarifa");
        System.out.println("17. Listar Tarifas");
        System.out.println("18. Agregar Reserva");
        System.out.println("19. Eliminar Reserva");
        System.out.println("20. Listar Reservas");
        System.out.println("21. Realizar Pago");
        System.out.println("22. Consultas");

    }

    static {
        escaner = new Scanner(System.in);
        controladora = new Controladora();
    }
}
