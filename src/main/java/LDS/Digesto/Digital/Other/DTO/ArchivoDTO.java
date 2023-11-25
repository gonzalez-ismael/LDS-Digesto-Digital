package LDS.Digesto.Digital.Other.DTO;

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
    private String fecha_publicacion;
    private String descripcion;
    private String taxonomia;
    private String url;
    private Integer reparticion;
    private Integer vigencia;
    private Integer nivelConfidencialidad;
    private List<Integer> palabrasClaves = new ArrayList<>();
    private List<Integer> destinatarios = new ArrayList<>();
}
