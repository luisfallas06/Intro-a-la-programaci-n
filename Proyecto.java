/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author luisfallas006
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        ListQuickPass activos=new ListQuickPass(5);
        ListQuickPass eliminados=new ListQuickPass(15);
       
       
        int indice = 0;
        do {
            QuickPass auxiliarQuick=null;
            indice = Integer.parseInt(JOptionPane.showInputDialog("**********MENU**********\n"
                    + "1. Crear un QuickPass\n"
                    + "2. Leer información de los QuickPass\n"
                    + "3. Eliminar QuickPass\n"
                    + "4. Gestion de Accesos\n"
                    + "5. Reportes del Condominio\n"
                    + "0. Salir"));
            switch(indice){
                case 1:
                    activos.agregarQuickPass();
                    break;
                case 2:
                    int subIndice = Integer.parseInt(JOptionPane.showInputDialog("**** Tipo de Visualización ****\n"
                            + "1. Mostrar todos los QuickPass activos\n"
                            + "2. Mostrar los QuickPass activos  de una filial en especifico\n"
                            + "3. Buscar un QuickPass en especifico\n"
                            + "4. Mostrar todos los QuickPass eliminados\n"
                            + "5. Mostrar los QuickPass eliminados  de una filial en especifico\n"
                            + "6. Buscar un QuickPass eliminado en especifico\n"
                            + "0. Regresar al menú principal"));
                    switch (subIndice) {
                        case 1:
                           JOptionPane.showMessageDialog(null, activos);
                            break;
                        case 2:
                             String FilialActiva = JOptionPane.showInputDialog("Ingrese la Filial del QuickPass a buscar:");
                            activos.encontrarPorFilial(FilialActiva);
                            break;
                        case 3:
                            String codigoActivo = JOptionPane.showInputDialog("Ingrese el código del QuickPass a buscar:");
                            activos.encontrarPorCodigo(codigoActivo);
                            break;
                            case 4:
                                JOptionPane.showMessageDialog(null, eliminados);
                            
                            break;
                            case 5:
                            String FilialEliminada = JOptionPane.showInputDialog("Ingrese la Filial del QuickPass a buscar:");
                            eliminados.encontrarPorFilial(FilialEliminada);
                            break;
                            case 6:
                               String codigoEliminado = JOptionPane.showInputDialog("Ingrese el código del QuickPass eliminado a buscar:");
                               eliminados.encontrarPorCodigo(codigoEliminado);
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida en el submenú");
                            break;
                    }
                    break;
                case 3:
                    int indiceEliminar = Integer.parseInt(JOptionPane.showInputDialog("**** Tipo de Visualización ****\n"
                            + "1. Eliminar por Placa\n"
                            + "2. Eliminar por Codigo\n"
                            + "0. Regresar al menú principal"));
                    switch (indiceEliminar) {
                        case 1:
                           auxiliarQuick = activos.eliminarPorPlaca(JOptionPane.showInputDialog(activos + "\nIngrese la placa a eliminar"));
                            if (auxiliarQuick != null) {
                                eliminados.agregarQuickPass2(auxiliarQuick);
                            }
                            break;
                        case 2:
                            auxiliarQuick = activos.eliminarPorCodigo(JOptionPane.showInputDialog(activos + "\nIngrese el codigo a eliminar"));
                            if (auxiliarQuick != null) {
                                eliminados.agregarQuickPass2(auxiliarQuick);
                            }
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida en el submenú");
                            break;
                    }
                    break;
                case 4:
                    int GestionAccesos = Integer.parseInt(JOptionPane.showInputDialog("**** Tipo de Visualización ****\n"
                            + "1. Registro de Quickpass\n"
                            + "2. Consultar Acceso historico de una Filial\n"
                            + "3. Accesos por un Rango de Fechas\n"
                            + "4. Accesos por un Codigo \n"
                            + "5. Accesos por un Placa \n"
                            + "0. Regresar al Menú"));
                    switch (GestionAccesos) {
                        case 1:
                           activos.registrarAcceso();
                            break;
                        case 2:
                           activos.consultarPorFilial();
                            break;
                            case 3:
                            activos.consultarPorRangoFechas();
                            break;
                            case 4:
                            activos.consultarPorCodigo();
                            break;
                            case 5:
                            activos.consultarPorPlaca();
                            break;
                        case 0:
                            
                            JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida en el submenú");
                            break;
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, activos);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, eliminados);
                    break;
                case 0:
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error: opcion no valida");
                    break;
            
            }
        } while (indice != 0);

    }

    
}
