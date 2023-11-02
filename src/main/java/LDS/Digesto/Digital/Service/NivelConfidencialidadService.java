package LDS.Digesto.Digital.Service;

import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import LDS.Digesto.Digital.Interface.Repository.INivelConfidencialidadRepository;
import LDS.Digesto.Digital.Interface.Service.INivelConfidencialidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es una implementación de la interfaz INivelConfidencialidadService y proporciona servicios para gestionar niveles de confidencialidad en el sistema.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Service
public class NivelConfidencialidadService implements INivelConfidencialidadService{
    @Autowired INivelConfidencialidadRepository iNivelesConfiRepos;

    @Override
    public List<NivelConfidencialidad> getNivelConfidencialidad() {
        List<NivelConfidencialidad> nivelesConfidencialidad = iNivelesConfiRepos.findAll();
        return nivelesConfidencialidad;
    }

    @Override
    public void saveNivelConfidencialidad(NivelConfidencialidad nivelConfidencialidad) {
        iNivelesConfiRepos.save(nivelConfidencialidad);
    }

    @Override
    public void deleteNivelConfidencialidad(Integer id) {
        iNivelesConfiRepos.deleteById(id);
    }

    @Override
    public NivelConfidencialidad findNivelConfidencialidad(Integer id) {
        NivelConfidencialidad nc = iNivelesConfiRepos.findById(id).orElse(null);
        return nc;
    }
    
}
