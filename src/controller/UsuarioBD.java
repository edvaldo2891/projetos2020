package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioBD {
    
    Conexao conexao;
    public UsuarioBD() {
       conexao = new Conexao();
        
    }
    
    public void salvar(Usuario us)throws  SQLException{
        String insert = "insert into usuario(nome,login,senha,layout,permissao)values(?,?,?,?,?)";
            conexao.conectar();
            
            PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setString(1, us.getNome());
            stmt.setString(2, us.getLogin());
            stmt.setString(3, us.getSenha());
            stmt.setInt(4, us.getLayout());
            stmt.setInt(5, us.getPermissao());
            stmt.execute();
            stmt.close();
            conexao.desconectar();
          
    }
    public Usuario logar(String login, String senha)throws SQLException{
        
        Usuario us = new Usuario();
        String select = "select * from usuario where login = ? and senha = ?";
        
         conexao.conectar();
         
        
         PreparedStatement stmt = conexao.getCon().prepareStatement(select);
         stmt.setString(1, login);
         stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();
        us.setId(Integer.parseInt(rs.getString("id")));
        us.setNome(rs.getString("nome"));
        us.setLogin(rs.getString("login"));
        us.setSenha(rs.getString("senha"));
        us.setLayout(Integer.parseInt(rs.getString("layout")));
        us.setPermissao(Integer.parseInt(rs.getString("permissao")));
        
        
         
        stmt.close();
        conexao.desconectar();
        return  us;        
    }
    public void ativaUsuario(int id, int op)throws SQLException{
        String update = "update usuario set ativo = ? where id = ?" ;
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
            if(op == 1){
                stmt.setInt(1, 1);
            }
            else{
               stmt.setInt(1, 0); 
            }
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            conexao.desconectar();
    }
    public boolean verificaNome(Usuario u)throws SQLException{
       String select = "select * from usuario where nome = ? or login = ? and id <> ?" ;
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);            
            stmt.setString(1, u.getNome());             
            stmt.setString(2, u.getLogin()); 
            stmt.setInt(3, u.getId());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if(rs.first()){
                stmt.close();
                conexao.desconectar();
                return false;
            }else{
                 stmt.close();
                 conexao.desconectar();
                 return true;
            }
    }
    
    public List<Usuario> buscaUsuarios(String nome) throws SQLException{
        List<Usuario> us = new ArrayList<>();
        
        String select = "select * from usuario u where u.nome like ? order by u.id asc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setString(1, "%"+nome+"%");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(rs.getString("u.id")));
            usuario.setNome(rs.getString("u.nome"));
            usuario.setLogin(rs.getString("u.login"));
            usuario.setSenha(rs.getString("u.senha"));
            usuario.setLayout(Integer.parseInt(rs.getString("u.layout")));
            usuario.setPermissao(Integer.parseInt(rs.getString("u.permissao")));
            
            
            us.add(usuario);
        }       
        stmt.close();
        conexao.desconectar();
        return  us;
    }
    
    public List<Usuario> buscaUsuarios2(Integer id) throws SQLException{
        List<Usuario> us = new ArrayList<>();
        String select = "select * from usuario u where u.id = ?";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1,id);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(rs.getString("u.id")));
            usuario.setNome(rs.getString("u.nome"));
            usuario.setLogin(rs.getString("u.login"));
            usuario.setSenha(rs.getString("u.senha"));
            usuario.setLayout(Integer.parseInt(rs.getString("u.layout")));
            usuario.setPermissao(Integer.parseInt(rs.getString("u.permissao")));
            
            
            us.add(usuario);
        }       
        stmt.close();
        conexao.desconectar();
        return  us;
    }
    
    public void alterar(Usuario u)throws SQLException{
        String update = "update usuario set nome = ?, login = ?, senha = ?, permissao = ? where id = ?";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
        
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getLogin());
        stmt.setString(3, u.getSenha());
        stmt.setInt(4, u.getPermissao());
        stmt.setInt(5, u.getId());
        
        stmt.execute();
        stmt.close();
        conexao.desconectar();
    }
     public void alterarTema(Usuario u)throws SQLException{
        String update = "update usuario set layout = ? where id = ?";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
        
        stmt.setInt(1, u.getLayout());
        stmt.setInt(2, u.getId());
        
        stmt.execute();
        stmt.close();
        conexao.desconectar();
    }
    public void delete(int id) throws SQLException{
       
        String delete = "delete from usuario where id = ?";
       conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(delete);
        stmt.setInt(1, id);
       
        stmt.execute();
        stmt.close();
        conexao.desconectar();
   }
    public String senhaAdmin() throws SQLException{
       Usuario usuario = new Usuario();
        String select = "select senha from usuario where login = 'Adm'";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        usuario.setSenha(rs.getString("senha"));
        
        stmt.close();
        conexao.desconectar();
        return usuario.getSenha();
    }
    public int layout_usuario(int op) throws SQLException{
        int layout = 0;
        
        String  select = "select u.layout from usuario u where u.id = ?";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setString(1, String.valueOf(op));
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
           int u;
           
           u = rs.getInt("u.layout");            

           layout = u;
        }    
        stmt.close();
        conexao.desconectar();
        return  layout;
    }
}
