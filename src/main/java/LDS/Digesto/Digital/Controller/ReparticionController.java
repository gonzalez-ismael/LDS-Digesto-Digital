package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Reparticion;
import LDS.Digesto.Digital.Interface.Service.IReparticionService;
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
 * Controlador que gestiona las operaciones relacionadas con reparticiones.
 * Proporciona endpoints para consultar, crear, editar y eliminar reparticiones.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con reparticiones y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Controller
public class ReparticionController {
    @Autowired IReparticionService iReparticionServi;
    
    @GetMapping("/reparticion/traer")
    public List<Reparticion> getReparticion() {
        return iReparticionServi.getReparticion();
    }

    @PostMapping("/reparticion/crear")
    public String createReparticion(@RequestBody Reparticion reparticion) {
        iReparticionServi.saveReparticion(reparticion);
        return "La reparticion fue creada correctamente.";
    }

    @DeleteMapping("/reparticion/eliminar/{id}")
    public String deleteReparticion(@PathVariable Integer id) {
        iReparticionServi.deleteReparticion(id);
        return "La reparticion fue eliminada correctamente.";
    }
    
    @PutMapping("/reparticion/modificar/{id}")
    public Reparticion editReparticion(@PathVariable Integer id,
            @RequestParam("reparticion") String nuevaReparticion) {
        
        Reparticion reparticion = iReparticionServi.findReparticion(id);
        
        reparticion.setReparticion(nuevaReparticion);

        iReparticionServi.saveReparticion(reparticion);
        return reparticion;
    }
}
