package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.base.PersistenciaJdbc;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.consulta.ConsultaProfessor;

import java.sql.PreparedStatement;

public class DeletaProfessor extends PersistenciaJdbc {

    public boolean deletaProfessor(Long id){
        boolean result = false;
        try {
            Professor professor = new ConsultaProfessor().consultaPorId(id);
            if (professor.getId() != null){
                preparaPersistencia();

                String sql = "DELETE FROM PROFESSORES WHERE ID_PROFESSOR = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setLong(1,id);
                pstmt.executeUpdate();
                result = true;
                System.out.println("O Professor foi excluido corretamente!");
                pstmt.close();
            }else{
                System.out.println("Não foi encontrado professor com id = " + id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
