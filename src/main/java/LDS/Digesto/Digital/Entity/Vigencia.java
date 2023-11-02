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
 * Esta clase define los posibles estados para la variable "vigente" en un archivo.
 * Puede contener valores como "Vigente", "Obsoleto", entre otros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity @Getter @Setter
public class Vigencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String vigencia;

    @OneToMany(mappedBy = "vigencia")
    private Set<Archive> archivos = new HashSet<>();
}
