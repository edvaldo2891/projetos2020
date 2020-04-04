package controller.rural;


import controller.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.rural.Exercicio;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EDVALDO ANTUNES
 */
public class ExercicioBD {
    
    Conexao conexao;

    public ExercicioBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Exercicio ex)throws  SQLException{        
        String insert = "insert into rural(exercicio,aparecida_salto,barreirinho,cacador,cerrado,furnas,"
                 + "herval,itopava,quadro_seda,lajeado,matao,morro_chato,morro_vermelho,morro_azul,pedra_branca,"
                 + "ponte_alta,sta_barbara,santa_cruz,demais_bairros)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, ex.getExercicio());
            stmt.setDouble(2,ex.getAparecida_salto());
            stmt.setDouble(3,ex.getBarreirinho());
            stmt.setDouble(4,ex.getCacador());
            stmt.setDouble(5,ex.getCerrado());            
            stmt.setDouble(6,ex.getFurnas());
            stmt.setDouble(7,ex.getHerval());
            stmt.setDouble(8,ex.getItopava());
            stmt.setDouble(9,ex.getQuadro_seda());          
            stmt.setDouble(10,ex.getLajeado());
            stmt.setDouble(11,ex.getMatao());
            stmt.setDouble(12,ex.getMorro_chato());
            stmt.setDouble(13,ex.getMorro_vermelho());
            stmt.setDouble(14,ex.getMorro_azul());            
            stmt.setDouble(15,ex.getPedra_branca());
            stmt.setDouble(16,ex.getPonte_alta());
            stmt.setDouble(17,ex.getSta_barbara());
            stmt.setDouble(18,ex.getSanta_cruz());            
            stmt.setDouble(19,ex.getDemais_bairros());
            
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public void delete(int id) throws SQLException{
       String delete = "delete from rural where cod = ?";
       conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(delete);
        stmt.setInt(1, id);
       
        stmt.execute();
            stmt.close();
            conexao.desconectar();
   }
    
   public void alterar(Exercicio ex)throws SQLException{
        String update = "update rural set exercicio = ?,aparecida_salto = ?,barreirinho = ?,cacador = ?,cerrado = ?,furnas = ?,"
                 + "herval = ?,itopava = ?,quadro_seda = ?,lajeado = ?,matao = ?,morro_chato = ?,morro_vermelho = ?,morro_azul = ?,pedra_branca = ?,"
                 + "ponte_alta = ?,sta_barbara = ?,santa_cruz = ?,demais_bairros = ?"
                + " where cod = ?";

        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
           
            stmt.setInt(1, ex.getExercicio());
            stmt.setDouble(2,ex.getAparecida_salto());
            stmt.setDouble(3,ex.getBarreirinho());
            stmt.setDouble(4,ex.getCacador());
            stmt.setDouble(5,ex.getCerrado());            
            stmt.setDouble(6,ex.getFurnas());
            stmt.setDouble(7,ex.getHerval());
            stmt.setDouble(8,ex.getItopava());
            stmt.setDouble(9,ex.getQuadro_seda());          
            stmt.setDouble(10,ex.getLajeado());
            stmt.setDouble(11,ex.getMatao());
            stmt.setDouble(12,ex.getMorro_chato());
            stmt.setDouble(13,ex.getMorro_vermelho());
            stmt.setDouble(14,ex.getMorro_azul());            
            stmt.setDouble(15,ex.getPedra_branca());
            stmt.setDouble(16,ex.getPonte_alta());
            stmt.setDouble(17,ex.getSta_barbara());
            stmt.setDouble(18,ex.getSanta_cruz());            
            stmt.setDouble(19,ex.getDemais_bairros());
            
            stmt.execute();
            stmt.close();
            conexao.desconectar();
   }
   public List<Exercicio> listaTabela(Integer ex) throws SQLException{
        List<Exercicio> lista = new ArrayList<>();
        
        String  select = "select * from rural v where v.exercicio = ? order by v.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, ex);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Exercicio e = new Exercicio();
           e.setId(Integer.parseInt(rs.getString("v.cod")));
           e.setExercicio(Integer.parseInt(rs.getString("v.exercicio")));
           e.setAparecida_salto(Double.parseDouble(rs.getString("v.aparecida_salto")));
           e.setBarreirinho(Double.parseDouble(rs.getString("v.barreirinho")));
           e.setCacador(Double.parseDouble(rs.getString("v.cacador")));
           e.setCerrado(Double.parseDouble(rs.getString("v.cerrado")));
           e.setFurnas(Double.parseDouble(rs.getString("v.furnas")));
           e.setHerval(Double.parseDouble(rs.getString("v.herval")));
           e.setItopava(Double.parseDouble(rs.getString("v.itopava")));
           e.setQuadro_seda(Double.parseDouble(rs.getString("v.quadro_seda")));
           e.setLajeado(Double.parseDouble(rs.getString("v.lajeado")));
           e.setMatao(Double.parseDouble(rs.getString("v.matao")));
           e.setMorro_chato(Double.parseDouble(rs.getString("v.morro_chato")));
           e.setMorro_vermelho(Double.parseDouble(rs.getString("v.morro_vermelho")));
           e.setMorro_azul(Double.parseDouble(rs.getString("v.morro_azul")));
           e.setPedra_branca(Double.parseDouble(rs.getString("v.pedra_branca")));
           e.setPonte_alta(Double.parseDouble(rs.getString("v.ponte_alta")));
           e.setSta_barbara(Double.parseDouble(rs.getString("v.sta_barbara")));
           e.setSanta_cruz(Double.parseDouble(rs.getString("v.santa_cruz")));
           e.setDemais_bairros(Double.parseDouble(rs.getString("v.demais_bairros")));
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
   
    public List<Exercicio> listaExercicios() throws SQLException{
        List<Exercicio> lista = new ArrayList<>();
        String  select = "select * from rural v order by v.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Exercicio e = new Exercicio();
           e.setId(Integer.parseInt(rs.getString("v.cod")));
           e.setExercicio(Integer.parseInt(rs.getString("v.exercicio")));           
           lista.add(e);
        }    
        
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
}
