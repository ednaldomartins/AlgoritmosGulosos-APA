
package util;

import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.09.2018                                                           *
 ******************************************************************************/
public class AlgoritmoOrdenacao {
    /***************************************************************************
     *  Algoritmo:      Insertion Sort                                         *
     *  Caso:           Melhor      Medio       Pior                           *
     *  Complexidade:   O(n)        O(n^2)	O(n^2)                         *
     *      @param list                                                        *
     **************************************************************************/
    public static void ordenar (Aresta [] list) 
    {
        for(int i = 1; i < list.length; i++)
        {   //1)j verifica para tras. 2)guardar o valor do pivo inicial.
            int j = i-1;
            Aresta pivo = list[i];    
            //enquanto o pivo for menor que o valor anterior, volte...
            for(; j >= 0 && ( pivo.getPeso() < list[j].getPeso() ); j-- )
                list[j+1] = list[j];
            list[j+1] = pivo;
        }
    }
    
}
