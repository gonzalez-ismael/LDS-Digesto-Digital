package LDS.Digesto.Digital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase representa la Entidad Archivo con sus distintos parámetros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity
@Getter
@Setter
public class Archive {

    //Atributos privados de la clase.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @NotNull
    private String id2;

    @NotNull
    private String titulo;

    @NotNull
    private java.time.LocalDate fecha_emision;

    @NotNull
    private java.time.LocalDate fecha_publicacion;

    @NotNull
    private String descripcion;

    @NotNull
    private String taxonomia;

    @NotNull
    private String url;

    @ManyToOne
    private Reparticion reparticion;

    @ManyToOne
    private Vigencia vigencia;

    @ManyToOne
    private NivelConfidencialidad nivelConfidencialidad;

    @ManyToMany
    @JoinTable(
            name = "archivo_palabraclave",
            joinColumns = @JoinColumn(name = "archivo_id"),
            inverseJoinColumns = @JoinColumn(name = "palabraclave_id")
    )
    private List<PalabraClave> palabrasClaves = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "archivo_destinatario",
            joinColumns = @JoinColumn(name = "archivo_id"),
            inverseJoinColumns = @JoinColumn(name = "destinatario_id")
    )
    private List<Destinatario> destinatarios = new ArrayList<>();
}
