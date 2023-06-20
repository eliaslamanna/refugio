package src.Controller;

import src.Model.Adoptante;

import java.util.List;

public class AdoptanteController {
    private static AdoptanteController instancia;
    private List<Adoptante> adoptantes;

    private AdoptanteController(){}

    public static AdoptanteController getInstancia() {
        if (instancia == null)
            instancia = new AdoptanteController();
        return instancia;
    }
}
