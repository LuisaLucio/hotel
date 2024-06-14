package hotel;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class HabitacionesSimples extends InformaciónHuesped {

    public HabitacionesSimples(int numeroHabitación) {
        super(numeroHabitación, 80.000);
    }

    @Override
    public String generarTipoHabitacion() {
        return "Habitación simple";
    }

}
