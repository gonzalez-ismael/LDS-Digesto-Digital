package LDS.Digesto.Digital.Interface.Repository;

import LDS.Digesto.Digital.Entity.Archive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz define un repositorio para la entidad "Archive," permitiendo acceder y gestionar registros
 * en la base de datos. Extiende JpaRepository, lo que proporciona operaciones de acceso a datos
 * predefinidas como guardar, recuperar, actualizar y eliminar archivos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Repository
public interface IArchiveRepository extends JpaRepository<Archive, Integer>{
    
}
