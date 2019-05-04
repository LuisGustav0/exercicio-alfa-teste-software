/**
 * Listagem 5. . Lendo dados de um arquivo de texto.
 * https://www.devmedia.com.br/java-arquivos-e-fluxos-de-dados/22859
 */
package br.com.gilmarioarantes.jdbccrudv1.util;

import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GeraListaDisciplinas {

    static Logger logger = Logger.getLogger(GeraListaDisciplinas.class.getName());

    private static List<Disciplina> disciplinasSemCurso = new ArrayList<>();
    private static String nomeArquivo = "src/main/resources/disciplinas.txt";

    public static List<Disciplina> geraLista(){

        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            Long id = new Long(0);
            String nomeDisciplina = "";

            String linha = lerArq.readLine();

            while(linha != null){
                StringTokenizer st = new StringTokenizer(linha, ";");
                while(st.hasMoreElements()){
                    id = Long.parseLong(st.nextToken());
                    nomeDisciplina = st.nextToken();
                }
                disciplinasSemCurso.add(new Disciplina(id, linha, 64.0));

                linha = lerArq.readLine(); // lê da segunda até a última linha

            }
            arq.close();
        }catch (IOException e){
            logger.error("Erro na abertura do arquivo!", e);
        }
        return disciplinasSemCurso;
    }

}
