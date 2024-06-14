package hotel;

import java.util.Date;

/**
 *
 * @author Luisa Lucio
 */
interface Habitaciones {
   
    int obtenerNumeroHabitacion();
    boolean disponibilidad();
    void reservarHabitacion(String nombre, String apellidos, String documento, Date fechaIngreso);
    void salidaHuesped(int numeroHabitación, Date fechaSalida);
    double valorPorPagar();
    String generarTipoHabitacion();
}
