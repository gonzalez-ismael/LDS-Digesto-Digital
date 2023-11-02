package LDS.Digesto.Digital.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta clase define los posibles estados para la variable "NivelConfidencialidad" en un archivo. Puede contener valores como "Público", "Privado", entre otros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity
@Getter
@Setter
public class NivelConfidencialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nivelConfidencialidad;

    @OneToMany(mappedBy = "nivelConfidencialidad")
    private Set<Archive> archivos = new HashSet<>();
}
