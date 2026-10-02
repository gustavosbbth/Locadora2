package locadora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

     Connection conn;
     PreparedStatement st;
     ResultSet rs;
    
    public ClienteDao(){
        conn = Conexao.conectar();
    }
    public void cadastrar(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, telefone) VALUES (?, ?)";

        try {
            
            st = conn.prepareStatement(sql);
            
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getTelefone());

            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try {

             st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));

                lista.add(c);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}