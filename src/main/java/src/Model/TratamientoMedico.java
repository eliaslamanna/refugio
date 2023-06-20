package src.Model;

import java.util.Date;
import java.util.List;

public class TratamientoMedico extends ControlPeriodico {
    private boolean _enTratamiento = false;
    private Date _inicioTratamiento;
    private Date _finTratamiento;

    public TratamientoMedico(Date inicioTratamiento, Date finTratamiento) {
        this._enTratamiento = true;
        this._inicioTratamiento = inicioTratamiento;
        this._finTratamiento = finTratamiento;
    }

    public TratamientoMedico(Date inicioTratamiento) {
        this(inicioTratamiento, null);
    }

    public void finalizarTratamiento() {
        this._finTratamiento = new Date();
        this._enTratamiento = false;
    }
}
