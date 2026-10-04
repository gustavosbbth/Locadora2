package locadora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

    
     private Connection conn;
     private PreparedStatement st;
     private ResultSet rs;
    
     public FilmeDao(){
         conn = Conexao.conectar();
     }
    public void cadastrar(Filme filme) {
        String sql = "INSERT INTO filme(titulo, genero, quantidade, valor) VALUES (?, ?, ?, ?)";

        try  {
            st = conn.prepareStatement(sql);
            
            st.setString(1, filme.getTitulo());
            st.setString(2, filme.getGenero());
            st.setInt(3,filme.getQuantidade());
            st.setDouble(4,filme.getValor());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Filme> listar() {
        List<Filme> lista = new ArrayList<>();

        String sql = "SELECT * FROM filme";

        try  {
            
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {
                Filme f = new Filme();

                f.setId(rs.getInt("id"));
                f.setTitulo(rs.getString("titulo"));
                f.setGenero(rs.getString("genero"));

                lista.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}