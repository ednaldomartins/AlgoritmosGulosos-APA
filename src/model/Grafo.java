
package model;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 08.10.2018                                                           *
 ******************************************************************************/
public class Grafo {
    
    void arestaMinima (Aresta[][] matriz, Aresta[] vetor)
    {
        long  menor = Long.MAX_VALUE;
        int verticeI = -1, verticeJ = -1;
        for(int v = 0, i = 0; v < vetor.length  && vetor[ (int)i ].getPeso() < Long.MAX_VALUE; v++)
        {
            //pega o proximo vertice para verificar suas conexoes na matriz
            i = (int) vetor[v].getV2();
            for(int j = 0; j < matriz.length; j++)
            {
                //sempre pega o menor caminho disponivel entre os vertices conhecidos
                if(   (matriz[ (int)i ][j].getPeso() != 0)   &&
                      (matriz[ (int)i ][j].getPeso() < menor)   &&
                       isAcyclic(vetor, i, j)   )
                {   
                    menor = matriz[ (int)i ][j].getPeso();
                    verticeI = (int) i;
                    verticeJ = j;
                }
            }//fim do for 2
        }//fim do for 1
        addAresta(matriz, vetor, verticeI, verticeJ);
    }
    
    /***************************************************************************
     * Metodo para adicionar a nova aresta na MST. O metodo deve procurar a    *
     * proxima posicao disponivel no vetor MST.                                *
     * @param matriz                                                           *
     * @param vetor                                                            *
     * @param i                                                                *
     * @param j                                                                *
     **************************************************************************/
    void addAresta(Aresta[][] matriz, Aresta[] vetor, int i, int j)
    {
        int k = 0;
        while(k < vetor.length  && vetor[k].getPeso() < Long.MAX_VALUE)
            k++;
        //setFloresta(1) ainda estah servindo para o metodo isMST
        vetor[k] = new Aresta(i, j, matriz[i][j].getPeso(), 1);
    }
    
    boolean isFull (Aresta[] vetorMST)
    {
        for(int i = 0; i < vetorMST.length; i++)
            if(vetorMST[i].getFloresta() == 0)
                return false;
        return true;
    }
    
    /***************************************************************************
     * O metodo deve retornar uma resposta verdadeira ou false. O metodo       *
     * consiste em dizer, se a MST ira continuar acilica mesmo apos a insercao *
     * de uma Aresta entre os vertices I e J.                                  *
     * @param vetor                                                            *
     * @param verticeI                                                         *
     * @param verticeJ                                                         *
     * @return                                                                 *
     **************************************************************************/
    private boolean isAcyclic (Aresta [] vetor, int verticeI, int verticeJ)
    {
        //variaveis para verificar se o vertice I e J ja pertencem ao vetor MST
        boolean vI = false, vJ = false;
        for(int k = 0; k < vetor.length  && vetor[k].getPeso() < Long.MAX_VALUE; k++)
        {
            if( verticeI == vetor[k].getV1() || verticeI == vetor[k].getV2() )
                vI = true;
            if( verticeJ == vetor[k].getV1() || verticeJ == vetor[k].getV2() )
                vJ = true;
        }
        // (true,true)=false : se os 2 vertices ja pertences a mst, entao false
        return !(vI && vJ);
    }
    
}
