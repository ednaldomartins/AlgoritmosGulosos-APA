
package util;

import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.09.2018                                                           *
 ******************************************************************************/
public interface AlgoritmoGuloso 
{
    public void gerarSolucaoSubOtima (Aresta [][] matrizAresta, Aresta [] arvoreMinima, int tamanhoMatriz);
}
