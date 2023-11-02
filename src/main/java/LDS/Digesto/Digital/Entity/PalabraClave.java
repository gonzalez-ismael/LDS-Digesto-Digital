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
 * Esta clase define los posibles estados para la variable "PalabraClave" en un archivo. Puede contener valores como "Informe", "Devolucion", "Resolucion", entre otros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity
@Setter
@Getter
public class PalabraClave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String palabraClave;

    @ManyToMany(mappedBy = "palabrasClaves")
    private Set<Archive> archivos = new HashSet<>();
}
