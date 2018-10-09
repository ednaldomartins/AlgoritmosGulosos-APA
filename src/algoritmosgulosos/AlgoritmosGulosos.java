
package algoritmosgulosos;

import java.util.Scanner;

import control.ControllerMST;
import model.Dijkstra;
import model.Kruskal;
import model.Prim;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 22.09.2018                                                           *
 ******************************************************************************/
public class AlgoritmosGulosos {
    
    public static void main(String[] args) 
    {  
        ControllerMST control = new ControllerMST();
        control.printMatriz();
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Escolha a Opcao abaixo: \n"
                    + "1. Kruskal \n"
                    + "2. Prim \n"
                    + "3. Dijkstra \n"
                    + "4. Visualizar Matriz \n"
                    + "5. Visualizar Resultado \n"
                    + "0. Sair \n");
            switch( opcao = entrada.nextInt() ) {
                case 1:
                    control.controleMST( new Kruskal() ); 
                    control.printMST();
                    control.printResultadoMST();
                    break;
                    
                case 2:
                    control.controleMST( new Prim() );
                    control.printMST();
                    control.printResultadoMST();
                    break;
                    
                case 3:
                    control.controleMST( new Dijkstra() );
                    control.printMST();
                    control.printResultadoMST();
                    break;
                case 4:
                    control.printMatriz();
                    break;
                    
                case 5:
                    control.printResultadoMST();
                    break;
                    
                case 0:
                    return;

                default:
                    System.out.println("opcao invalida\n");
            }
        }while(opcao != 0);
    }
    
}
