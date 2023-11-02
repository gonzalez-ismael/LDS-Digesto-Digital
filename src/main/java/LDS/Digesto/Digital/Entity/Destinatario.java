package LDS.Digesto.Digital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase define los posibles estados para la variable "Destinatario" en un archivo. Puede contener valores como "Alumnos", "Abogados", "Sector A", entre otros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity
@Getter
@Setter
public class Destinatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String destinatario;

    @ManyToMany(mappedBy = "destinatarios")
    private Set<Archive> archivos = new HashSet<>();
}
