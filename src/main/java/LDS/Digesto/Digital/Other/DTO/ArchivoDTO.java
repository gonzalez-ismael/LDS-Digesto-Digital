package LDS.Digesto.Digital.Other.DTO;

import LDS.Digesto.Digital.Entity.Destinatario;
import LDS.Digesto.Digital.Entity.NivelConfidencialidad;
import LDS.Digesto.Digital.Entity.PalabraClave;
import LDS.Digesto.Digital.Entity.Reparticion;
import LDS.Digesto.Digital.Entity.Vigencia;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase solo funciona para pasar parametros en la clase ArchiveController,
 * en el método "public HttpStatus editArchive(@PathVariable Integer id, @RequestBody ArchivoDTO miDTO)"
 * 
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Getter @Setter
public class ArchivoDTO {
    private String id2;
    private String titulo;
    private java.time.LocalDate fecha_emision;
    private java.time.LocalDate fecha_publicacion;
    private String descripcion;
    private String taxonomia;
    private String url;
    private Reparticion reparticion;
    private Vigencia vigencia;
    private NivelConfidencialidad nivelConfidencialidad;
    private List<PalabraClave> palabrasClaves = new ArrayList<>();
    private List<Destinatario> destinatarios = new ArrayList<>();
}
