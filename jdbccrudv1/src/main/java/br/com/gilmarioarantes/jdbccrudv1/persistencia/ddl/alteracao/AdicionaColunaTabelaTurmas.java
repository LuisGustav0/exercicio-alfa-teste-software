package br.com.gilmarioarantes.jdbccrudv1.persistencia.ddl.alteracao;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;

public class AdicionaColunaTabelaTurmas extends PersistenciaJdbc {

    public boolean adicionaColuna() throws Exception{

        preparaPersistencia();

        System.out.println("\nAlterando a Tabela Turmas");

        String sql = "ALTER TABLE TURMAS ADD COLUMN FREQUENCIA DECIMAL(5,2) NOT NULL;";

        stmt.executeUpdate(sql);

        System.out.println("\nTabela Turmas alterada com sucesso!");

        //STEP 4: Clean-up environment
        stmt.close();
        connection.close();

        return true;
    }
}
