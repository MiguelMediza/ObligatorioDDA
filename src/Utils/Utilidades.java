package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utilidades {
    public static LocalDate validarFecha (String pFecha) throws AppException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha;

        try{
            fecha = LocalDate.parse(pFecha, formatter);
            LocalDate hoy = LocalDate.now();
            if(fecha.isBefore(hoy)){
                throw new AppException("La fecha de la reserva debe ser posterior a la de hoy");
            }
        }
        catch(DateTimeParseException e){
            throw new AppException("El formato de la fecha no es valido");
        }
        return fecha;
    }

    public static LocalDate validarFechaMayor18(String pFecha) throws AppException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(pFecha, formatter);
            LocalDate hoy = LocalDate.now();
            LocalDate hace18Anios = hoy.minusYears(18); // Calcula la fecha límite (hace 18 años)

            if (fecha.isAfter(hace18Anios)) {
                throw new AppException("Debe ser mayor a 18 años para agendarse como huesped");
            }
        } catch (DateTimeParseException e) {
            throw new AppException("El formato de la fecha no es válido");
        }

        return fecha;
    }

    public static LocalDate validarFechaSinRestriccion (String pFecha) throws AppException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha;

        try{
            fecha = LocalDate.parse(pFecha, formatter);
            LocalDate hoy = LocalDate.now();
        }
        catch(DateTimeParseException e){
            throw new AppException("El formato de la fecha no es valido");
        }
        return fecha;
    }
}
