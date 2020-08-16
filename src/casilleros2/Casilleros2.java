/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casilleros2;

import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class Casilleros2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] casilleros = new int[20]; //1 - Casillero ocupado, 0 - casillero vacío
        int numeroCasillero, opciones, fila = 1;
        String strVector = "";
        
        for(int i = 0; i < casilleros.length; i++){
            casilleros[i] = 0;
        }
        
        opciones = Integer.parseInt(JOptionPane.showInputDialog("Opciones del menú\n1.Ver disponibilidad de casilleros\n2.Prestar un casillero\n3.Devolver un casillero\nCualquier número para salir"));
        
        while(opciones >= 1 && opciones <= 3){
          switch(opciones){
              case 1:
                  strVector = "";
                  for(int i = 0; i < casilleros.length; i++){
                        strVector = strVector + "\t" + casilleros[i];
                        fila++;
                        if(fila == 6){
                            strVector += "\n";
                            fila = 1;
                        }
                  }
                  JOptionPane.showMessageDialog(null, "Casilleros:\n" + strVector);
                  break;
              case 2:
                  do{
                      numeroCasillero = Integer.parseInt(JOptionPane.showInputDialog("Cuál casillero desea prestar? (1 al 20)"));
                  }while(numeroCasillero <= 0 || numeroCasillero > 20);
                  
                  if(casilleros[numeroCasillero - 1] == 1){
                      JOptionPane.showMessageDialog(null, "Lo sentimos, el casillero ya está ocupado");
                  }else if(casilleros[numeroCasillero -1] == 0){
                      casilleros[numeroCasillero - 1] = 1;
                      JOptionPane.showMessageDialog(null, "Se te ha asignado el casillero #"+ numeroCasillero);
                  }
                  
                  break;
              case 3:
                  do{
                      numeroCasillero = Integer.parseInt(JOptionPane.showInputDialog("Cuál casillero desea devolver? (1 al 20)"));
                  }while(numeroCasillero <= 0 || numeroCasillero > 20);
                  
                   if(casilleros[numeroCasillero - 1] == 0){
                      JOptionPane.showMessageDialog(null, "El casillero no está ocupado");
                  }else if(casilleros[numeroCasillero -1] == 1){
                      casilleros[numeroCasillero - 1] 
                              = 0;
                      JOptionPane.showMessageDialog(null, "Has devuelto el casillero #"+ numeroCasillero);
                  }
                  
                  break;
              default:
                  break;
          }
           opciones = Integer.parseInt(JOptionPane.showInputDialog("Opciones del menú\n1.Ver disponibilidad de casilleros\n2.Prestar un casillero\n3.Devolver un casillero\nCualquier número para salir"));
        }
        
    }
    
}
