import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class contaBDD{
    public static boolean inserirConta(conta c){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="insert into "
                        +"conta (codAgenc,nome,saldo) "
                        +"values (?,?,?);";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, c.getCodAgenc());
            stat.setString(2, c.getNome());
            stat.setDouble(3, c.getSaldo());
            stat.execute();
            ResultSet rs=stat.getGeneratedKeys();
            if (rs.next()){
                c.setCodConta(rs.getInt(1));
            }
            return true;
        } catch (Exception e){
            System.out.println("Não inserido \n"+e.getMessage());
            return false;
        } finally{
            conexao.fecharConexao(conn, stat);
        }
    }

    public static boolean alterarConta(conta c){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="update conta set "
                    +"codAgenc=?, "
                    +"nome=?, "
                    +"saldo=?, "
                    +"where codConta=?;";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
            stat.setInt(1, c.getCodAgenc());
            stat.setString(2, c.getNome());
            stat.setDouble(3, c.getSaldo());
            stat.setInt(4, c.getCodConta());
            stat.execute();

            return true;
        } catch (Exception e){
            System.out.println("Alteração não realizada \n"+e.getMessage());
            return false;
        }finally{
            conexao.fecharConexao(conn, stat);
        }
    }

    public static boolean somarSaldo(conta c){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="update conta set "
                    +"saldo=saldo+? "
                    +"where codConta=?;";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
           
            stat.setDouble(1, c.getSaldo());
            stat.setInt(2, c.getCodConta());
            stat.execute();

            System.out.println("Deposito Realizado!!");
            return true;
        } catch (Exception e){
            System.out.println("Deposito não realizado \n"+e.getMessage());
            return false;
        }finally{
            conexao.fecharConexao(conn, stat);
        }
    }

    public static boolean alterarAgencia(conta c){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="update conta set "
                    +"codAgenc=? "
                    +"where codConta=?;";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
           
            stat.setInt(1, c.getCodAgenc());
            stat.setInt(2, c.getCodConta());
            stat.execute();

            System.out.println("Agência Alterada!!");
            return true;
        } catch (Exception e){
            System.out.println("Agência não alterada"+e.getMessage());
            return false;
        }finally{
            conexao.fecharConexao(conn, stat);
        }
    }

    public static boolean alterarNome(conta c){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="update conta set "
                    +"nome=? "
                    +"where codConta=?;";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
           
            stat.setString(1, c.getNome());
            stat.setInt(2, c.getCodConta());
            stat.execute();

            System.out.println("Nome Alterado!!");
            return true;
        } catch (Exception e){
            System.out.println("Nome não alterado \n"+e.getMessage());
            return false;
        }finally{
            conexao.fecharConexao(conn, stat);
        }
    }

    public static boolean diminuirSaldo(conta c){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="update conta set "
                    +"saldo=saldo-? "
                    +"where codConta=?;";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
           
            stat.setDouble(1, c.getSaldo());
            stat.setInt(2, c.getCodConta());
            stat.execute();

            System.out.println("Saque Realizado!!");
            return true;
        } catch (Exception e){
            System.out.println("Saque não realizado \n"+e.getMessage());
            return false;
        }finally{
            conexao.fecharConexao(conn, stat);
        }
    }

    public ArrayList<conta> verContas(){
        ArrayList<conta> lista=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        
        try{
            String sql="select * from conta";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
            rs=stat.executeQuery();

            while(rs.next()){
                conta c=new conta();
                c.setCodConta(rs.getInt("codConta"));
                c.setCodAgenc(rs.getInt("codAgenc"));
                c.setNome(rs.getString("nome"));
                c.setSaldo(rs.getDouble("saldo"));
                lista.add(c);
            }
            return lista;
        }catch (Exception e){
            System.out.println("Erro ao ver contas \n"+e.getMessage());
            return null;
        }finally{
            conexao.fecharConexao(conn, stat, rs);
        }
    }

    public static conta consultConta(int cod){
        conta c=null;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;
        try{
            String sql="select * from conta where codConta=?";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
            stat.setInt(1, cod);
            rs=stat.executeQuery();
            if(rs.next()){
                c=new conta();
                c.setCodConta(rs.getInt("codConta"));
                c.setCodAgenc(rs.getInt("codAgenc"));
                c.setNome(rs.getString("nome"));
                c.setSaldo(rs.getDouble("saldo"));
                } 
            return c;
            }catch(Exception e){
                System.out.println("Erro ao ver a conta \n"+e.getMessage());
                return null;
            } finally{
                conexao.fecharConexao(conn, stat, rs);
        }
    }

    public static conta consultSaldo(int cod){
        conta c=null;
        Connection conn=null;
        PreparedStatement stat=null;
        ResultSet rs=null;

        try{
            String sql="select saldo from conta where codConta=?";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
            stat.setInt(1, cod);
            rs=stat.executeQuery();
            if(rs.next()){
                c=new conta();
                c.setSaldo(rs.getDouble("saldo"));
                } 
            return c;
            }catch(Exception e){
                System.out.println("Erro ao consultar saldo \n"+e.getMessage());
                return null;
            } finally{
                conexao.fecharConexao(conn, stat, rs);
        }
    }

    public static boolean excluirConta(int cod){
        Connection conn=null;
        PreparedStatement stat=null;

        try{
            String sql="Delete from conta "
                        +"where codConta=?";
            conn=conexao.abrirConexao();
            stat=conn.prepareStatement(sql);
            stat.setInt(1,cod);
            stat.execute();

            System.out.println("Conta excluída!!");
            
            return true;
        } catch (Exception e){
            System.out.println("Erro ao excluir \n"+e.getMessage());
            return false;
        } finally {
            conexao.fecharConexao(conn, stat);
        }
    }
   
}
