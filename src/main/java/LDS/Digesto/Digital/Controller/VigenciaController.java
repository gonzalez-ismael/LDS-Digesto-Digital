package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Vigencia;
import LDS.Digesto.Digital.Interface.Service.IVigenciaService;
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
 * Controlador que gestiona las operaciones relacionadas con vigencias.
 * Proporciona endpoints para consultar, crear, editar y eliminar vigencias.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con vigencias y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@RestController
public class VigenciaController {
    @Autowired IVigenciaService iVigenciaServi;
    
    @GetMapping("/vigencias/traer")
    public List<Vigencia> getVigencia() {
        return iVigenciaServi.getVigencia();
    }

    @PostMapping("/vigencia/crear")
    public HttpStatus createVigencia(@RequestBody Vigencia vigencia) {
        iVigenciaServi.saveVigencia(vigencia);
        return HttpStatus.CREATED; //201
    }

    @DeleteMapping("/vigencia/eliminar/{id}")
    public HttpStatus deleteVigencia(@PathVariable Integer id) {
        iVigenciaServi.deleteVigencia(id);
        return HttpStatus.NO_CONTENT; //204 
    }
    
    @PutMapping("/vigencia/modificar/{id}")
    public HttpStatus editVigencia(@PathVariable Integer id,
            @RequestBody Map<String, String> requestBody) {
        
        String nuevaVigencia = requestBody.get("vigencia");
        Vigencia vigencia = iVigenciaServi.findVigencia(id);
        vigencia.setVigencia(nuevaVigencia);

        iVigenciaServi.saveVigencia(vigencia);
        return HttpStatus.OK; //200
    }
}
