package LDS.Digesto.Digital.Service;

import LDS.Digesto.Digital.Entity.Vigencia;
import LDS.Digesto.Digital.Interface.Repository.IVigenciaRepository;
import LDS.Digesto.Digital.Interface.Service.IVigenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es una implementación de la interfaz IVigenciaService y proporciona servicios para gestionar vigencias en el sistema.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Service
public class VigenciaService implements IVigenciaService {

    @Autowired
    IVigenciaRepository vigenciaRepos;

    @Override
    public List<Vigencia> getVigencia() {
        List<Vigencia> vigencias = vigenciaRepos.findAll();
        return vigencias;
    }

    @Override
    public void saveVigencia(Vigencia vigencia) {
        vigenciaRepos.save(vigencia);
    }

    @Override
    public void deleteVigencia(Integer id) {
        vigenciaRepos.deleteById(id);
    }

    @Override
    public Vigencia findVigencia(Integer id) {
        Vigencia v = vigenciaRepos.findById(id).orElse(null);
        return v;
    }

}
