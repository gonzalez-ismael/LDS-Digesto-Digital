package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import LDS.Digesto.Digital.Interface.Service.INivelConfidencialidadService;
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
 * Controlador que gestiona las operaciones relacionadas con los niveles de confidencialidad.
 * Proporciona endpoints para consultar, crear, editar y eliminar niveles de confidencialidad.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con niveles de confidencialidad y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Controller
public class NivelConfidencialidadController {
    @Autowired INivelConfidencialidadService iNivelConfiServi;
    
    @GetMapping("/nivel-confidencialidad/traer")
    public List<NivelConfidencialidad> getNivelConfidencialidad() {
        return iNivelConfiServi.getNivelConfidencialidad();
    }

    @PostMapping("/nivel-confidencialidad/crear")
    public String createNivelConfidencialidad(@RequestBody NivelConfidencialidad nivelConfidencialidad) {
        iNivelConfiServi.saveNivelConfidencialidad(nivelConfidencialidad);
        return "El nivel de confidencialidad fue creado correctamente.";
    }

    @DeleteMapping("/nivel-confidencialidad/eliminar/{id}")
    public String deleteNivelConfidencialidad(@PathVariable Integer id) {
        iNivelConfiServi.deleteNivelConfidencialidad(id);
        return "El nivel de confidencialidad fue eliminado correctamente.";
    }
    
    @PutMapping("/nivel-confidencialidad/modificar/{id}")
    public NivelConfidencialidad editNivelConfidencialidad(@PathVariable Integer id,
            @RequestParam("nivelConfidencialidad") String nuevoNivelConfidencialidad) {
        
        NivelConfidencialidad nivelConfidencialidad = iNivelConfiServi.findNivelConfidencialidad(id);
        
        nivelConfidencialidad.setNivelConfidencialidad(nuevoNivelConfidencialidad);

        iNivelConfiServi.saveNivelConfidencialidad(nivelConfidencialidad);
        return nivelConfidencialidad;
    }
}
