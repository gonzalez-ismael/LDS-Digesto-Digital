package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.PalabraClave;
import LDS.Digesto.Digital.Interface.Service.IPalabraClaveService;
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
 * Controlador que gestiona las operaciones relacionadas con palabras claves. Proporciona endpoints para consultar, crear, editar y eliminar palabras claves.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con palabras claves y se comunica con el servicio correspondiente para realizar las operaciones necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@RestController
public class PalabraClaveController {

    @Autowired
    IPalabraClaveService iPalabraServi;

    @GetMapping("/palabras-claves/traer")
    public List<PalabraClave> getPalabrasClaves() {
        return iPalabraServi.getPalabrasClaves();
    }

    @PostMapping("/palabra-clave/crear")
    public HttpStatus createPalabrasClaves(@RequestBody PalabraClave palabra) {
        iPalabraServi.savePalabraClave(palabra);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/palabra-clave/eliminar/{id}")
    public HttpStatus deletePalabraClave(@PathVariable Integer id) {
        iPalabraServi.deletePalabraClave(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/palabra-clave/modificar/{id}")
    public HttpStatus editPalabraClave(@PathVariable Integer id,
            @RequestBody Map<String, String> requestBody) {
        
        String nuevaPalabra = requestBody.get("palabraClave");
        PalabraClave palabraClave = iPalabraServi.findPalabraClave(id);
        palabraClave.setPalabraClave(nuevaPalabra);

        iPalabraServi.savePalabraClave(palabraClave);
        return HttpStatus.OK;
    }
}