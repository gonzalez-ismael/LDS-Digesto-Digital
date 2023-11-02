package LDS.Digesto.Digital.Interface.Service;

import LDS.Digesto.Digital.Entity.PalabraClave;
import java.util.List;

/**
 * Esta interfaz define un servicio que gestiona operaciones relacionadas con la entidad "Palabra Clave." Proporciona métodos
 * para recuperar palabras claves, guardar nuevas palabras claves, eliminar palabras claves y buscar palabras claves por su identificador.
 *
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public interface IPalabraClaveService {
    /**
     * Recupera una lista de palabras claves almacenadas en el sistema.
     *
     * @return Una lista de palabras claves.
     */
    public List<PalabraClave> getPalabrasClaves();

    /**
     * Guarda una palabra clave en el sistema.
     *
     * @param palabraClave La palabra clave a guardar.
     */
    public void savePalabraClave(PalabraClave palabraClave);

    /**
     * Elimina una palabra clave del sistema por su identificador.
     *
     * @param id El identificador de la palabra clave a eliminar.
     */
    public void deletePalabraClave(Integer id);

    /**
     * Busca una palabra clave por su identificador.
     *
     * @param id El identificador de la palabra clave a buscar.
     * @return La palabra clave encontrada, o null si no se encuentra.
     */
    public PalabraClave findPalabraClave(Integer id);
}
