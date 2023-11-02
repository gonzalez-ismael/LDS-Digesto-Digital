package LDS.Digesto.Digital.Interface.Repository;

import LDS.Digesto.Digital.Entity.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz define un repositorio para la entidad "Destinatario," permitiendo acceder y gestionar registros
 * en la base de datos. Extiende JpaRepository, lo que proporciona operaciones de acceso a datos
 * predefinidas como guardar, recuperar, actualizar y eliminar destinatario.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Repository
public interface IDestinatarioRepository extends JpaRepository<Destinatario, Integer>{
    
}
