
package algoritmosgulosos;

import control.ControllerMST;
import model.Kruskal;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 22.09.2018                                                           *
 ******************************************************************************/
public class AlgoritmosGulosos {
    
    public static void main(String[] args) 
    {  
        ControllerMST control = new ControllerMST();
        control.printLista();
        control.controleMST( new Kruskal() );
        control.printMST();
        control.printResultadoMST();
    }
    
}
