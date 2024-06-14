package hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Recepcion extends InformaciónHuesped{
    List<Habitaciones> habitaciones= new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Recepcion(int numeroHabitación, double tarifaPorDia) {
        super(numeroHabitación, tarifaPorDia);
    }

    Recepcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void habitacionesOcupadas() {
        for (int i = 1; i <= 10; i++) {
            habitaciones.add(new HabitacionesSimples(i));
        }
        for (int i = 11; i <= 23; i++) {
            habitaciones.add(new HabitacionesDobles(i));
        }
        for (int i = 24; i <= 35; i++) {
            habitaciones.add(new HabitacionesMultiples(i));
        }
    }

    public void reservarHabitacion(){
        System.out.println("Ingrese el número de la habitación a reservar:");
        int numeroHabitacion = sc.nextInt();
        Habitaciones habitacion = obtenerHabitacion(numeroHabitacion);

        if (!habitacion.disponibilidad()) {
            System.out.println("Error: No se puede realizar la reservación. La habitación no está disponible.");
            return;
        }

        System.out.println("Ingrese la fecha de ingreso (YYYY-MM-DD):");
        String fechaIngresoStr = sc.next();
        Date fechaIngreso = java.sql.Date.valueOf(fechaIngresoStr);

        System.out.println("Ingrese el nombre del huésped:");
        String nombre = sc.next();

        System.out.println("Ingrese el apellido del huésped:");
        String apellido = sc.next();

        System.out.println("Ingrese el documento del huésped:");
        String documento = sc.next();

        habitacion.reservarHabitacion(nombre, apellido, documento, fechaIngreso);
        System.out.println("La habitación ha sido reservada.");
    }
    
    public void salidaHuesped(){
        System.out.println("Ingrese el número de la habitación:");
        int numeroHabitacion = sc.nextInt();
        Habitaciones habitacion = obtenerHabitacion(numeroHabitacion);

        if (habitacion.disponibilidad()) {
            System.out.println("Error: La habitación ya está disponible.");
            return;
        }

        System.out.println("Ingrese la fecha de salida (YYYY-MM-DD):");
        String fechaSalidaStr = sc.next();
        Date fechaSalida = java.sql.Date.valueOf(fechaSalidaStr);

        habitacion.salidaHuesped(numeroHabitacion, fechaSalida);
        double costo = habitacion.valorPorPagar();

        System.out.println("El costo de la estancia es: $" + costo);
    }
    public void informeHabitacion() {
        for (Habitaciones habitacion : habitaciones) {
            if (!habitacion.disponibilidad()) {
                System.out.println("Habitación " + habitacion.obtenerNumeroHabitacion() +
                                   "\nFecha de ingreso: " +fechaIngreso +
                                   "\nFecha de salida: " + fechaSalida);
            }
        }
    }

    public void informeHuesped() {
            for (Habitaciones habitacion : habitaciones) {
            if (!habitacion.disponibilidad()) {
                System.out.println("Huésped: " + nombre + " " + apellido + "\nDocumento: " +documento + "\nHabitación: " +obtenerNumeroHabitacion() + "\nTipo: " +habitacion.generarTipoHabitacion() + "\nFecha de ingreso: " + fechaIngreso+ "\nFecha de salida: " +fechaSalida);
            }
        }
    }

    public void listadoHabitaciones() {
        if (habitaciones.isEmpty()) {
            System.out.println("Todas las habitaciones estan disponibles");
            return;
        }
        System.out.printf("%-30s %-20s %-10s%n", "Habitacion", "Tipo", "Disponibilidad");
        System.out.println("------------------------------------------------------------");
        for (Habitaciones habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }


    public Habitaciones obtenerHabitacion(int numeroHabitación) {
        for (Habitaciones habitacion : habitaciones) {
            if (habitacion.obtenerNumeroHabitacion() == numeroHabitación) {
                return habitacion;
            }
        }
        throw new IllegalArgumentException("Número de habitación no encontrado");
    }

    public List<String> obtenerHistorialHabitacion(int numeroHabitación) {
        // Implementar la recuperación de datos históricos para una habitación específica
        return new ArrayList<>();
    }

    public List<String> obtenerHistorialHuesped(String documento) {
        // Implementar la recuperación de datos históricos para un huésped específico
        return new ArrayList<>();
    }

    @Override
    public String generarTipoHabitacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
