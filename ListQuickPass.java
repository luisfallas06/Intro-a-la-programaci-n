/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 *
 * @author luisfallas006
 */

public class ListQuickPass {

    private QuickPass lista[];
    private QuickPass quickpassEliminados[];
    private int cupo;
    private int cupoEliminados;
    private Acceso[] listaAccesos;
    private int capacidad;
    private int cantidad;

    public ListQuickPass(int tamanno) {
        lista = new QuickPass[tamanno];
        quickpassEliminados = new QuickPass[tamanno]; 
        cupo = tamanno;
        cupoEliminados = tamanno;

        listaAccesos = new Acceso[tamanno];
        capacidad = tamanno;
        cantidad = 0;
    }
    

    // Agregar
    public void agregarQuickPass() {
        if (cupo > 0) {
            String Filial, Placa, Codigo;

            Filial = this.valStringNoVacio("Filial");
            Placa = this.valStringNoVacio("Placa");

            do {
                Codigo = JOptionPane.showInputDialog("Ingrese el Código");
                if (Codigo == null) {
                    JOptionPane.showMessageDialog(null, "Error: El código no puede estar vacío");
                    continue;
                }
                if (!Codigo.startsWith("101")) {
                    JOptionPane.showMessageDialog(null, "Error: El código debe iniciar con 101");
                    continue;
                }
                if (Codigo.length() != 10) {
                    JOptionPane.showMessageDialog(null, "Error: El código debe tener exactamente 10 caracteres");
                    continue;
                }
                break;
            } while (true);

            QuickPass quickpass = new QuickPass(Filial, Placa, Codigo);
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == null) {
                    lista[i] = quickpass;
                    cupo -= 1;
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay más espacio disponible para agregar QuickPass");
        }
    }

    public void agregarQuickPass2(QuickPass quickpass) {
        if (cupo > 0) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == null) {
                    lista[i] = quickpass;
                    cupo -= 1;
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: no hay cupo disponible");
        }
    }

    private String valStringNoVacio(String param) {
        String r;
        do {
            r = JOptionPane.showInputDialog("Ingrese el valor de " + param);
            if (r == null || r.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: valor incorrecto");
            }
        } while (r == null || r.trim().isEmpty());
        return r;
    }

    // Eliminar
    public QuickPass eliminarPorCodigo(String Codigo) {
        if (cupo != this.lista.length) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] != null && lista[i].getCodigo().equals(Codigo)) {
                    QuickPass eliminado = lista[i];
                    lista[i] = null;
                    cupo += 1;
                    moverAEliminados(eliminado);
                    JOptionPane.showMessageDialog(null, "El QuickPass fue eliminado correctamente");
                    return eliminado;
                }
            }

            JOptionPane.showMessageDialog(null, "No se encontró un QuickPass con ese código");

        } else {
            JOptionPane.showMessageDialog(null, "No hay QuickPass registrados");
        }
        return null;
    }
    
    public QuickPass eliminarPorPlaca(String Placa) {
        if (cupo != this.lista.length) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] != null && lista[i].getPlaca().equals(Placa)) {
                    QuickPass eliminado = lista[i];
                    lista[i] = null;
                    cupo += 1;
                    JOptionPane.showMessageDialog(null, "El QuickPass fue eliminado correctamente");
                    return eliminado;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontró un QuickPass con esa placa");
        } else {
            JOptionPane.showMessageDialog(null, "No hay QuickPass registrados");
        }
        return null;
    }

    private void moverAEliminados(QuickPass eliminado) {
        if (cupoEliminados > 0) {
            for (int i = 0; i < quickpassEliminados.length; i++) {
                if (quickpassEliminados[i] == null) {
                    quickpassEliminados[i] = eliminado;
                    cupoEliminados -= 1;
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: no hay espacio para mover a eliminados");
        }
    }
//Buscar 
    public void encontrarPorCodigo(String codigo) {
    if (cupo != this.lista.length) { 
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getCodigo().equals(codigo)) { 
                JOptionPane.showMessageDialog(null, lista[i]); 
                return; // 
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró un QuickPass con ese código"); // Mensaje si no se encuentra
    } else {
        JOptionPane.showMessageDialog(null, "No hay QuickPass registrados"); // Mensaje si la lista está vacía
    }
}
    
     public void encontrarPorFilial(String filial) {
    if (cupo != this.lista.length) { 
        boolean encontrado = false; 
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getFilial().equals(filial)) { 
                JOptionPane.showMessageDialog(null, lista[i]); 
                encontrado = true; 
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un QuickPass con esa filial"); 
        }
    } else {
        JOptionPane.showMessageDialog(null, "No hay QuickPass registrados"); 
    }
}
   
    public void registrarAcceso() {
  
    for (int i = 0; i < lista.length; i++) {
        if (lista[i] != null) {
            QuickPass qp = lista[i];  

            if (cantidad < capacidad) {  
                LocalDateTime fechaActual = LocalDateTime.now();
                Acceso nuevoAcceso = new Acceso(qp);
                nuevoAcceso.setFechaActual(fechaActual);

                listaAccesos[cantidad] = nuevoAcceso;
                cantidad++;

                JOptionPane.showMessageDialog(null, "Codigo: " + qp.getCodigo() + "; Placa: " + qp.getPlaca() + "; Filial: " + qp.getFilial() +
                        "; Fecha: " + fechaActual);
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacio disponible para registrar más accesos");
                break;  
            }
        }
    }
}


    public void consultarPorFilial() {
  
    String filial = JOptionPane.showInputDialog(null, "Ingrese el nombre de la filial a consultar:", 
                                                "Consulta de Filial", JOptionPane.QUESTION_MESSAGE);
    
    
    if (filial == null || filial.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se ingresó una filial válida.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    
    boolean encontrado = false;
    StringBuilder resultados = new StringBuilder("Accesos para la filial: " + filial + "\n");

    for (int i = 0; i < cantidad; i++) {
        if (listaAccesos[i].getQp().getFilial().equalsIgnoreCase(filial)) {
            resultados.append(listaAccesos[i]).append("\n");
            encontrado = true;
        }
    }

    // Mostrar resultados
    if (encontrado) {
        JOptionPane.showMessageDialog(null, resultados.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontraron accesos para la filial: " + filial, 
                                      "Sin Resultados", JOptionPane.WARNING_MESSAGE);
    }
}

   
    public void consultarPorRangoFechas() {
    
    String inputInicio = JOptionPane.showInputDialog("Introduce la fecha de inicio (formato: yyyy-MM-dd):");
    String inputFin = JOptionPane.showInputDialog("Introduce la fecha de fin (formato: yyyy-MM-dd):");

    
    LocalDate fechaInicio = parseFecha(inputInicio);
    LocalDate fechaFin = parseFecha(inputFin);

    boolean encontrado = false;
    StringBuilder resultados = new StringBuilder("Accesos entre " + fechaInicio + " y " + fechaFin + "\n");

    
    for (int i = 0; i < cantidad; i++) {
        
        LocalDate fechaAcceso = listaAccesos[i].getFechaActual().toLocalDate(); 

        
        if (!fechaAcceso.isBefore(fechaInicio) && !fechaAcceso.isAfter(fechaFin)) {
            resultados.append(listaAccesos[i]).append("\n");
            encontrado = true;
        }
    }

    
    if (encontrado) {
        JOptionPane.showMessageDialog(null, resultados.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No se encontraron accesos en el rango especificado");
    }
}

private LocalDate parseFecha(String fecha) {
    
    int año = Integer.parseInt(fecha.substring(0, 4));
    int mes = Integer.parseInt(fecha.substring(5, 7));
    int día = Integer.parseInt(fecha.substring(8, 10));

    return LocalDate.of(año, mes, día);
}

    
    public void consultarPorCodigo() {
   
    String codigo = JOptionPane.showInputDialog(null, "Ingrese el código a buscar:");

    if (codigo == null || codigo.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El código ingresado no es válido.");
        return;
    }

    boolean encontrado = false;
    StringBuilder resultados = new StringBuilder("Accesos para el código: " + codigo + "\n");

    for (int i = 0; i < cantidad; i++) {
        if (listaAccesos[i].getQp().getCodigo().equalsIgnoreCase(codigo)) {
            resultados.append(listaAccesos[i]).append("\n");
            encontrado = true;
        }
    }

    if (encontrado) {
        JOptionPane.showMessageDialog(null, resultados.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No se encontraron accesos para el código: " + codigo);
    }
}
    
    public void consultarPorPlaca() {
    
    String placa = JOptionPane.showInputDialog(null, "Ingrese la placa a buscar:");

    if (placa == null || placa.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "La placa ingresada no es válida.");
        return;
    }

    boolean encontrado = false;
    StringBuilder resultados = new StringBuilder("Accesos para la placa: " + placa + "\n");

    for (int i = 0; i < cantidad; i++) {
        if (listaAccesos[i].getQp().getPlaca().equalsIgnoreCase(placa)) {
            resultados.append(listaAccesos[i]).append("\n");
            encontrado = true;
        }
    }

    if (encontrado) {
        JOptionPane.showMessageDialog(null, resultados.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No se encontraron accesos para la placa: " + placa);
    }
}




     
     
    // Listar todos los QuickPass
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("Listado de QuickPass\n");
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                r.append((i + 1)).append(")").append(lista[i]).append("\n");
            }
        }
        return r.toString();
    }

    public String verPorFilial() {
        if (cupo != this.lista.length) {
            String Filial = this.valStringNoVacio("Filial");
            StringBuilder r = new StringBuilder("Datos de la filial " + Filial + "\n");
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] != null && lista[i].getFilial().equals(Filial)) {
                    r.append(lista[i]).append("\n");
                }
            }
            return r.toString();
        } else {
            return "No hay datos en la lista";
        }
    }
}

