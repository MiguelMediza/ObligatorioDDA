//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controladora;

import Dominio.*;
import Persistencia.*;

import Utils.AppException;
import Utils.Utilidades;
import java.time.LocalDate;
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
        LocalDate fechaDate2=null;
        do {
            System.out.println("Fecha de nacimiento(YYYY-MM-DD)");
            fechaNacimiento = escaner.nextLine();
            try{
                fechaDate2 = Utilidades.validarFechaMayor18(fechaNacimiento);
            }
            catch(AppException a){
                fechaDate2 = null;
                System.out.println(a.getMessage());
            }
            catch (Exception e) {
                fechaDate2 = null;
                System.out.println(e.getMessage());
            }
        } while (fechaDate2 == null);

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

        Huesped e = new Huesped(nombre, aPaterno, aMaterno, tipoDocumento, numDocumento, fechaDate2, telefono, pais);
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

            String fechaNacimiento;
            LocalDate fechaDate2=null;
            do {
                System.out.println("Fecha de nacimiento(YYYY-MM-DD)");
                fechaNacimiento = escaner.nextLine();
                try{
                    fechaDate2 = Utilidades.validarFechaMayor18(fechaNacimiento);
                    e.setFecha_nacimiento(fechaDate2);
                }
                catch(AppException a){
                    fechaDate2 = null;
                    System.out.println(a.getMessage());
                }
                catch (Exception ex) {
                    fechaDate2 = null;
                    System.out.println(ex.getMessage());
                }
            } while (fechaDate2 == null);

//            System.out.println("Ingrese fecha de nacimiento (" + e.getFecha_nacimiento() + ")");
//            String fechaNacimiento = escaner.nextLine().trim();
//            if (!fechaNacimiento.isEmpty()) {
//                e.setFecha_nacimiento(fechaNacimiento);
//            }

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


    //Tarifa

    public void agregarTarifa() {
        System.out.println("AGREGAR TARIFA");

        int monto;
        do {
            System.out.println("Ingrese el monto de la tarifa");
            try {
                monto = Integer.parseInt(escaner.nextLine().trim());
            } catch (Exception e) {
                monto = 0; // Valor por defecto si hay error
            }
        } while (monto == 0);

        String fechaVigencia;
        LocalDate fechaDate=null;
        do {
            System.out.println("Fecha de vigencia(YYYY-MM-DD)");
            fechaVigencia = escaner.nextLine();
            try{
                fechaDate = Utilidades.validarFecha(fechaVigencia);
            }
            catch(AppException a){
                fechaDate = null;
                System.out.println(a.getMessage());
            }
            catch (Exception e) {
                fechaDate = null;
                System.out.println(e.getMessage());
            }
        } while (fechaDate == null);


        Tarifa nuevaTarifa = new Tarifa(monto, fechaVigencia);
        if (PETarifa.agregarTarifa(nuevaTarifa)) {
            System.out.println("Se agregó la tarifa con exito");
        } else {
            System.out.println("Hubo un problema para agregar");
        }
    }

    public void eliminarTarifa() {
        System.out.println("Eliminar Tarifa");
        Tarifa t = this.buscarTarifa();
        if (t == null) {
            System.out.println("No se encontró la tarifa");
        } else if (PETarifa.eliminarTarifa(t.getId())) {
            System.out.println("La tarifa se eliminó con éxito");
        } else {
            System.out.println("La tarifa no se pudo eliminar");
        }

    }

    public Tarifa buscarTarifa() {
        int idTarifa;
        do {
            System.out.println("Ingrese el ID de la tarifa");

            try {
                idTarifa = Integer.parseInt(escaner.nextLine());
            } catch (Exception var3) {
                idTarifa = 0;
            }
        } while(idTarifa == 0);

        return PETarifa.buscarTarifa(idTarifa);
    }

    public void listarTarifas() {
        System.out.println("Listado de tarifas");
        Iterator var1 = PETarifa.listarTarifas().iterator();

        while(var1.hasNext()) {
            Tarifa t = (Tarifa) var1.next();
            System.out.println(t.toString());
        }

    }


    //Reserva

    public void agregarReserva() {
        System.out.println("AGREGAR RESERVA");

        int idResponsable;
        Huesped responsable = null;
        do {
            System.out.println("Ingrese el id del Responsable de la reserva(Huesped)");
            try {
                idResponsable = Integer.parseInt(escaner.nextLine().trim());
                responsable = PEHuesped.buscarHuesped(idResponsable);
                if (responsable == null) {
                    idResponsable = 0;
                }

            } catch (Exception e) {
                idResponsable = 0; // Valor por defecto si hay error
            }
        } while (idResponsable == 0);

        int idHabitacion;
        Habitacion habitacion = null;
        do {
            System.out.println("Ingrese el ID de la habitacion");
            try {
                idHabitacion = Integer.parseInt(escaner.nextLine().trim());
                habitacion = PEHabitacion.buscarHabitacion(idHabitacion);

                if (habitacion == null) {
                    idHabitacion = 0;
                }
                if(habitacion.isOcupada()){
                    idHabitacion = 0;
                    System.out.println("La habitacion ingresada se encuentra ocupada");
                }
            } catch (Exception e) {
                idHabitacion = 0; // Valor por defecto si hay error
            }

        } while (idHabitacion == 0 );

        int cantPersonas;
        do {
            System.out.println("Ingrese la cantidad de personas");

            try {
                cantPersonas = Integer.parseInt(escaner.nextLine().trim());
            } catch (Exception var7) {
                cantPersonas = 0;
            }
        } while(cantPersonas == 0);

        String fechaReserva;
        LocalDate fechaDate=null;
        do {
            System.out.println("Fecha de reserva(YYYY-MM-DD)");
            fechaReserva = escaner.nextLine();
            try{
                fechaDate = Utilidades.validarFecha(fechaReserva);
            }
            catch(AppException a){
                fechaDate = null;
                System.out.println(a.getMessage());
            }
            catch (Exception e) {
                fechaDate = null;
                System.out.println(e.getMessage());
            }
        } while (fechaDate == null);

        //Al crear la reserva se inicializa como sin pagar siempre
        boolean pagado = false;

        int seniaValor=0;
        Tarifa tarifaActual = PETarifa.buscarTarifa(1);
        int pagoTotal = (cantPersonas * tarifaActual.getMonto());
        Double minimoPago = ((cantPersonas * tarifaActual.getMonto()) * 0.2);
        do {
            System.out.println("La tarifa actual por persona es: $" + tarifaActual.getMonto());
            System.out.println("Ingrese valor a pagar de la estadia: ('Minimo pago requerido: ' $"+minimoPago+") Pago total es: $" + pagoTotal + " Si Paga el total de la estadia, se congelara el precio");
            try {
                seniaValor = Integer.parseInt(escaner.nextLine().trim());
                if (seniaValor < minimoPago) {
                    System.out.println("- ERROR! El valor ingresado es menor al Minimo requerido");
                    seniaValor=0;
                }
                if (seniaValor > pagoTotal) {
                    System.out.println("- ERROR! El valor ingresado es mayor al pago total de la estadia");
                    seniaValor=0;
                }
                if (seniaValor == pagoTotal) {
                    pagado = true;
                }
            } catch (Exception var7) {
                seniaValor = 0;
            }
        } while(seniaValor == 0);

        String observaciones;
        do {
            System.out.println("Observaciones");
            observaciones = escaner.nextLine().trim();
        } while (observaciones.isEmpty());

        Reserva nuevaReserva = new Reserva(responsable, habitacion, cantPersonas, fechaReserva, seniaValor, pagado, observaciones);
        if (PEReserva.agregarReserva(nuevaReserva)) {
            if (PEHabitacion.ActualizarDisponibilidad( true, habitacion.getIdHabitacion())){
                System.out.println("Se actualizo el estado de la habitación con exito");
            }
            else{
                System.out.println("Hubo un error al actualizar el estado de la habitación");
            }
            System.out.println("Reserva realizada con exito!");
        } else {
            System.out.println("Hubo un problema para agregar");
        }
    }


    public void eliminarReserva() {
        System.out.println("Eliminar Reserva");
        Reserva r = this.buscarReserva();
        if (r == null) {
            System.out.println("No se encontró la reserva");
        } else if (PEHabitacion.ActualizarDisponibilidad( false, r.getHabitacion().getIdHabitacion())) {
            if (PEReserva.eliminarReserva(r.getIdReserva())){
                System.out.println("La reserva se eliminó con éxito");
            }
            else{
                System.out.println("La reserva no se pudo eliminar");
            }
            System.out.println("Se actualizo el estado de la habitación con exito");
        } else {
            System.out.println("Hubo un error al actualizar el estado de la habitación");
        }

    }

    public Reserva buscarReserva() {
        int idReserva;
        do {
            System.out.println("Ingrese el ID de la Reserva");

            try {
                idReserva = Integer.parseInt(escaner.nextLine());
            } catch (Exception var3) {
                idReserva = 0;
            }
        } while(idReserva == 0);

        return PEReserva.buscarReserva(idReserva);
    }

    public void listarReservas() {
        System.out.println("Listado de Reservas");
        Iterator var1 = PEReserva.listarReservas().iterator();

        while(var1.hasNext()) {
            Reserva r = (Reserva) var1.next();
            System.out.println(r.toString());
        }

    }

    public void RealizarPago(){
        System.out.println("Realizar Pago");

        int idReserva;
        Reserva reserva = null;
        do {
            System.out.println("Ingrese el id de la reserva a pagar");
            try {
                idReserva = Integer.parseInt(escaner.nextLine().trim());
                reserva = PEReserva.buscarReserva(idReserva);
                if (reserva == null) {
                    idReserva = 0;
                }
                if (reserva.isPagado()){
                    System.out.println("Esta reserva ya esta completamente pagada");
                    idReserva=1;
                }
                if(!reserva.isPagado()){
                    Tarifa tarifaActual = PETarifa.buscarTarifa(1);
                    int cantidadPersonas = reserva.getCantidadPersonas();
                    int montoTotal = (tarifaActual.getMonto() * cantidadPersonas);
                    double montoPago = reserva.getSeniaValor();
                    double restantePagar = (montoTotal - montoPago);
                    System.out.println("La reserva esta realizada para: " + cantidadPersonas + " personas.");
                    System.out.println("La tarifa actual es de: $" + tarifaActual.getMonto() + " por persona.");
                    System.out.println("Seña de: $" + montoPago+ " realizada, le falta pagar $" + restantePagar );
                    System.out.println("Por favor ingrese: " + restantePagar + " para finalizar el pago!");

                    int opcion = 0;
                    do{
                        try{
                            int montoPagar = Integer.parseInt(escaner.nextLine().trim());
                            if (montoPagar > restantePagar) {
                                System.out.println("El monto ingresado es mayor a TOTAL a pagar faltante, vuelva a ingresar!");
                                opcion = 0;
                            }
                            if (montoPagar != restantePagar) {
                                System.out.println("Debe pagar el total restante!");
                                opcion=0;
                            }

                            if(montoPagar == restantePagar){
                                System.out.println("Pago de la reserva exitoso!");
                                PEReserva.ActualizarPago(idReserva);
                                opcion = 1;
                            }

                        }
                        catch (Exception var8) {
                            opcion = 0;
                        }
                    }
                    while (opcion == 0);
                }

            } catch (Exception e) {
                idReserva = 0; // Valor por defecto si hay error
            }
        } while (idReserva == 0);


    }



    //CONSULTAS


    //CONSULTAS DE HOTELES
    public void ConsultaDeHoteles(){
        System.out.println("Consulta Hoteles");
        System.out.println("1. Por ciudad");
        System.out.println("2. Por nombre");
        System.out.println("3. Cantidad de estrellas");
        System.out.println("4. Salir");
        int opcion=0;
        opcion = Integer.parseInt(escaner.nextLine().trim());
        do {
           switch(opcion){
               case 1:
                   System.out.println("Listado de Hoteles por ciudad");
                   System.out.println("Ingrese la ciudad del hotel [ Vacio para salir ]");
                   String ciudad = escaner.nextLine().trim();
                   if (ciudad.isEmpty()) {
                       opcion = 4;
                       break;
                   }
                   System.out.println("----------------------------");
                   System.out.println("Listado de Hoteles en " + ciudad);
                   System.out.println(listarHotelesPorCiudad(ciudad));
                   break;
               case 2:
                   System.out.println("Listado de Hoteles por nombre");
                   System.out.println("Ingrese la nombre del hotel [ Vacio para salir ]");
                   String nombre = escaner.nextLine().trim();
                   if (nombre.isEmpty()) {
                       opcion = 4;
                       break;
                   }
                   System.out.println("----------------------------");
                   System.out.println("Listado de Hoteles llamados: " + nombre);
                   System.out.println(listarHotelesPorNombre(nombre));
                   break;
               case 3:
                   System.out.println("Listado de Hoteles por Cantidad de estrellas");
                   System.out.println("Ingrese la cantidad de estrellas del hotel [ Vacio para salir ]");
                   int cantidad = Integer.parseInt(escaner.nextLine().trim());
                   if (cantidad <= 0) {
                       opcion = 4;
                       break;
                   }
                   System.out.println("----------------------------");
                   System.out.println("Listado de Hoteles con: " + cantidad + " de estrellas");
                   System.out.println(listarHotelesPorCantidadEstrellas(cantidad));
                   break;

                   default:
                       System.out.println("Opcion no valida");
                       opcion = 4;
                       break;
           }
        }
        while (opcion != 4);
    }

    public static ArrayList<Hotel> listarHotelesPorCiudad(String ciudadBuscada) {
        ArrayList<Hotel> todosLosHoteles = PEHotel.listarHoteles();
        ArrayList<Hotel> hotelesFiltrados = new ArrayList<>();

        // Filtrar hoteles que están en la ciudad especificada
        for (Hotel hotel : todosLosHoteles) {
            if (hotel.getCiudad().equalsIgnoreCase(ciudadBuscada)) {
                hotelesFiltrados.add(hotel);
            }
        }
        if(hotelesFiltrados.isEmpty()){
            System.out.println("No existen hoteles agregados en: " + ciudadBuscada);
            return null;
        }
        return hotelesFiltrados;
    }

    public static ArrayList<Hotel> listarHotelesPorNombre(String nombre) {
        ArrayList<Hotel> todosLosHoteles = PEHotel.listarHoteles();
        ArrayList<Hotel> hotelesFiltrados = new ArrayList<>();

        // Filtrar hoteles por nombre
        for (Hotel hotel : todosLosHoteles) {
            if (hotel.getNombre().equalsIgnoreCase(nombre)) {
                hotelesFiltrados.add(hotel);
            }
        }
        if(hotelesFiltrados.isEmpty()){
            System.out.println("No existen hoteles con el nombre: " + nombre);
            return null;
        }

        return hotelesFiltrados;
    }

    public static ArrayList<Hotel> listarHotelesPorCantidadEstrellas(int cantidadEstrellas) {
        ArrayList<Hotel> todosLosHoteles = PEHotel.listarHoteles();
        ArrayList<Hotel> hotelesFiltrados = new ArrayList<>();

        // Filtrar hoteles que están en la ciudad especificada
        for (Hotel hotel : todosLosHoteles) {
            if (hotel.getCantidadEstrellas() == (cantidadEstrellas)) {
                hotelesFiltrados.add(hotel);
            }
        }
        if(hotelesFiltrados.isEmpty()){
            System.out.println("No existen hoteles agregados con: " + cantidadEstrellas + " estrellas");
            return null;
        }

        return hotelesFiltrados;
    }


    //CONSULTAS DE RESERVAS POR RANGO DE FECHAS
    public static ArrayList<Reserva> listarReservasEnRangoFechas() {
        ArrayList<Reserva> todasLasReservas = PEReserva.listarReservas();
        ArrayList<Reserva> reservasFiltradas = new ArrayList<>();

        String fecha1;
        LocalDate fechaDate=null;
        do {
            System.out.println("Ingrese la primera fecha(YYYY-MM-DD)");
            fecha1 = escaner.nextLine();
            try{
                fechaDate = Utilidades.validarFechaSinRestriccion(fecha1);
            }
            catch(AppException a){
                fechaDate = null;
                System.out.println(a.getMessage());
            }
            catch (Exception e) {
                fechaDate = null;
                System.out.println(e.getMessage());
            }
        } while (fechaDate == null);

        String fecha2;
        LocalDate fechaDate2=null;
        do {
            System.out.println("Ingrese la segunda fecha(YYYY-MM-DD)");
            fecha2 = escaner.nextLine();
            try{
                fechaDate2 = Utilidades.validarFechaSinRestriccion(fecha2);
            }
            catch(AppException a){
                fechaDate2 = null;
                System.out.println(a.getMessage());
            }
            catch (Exception e) {
                fechaDate2 = null;
                System.out.println(e.getMessage());
            }
        } while (fechaDate2 == null);

        // Filtrar reservas por rango de fechas
        for (Reserva reserva : todasLasReservas) {
            LocalDate comodin = null;
            try{
                comodin = Utilidades.validarFechaSinRestriccion(reserva.getFechaReserva());
            }
            catch(AppException a){
                comodin = null;
                System.out.println(a.getMessage());
            }

            if (fechaDate.isBefore(comodin) && fechaDate2.isAfter(comodin)) {
                reservasFiltradas.add(reserva);
            }
        }
        if(reservasFiltradas.isEmpty()){
            System.out.println("No existen reservas agregadas entre: " + fecha1 + "," + fechaDate2);
            return null;
        }
        return reservasFiltradas;
    }


    //Filtrar habitaciones con reserva y sin reserva

    public void ConsultaDeHabitaciones(){
        System.out.println("Consulta Habitaciones");
        System.out.println("1. Con Reservas");
        System.out.println("2. Sin Reservas");
        System.out.println("3. Salir");
        int opcion=0;
        opcion = Integer.parseInt(escaner.nextLine().trim());
        do {
            switch(opcion){
                case 1:
                    System.out.println("Listado de habitaciones con reservas");
                    System.out.println(listarHabitacionesConReserva());
                    opcion = 0;
                    break;
                case 2:
                    System.out.println("Listado de habitaciones sin reservas");
                    System.out.println(listarHabitacionesSinReserva());
                    opcion = 0;
                    break;
                case 3:
                    opcion = 0;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    opcion = 0;
                    break;
            }
        }
        while (opcion != 0);
    }

    public static ArrayList<Habitacion> listarHabitacionesConReserva() {
        ArrayList<Habitacion> todasHabitaciones = PEHabitacion.listarHabitaciones();
        ArrayList<Habitacion> habitacionesFiltradas = new ArrayList<>();

        for (Habitacion habitacion : todasHabitaciones) {
            if (habitacion.isOcupada() == true) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        if(habitacionesFiltradas.isEmpty()){
            System.out.println("No existen habitaciones con reservas");
            return null;
        }
        return habitacionesFiltradas;
    }

    public static ArrayList<Habitacion> listarHabitacionesSinReserva() {
        ArrayList<Habitacion> todasHabitaciones = PEHabitacion.listarHabitaciones();
        ArrayList<Habitacion> habitacionesFiltradas = new ArrayList<>();

        for (Habitacion habitacion : todasHabitaciones) {
            if (!habitacion.isOcupada()) {
                habitacionesFiltradas.add(habitacion);
            }
        }
        if(habitacionesFiltradas.isEmpty()){
            System.out.println("No existen habitaciones sin reservas");
            return null;
        }

        return habitacionesFiltradas;
    }

    static {
        escaner = new Scanner(System.in);
    }
}

