
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
//        Arquivo arquivo = new Arquivo("..\\AlgoritmosGulosos\\dij10.txt");
//        List <Aresta> list = arquivo.carregarMST();
//        for(int i = 1; i<list.size(); i++)
//        {
//            System.out.println( "(" + list.get(i).getV1() + ")" + 
//                                "______" + list.get(i).getPeso() + "______" + 
//                                "(" + list.get(i).getV2() + ")" );
//        }
        
        ControllerMST control = new ControllerMST();
        control.controleMST( new Kruskal() );
        
        
    }
    
}
