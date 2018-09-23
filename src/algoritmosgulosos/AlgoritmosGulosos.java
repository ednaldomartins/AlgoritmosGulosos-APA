
package algoritmosgulosos;

import infra.Arquivo;
import java.io.IOException;
import java.util.List;
import model.Aresta;

/**
 * @author Ednaldo
 *  date: 22.09.2018
 */
public class AlgoritmosGulosos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        Arquivo arquivo = new Arquivo("..\\AlgoritmosGulosos\\dij10.txt");
        List <Aresta> list = arquivo.carregarMST();
        for(int i = 1; i<list.size(); i++)
        {
            System.out.println( "(" + list.get(i).getV1() + ")" + 
                                "______" + list.get(i).getPeso() + "______" + 
                                "(" + list.get(i).getV2() + ")" );
        }
    }
    
}
