package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Destinatario;
import LDS.Digesto.Digital.Interface.Service.IDestinatarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
public class DestinatarioController {
    @Autowired IDestinatarioService iDestinatarioServi;
    
    @GetMapping("/destinatario/traer")
    public List<Destinatario> getDestinatarios() {
        return iDestinatarioServi.getDestinatarios();
    }

    @PostMapping("/destinatario/crear")
    public String createDestinatario(@RequestBody Destinatario destinatario) {
        iDestinatarioServi.saveDestinatario(destinatario);
        return "El destinatario fue creado correctamente.";
    }

    @DeleteMapping("/destinatario/eliminar/{id}")
    public String deleteDestinatario(@PathVariable Integer id) {
        iDestinatarioServi.deleteDestinatario(id);
        return "El destinatario fue eliminado correctamente.";
    }
    
    @PutMapping("/destinatario/modificar/{id}")
    public Destinatario editDestinatario(@PathVariable Integer id,
            @RequestParam("destinatario") String nuevoDestinatario) {
        
        Destinatario destinatario = iDestinatarioServi.findDestinatario(id);
        
        destinatario.setDestinatario(nuevoDestinatario);

        iDestinatarioServi.saveDestinatario(destinatario);
        return destinatario;
    }
}
