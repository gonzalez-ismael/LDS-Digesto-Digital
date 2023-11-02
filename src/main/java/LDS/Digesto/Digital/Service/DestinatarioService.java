package LDS.Digesto.Digital.Service;

import LDS.Digesto.Digital.Entity.Destinatario;
import LDS.Digesto.Digital.Interface.Repository.IDestinatarioRepository;
import LDS.Digesto.Digital.Interface.Service.IDestinatarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es una implementación de la interfaz IDestinatarioService y proporciona servicios para gestionar destinatarios en el sistema.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Service
public class DestinatarioService implements IDestinatarioService{
    @Autowired IDestinatarioRepository iDestinatarioRepos;

    @Override
    public List<Destinatario> getDestinatarios() {
        List<Destinatario> destinarios = iDestinatarioRepos.findAll();
        return destinarios;
    }

    @Override
    public void saveDestinatario(Destinatario destinatario) {
        iDestinatarioRepos.save(destinatario);
    }

    @Override
    public void deleteDestinatario(Integer id) {
        iDestinatarioRepos.deleteById(id);
    }

    @Override
    public Destinatario findDestinatario(Integer id) {
        Destinatario d = iDestinatarioRepos.findById(id).orElse(null);
        return d;
    }
    
}
