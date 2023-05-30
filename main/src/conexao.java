import java.sql.*;

public class conexao {
    private static String driver;
    private static String servidor;
    private static String usuario;
    private static String senha;

    public static Connection abrirConexao(){
        driver="com.mysql.cj.jdbc.Driver";
        servidor="jdbc:mysql://localhost:3306/conta";
        usuario="root";
        senha="1234";
        try{
            Class.forName(driver);
            return DriverManager.getConnection(servidor,usuario,senha);
        }catch(Exception e){
           System.out.println("agora deu o karaio memo deu a porra "+e);
           return null; 
        }
    }
    
    public static void fecharConexao(Connection conn){
        if (conn != null){
            try{
                conn.close();
            }catch(Exception e){
                System.out.print("fudeu "+e);
            }
        }  
    }

    public static void fecharConexao(Connection conn, PreparedStatement stat){
        conexao.fecharConexao(conn);
        if (stat != null){
            try{
                stat.close();
            } catch(Exception e){
                System.out.println("deu ruim "+e);
            }
        }
    }

    public static void fecharConexao(Connection conn, PreparedStatement stat, ResultSet res){
        conexao.fecharConexao(conn, stat);
        if (res != null){
            try{
                res.close();
            } catch (Exception e){
                System.out.println("me ferrei amigos e amigas "+e);
            }
        }
    }
}
