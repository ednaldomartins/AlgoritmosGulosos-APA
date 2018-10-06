
package model;

import util.AlgoritmoGuloso;
import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 03.10.2018                                                           *
 ******************************************************************************/
public class Prim implements AlgoritmoGuloso {

    @Override
    public void gerarMST(Aresta[][] matrizAresta, Aresta[] mst, int tamanhoMatriz) 
    {
        //verificando se o existe uma arvore para garantir que funcione corretamente
        if(matrizAresta != null && tamanhoMatriz > 0)
        {
            /*
                iniciando vetor MST.
                numeroFloresta = 1 : faz parte do vetor
                numeroFLoresta = 0 : não faz parte do vetor
            */
            int numeroFloresta = 1;
            FuncoesVetor.iniciarVetor(mst);
            mst[0] = matrizAresta[0][0];
            mst[0].setV1(-1);
            mst[0].setV2(0);
            mst[0].setFloresta(numeroFloresta);
            //Gerar MST. Apontador diz ateh qual posicao a mst[]  foi preenchida
            while(!isMST(mst))
                minimo(matrizAresta, mst);
            
        }
    }
    
    private void minimo (Aresta[][] matriz, Aresta[] vetor)
    {
        long  menor = Long.MAX_VALUE;
        int verticeI = -1, verticeJ = -1;
        //while(i < vetor.length  && vetor[ (int)i ].getPeso() < Long.MAX_VALUE)
        for(int v = 0, i = 0; v < vetor.length  && vetor[ (int)i ].getPeso() < Long.MAX_VALUE; v++)
        {
            i = (int) vetor[v].getV2();
            for(int j = 0; j < matriz.length; j++)
            {
                if(   (matriz[ (int)i ][j].getPeso() != 0)   &&
                      (matriz[ (int)i ][j].getPeso() < menor)   &&
                      (matriz[ (int)i ][j].getFloresta() == 0)   )
                {   //se fizer parte da floresta tem q fazer uma troca
                    menor = matriz[ (int)i ][j].getPeso();
                    verticeI = (int) i;
                    verticeJ = j;
                }
            }
        }
        addAresta(matriz, vetor, verticeI, verticeJ);
    }
    
    private void addAresta(Aresta[][] matriz, Aresta[] vetor, int i, int j)
    {
        int k = 0;
        while(k < vetor.length  && vetor[k].getPeso() < Long.MAX_VALUE)
            k++;
        
        vetor[k] = new Aresta(i, j, matriz[i][j].getPeso(), 1);
        matriz[i][j].setFloresta(1);
        matriz[j][i].setFloresta(1);
    }
    
    private boolean isMST (Aresta[] vetorMST)
    {
        for(int i = 0; i < vetorMST.length; i++)
            if(vetorMST[i].getFloresta() == 0)
                return false;
        return true;
    }
}
