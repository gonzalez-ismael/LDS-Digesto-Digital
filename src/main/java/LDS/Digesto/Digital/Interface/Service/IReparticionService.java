package LDS.Digesto.Digital.Interface.Service;

import LDS.Digesto.Digital.Entity.Reparticion;
import java.util.List;

/**
 * Esta interfaz define un servicio que gestiona operaciones relacionadas con la entidad "Reparticion." Proporciona métodos
 * para recuperar, guardar nuevos, eliminar y buscar reparticion por su identificador.
 *
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public interface IReparticionService {
    /**
     * Recupera una lista de reparticiones almacenados en el sistema.
     *
     * @return Una lista de reparticiones.
     */
    public List<Reparticion> getReparticion();

    /**
     * Guarda una reparticion en el sistema.
     *
     * @param reparticion La reparticion a guardar.
     */
    public void saveReparticion(Reparticion reparticion);

    /**
     * Elimina una reparticion del sistema por su identificador.
     *
     * @param id El identificador de la reparticion a eliminar.
     */
    public void deleteReparticion(Integer id);

    /**
     * Busca una reparticion por su identificador.
     *
     * @param id El identificador de la reparticion a buscar.
     * @return La reparticion encontrada, o null si no se encuentra.
     */
    public Reparticion findReparticion(Integer id);
}
