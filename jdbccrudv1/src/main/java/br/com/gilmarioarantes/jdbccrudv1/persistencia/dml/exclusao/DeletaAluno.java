package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaAluno;

import java.sql.PreparedStatement;

public class DeletaAluno extends PersistenciaJdbc {
    public boolean deletaAluno(Long id){
        boolean result = false;
        try {
            Aluno aluno = new ConsultaAluno().consultaPorId(id);
            if (aluno.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM ALUNOS WHERE ID_ALUNO = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Aluno foi excluido corretamente!");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrado aluno com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
