package src.DTO;

public class AdopcionDTO {
    private AdoptanteDTO adoptanteDTO;
    private AnimalDTO mascotaDTO;
    private SeguimientoDTO seguimientoDTO;

    public AdopcionDTO(AdoptanteDTO adoptanteDTO, AnimalDTO mascotaDTO, SeguimientoDTO seguimientoDTO) {
        this.adoptanteDTO = adoptanteDTO;
        this.mascotaDTO = mascotaDTO;
        this.seguimientoDTO = seguimientoDTO;
    }

    public AdoptanteDTO getAdoptante() {
        return adoptanteDTO;
    }

    public AnimalDTO getMascota() {
        return mascotaDTO;
    }

    public SeguimientoDTO getSeguimiento() {
        return seguimientoDTO;
    }
}
