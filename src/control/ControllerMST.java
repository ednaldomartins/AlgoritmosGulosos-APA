
package control;

import infra.Arquivo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aresta;
import util.AlgoritmoGuloso;
import util.FuncoesVetor;
import util.Print;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.09.2018                                                           *
 ******************************************************************************/
public class ControllerMST 
{
    private final List <Aresta> listaAresta;
    private final String ARQUIVO_ORIGEM = "..\\AlgoritmosGulosos\\dij10.txt";
    private Aresta [] arvoreGeradora;
            
    public ControllerMST() {
        this.listaAresta = carregarListaArquivo();
    }

    public void controleMST(AlgoritmoGuloso algoritmoGuloso) 
    {
        //tamanho da lista de combinacoes de vestices(arestas), e numero de vertices
        int numeroVertices = (int) listaAresta.get(0).getPeso();
        int tamanhoLista = listaAresta.size()-1;
        //copiando Array para trabalhar com Vetor
        Aresta vetorAresta [] = new Aresta [ tamanhoLista ];
        FuncoesVetor.copiarLista(listaAresta, vetorAresta);
        //criando e recuperando MST
        arvoreGeradora = new Aresta[ numeroVertices-1 ];
        algoritmoGuloso.gerarMST(vetorAresta, arvoreGeradora, vetorAresta.length, numeroVertices);
    }
     
    private List<Aresta> carregarListaArquivo() 
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarMST();
        } catch (IOException ex) { Logger.getLogger(ControllerMST.class.getName()).log(Level.SEVERE, null, ex); }
        return null;
    }

    
    public void printLista ()
    {
        Print.printLista(listaAresta);
    }
    
    public void printMST ()
    {
        Print.printMST(arvoreGeradora);
    }
    
    public void printResultadoMST ()
    {
        Print.printResultadoMST(arvoreGeradora);
    }
   
}
