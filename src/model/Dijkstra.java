
package model;

import util.AlgoritmoGuloso;
import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 08.10.2018                                                           *
 ******************************************************************************/
public class Dijkstra extends Grafo implements AlgoritmoGuloso
{
    @Override
    public void gerarSolucaoSubOtima(Aresta[][] matrizAresta, Aresta[] mpp, int tamanhoMatriz) 
    {
        //verificando se o existe uma arvore para garantir que funcione corretamente
        if(matrizAresta != null && tamanhoMatriz > 0)
        {
            /*
                iniciando vetor MST.
                numeroFloresta = 1 : faz parte do vetor
                numeroFLoresta = 0 : não faz parte do vetor
            */
            FuncoesVetor.iniciarVetor(mpp);
            mpp[0] = matrizAresta[0][0];
            mpp[0].setV1(-1);
            mpp[0].setV2(0);
            mpp[0].setFloresta(1);
            //enquanto nao for uma MST adicionar novas arestas
            while(!super.isFull(mpp))
                super.arestaMinima(matrizAresta, mpp);
        }
    }

    @Override
    void addAresta(Aresta[][] matriz, Aresta[] vetor, int i, int j) 
    {
        int k = 0;
        long custoAcumulado = 0, custoPai = 0;
        while(k < vetor.length  && vetor[k].getPeso() < Long.MAX_VALUE)
        {
            //true: entao pegue o custo que foi acumulado ate o pai dele
            if(vetor[k].getV2() == matriz[i][j].getV1())
                custoPai = vetor[k].getPeso();
            k++;
        }
        custoAcumulado = matriz[i][j].getPeso() + custoPai;
        vetor[k] = new Aresta(i, j, custoAcumulado, 1);
    }
    
}
