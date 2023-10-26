package LDS.Digesto.Digital.Service;

import LDS.Digesto.Digital.Entity.Archive;
import LDS.Digesto.Digital.Interface.Repository.IArchiveRepository;
import LDS.Digesto.Digital.Interface.Service.IArchiveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es una implementación de la interfaz IArchiveService y proporciona servicios para gestionar archivos en el sistema.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Service
public class ArchiveService implements IArchiveService {

    @Autowired
    IArchiveRepository iArchiveRepos;

    @Override
    public List<Archive> getArchive() {
        List<Archive> archivos = iArchiveRepos.findAll();
        return archivos;
    }

    @Override
    public void saveArchive(Archive archivo) {
        iArchiveRepos.save(archivo);
    }

    @Override
    public void deleteArchive(Integer id) {
        iArchiveRepos.deleteById(id);
    }

    @Override
    public Archive findArchive(Integer id) {
        Archive a = iArchiveRepos.findById(id).orElse(null);
        return a;
    }
}
