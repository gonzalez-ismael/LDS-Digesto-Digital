package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Reparticion;
import LDS.Digesto.Digital.Interface.Service.IReparticionService;
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
 * Controlador que gestiona las operaciones relacionadas con reparticiones.
 * Proporciona endpoints para consultar, crear, editar y eliminar reparticiones.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con reparticiones y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@RestController
public class ReparticionController {
    @Autowired IReparticionService iReparticionServi;
    
    @GetMapping("/reparticiones/traer")
    public List<Reparticion> getReparticion() {
        return iReparticionServi.getReparticion();
    }

    @PostMapping("/reparticion/crear")
    public HttpStatus createReparticion(@RequestBody Reparticion reparticion) {
        iReparticionServi.saveReparticion(reparticion);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/reparticion/eliminar/{id}")
    public HttpStatus deleteReparticion(@PathVariable Integer id) {
        iReparticionServi.deleteReparticion(id);
        return HttpStatus.NO_CONTENT;
    }
    
    @PutMapping("/reparticion/modificar/{id}")
    public HttpStatus editReparticion(@PathVariable Integer id,
            @RequestBody Map<String, String> requestBody) {
        
        String nuevaReparticion = requestBody.get("reparticion");
        Reparticion reparticion = iReparticionServi.findReparticion(id);
        reparticion.setReparticion(nuevaReparticion);

        iReparticionServi.saveReparticion(reparticion);
        return HttpStatus.OK;
    }
}
