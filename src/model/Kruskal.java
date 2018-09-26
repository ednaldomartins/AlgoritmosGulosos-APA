
package model;

import util.AlgoritmoGuloso;
import util.AlgoritmoOrdenacao;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.09.2018                                                           *
 ******************************************************************************/
public class Kruskal implements AlgoritmoGuloso
{
    /***************************************************************************
     * gerarMST de Kruskal deve ordenar a lista, de forma nao decrescente      *
     * e verificar a cada interacao do for, se a nova aresta deve ou nao       *
     * conectar os 2 vertices, seguindo os críterios do algoritmo.             *
     * @param vetorAresta                                                      *
     * @param mst                                                              *
     * @param tamanhoVetor                                                     *
     **************************************************************************/
    @Override
    public void gerarMST(Aresta [] vetorAresta, Aresta [] mst, int tamanhoVetor) 
    {
        //verificando se o existe uma arvore para garantir que funcione corretamente
        if(vetorAresta != null && tamanhoVetor > 0)
        {
            //Ordenando o vetor de arestas de forma nao decrescente
            AlgoritmoOrdenacao.ordenar(vetorAresta);
            //Gerar MST. Apontador diz ateh qual posicao a mst[]  foi preenchida
            int numeroFloresta = 1;
            mst[0] = vetorAresta[0];
            mst[0].setFloresta(numeroFloresta);
            //loop comeca em 1, pois o primeiro elemento ja foi inserido na MST
            for(int loop = 1, apontador = 0; ( loop < tamanhoVetor && apontador < mst.length-1 ); loop++)
            {   
                //variaveis para verificar se a aresta deve ser inserida ou nao
                int florestaV1 = 0, florestaV2 = 0;
                
                //os 2 for devem buscar nos vetores, vertices conectados
                for(int i = 0; i <= apontador ; i++)
                {   //pela logica tanto v1, quanto v2 da mst[i], tem a mesma floresta
                    if(  ( vetorAresta[loop].getV1() == mst[i].getV1() ) || 
                         ( vetorAresta[loop].getV1() == mst[i].getV2() )  )
                    {   //entao se ambas arestas entao ligadas a um mesmo vertice...
                        florestaV1 = mst[i].getFloresta();
                        break;
                    }
                }
                //a mesma logica do primeiro for, apenas usando outra visao
                for(int i = 0; i <= apontador; i++)
                {   //se a aresta estah ligada a algum vertice da MST
                    if(  ( vetorAresta[loop].getV2() == mst[i].getV1() ) || 
                         ( vetorAresta[loop].getV2() == mst[i].getV2() )  )
                    {   //entao guarde o numero da floresta
                        florestaV2 = mst[i].getFloresta();
                        break;
                    }
                }
                /*
                    Nessa etapa vamos verificar quais os vertices que a nova 
                aresta pode se conectar (ou nao deve ser conectada seguindo os 
                criterios de Kruskal).
                    florestaV1, forestaV2: guarda o numero da floresta do 
                vertice 1 e do vertice2, respectivamente, que a nova aresta esta
                conectando.
                    Caso 1: ambos sejam igual a 0, entao essa nova aresta estah
                conectando 2 novos vertices ateh entao desconhecidos, entao essa
                arresta farah parte de uma nova floresta, como uma ponta solta.
                    Caso 2: caso uma das florestas seja diferente de 0 e a outra
                igual a 0, entao houve alguma ligacao entre um vertice conhecido
                e um desconhecido, entao esse novo vertice deve se conectar com
                a nova aresta
                    Caso 3: ambos sao diferentes de 0, entao deve conectar ,se e 
                somente se, a nova ligacao entre ambos vertices conhecidos nao
                gerem um ciclo fechado.
                    Caso 4: ambos sao diferentes de 0, mas sao iguais, entao
                essa aresta deve ser ignorada para nao criar ciclo fechado entre
                vertices pertencentes a mesma floresta
                */
                if(florestaV1 == 0 && florestaV2 == 0)
                {   //aresta em nova floresta
                    apontador++;
                    numeroFloresta++;   
                    unir(vetorAresta, mst, numeroFloresta, apontador, loop);
                }
                else 
                {    
                    if(florestaV1 != 0 && florestaV2 == 0)
                    {   //aresta conecta com floresta do vertice1
                        apontador++;
                        unir(vetorAresta, mst, florestaV1, apontador, loop);
                    }
                    else if(florestaV1 == 0 && florestaV2 != 0)
                    {   //aresta conecta com floresta do vertice2
                        apontador++;
                        unir(vetorAresta, mst, florestaV2, apontador, loop);
                    }
                    //se chegou ateh aqui, entao ambos sao diferente de 0
                    else if(florestaV1 != florestaV2)
                    {   //como sao diferentes diferetes, entao
                        for(int j = 0; j <= apontador; j++)
                        {   //unir as duas florestas setando o mesmo valor 
                            if(mst[j].getFloresta() == florestaV2)
                                mst[j].setFloresta(florestaV1);
                        }   //eu preferi por manter a floresta do vertice1
                        apontador++;
                        unir(vetorAresta, mst, florestaV1, apontador, loop);
                    } 
                //se nao entrou em nenhum if, entao a uniao causaria um ciclo
                }
            }//fim do loop
        }//fim do if
    }//fim do metodo
    
    private void unir(Aresta [] vetorAresta, Aresta [] mst, int numFloresta, int apontador, int loop)
    {
        mst[apontador] = vetorAresta[loop];
        mst[apontador].setFloresta(numFloresta);
    }
    
}//fim da classe
    

