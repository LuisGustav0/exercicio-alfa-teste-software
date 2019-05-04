package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Turma;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaTurma;

import java.sql.PreparedStatement;

public class DeletaTurma extends PersistenciaJdbc {

    public boolean deletaTurma(Long id){
        boolean result = false;
        try {
            Turma turma = new ConsultaTurma().consultaPorId(id);
            if (turma.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM TURMAS WHERE ID_TURMA = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("A Turma foi excluida corretamente!");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrada Turma com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
