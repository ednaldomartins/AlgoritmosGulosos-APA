
package control;

import infra.Arquivo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.09.2018                                                           *
 ******************************************************************************/
public class ControllerMST 
{
    private final List <Aresta> listaAresta;
    private final String ARQUIVO_ORIGEM = "..\\AlgoritmosDeOrdenacao\\listaDesordenada.txt";

    public ControllerMST() {
        this.listaAresta = carregarListaArquivo();
    }

    
    private List<Aresta> carregarListaArquivo() 
    {
        try {
            return new Arquivo(ARQUIVO_ORIGEM).carregarMST();
        } catch (IOException ex) { Logger.getLogger(ControllerMST.class.getName()).log(Level.SEVERE, null, ex); }
        return null;
    }
}
