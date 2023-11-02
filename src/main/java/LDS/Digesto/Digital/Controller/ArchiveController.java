package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Archive;
import LDS.Digesto.Digital.Entity.Destinatario;
import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import LDS.Digesto.Digital.Entity.PalabraClave;
import LDS.Digesto.Digital.Entity.Reparticion;
import LDS.Digesto.Digital.Entity.Vigencia;
import LDS.Digesto.Digital.Interface.Service.IArchiveService;
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
 * Controlador que gestiona las operaciones relacionadas con archivos.
 * Proporciona endpoints para consultar, crear, editar y eliminar archivos.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con archivos y
 * se comunica con el servicio correspondiente para realizar las operaciones
 * necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Controller
public class ArchiveController {

    @Autowired
    IArchiveService iArchiveServi;

    @GetMapping("/archivo/traer")
    public List<Archive> getPersonas() {
        return iArchiveServi.getArchive();
    }

    @PostMapping("/archivo/crear")
    public String createArchive(@RequestBody Archive archivo) {
        iArchiveServi.saveArchive(archivo);
        return "El archivo fue creado correctamente.";
    }

    @DeleteMapping("/archivo/eliminar/{id}")
    public String deleteArchive(@PathVariable Integer id) {
        iArchiveServi.deleteArchive(id);
        return "El archivo fue eliminado correctamente.";
    }

    @PutMapping("/archivo/modificar/{id}")
    public Archive editArchive(@PathVariable Integer id,
            @RequestParam("id2") String nuevoId2,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("fecha_emision") java.time.LocalDate nuevaFechaEmision,
            @RequestParam("fecha_publicacion") java.time.LocalDate nuevaFechaPublicacion,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("taxonomia") String nuevaTaxonomia,
            @RequestParam("url") String nuevaUrl,
            @RequestParam("reparticion") Reparticion nuevaReparticion,
            @RequestParam("vigencia") Vigencia nuevaVigencia,
            @RequestParam("nivelConfidencialidad") NivelConfidencialidad nuevoNivelConfidencialidad,
            @RequestParam("palabrasClaves") List<PalabraClave> nuevasPalabrasClaves,
            @RequestParam("destinatarios") List<Destinatario> nuevosDestinatarios) {
        Archive archivo = iArchiveServi.findArchive(id);

        // Establecer los demás atributos de la entidad Archive con los nuevos valores
        archivo.setId2(nuevoId2);
        archivo.setTitulo(nuevoTitulo);
        archivo.setFecha_emision(nuevaFechaEmision);
        archivo.setFecha_publicacion(nuevaFechaPublicacion);
        archivo.setDescripcion(nuevaDescripcion);
        archivo.setTaxonomia(nuevaTaxonomia);
        archivo.setUrl(nuevaUrl);
        archivo.setReparticion(nuevaReparticion);
        archivo.setVigencia(nuevaVigencia);
        archivo.setNivelConfidencialidad(nuevoNivelConfidencialidad);
        archivo.setPalabrasClaves(nuevasPalabrasClaves);
        archivo.setDestinatarios(nuevosDestinatarios);

        iArchiveServi.saveArchive(archivo);
        return archivo;
    }
}
