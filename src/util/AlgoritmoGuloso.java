
package util;

import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.09.2018                                                           *
 ******************************************************************************/
public interface AlgoritmoGuloso {
    public void gerarMST (Aresta [][] matrizAresta, Aresta [] arvoreGeradora, int tamanhoVetor);
}
