package hotel;

import java.util.Date;

/**
 *
 * @author Usuario
 */
abstract class InformaciónHuesped implements Habitaciones {
    protected final int numeroHabitación;
    protected boolean disponibilidad;
    protected String nombre,apellido, documento;
    protected Date fechaIngreso, fechaSalida;
    protected final double tarifaPorDia;

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public void setApellidos(String apellidos) {
        this.apellido = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    
    
    public InformaciónHuesped(int numeroHabitación, double tarifaPorDia) {
        this.numeroHabitación = numeroHabitación;
        this.disponibilidad = true;
        this.tarifaPorDia = tarifaPorDia;
    }

    @Override
    public int obtenerNumeroHabitacion() {
        return numeroHabitación;
    }

    
    @Override
    public boolean disponibilidad() {
        return disponibilidad;
    }

   
    public void reservarHabitacion (String nombre, String apellidos, String documento, Date fechaIngreso){
        if (disponibilidad) {
            this.nombre = nombre;
            this.apellido = apellidos;
            this.documento = documento;
            this.fechaIngreso = fechaIngreso;
            this.disponibilidad = false;
        } else {
            throw new IllegalStateException("La habitación no está disponible");
        }
    }


    public void salidaHuesped(int numeroHabitación, Date fechaSalida) {
        if (!disponibilidad && fechaSalida.after(fechaIngreso)) {
            this.fechaSalida = fechaSalida;
            this.disponibilidad = true;
        } else {
            throw new IllegalStateException("Fecha de salida inválida o la habitación no está reservada");
        }
    }


    @Override
    public double valorPorPagar() {
        if (fechaSalida != null && fechaIngreso != null) {
            long diferencia = fechaSalida.getTime() - fechaIngreso.getTime();
            long diasDiferencia = diferencia / (24 * 60 * 60 * 1000);
            return diasDiferencia * tarifaPorDia;
        }
        return 0;
    }

    @Override
    public abstract String generarTipoHabitacion();

    @Override
    public String toString() {
        return String.format("%-30s %-20s %-10s", numeroHabitación, generarTipoHabitacion(), disponibilidad());
    }
}
