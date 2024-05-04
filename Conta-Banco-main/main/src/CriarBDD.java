import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriarBDD {
    public boolean criarTabela(){
        Connection conn = null;
        PreparedStatement stat = null;
        
        try{
            String sql = "create table conta ("
                        + "codConta INT PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                        + "codAgenc INT NOT NULL,"
                        + "nome varchar(50) NOT NULL,"
                        + "saldo DECIMAL(10,2));";
            conn = conexao.abrirConexao();
            stat = conn.prepareStatement(sql);
            stat.execute();

            System.out.println("Tabela criada com sucesso!!");
            return true;
        } catch(Exception e){
            System.out.println("Erro ao criar a tabela \n"+e.getMessage());
            return false;
        } finally{
            conexao.fecharConexao(conn,stat);
        }
    }
}
