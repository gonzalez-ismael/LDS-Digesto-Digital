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
 * Esta clase define los posibles estados para la variable "Reparticion" en un archivo.
 * Puede contener valores como "Departamento A", "Secretaria Academica", "Sector 1-A", entre otros.
 * 
 * @author GONZALEZ ESPADA, José Ismael
 */
@Entity @Getter @Setter
public class Reparticion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String reparticion;

    @OneToMany(mappedBy = "reparticion")
    private Set<Archive> archivos = new HashSet<>();
}
