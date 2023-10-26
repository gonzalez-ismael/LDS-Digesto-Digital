package LDS.Digesto.Digital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa la Entidad Archivo con sus distintos parámetros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity @Getter @Setter
public class Archive {
    //Atributos privados de la clase.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    private Integer id;
    
    @NotNull
    private Integer id2;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private java.time.LocalDate fecha_emision;
    
    @NotNull
    private java.time.LocalDate fecha_publicacion;
    
    @NotNull
    private String descripcion;
    
    @NotNull
    private String reparticion;
    
    @NotNull
    private String taxonomia;
    
    @NotNull
    private String[] palabras_claves;
    
    @NotNull
    private Vigencia vigencia;
    
    @NotNull
    private NivelConfidencialidad niveles_confidencialidad;
    
    @NotNull
    private String[] destinatarios;
    
    @NotNull
    private String url;
}
