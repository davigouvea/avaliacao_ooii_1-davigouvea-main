package ifpr.pgua.eic.avaliacao01.model.DAO;

    import ifpr.pgua.eic.avaliacao01.model.FabricaConexoes;
    
    public class JDBCLivroDAO implements LivroDAO {
    
        public FabricaConexoes fabricaConexoes;
    
        public JDBCLivroDAO(FabricaConexoes fabricaConexoes) {
            this.fabricaConexoes = fabricaConexoes;
        }
    
    }


