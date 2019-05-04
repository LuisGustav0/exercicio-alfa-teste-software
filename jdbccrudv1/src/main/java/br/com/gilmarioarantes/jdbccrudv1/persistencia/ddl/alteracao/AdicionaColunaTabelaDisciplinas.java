package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;

public class AdicionaColunaTabelaDisciplinas extends PersistenciaJdbc {

    public boolean adicionaColuna() throws Exception{

        preparaPersistencia();

        System.out.println("\nAlterando a Tabela Disciplinas");

        String sql = "ALTER TABLE DISCIPLINAS " +
                "ADD COLUMN CARGA_HORARIA DECIMAL(5,2) NOT NULL";

        stmt.executeUpdate(sql);

        System.out.println("\nTabela Disciplinas alterada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }
}
