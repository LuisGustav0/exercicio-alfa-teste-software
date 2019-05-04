/**
 * Listagem 5. . Lendo dados de um arquivo de texto.
 * https://www.devmedia.com.br/java-arquivos-e-fluxos-de-dados/22859
 */
package br.com.gilmarioarantes.jdbccrudv1.util;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GeraListaProfessores {

    static Logger logger = Logger.getLogger(GeraListaProfessores.class.getName());

    private static List<Professor> professores = new ArrayList<>();
    private static String nomeArquivo = "src/main/resources/professores.txt";

    public static List<Professor> geraLista(){

        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            Long id = new Long(0);
            String linha = lerArq.readLine();

            String nome = "";
            String email = "";
            String titulacao = "";

            while(linha != null){
                StringTokenizer st = new StringTokenizer(linha,";");
                while (st.hasMoreElements()){
                    id = Long.parseLong(st.nextToken());
                    nome = st.nextToken();
                    email = st.nextToken();
                    titulacao = st.nextToken();
                }

                professores.add(new Professor(id, nome, email, titulacao));

                linha = lerArq.readLine(); // lê da segunda até a última linha

            }
            arq.close();
        }catch (Exception e){
            logger.error("Erro na abertura do arquivo!", e);
        }
        return professores;
    }

}
