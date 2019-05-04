/**
 * Listagem 5. . Lendo dados de um arquivo de texto.
 * https://www.devmedia.com.br/java-arquivos-e-fluxos-de-dados/22859
 */
package br.com.gilmarioarantes.jdbccrudv1.util;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GeraListaAlunos {

    static Logger logger = Logger.getLogger(GeraListaAlunos.class.getName());

    private static List<Aluno> alunos = new ArrayList<>();
    private static String nome = "src/main/resources/alunos.txt";

    public static List<Aluno> geraLista(){

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);
            Long id = new Long(0);
            String linha = lerArq.readLine();
            String matricula = "";
            String nomeAluno = "";
            String sexo = "";
            while(linha != null){
                StringTokenizer st = new StringTokenizer(linha,";");
                while (st.hasMoreElements()){
                    id = Long.parseLong(st.nextToken());
                    matricula = st.nextToken();
                    nomeAluno = st.nextToken();
                    sexo = st.nextToken();
                }

                String dataNascimento = GeraData.geraData();

                alunos.add(new Aluno(id, matricula, nomeAluno, sexo, new FormataData().stringToTimeStamp(dataNascimento)));

                linha = lerArq.readLine(); // lê da segunda até a última linha

            }
            arq.close();
        }catch (IOException e){
            logger.error("Erro na abertura do arquivo!", e);
        }
        return alunos;
    }

}
