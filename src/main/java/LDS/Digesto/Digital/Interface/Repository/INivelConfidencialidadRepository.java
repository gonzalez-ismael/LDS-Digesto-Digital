package LDS.Digesto.Digital.Interface.Repository;

import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz define un repositorio para la entidad "NivelConfidencialidad," permitiendo acceder y gestionar registros
 * en la base de datos. Extiende JpaRepository, lo que proporciona operaciones de acceso a datos
 * predefinidas como guardar, recuperar, actualizar y eliminar Niveles de Confidencialidad.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Repository
public interface INivelConfidencialidadRepository extends JpaRepository<NivelConfidencialidad, Integer> {
    
}
