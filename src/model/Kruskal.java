
package model;

import java.util.List;

import util.AlgoritmoGuloso;
import util.AlgoritmoOrdenacao;
import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.09.2018                                                           *
 ******************************************************************************/
public class Kruskal implements AlgoritmoGuloso{

    @Override
    public Aresta [] gerarMST(Aresta [] vetorAresta, int tamanhoVetor, int numeroVertices) 
    {
        Aresta [] mst = new Aresta[numeroVertices];
        //usando InsertionSort para ordenar Vetor nao descrescente
        AlgoritmoOrdenacao.ordenar(vetorAresta);
        //gerar MST
        for(int loop = 0; loop < tamanhoVetor; loop++)
        {   //printando vetor ordenado
            System.out.println(vetorAresta[loop].getPeso());
        }
        
        return mst;
    }
    
}
