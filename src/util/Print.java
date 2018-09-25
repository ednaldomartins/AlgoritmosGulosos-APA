
package util;

import java.util.List;

import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 25.09.2018                                                           *
 ******************************************************************************/
public class Print 
{
    public static void printLista (List <Aresta> list)
    {
        int tamanhoLista = list.size();
        System.out.println("Lista de Aresta. Tamanho: " + tamanhoLista);
        for(int i = 1; i < tamanhoLista; i++)
        {
            System.out.println( "(" + list.get(i).getV1() + ")" + 
                                "______" + list.get(i).getPeso() + "______" + 
                                "(" + list.get(i).getV2() + ")" );
        }
    }
    
    public static void printMST (Aresta [] mst)
    {
        System.out.println("MST. Tamanho: " + mst.length);
        for(int i = 0; i < mst.length; i++)
        {
            System.out.println( "(" + mst[i].getV1() + ")" + 
                                "______" + mst[i].getPeso() + "______" + 
                                "(" + mst[i].getV2() + ")" );
        }
    }
    
    public static void printResultadoMST (Aresta [] mst)
    {
        long resultadoMST = 0;
        for(int i = 0; i < mst.length; i++)
            resultadoMST += mst[i].getPeso();
        System.out.println("MST. Tamanho: " + mst.length);
        System.out.println("MST. Resultado: " + resultadoMST);
    }
    
}
