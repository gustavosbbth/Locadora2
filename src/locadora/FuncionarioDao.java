package locadora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

   
    
     Connection conn;
     PreparedStatement st;
     ResultSet rs;
    
     public FuncionarioDao(){
    conn = Conexao.conectar();
}
    
    public int cadastrar(Funcionario funcionario) {

       String sql = "INSERT INTO funcionario(nome, telefone) VALUES (?, ?)";
       int status;
        try
              {
             st = conn.prepareStatement(sql);
             
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getTelefone());
           
            status = st.executeUpdate();
            return status;
            
    }catch(SQLException e){
            System.out.println("Erro: "+ e.getMessage());
            return e.getErrorCode();
    }
    }
}
       
        
    
    
