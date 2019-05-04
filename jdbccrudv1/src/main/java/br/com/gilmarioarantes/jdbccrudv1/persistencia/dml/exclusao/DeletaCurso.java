package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Curso;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaCurso;

import java.sql.PreparedStatement;

public class DeletaCurso extends PersistenciaJdbc {
    public boolean deletaCurso(Long id){
        boolean result = false;
        try {
            Curso curso = new ConsultaCurso().consultaPorId(id);
            if (curso.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM ALUNOS WHERE ID_ALUNO = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Curso foi excluido corretamente!");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrado curso com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
