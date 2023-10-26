package LDS.Digesto.Digital.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase define los posibles estados para la variable "NivelConfidencialidad" en un archivo.
 * Puede contener valores como "Público", "Privado", entre otros.
 *
 * @author GONZALEZ ESPADA, José Ismael
 */
public class NivelConfidencialidad {
    private final List<String> estados = new ArrayList<>();

    public NivelConfidencialidad() {
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
