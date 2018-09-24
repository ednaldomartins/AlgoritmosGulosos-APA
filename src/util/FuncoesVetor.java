
package util;

import java.util.List;
import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.09.2018                                                           *
 ******************************************************************************/
public class FuncoesVetor {
    
    public static void swap ( Aresta [] list, int i, int j )
    {
        Aresta temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
    
    public static void copiarLista ( List <Aresta> original, Aresta [] copia )
    {
        copia = new Aresta[original.size()];
        for(int i = 0; i < copia.length; i++)
            copia[i] = original.get(i);
    }

}
