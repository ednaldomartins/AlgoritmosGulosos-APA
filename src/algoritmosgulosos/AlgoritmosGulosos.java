
package algoritmosgulosos;

import infra.Arquivo;
import java.io.IOException;
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
        Aresta [] list = arquivo.carregarMST();
        for(int i = 0; i<list.length; i++)
            System.out.println(list[i].getPeso());
    }
    
}
