package LDS.Digesto.Digital.Interface.Service;

import LDS.Digesto.Digital.Entity.Vigencia;
import java.util.List;

/**
 * Esta interfaz define un servicio que gestiona operaciones relacionadas con la entidad "Vigencia." Proporciona métodos
 * para recuperar, guardar nuevos, eliminar y buscar vigencias por su identificador.
 *
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public interface IVigenciaService {
    /**
     * Recupera una lista de vigencias almacenados en el sistema.
     *
     * @return Una lista de vigencias.
     */
    public List<Vigencia> getVigencia();

    /**
     * Guarda una vigencia en el sistema.
     *
     * @param vigencia La vigencia a guardar.
     */
    public void saveVigencia(Vigencia vigencia);

    /**
     * Elimina una vigencia del sistema por su identificador.
     *
     * @param id El identificador de la vigencia a eliminar.
     */
    public void deleteVigencia(Integer id);

    /**
     * Busca una vigencia por su identificador.
     *
     * @param id El identificador de la vigencia a buscar.
     * @return La vigencia encontrada, o null si no se encuentra.
     */
    public Vigencia findVigencia(Integer id);
}
