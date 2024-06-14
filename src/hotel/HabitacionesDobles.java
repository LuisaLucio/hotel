/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class HabitacionesDobles extends InformaciónHuesped{
    public HabitacionesDobles(int numeroHabitación) {
        super(numeroHabitación, 100.000);
    }
    
    @Override
    public String generarTipoHabitacion() {
        return "Habitación doble";
    }
}
