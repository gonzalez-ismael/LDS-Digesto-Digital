package LDS.Digesto.Digital.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase define los posibles estados para la variable "vigente" en un archivo.
 * Puede contener valores como "Vigente", "Obsoleto", entre otros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public class Vigencia {
    private final List<String> estados = new ArrayList<>();

    public Vigencia() {
        estados.add("Vigente");
        estados.add("Obsoleto");
    }

    public void agregarEstado(String nuevoEstado) {
        estados.add(nuevoEstado);
    }

    public void eliminarEstado(String estado) {
        estados.remove(estado);
    }

    public List<String> getEstados() {
        return estados;
    }
}
