package hotel;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class HabitacionesMultiples extends InformaciónHuesped {

    public HabitacionesMultiples(int numeroHabitación) {
        super(numeroHabitación, 120.000);
    }
    
    @Override
    public String generarTipoHabitacion() {
       return "Habitación multiple";
    }
}

