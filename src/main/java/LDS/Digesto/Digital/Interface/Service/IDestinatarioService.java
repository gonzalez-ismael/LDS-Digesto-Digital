package LDS.Digesto.Digital.Interface.Service;

import LDS.Digesto.Digital.Entity.Destinatario;
import java.util.List;

/**
 * Esta interfaz define un servicio que gestiona operaciones relacionadas con la entidad "Destinatario." Proporciona métodos
 * para recuperar, guardar nuevos, eliminar y buscar destinatario por su identificador.
 *
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public interface IDestinatarioService {
    /**
     * Recupera una lista de destinatario almacenados en el sistema.
     *
     * @return Una lista de destinatarios.
     */
    public List<Destinatario> getDestinatarios();

    /**
     * Guarda un destinatario en el sistema.
     *
     * @param destinatario El destinatario a guardar.
     */
    public void saveDestinatario(Destinatario destinatario);

    /**
     * Elimina un destinatario del sistema por su identificador.
     *
     * @param id El identificador del destinatario a eliminar.
     */
    public void deleteDestinatario(Integer id);

    /**
     * Busca un destinatario por su identificador.
     *
     * @param id El identificador del destinatario a buscar.
     * @return El destinatario encontrado, o null si no se encuentra.
     */
    public Destinatario findDestinatario(Integer id);
}
