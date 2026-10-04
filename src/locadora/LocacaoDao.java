package locadora;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocacaoDao {

   private Connection conn;
   private PreparedStatement st;
   private ResultSet rs;
    
     public LocacaoDao(){
        conn = Conexao.conectar();
     }
     
     public void inserir(Locacao locacao) {

        String sql = "INSERT INTO locacao (id_cliente,id_filme,quantidade,data_locacao,data_devolucao,valor_total) VALUES (?,?,?,?,?,?)";
     
     try {

        st = conn.prepareStatement(sql);

        st.setInt(1, locacao.getIdCliente());
        st.setInt(2, locacao.getIdFilme());
        st.setInt(3, locacao.getQuantidade());
        st.setDate(4, Date.valueOf(locacao.getDataLocacao()));
        st.setDate(5, Date.valueOf(locacao.getDataDevolucao()));
        st.setDouble(6, locacao.getValorTotal());
        st.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<Locacao> listar() {

        List<Locacao> lista = new ArrayList<>();

        String sql = "SELECT * FROM locacao";

        try {
            
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()) {

                Locacao l = new Locacao();

                l.setId(rs.getInt("id"));
                l.setIdCliente(rs.getInt("id_cliente"));
                l.setIdFilme(rs.getInt("id_filme"));
                l.setDataLocacao(rs.getDate("data_locacao").toLocalDate());

                lista.add(l);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}