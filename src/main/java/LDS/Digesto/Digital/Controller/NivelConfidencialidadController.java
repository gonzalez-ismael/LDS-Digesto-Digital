package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import LDS.Digesto.Digital.Interface.Service.INivelConfidencialidadService;
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
 * Controlador que gestiona las operaciones relacionadas con los niveles de confidencialidad.
 * Proporciona endpoints para consultar, crear, editar y eliminar niveles de confidencialidad.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con niveles de confidencialidad y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@RestController
public class NivelConfidencialidadController {
    @Autowired INivelConfidencialidadService iNivelConfiServi;
    
    @GetMapping("/nivel-confidencialidad/traer")
    public List<NivelConfidencialidad> getNivelConfidencialidad() {
        return iNivelConfiServi.getNivelConfidencialidad();
    }

    @PostMapping("/nivel-confidencialidad/crear")
    public HttpStatus createNivelConfidencialidad(@RequestBody NivelConfidencialidad nivelConfidencialidad) {
        iNivelConfiServi.saveNivelConfidencialidad(nivelConfidencialidad);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/nivel-confidencialidad/eliminar/{id}")
    public HttpStatus deleteNivelConfidencialidad(@PathVariable Integer id) {
        iNivelConfiServi.deleteNivelConfidencialidad(id);
        return HttpStatus.NO_CONTENT;
    }
    
    @PutMapping("/nivel-confidencialidad/modificar/{id}")
    public HttpStatus editNivelConfidencialidad(@PathVariable Integer id,
            @RequestBody Map<String, String> requestBody) {
        
        String nuevoNivelConfidencialidad = requestBody.get("nivelConfidencialidad");
        NivelConfidencialidad nivelConfidencialidad = iNivelConfiServi.findNivelConfidencialidad(id);
        nivelConfidencialidad.setNivelConfidencialidad(nuevoNivelConfidencialidad);

        iNivelConfiServi.saveNivelConfidencialidad(nivelConfidencialidad);
        return HttpStatus.OK;
    }
}
