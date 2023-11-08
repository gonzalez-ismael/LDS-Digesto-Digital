package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Destinatario;
import LDS.Digesto.Digital.Interface.Service.IDestinatarioService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que gestiona las operaciones relacionadas con destinatarios.
 * Proporciona endpoints para consultar, crear, editar y eliminar destinatarios.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con destinatarios y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@RestController
public class DestinatarioController {
    @Autowired IDestinatarioService iDestinatarioServi;
    
    @GetMapping("/destinatarios/traer")
    public List<Destinatario> getDestinatarios() {
        return iDestinatarioServi.getDestinatarios();
    }

    @PostMapping("/destinatario/crear")
    public HttpStatus createDestinatario(@RequestBody Destinatario destinatario) {
        iDestinatarioServi.saveDestinatario(destinatario);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/destinatario/eliminar/{id}")
    public HttpStatus deleteDestinatario(@PathVariable Integer id) {
        iDestinatarioServi.deleteDestinatario(id);
        return HttpStatus.NO_CONTENT;
    }
    
    @PutMapping("/destinatario/modificar/{id}")
    public HttpStatus editDestinatario(@PathVariable Integer id,
            @RequestBody Map<String, String> requestBody) {
    
        String nuevoDestinatario = requestBody.get("destinatario");
        Destinatario destinatario = iDestinatarioServi.findDestinatario(id);
        destinatario.setDestinatario(nuevoDestinatario);

        iDestinatarioServi.saveDestinatario(destinatario);
        return HttpStatus.OK;
    }
}
