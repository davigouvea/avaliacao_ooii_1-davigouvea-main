package ifpr.pgua.eic.avaliacao01.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ifpr.pgua.eic.avaliacao01.model.entities.Livro;
import ifpr.pgua.eic.avaliacao01.utils.Env;

public class FabricaConexoes {
    private static final int MAX_CONEXOES=5;

    private static FabricaConexoes instance;

    private Connection[] conexoes;

    private FabricaConexoes(){
        conexoes = new Connection[MAX_CONEXOES];
    }

    public static FabricaConexoes getInstance(){
        if(instance == null){
            instance = new FabricaConexoes();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{

        String user = Env.get("DB_USER");
        String password = Env.get("DB_PASSWORD");
        String url = Env.get("DB_URL");


        for(int i=0;i<conexoes.length;i++){
            if(conexoes[i]==null || conexoes[i].isClosed()){
                conexoes[i] = DriverManager.getConnection(url, 
                                                          user, 
                                                          password);
                return conexoes[i];
            }
        }
        throw new SQLException("Não há conexões disponíveis! Esqueceu de fechar?");
    }

    public List<Livro> buscarTodos() {
        
        try {
        
            Connection con = getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM livros");
            ResultSet resultSet = pstm.executeQuery();
            ArrayList<Livro> livros = new ArrayList<>();
        
            while(resultSet.next()){
        
                Integer id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String editora = resultSet.getString("editora");
                Integer paginas = resultSet.getInt("paginas");
                Integer anoPublicacao = resultSet.getInt("anoPublicacao");
        
                Livro livro = new Livro(id, titulo, editora, paginas, anoPublicacao);
        
                livros.add(livro);
            }
            return livros;
        
        } catch (SQLException e) {
            return Collections.emptyList();
        }
        
    }
}
