package LDS.Digesto.Digital.Service;

import LDS.Digesto.Digital.Entity.Reparticion;
import LDS.Digesto.Digital.Interface.Repository.IReparticionRepository;
import LDS.Digesto.Digital.Interface.Service.IReparticionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es una implementación de la interfaz IReparticionService y proporciona servicios para gestionar reparticiones en el sistema.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Service
public class ReparticionService implements IReparticionService{
    @Autowired IReparticionRepository iReparticionRepos;
    
    @Override
    public List<Reparticion> getReparticion() {
        List<Reparticion> reparticiones = iReparticionRepos.findAll();
        return reparticiones;
    }

    @Override
    public void saveReparticion(Reparticion reparticion) {
        iReparticionRepos.save(reparticion);
    }

    @Override
    public void deleteReparticion(Integer id) {
        iReparticionRepos.deleteById(id);
    }

    @Override
    public Reparticion findReparticion(Integer id) {
        Reparticion r = iReparticionRepos.findById(id).orElse(null);
        return r;
    }
    
}
