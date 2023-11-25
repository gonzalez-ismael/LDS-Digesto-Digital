package LDS.Digesto.Digital.Controller;

import LDS.Digesto.Digital.Entity.Archive;
import LDS.Digesto.Digital.Entity.Destinatario;
import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import LDS.Digesto.Digital.Entity.PalabraClave;
import LDS.Digesto.Digital.Entity.Reparticion;
import LDS.Digesto.Digital.Entity.Vigencia;
import LDS.Digesto.Digital.Interface.Service.IArchiveService;
import LDS.Digesto.Digital.Interface.Service.IDestinatarioService;
import LDS.Digesto.Digital.Interface.Service.INivelConfidencialidadService;
import LDS.Digesto.Digital.Interface.Service.IPalabraClaveService;
import LDS.Digesto.Digital.Interface.Service.IReparticionService;
import LDS.Digesto.Digital.Interface.Service.IVigenciaService;
import LDS.Digesto.Digital.Other.DTO.ArchivoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que gestiona las operaciones relacionadas con archivos. Proporciona endpoints para consultar, crear, editar y eliminar archivos.
 *
 * Este controlador maneja las solicitudes HTTP relacionadas con archivos y se comunica con el servicio correspondiente para realizar las operaciones necesarias en la base de datos.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@RestController
public class ArchiveController {

    @Autowired
    IArchiveService iArchiveServi;
    @Autowired
    IReparticionService iRepaServi;
    @Autowired
    IVigenciaService iVigeServi;
    @Autowired
    INivelConfidencialidadService iConfiServi;
    @Autowired
    IPalabraClaveService iClaveServi;
    @Autowired
    IDestinatarioService iDestiServi;

    @GetMapping("/archivos/traer")
    public List<Archive> getPersonas() {
        return iArchiveServi.getArchive();
    }

    @JsonIgnore
    @PostMapping("/archivo/crear")
    public HttpStatus createArchive(@RequestBody ArchivoDTO miDTO) {

        String nuevoId2 = miDTO.getId2();
        String nuevoTitulo = miDTO.getTitulo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nuevaFechaEmision = miDTO.getFecha_emision();
        LocalDate nuevaFechaPublicacion = LocalDate.parse(miDTO.getFecha_publicacion(), formatter);                
        String nuevaDescripcion = miDTO.getDescripcion();
        String nuevaTaxonomia = miDTO.getTaxonomia();
        String nuevaUrl = miDTO.getUrl();
        Reparticion nuevaReparticion = iRepaServi.findReparticion(miDTO.getReparticion());
        Vigencia nuevaVigencia = iVigeServi.findVigencia(miDTO.getVigencia());
        NivelConfidencialidad nuevoNivelConfidencialidad = iConfiServi.findNivelConfidencialidad(miDTO.getNivelConfidencialidad());
        List<PalabraClave> nuevasPalabrasClaves = new ArrayList();
        for (Integer e : miDTO.getPalabrasClaves()) {
            nuevasPalabrasClaves.add(iClaveServi.findPalabraClave(e));
        }
        List<Destinatario> nuevosDestinatarios = new ArrayList<>();
        for (Integer idDestinatario : miDTO.getDestinatarios()) {
            nuevosDestinatarios.add(iDestiServi.findDestinatario(idDestinatario));
        }

        Archive archivo = new Archive();

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
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/archivo/eliminar/{id}")
    public HttpStatus deleteArchive(@PathVariable Integer id) {
        iArchiveServi.deleteArchive(id);
        return HttpStatus.NO_CONTENT;
    }

    /*@PutMapping("/archivo/modificar/{id}")
    public HttpStatus editArchive(@PathVariable Integer id, @RequestBody ArchivoDTO miDTO) {
        
        String nuevoId2 = miDTO.getId2();
        String nuevoTitulo = miDTO.getTitulo();
        java.time.LocalDate nuevaFechaEmision = miDTO.getFecha_emision();
        java.time.LocalDate nuevaFechaPublicacion = miDTO.getFecha_publicacion();
        String nuevaDescripcion = miDTO.getDescripcion();
        String nuevaTaxonomia = miDTO.getTaxonomia();
        String nuevaUrl = miDTO.getUrl();
        Reparticion nuevaReparticion = miDTO.getReparticion();
        Vigencia nuevaVigencia = miDTO.getVigencia();
        NivelConfidencialidad nuevoNivelConfidencialidad = miDTO.getNivelConfidencialidad();
        List<PalabraClave> nuevasPalabrasClaves = miDTO.getPalabrasClaves();
        List<Destinatario> nuevosDestinatarios = miDTO.getDestinatarios();

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
        return HttpStatus.OK;
    }*/
}
