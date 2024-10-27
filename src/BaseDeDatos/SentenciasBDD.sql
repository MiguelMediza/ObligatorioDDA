create database obligatorio;

use obligatorio;

create table huespedes(
	idHuesped int(3) auto_increment primary key,
    nombre varchar(50),
    aPaterno varchar(50),
    aMaterno varchar(50),
    tipoDocumento varchar(50),
    nroDocumento int(20),
    fechaNacimiento varchar(20),
    telefono varchar(20),
    pais varchar(50));
    
    
create table hoteles (
    idHotel int(3) auto_increment primary key,
    nombre VARCHAR(100),
    ciudad VARCHAR(100),
    pais VARCHAR(100),
    cantidadEstrellas INT,
    direccion VARCHAR(255),
    zona VARCHAR(100)
);


create table tarifas(
idTarifa int auto_increment primary key,
monto int not null,
fechaVigencia varchar(50));

create table habitaciones (
    idHabitacion int(3) auto_increment primary key,
    capacidadCamas INT,
    camaMatrimonial BOOLEAN,
    aireAcondicionado BOOLEAN,
    balcon BOOLEAN,
    vista BOOLEAN,
    amenities VARCHAR(255),
    ocupada BOOLEAN,
    idHotel int(3),
    FOREIGN KEY (idHotel) REFERENCES hoteles(idHotel)
);

create table reservas(
idReserva int auto_increment primary key,
responsable int references huespedes(idHuesped),
habitacion int references habitaciones(idHabitacion),
cantidadPersonas int,
fechaReserva varchar(20),
seniaPago double,
pagado boolean,
observaciones varchar(250));

SELECT h.idHotel, h.nombre AS hotelNombre, h.ciudad, h.pais, h.cantidadEstrellas, h.direccion, h.zona, 
                   hb.idHabitacion, hb.capacidadCamas, hb.camaMatrimonial, hb.aireAcondicionado, hb.balcon, hb.vista, hb.amenities, hb.ocupada 
                   FROM hoteles h 
                   LEFT JOIN habitaciones hb ON h.idHotel = hb.idHotel 
                   ORDER BY h.idHotel, hb.idHabitacion