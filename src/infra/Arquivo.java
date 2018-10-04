
package infra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Aresta;
import util.FuncoesVetor;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  data: 22.09.2018                                                           *
 ******************************************************************************/
public class Arquivo 
{
    private final Path loadPath;
    private final Charset utf8 = StandardCharsets.UTF_8;
    
    public Arquivo (String loadPath) 
    {
        this.loadPath = Paths.get(loadPath);
    }
    /*
    usar uma metodologia diferente na leitura do arquivo futuramente
    por exemplo: 1_34_8, que quer dizer que o vertice1 estah ligado ao vertice8
    atraves de uma aresta de peso 34
    */
    /***************************************************************************
     * MST: Minimum Soanning Tree                                              *
     *      Note que o primeiro elemento a ser recuperado da lista eh o        *
     *  numero de vertices da lista, e ele estarah ligando os vertices 0 e 1,  *
     *  que no fim das contas serah descartado, restando apenas o tamanho.     *
     *      A numeracao dos vertices se darah a partir do vertice 1 em diante  *
     * i: primeiro vertice                                                     *
     * j: segundo vertice                                                      *
     * k: valor do peso da aresta que estah ligando os vertice 'i' e 'j'       *
     * @return arvore                                                          *
     * @throws IOException                                                     *
     **************************************************************************/
    public List<Aresta> carregarMST() throws IOException 
    {
        List<Aresta> listaPesoAresta = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(loadPath, utf8))
        {
            String line = null;
            for(int i = 0; (line = reader.readLine()) != null; i++) 
            {   
                String[] parametro = line.split(" ");
                for(int j = i+1, k = 0; k < parametro.length; k++, j++)
                    listaPesoAresta.add(   new Aresta(i, j, Long.parseLong(parametro[k]), 0 )   );
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");}
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        catch(IOException ex) {System.err.println("Erro de leitura");}
        
        return listaPesoAresta;
    }
    
    public Aresta [][] carregarMatrizMST() throws IOException 
    {
        Aresta [][] matriz = null;
        try (BufferedReader reader = Files.newBufferedReader(loadPath, utf8))
        {
            String line = null;
            int tamanhoMatriz = Integer.parseInt( reader.readLine() );
            matriz = new Aresta[tamanhoMatriz][tamanhoMatriz];
            FuncoesVetor.iniciarMatriz(matriz);
            for(int i = 0; (line = reader.readLine()) != null; i++) 
            {   
                String[] parametro = line.split(" ");
                for(int j = i+1, k = 0; k < parametro.length; k++, j++)
                    matriz[i][j] =  new Aresta( Long.parseLong(parametro[k]), 0 );
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");}
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        catch(IOException ex) {System.err.println("Erro de leitura");}
            
        return matriz;
    }
    
}
