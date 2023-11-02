package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Vigencia;
import LDS.Digesto.Digital.Interface.Service.IVigenciaService;
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
 * Controlador que gestiona las operaciones relacionadas con vigencias.
 * Proporciona endpoints para consultar, crear, editar y eliminar vigencias.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con vigencias y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Controller
public class VigenciaController {
    @Autowired IVigenciaService iVigenciaServi;
    
    @GetMapping("/vigencia/traer")
    public List<Vigencia> getVigencia() {
        return iVigenciaServi.getVigencia();
    }

    @PostMapping("/vigencia/crear")
    public String createVigencia(@RequestBody Vigencia vigencia) {
        iVigenciaServi.saveVigencia(vigencia);
        return "La vigencia fue creada correctamente.";
    }

    @DeleteMapping("/vigencia/eliminar/{id}")
    public String deleteVigencia(@PathVariable Integer id) {
        iVigenciaServi.deleteVigencia(id);
        return "La vigencia fue eliminada correctamente.";
    }
    
    @PutMapping("/vigencia/modificar/{id}")
    public Vigencia editVigencia(@PathVariable Integer id,
            @RequestParam("vigencia") String nuevaVigencia) {
        
        Vigencia vigencia = iVigenciaServi.findVigencia(id);
        
        vigencia.setVigencia(nuevaVigencia);

        iVigenciaServi.saveVigencia(vigencia);
        return vigencia;
    }
}
