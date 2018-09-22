
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

/**
 * @author Ednaldo
 *  data: 22.09.2018
 */
public class Arquivo {
    
    private Path loadPath;
    private Charset utf8 = StandardCharsets.UTF_8;
    
    public Arquivo (String loadPath) {
        this.loadPath = Paths.get(loadPath);
    }
    
    /**
     * MST: Minimum Soanning Tree
     * @return arvore
     * @throws IOException 
     */
    public Aresta [] carregarMST() throws IOException {
        Aresta [] listaAresta = null;
        List<Long> listaPesoAresta = new ArrayList<>();
        
        try (BufferedReader reader = Files.newBufferedReader(loadPath, utf8)){
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] parametro = line.split(" ");
                //add valores no array dinamico
                for(int i = 0; i < parametro.length; i++)
                    listaPesoAresta.add( Long.parseLong(parametro[i]) );
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");}
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        catch(IOException ex) 
        {
            System.err.println("Erro de leitura");
            ex.printStackTrace();
        }
        //FAZER: repassar pesos da aresta para o novo vetor (usar funcao)
        int tamanhoMST = listaPesoAresta.size();
        listaAresta = new Aresta [tamanhoMST];
        for(int i = 0; i < tamanhoMST; i++)
           listaAresta[i] = new Aresta(10, 10, listaPesoAresta.get(i), 10);
        //no retorno ainda estah passando o numero de vertices na posicao 0
        return listaAresta;
    }
    
}
