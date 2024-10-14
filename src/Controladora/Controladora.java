//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controladora;

import Dominio.Habitacion;
import Dominio.Hotel;
import Dominio.Huesped;
import Persistencia.PEHotel;
import Persistencia.PEHuesped;
import Persistencia.PEHabitacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Controladora {
    private static Scanner escaner;
    private List<Hotel> hoteles;
    public Controladora() {
        this.hoteles = new ArrayList<>();
    }

    //Huesped
    public void agregarHuesped() {
        System.out.println("AGREGAR Huesped");

        String nombre;
        do {
            System.out.println("Ingrese el nombre del Huesped");
            nombre = escaner.nextLine().trim();
        } while(nombre.isEmpty());

        String aPaterno;
        do {
            System.out.println("Ingrese el apellido paterno del Huesped");
            aPaterno = escaner.nextLine().trim();
        } while(aPaterno.isEmpty());

        String aMaterno;
        do {
            System.out.println("Ingrese el apellido materno del Huesped");
            aMaterno = escaner.nextLine().trim();
        } while(aMaterno.isEmpty());

        String tipoDocumento;
        do {
            System.out.println("Ingrese el tipo de documento del Huesped");
            tipoDocumento = escaner.nextLine().trim();
        } while(tipoDocumento.isEmpty());

        int numDocumento;
        do {
            System.out.println("Ingrese el numero de documento del Huesped");

            try {
                numDocumento = Integer.parseInt(escaner.nextLine().trim());
            } catch (Exception var7) {
                numDocumento = 0;
            }
        } while(numDocumento == 0);

        String fechaNacimiento;
        do {
            System.out.println("Ingrese la fecha de nacimiento del Huesped");
            fechaNacimiento = escaner.nextLine().trim();
        } while(fechaNacimiento.isEmpty());

        String telefono;
        do {
            System.out.println("Ingrese el número de teléfono del Huesped");
            telefono = escaner.nextLine().trim();
        } while(telefono.isEmpty());

        String pais;
        do {
            System.out.println("Ingrese el país del Huesped");
            pais = escaner.nextLine().trim();
        } while(pais.isEmpty());

        Huesped e = new Huesped(nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaNacimiento, telefono, pais);
        if (PEHuesped.agregarHuesped(e)) {
            System.out.println("Se agregó el Huesped con éxito");
        } else {
            System.out.println("Hubo un problema para agregar");
        }

    }

    public void eliminarHuesped() {
        System.out.println("Eliminar Huesped");
        Huesped e = this.buscarHuesped();
        if (e == null) {
            System.out.println("No se encontró el Huesped");
        } else if (PEHuesped.eliminarHuesped(e.getIdHuesped())) {
            System.out.println("El Huesped se eliminó con éxito");
        } else {
            System.out.println("El Huesped no se pudo eliminar");
        }

    }

    public void listarHuespedes() {
        System.out.println("Listado de Huespedes");
        Iterator var1 = PEHuesped.listarHuespedes().iterator();

        while(var1.hasNext()) {
            Huesped e = (Huesped)var1.next();
            System.out.println(e.toString());
        }

    }

    public void modificarHuesped() {
        System.out.println("Modificar Huesped");
        Huesped e = this.buscarHuesped();
        if (e == null) {
            System.out.println("No se encontró el Huesped");
        } else {
            System.out.println("Ingrese el nombre (" + e.getNombre() + ")");
            String nombre = escaner.nextLine().trim();
            if (!nombre.isEmpty()) {
                e.setNombre(nombre);
            }

            System.out.println("Ingrese el apellido paterno (" + e.getaPaterno() + ")");
            String aPaterno = escaner.nextLine().trim();
            if (!aPaterno.isEmpty()) {
                e.setaPaterno(aPaterno);
            }

            System.out.println("Ingrese el apellido materno (" + e.getaMaterno() + ")");
            String aMaterno = escaner.nextLine().trim();
            if (!aMaterno.isEmpty()) {
                e.setaMaterno(aMaterno);
            }

            System.out.println("Ingrese el tipo de documento (" + e.getTipo_documento() + ")");
            String tipoDocumento = escaner.nextLine().trim();
            if (!tipoDocumento.isEmpty()) {
                e.setTipo_documento(tipoDocumento);
            }

            System.out.println("Ingrese el número de documento (" + e.getNum_documento() + ")");
            int nroDocumento;
            try {
                nroDocumento = Integer.parseInt(escaner.nextLine().trim());
                e.setNum_documento(nroDocumento);
            } catch (Exception var11) {

            }

            System.out.println("Ingrese fecha de nacimiento (" + e.getFecha_nacimiento() + ")");
            String fechaNacimiento = escaner.nextLine().trim();
            if (!fechaNacimiento.isEmpty()) {
                e.setFecha_nacimiento(fechaNacimiento);
            }

            System.out.println("Ingrese el teléfono (" + e.getTelefono() + ")");
            String telefono = escaner.nextLine().trim();
            if (!telefono.isEmpty()) {
                e.setTelefono(telefono);
            }

            System.out.println("Ingrese el país (" + e.getPais() + ")");
            String pais = escaner.nextLine().trim();
            if (!pais.isEmpty()) {
                e.setPais(pais);
            }

            if (PEHuesped.modificarHuesped(e)) {
                System.out.println("Se modificó con éxito");
            } else {
                System.out.println("No se pudo modificar");
            }
        }

    }

    public void traerHuesped() {
        System.out.println("Buscar por cédula");
        Huesped e = this.buscarHuespedPorCI();
        if (e == null) {
            System.out.println("No se encontró el Huesped");
        } else {
            System.out.println(e.toString());
        }
    }

    private Huesped buscarHuesped() {
        int idHuesped;
        do {
            System.out.println("Ingrese el ID del Huesped");

            try {
                idHuesped = Integer.parseInt(escaner.nextLine());
            } catch (Exception var3) {
                idHuesped = 0;
            }
        } while(idHuesped == 0);

        return PEHuesped.buscarHuesped(idHuesped);
    }

    private Huesped buscarHuespedPorCI() {
        int HuespedCi;
        do {
            System.out.println("Ingrese la CI del Huesped");

            try {
                HuespedCi = Integer.parseInt(escaner.nextLine());
            } catch (Exception var3) {
                HuespedCi = 0;
            }
        } while(HuespedCi == 0);

        return PEHuesped.buscarHuespedPorCi(HuespedCi);
    }

    //Hotel
    public void agregarHotel() {
        System.out.println("AGREGAR HOTEL");

        String nombre;
        do {
            System.out.println("Ingrese el nombre del Hotel");
            nombre = escaner.nextLine().trim();
        } while (nombre.isEmpty());

        String ciudad;
        do {
            System.out.println("Ingrese la ciudad del Hotel");
            ciudad = escaner.nextLine().trim();
        } while (ciudad.isEmpty());

        String pais;
        do {
            System.out.println("Ingrese el país del Hotel");
            pais = escaner.nextLine().trim();
        } while (pais.isEmpty());

        int cantidadEstrellas;
        do {
            System.out.println("Ingrese la cantidad de estrellas del Hotel (1-5)");
            try {
                cantidadEstrellas = Integer.parseInt(escaner.nextLine().trim());
            } catch (Exception e) {
                cantidadEstrellas = 0; // Valor por defecto si hay error
            }
        } while (cantidadEstrellas < 1 || cantidadEstrellas > 5);

        String direccion;
        do {
            System.out.println("Ingrese la dirección del Hotel");
            direccion = escaner.nextLine().trim();
        } while (direccion.isEmpty());

        String zona;
        do {
            System.out.println("Ingrese la zona del Hotel");
            zona = escaner.nextLine().trim();
        } while (zona.isEmpty());

        Hotel nuevoHotel = new Hotel(nombre, ciudad, pais, cantidadEstrellas, direccion, zona);
        hoteles.add(nuevoHotel);
        if (PEHotel.agregarHotel(nuevoHotel)) {
            System.out.println("Se agregó el Hotel con éxito");
        } else {
            System.out.println("Hubo un problema para agregar");
        }
    }

    private Hotel buscarHotel() {
        int idHotel;
        do {
            System.out.println("Ingrese el ID del Hotel");

            try {
                idHotel = Integer.parseInt(escaner.nextLine());
            } catch (Exception var3) {
                idHotel = 0;
            }
        } while(idHotel == 0);

        return PEHotel.buscarHotel(idHotel);
    }

    public void eliminarHotel() {
        System.out.println("Eliminar Hotel");
        Hotel h = this.buscarHotel();
        if (h == null) {
            System.out.println("No se encontró el Hotel");
        } else if (PEHotel.eliminarHotel(h.getIdHotel())) {
            System.out.println("El Hotel se eliminó con éxito");
        } else {
            System.out.println("El Hotel no se pudo eliminar");
        }

    }

    public void listarHoteles() {
        System.out.println("Listado de Hoteles");
        Iterator var1 = PEHotel.listarHoteles().iterator();

        while(var1.hasNext()) {
            Hotel h = (Hotel)var1.next();
            System.out.println(h.toString());
        }

    }

    public void modificarHotel() {
        System.out.println("Modificar Hotel");
        Hotel h = this.buscarHotel();
        if (h == null) {
            System.out.println("No se encontró el Hotel");
        } else {
            System.out.println("Ingrese el nombre del hotel (" + h.getNombre() + ")");
            String nombre = escaner.nextLine().trim();
            if (!nombre.isEmpty()) {
                h.setNombre(nombre);
            }

            System.out.println("Ingrese la ciudad (" + h.getCiudad() + ")");
            String ciudad = escaner.nextLine().trim();
            if (!ciudad.isEmpty()) {
                h.setCiudad(ciudad);
            }

            System.out.println("Ingrese el país (" + h.getPais() + ")");
            String pais = escaner.nextLine().trim();
            if (!pais.isEmpty()) {
                h.setPais(pais);
            }

            System.out.println("Ingrese la cantidad de estrellas (" + h.getCantidadEstrellas() + ")");
            int estrellas;
            try {
                estrellas = Integer.parseInt(escaner.nextLine().trim());
                h.setCantidadEstrellas(estrellas);
            } catch (NumberFormatException var11) {
                System.out.println("Valor inválido para estrellas");
            }

            System.out.println("Ingrese la dirección (" + h.getDireccion() + ")");
            String direccion = escaner.nextLine().trim();
            if (!direccion.isEmpty()) {
                h.setDireccion(direccion);
            }

            System.out.println("Ingrese la zona/barrio (" + h.getZona() + ")");
            String zona = escaner.nextLine().trim();
            if (!zona.isEmpty()) {
                h.setZona(zona);
            }

            if (PEHotel.modificarHotel(h)) {
                System.out.println("Se modificó el hotel con éxito");
            } else {
                System.out.println("No se pudo modificar el hotel");
            }
        }
    }

    public void agregarHabitacionAHotel(Habitacion habitacion, Hotel hotel) {
        hotel.agregarHabitacion(habitacion);
    }


    //Habitacion

    public void agregarHabitacion() {
        System.out.println("AGREGAR Habitación");

        int capacidadCamas;
        do {
            System.out.println("Ingrese la capacidad de camas de la habitación");
            try {
                capacidadCamas = Integer.parseInt(escaner.nextLine().trim());
            } catch (Exception e) {
                capacidadCamas = 0;
            }
        } while (capacidadCamas <= 0);

        boolean camaMatrimonial;
        String opcionCama;
        do {
            System.out.println("¿La habitación tiene cama matrimonial? (true/false)");
            opcionCama = escaner.nextLine().trim().toLowerCase();
            if (opcionCama.equals("true")) {
                camaMatrimonial = true;
            }else{
                camaMatrimonial = false;
            }

        } while (!opcionCama.equals("true") && !opcionCama.equals("false"));


        boolean aireAcondicionado;
        String opcionAire;
        do {
            System.out.println("¿La habitación tiene aire acondicionado? (true/false)");
            opcionAire = escaner.nextLine().trim().toLowerCase();
            if (opcionAire.equals("true")) {
                aireAcondicionado = true;
            }
            else{
                aireAcondicionado = false;
            }

        } while (!opcionAire.equals("true") && !opcionAire.equals("false"));

        boolean balcon;
        String opcionBalcon;
        do {
            System.out.println("¿La habitación tiene balcón? (true/false)");
            opcionBalcon = escaner.nextLine().trim().toLowerCase();
            if (opcionBalcon.equals("true")) {
                balcon = true;
            }
            else{
                balcon = false;
            }

        } while (!opcionBalcon.equals("true") && !opcionBalcon.equals("false"));


        boolean vista;
        String opcionVista;
        do {
            System.out.println("¿La habitación tiene vista? (true/false)");
            opcionVista = escaner.nextLine().trim().toLowerCase();
            if (opcionVista.equals("true")) {
                vista = true;
            }
            else{
                vista = false;
            }
        } while (!opcionVista.equals("true") && !opcionVista.equals("false"));

        String amenities;
        do {
            System.out.println("Amenities/Comodidades de la habitación");
            amenities = escaner.nextLine().trim();
        } while (amenities.isEmpty());

        int idHotel;
        do {
            System.out.println("Ingrese el ID del hotel");

            try {
                Hotel hotel = PEHotel.buscarHotel(Integer.parseInt(escaner.nextLine().trim()));
                idHotel = hotel.getIdHotel();
            } catch (Exception var7) {
                System.out.println("No se encontro el Hotel, intente de nuevo");
                idHotel = 0;
            }
        } while(idHotel == 0);


        Habitacion habitacion = new Habitacion( capacidadCamas, camaMatrimonial, aireAcondicionado, balcon, vista, amenities, false,idHotel );
        Hotel hotel = PEHotel.buscarHotel(idHotel);
        assert hotel != null;
        this.agregarHabitacionAHotel(habitacion, hotel);


        if (PEHabitacion.agregarHabitacon(habitacion)) {
            System.out.println("Se agregó la habitación con éxito");
        } else {
            System.out.println("Hubo un problema para agregar la habitación");
        }
    }

    public void eliminarHabitacion() {
        System.out.println("Eliminar Habitación");
        Habitacion h = this.buscarHabitacion();
        if (h == null) {
            System.out.println("No se encontró la habitación");
        } else if (PEHabitacion.eliminarHabitacion(h.getIdHabitacion())) {
            System.out.println("La habitación se eliminó con éxito");
        } else {
            System.out.println("la habitación no se pudo eliminar");
        }

    }

    public void listarHabitaciones() {
        System.out.println("Listado de Habitaciones");
        Iterator var1 = PEHabitacion.listarHabitaciones().iterator();

        while(var1.hasNext()) {
            Habitacion h = (Habitacion) var1.next();
            System.out.println(h.toString());
        }

    }

    public void imprimirHotelesConHabitaciones(List<Hotel> hoteles) {
        if (hoteles.isEmpty()) {
            System.out.println("No hay hoteles disponibles.");
            return;
        }

        for (Hotel hotel : hoteles) {
            System.out.println("Hotel: " + hotel.getNombre());
            System.out.println("Ciudad: " + hotel.getCiudad());
            System.out.println("País: " + hotel.getPais());
            System.out.println("Estrellas: " + hotel.getCantidadEstrellas());
            System.out.println("Dirección: " + hotel.getDireccion());
            System.out.println("Zona: " + hotel.getZona());
            System.out.println("Habitaciones Disponibles:");

            if (hotel.getHabitacionesDisponibles().isEmpty()) {
                System.out.println("  No hay habitaciones disponibles.");
            } else {
                for (Habitacion habitacion : hotel.getHabitacionesDisponibles()) {
                    imprimirHabitacion(habitacion);
                }
            }

            System.out.println("Habitaciones Ocupadas:");
            if (hotel.getHabitacionesOcupadas().isEmpty()) {
                System.out.println("  No hay habitaciones ocupadas.");
            } else {
                for (Habitacion habitacion : hotel.getHabitacionesOcupadas()) {
                    imprimirHabitacion(habitacion);
                }
            }
            System.out.println("---------------------------------------------------");
        }
    }

    private void imprimirHabitacion(Habitacion habitacion) {
        System.out.println("  ID Habitación: " + habitacion.getIdHabitacion());
        System.out.println("  Capacidad de Camas: " + habitacion.getCapacidadCamas());
        System.out.println("  Cama Matrimonial: " + (habitacion.isCamaMatrimonial() ? "Sí" : "No"));
        System.out.println("  Aire Acondicionado: " + (habitacion.isAireAcondicionado() ? "Sí" : "No"));
        System.out.println("  Balcón: " + (habitacion.isBalcon() ? "Sí" : "No"));
        System.out.println("  Vista: " + habitacion.getVista());
        System.out.println("  Amenities: " + habitacion.getAmenities());
        System.out.println("  Ocupada: " + (habitacion.isOcupada() ? "Sí" : "No"));
        System.out.println();
    }

    public Habitacion buscarHabitacion() {
        int idHabitacion;
        do {
            System.out.println("Ingrese el ID de la habitacion");

            try {
                idHabitacion = Integer.parseInt(escaner.nextLine());
            } catch (Exception var3) {
                idHabitacion = 0;
            }
        } while(idHabitacion == 0);

        return PEHabitacion.buscarHabitacion(idHabitacion);
    }

    public void modificarHabitacion() {
        System.out.println("Modificar Habitación");
        Habitacion habitacion = this.buscarHabitacion();

        if (habitacion == null) {
            System.out.println("No se encontró la habitación");
        } else {
            System.out.println("Ingrese la capacidad de camas (" + habitacion.getCapacidadCamas() + ")");
            int capacidadCamas;
            try {
                capacidadCamas = Integer.parseInt(escaner.nextLine().trim());
                habitacion.setCapacidadCamas(capacidadCamas);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido para la capacidad de camas");
            }

            System.out.println("¿La cama es matrimonial? (Actual: " + (habitacion.isCamaMatrimonial() ? "Sí" : "No") + ")");
            String camaMatrimonial = escaner.nextLine().trim().toLowerCase();
            if (!camaMatrimonial.isEmpty()) {
                habitacion.setCamaMatrimonial(camaMatrimonial.equals("si") || camaMatrimonial.equals("sí"));
            }

            System.out.println("¿Tiene aire acondicionado? (Actual: " + (habitacion.isAireAcondicionado() ? "Sí" : "No") + ")");
            String aireAcondicionado = escaner.nextLine().trim().toLowerCase();
            if (!aireAcondicionado.isEmpty()) {
                habitacion.setAireAcondicionado(aireAcondicionado.equals("si") || aireAcondicionado.equals("sí"));
            }

            System.out.println("¿Tiene balcón? (Actual: " + (habitacion.isBalcon() ? "Sí" : "No") + ")");
            String balcon = escaner.nextLine().trim().toLowerCase();
            if (!balcon.isEmpty()) {
                habitacion.setBalcon(balcon.equals("si") || balcon.equals("sí"));
            }

            System.out.println("¿Tiene vista? (Actual: " + (habitacion.getVista() ? "Sí" : "No") + ")");
            String vista = escaner.nextLine().trim();
            if (!vista.isEmpty()) {
                habitacion.setVista(Boolean.parseBoolean(vista));
            }

            System.out.println("Ingrese los amenities (" + habitacion.getAmenities() + ")");
            String amenities = escaner.nextLine().trim();
            if (!amenities.isEmpty()) {
                habitacion.setAmenities(amenities);
            }

            System.out.println("¿La habitación está ocupada? (Actual: " + (habitacion.isOcupada() ? "Sí" : "No") + ")");
            String ocupada = escaner.nextLine().trim().toLowerCase();
            if (!ocupada.isEmpty()) {
                habitacion.setOcupada(ocupada.equals("si") || ocupada.equals("sí"));
            }

            if (PEHabitacion.modificarHabitacion(habitacion)) {
                System.out.println("Se modificó la habitación con éxito");
            } else {
                System.out.println("No se pudo modificar la habitación");
            }
        }
    }


    static {
        escaner = new Scanner(System.in);
    }
}

