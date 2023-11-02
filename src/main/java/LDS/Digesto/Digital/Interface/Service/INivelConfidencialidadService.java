package LDS.Digesto.Digital.Interface.Service;

import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import java.util.List;

/**
 * Esta interfaz define un servicio que gestiona operaciones relacionadas con la entidad "NivelConfidencialidad." Proporciona métodos
 * para recuperar, guardar nuevos, eliminar y buscar NivelConfidencialidad por su identificador.
 *
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public interface INivelConfidencialidadService {
    /**
     * Recupera una lista de los niveles de confidencialidad almacenados en el sistema.
     *
     * @return Una lista de niveles de confidencialidad.
     */
    public List<NivelConfidencialidad> getNivelConfidencialidad();

    /**
     * Guarda un nivel de confidencialidad en el sistema.
     *
     * @param nivelConfidencialidad El nivel de confidencialidad a guardar.
     */
    public void saveNivelConfidencialidad(NivelConfidencialidad nivelConfidencialidad);

    /**
     * Elimina un nivel de confidencialidaddel sistema por su identificador.
     *
     * @param id El identificador del nivel de confidencialidad a eliminar.
     */
    public void deleteNivelConfidencialidad(Integer id);

    /**
     * Busca un nivel de confidencialidad por su identificador.
     *
     * @param id El identificador del nivel de confidencialidad a buscar.
     * @return El nivel de confidencialidad encontrado, o null si no se encuentra.
     */
    public NivelConfidencialidad findNivelConfidencialidad(Integer id);
}
