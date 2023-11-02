package LDS.Digesto.Digital.Interface.Service;

import LDS.Digesto.Digital.Entity.Archive;
import java.util.List;

/**
 * Esta interfaz define un servicio que gestiona operaciones relacionadas con la entidad "Archive." Proporciona métodos
 * para recuperar, guardar nuevos, eliminar y buscar archivos por su identificador.
 *
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public interface IArchiveService {
    /**
     * Recupera una lista de archivos almacenados en el sistema.
     *
     * @return Una lista de archivos.
     */
    public List<Archive> getArchive();

    /**
     * Guarda un archivo en el sistema.
     *
     * @param archivo El archivo a guardar.
     */
    public void saveArchive(Archive archivo);

    /**
     * Elimina un archivo del sistema por su identificador.
     *
     * @param id El identificador del archivo a eliminar.
     */
    public void deleteArchive(Integer id);

    /**
     * Busca un archivo por su identificador.
     *
     * @param id El identificador del archivo a buscar.
     * @return El archivo encontrado, o null si no se encuentra.
     */
    public Archive findArchive(Integer id);
}
