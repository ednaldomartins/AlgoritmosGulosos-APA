
package algoritmosgulosos;

import control.ControllerMST;
import java.util.Scanner;
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
        control.printLista();
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("Escolha a Opcao abaixo: \n"
                    + "1. Kruskal \n"
                    + "2. Prim \n"
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
               
                case 0:
                    return;

                default:
                    System.out.println("opcao invalida\n");
            }
        }while(opcao != 0);
    }
    
}
