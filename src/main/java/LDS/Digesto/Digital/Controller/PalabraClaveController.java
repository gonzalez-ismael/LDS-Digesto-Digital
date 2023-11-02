package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.PalabraClave;
import LDS.Digesto.Digital.Interface.Service.IPalabraClaveService;
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
 * Controlador que gestiona las operaciones relacionadas con palabras claves. Proporciona endpoints para consultar, crear, editar y eliminar palabras claves.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con palabras claves y se comunica con el servicio correspondiente para realizar las operaciones necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Controller
public class PalabraClaveController {

    @Autowired
    IPalabraClaveService iPalabraServi;

    @GetMapping("/palabras-claves/traer")
    public List<PalabraClave> getPalabrasClaves() {
        return iPalabraServi.getPalabrasClaves();
    }

    @PostMapping("/palabras-claves/crear")
    public String createPalabrasClaves(@RequestBody PalabraClave palabra) {
        iPalabraServi.savePalabraClave(palabra);
        return "La palabra clave fue creada correctamente.";
    }

    @DeleteMapping("/palabras-claves/eliminar/{id}")
    public String deletePalabraClave(@PathVariable Integer id) {
        iPalabraServi.deletePalabraClave(id);
        return "La palabra clave fue eliminada correctamente.";
    }

    @PutMapping("/palabra-clave/modificar/{id}")
    public PalabraClave editPalabraClave(@PathVariable Integer id,
            @RequestParam("palabraClave") String nuevaPalabra) {
        
        PalabraClave palabraClave = iPalabraServi.findPalabraClave(id);

        palabraClave.setPalabraClave(nuevaPalabra);

        iPalabraServi.savePalabraClave(palabraClave);
        return palabraClave;
    }
}