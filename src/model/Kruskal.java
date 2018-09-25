
package model;

import util.AlgoritmoGuloso;
import util.AlgoritmoOrdenacao;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.09.2018                                                           *
 ******************************************************************************/
public class Kruskal implements AlgoritmoGuloso{

    @Override
    public Aresta [] gerarMST(Aresta [] vetorAresta, Aresta [] mst, int tamanhoVetor, int numeroVertices) 
    {
        //numero de Arestas = numero Vertices - 1
        //Aresta [] mst = new Aresta[numeroVertices-1];
        //usando InsertionSort para ordenar Vetor nao descrescente
        AlgoritmoOrdenacao.ordenar(vetorAresta);
        //gerar MST
        //apontador diz ateh qual posicao a mst[]  foi preenchida
        mst[0] = vetorAresta[0];
        int numeroFloresta = 0;
        mst[0].setFloresta(numeroFloresta);
        for(int loop = 0, apontador = 0; ( loop < tamanhoVetor && apontador < mst.length-1 ); loop++)
        {   //printando vetor ordenado
            System.out.println(vetorAresta[loop].getPeso());
            
            //ENXUGAR O CODIGO
            int florestaV1 = 0, florestaV2 = 0;
            for(int i = 0; i <= apontador ; i++)
            {   //pela logica tanto v1, quanto v2 da mst[i] tem a mesma floresta
                if(   ( vetorAresta[loop].getV1() == mst[i].getV1() ) || ( vetorAresta[loop].getV1() == mst[i].getV2() )  )
                {    
                    florestaV1 = mst[i].getFloresta();
                    break;
                }
            }
            
            for(int i = 0; i <= apontador; i++)
            {
                if(   ( vetorAresta[loop].getV2() == mst[i].getV1() ) || ( vetorAresta[loop].getV2() == mst[i].getV2() )   )
                {
                    florestaV2 = mst[i].getFloresta();
                    break;
                }
            }
            //ponta solta
            if(florestaV1 == 0 && florestaV2 == 0)
            {
                apontador++;
                mst[apontador] = vetorAresta[loop];
                numeroFloresta++;
                mst[apontador].setFloresta(numeroFloresta);
                continue;
            }
            //ligar V1 da nova aresta
            if(florestaV1 != 0 && florestaV2 == 0)
            {
                //apontador direciona para nova posicao
                apontador++;
                mst[apontador] = vetorAresta[loop];
                mst[apontador].setFloresta(florestaV1);
                continue;
            }
            //ligar V2 da nova aresta
            if(florestaV1 == 0 && florestaV2 != 0)
            {
                apontador++;
                mst[apontador] = vetorAresta[loop];
                mst[apontador].setFloresta(florestaV2);
                continue;
            }
            //se chegou ateh ambos sao diferente de 0, se forem diferentes entao deve unir
            if(florestaV1 != florestaV2)
            {   
                for(int j = 0; j <= apontador; j++)
                {   //unir as duas florestas setando o mesmo valor 
                    if(mst[j].getFloresta() == florestaV2)
                        mst[j].setFloresta(florestaV1);
                }
                //apontador direciona para nova posicao
                apontador++;
                mst[apontador] = vetorAresta[loop];
                mst[apontador].setFloresta(florestaV1);
                continue;
            }         
        }
                
        return mst;
    }
    
}
