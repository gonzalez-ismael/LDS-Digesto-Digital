package LDS.Digesto.Digital.Service;

import LDS.Digesto.Digital.Entity.PalabraClave;
import LDS.Digesto.Digital.Interface.Service.IPalabraClaveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import LDS.Digesto.Digital.Interface.Repository.IPalabraClaveRepository;
import org.springframework.stereotype.Service;

/**
 * Esta clase es una implementación de la interfaz IPalabraClaveService y proporciona servicios para gestionar palabra clave en el sistema.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Service
public class PalabraClaveService implements IPalabraClaveService {

    @Autowired
    IPalabraClaveRepository iPalabraRepos;

    @Override
    public List<PalabraClave> getPalabrasClaves() {
        List<PalabraClave> palabrasClaves = iPalabraRepos.findAll();
        return palabrasClaves;
    }

    @Override
    public void savePalabraClave(PalabraClave palabraClave) {
        iPalabraRepos.save(palabraClave);
    }

    @Override
    public void deletePalabraClave(Integer id) {
        iPalabraRepos.deleteById(id);
    }

    @Override
    public PalabraClave findPalabraClave(Integer id) {
        PalabraClave pa = iPalabraRepos.findById(id).orElse(null);
        return pa;
    }

}
