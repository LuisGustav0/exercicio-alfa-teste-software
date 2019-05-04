package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaDisciplina;

import java.sql.PreparedStatement;

public class DeletaDisciplina extends PersistenciaJdbc {

    public boolean deletaDisciplina(Long id){
        boolean result = false;
        try {
            Disciplina disciplina = new ConsultaDisciplina().consultaPorId(id);
            if (disciplina.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM DISCIPLINAS WHERE ID_DISCIPLINA = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("A Disciplina foi excluida corretamente!");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrada disciplina com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
