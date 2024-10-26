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
                    controladora.modificarHotel();
                    break;
                case 10:
                    controladora.agregarHabitacion();
                    break;
                case 11:
                    controladora.eliminarHabitacion();
                    break;
                case 12:
                    controladora.listarHabitaciones();
                    break;
                case 13:
                    controladora.modificarHabitacion();
                    break;
                case 14:
                    controladora.agregarTarifa();
                    break;
                case 15:
                    controladora.eliminarTarifa();
                    break;
                case 16:
                    controladora.listarTarifas();
                    break;
                case 17:
                    controladora.agregarReserva();
                    break;
                case 18:
                    controladora.eliminarReserva();
                    break;
                case 19:
                    controladora.listarReservas();
                    break;

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
        System.out.println("8. Listar Hoteles");
        System.out.println("9. Modificar Hotel");
        System.out.println("10. Agregar Habitación");
        System.out.println("11. Eliminar Habitación");
        System.out.println("12. Listar Habitaciones");
        System.out.println("13. Modificar Habitación");
        System.out.println("14. Agregar Tarifa");
        System.out.println("15. Eliminar Tarifa");
        System.out.println("16. Listar Tarifas");
        System.out.println("17. Agregar Reserva");
        System.out.println("18. Eliminar Reserva");
        System.out.println("19. Listar Reservas");

    }

    static {
        escaner = new Scanner(System.in);
        controladora = new Controladora();
    }
}
