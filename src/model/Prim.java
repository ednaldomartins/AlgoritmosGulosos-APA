
package model;

import util.AlgoritmoGuloso;
import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 03.10.2018                                                           *
 ******************************************************************************/
public class Prim implements AlgoritmoGuloso  
{
    private Grafo grafo;
    @Override
    public void gerarSolucaoSubOtima(Aresta[][] matrizAresta, Aresta[] mst, int tamanhoMatriz) 
    {
        //verificando se o existe uma arvore para garantir que funcione corretamente
        if(matrizAresta != null && tamanhoMatriz > 0)
        {
            /*
                iniciando vetor MST.
                numeroFloresta = 1 : faz parte do vetor
                numeroFLoresta = 0 : não faz parte do vetor
            */
            FuncoesVetor.iniciarVetor(mst);
            mst[0] = matrizAresta[0][0];
            mst[0].setV1(-1);
            mst[0].setV2(0);
            mst[0].setFloresta(1);
            //enquanto nao for uma MST adicionar novas arestas
            while(!grafo.isFull(mst))
                grafo.arestaMinima(matrizAresta, mst);
        }
    }
    
    
}
