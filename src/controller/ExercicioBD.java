package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Exercicio;
import model.PlantaString;

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
        String insert = "insert into urbano(exercicio,a_1_0,a_1_1, a_1_2, a_1_3, a_2_0, a_2_1, a_2_2, a_2_3, a_3_0, a_3_1, a_3_2, a_3_3, a_terreno,"
                 + "                                      b_1_0, b_1_1, b_1_2, b_1_3, b_2_0, b_2_1, b_2_2, b_2_3, b_3_0, b_3_1, b_3_2, b_3_3, b_terreno,"
                 + "                                      c_1_0, c_1_1, c_1_2, c_1_3, c_2_0, c_2_1, c_2_2, c_2_3, c_3_0, c_3_1, c_3_2, c_3_3, c_terreno, "
                 + "                                      d_1_0, d_1_1, d_1_2, d_1_3, d_2_0, d_2_1, d_2_2, d_2_3, d_3_0, d_3_1, d_3_2, d_3_3, d_terreno, "
                 + "                                      e_1_0, e_1_1, e_1_2, e_1_3, e_2_0, e_2_1, e_2_2, e_2_3, e_3_0, e_3_1, e_3_2, e_3_3, e_terreno) "
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, ex.getExercicio());
            stmt.setDouble(2,ex.getA_1_0());
            stmt.setDouble(3,ex.getA_1_1());
            stmt.setDouble(4,ex.getA_1_2());
            stmt.setDouble(5,ex.getA_1_3());            
            stmt.setDouble(6,ex.getA_2_0());
            stmt.setDouble(7,ex.getA_2_1());
            stmt.setDouble(8,ex.getA_2_2());
            stmt.setDouble(9,ex.getA_2_3());          
            stmt.setDouble(10,ex.getA_3_0());
            stmt.setDouble(11,ex.getA_3_1());
            stmt.setDouble(12,ex.getA_3_2());
            stmt.setDouble(13,ex.getA_3_3());
            stmt.setDouble(14,ex.getA_terreno());            
            stmt.setDouble(15,ex.getB_1_0());
            stmt.setDouble(16,ex.getB_1_1());
            stmt.setDouble(17,ex.getB_1_2());
            stmt.setDouble(18,ex.getB_1_3());            
            stmt.setDouble(19,ex.getB_2_0());
            stmt.setDouble(20,ex.getB_2_1());
            stmt.setDouble(21,ex.getB_2_2());
            stmt.setDouble(22,ex.getB_2_3());          
            stmt.setDouble(23,ex.getB_3_0());
            stmt.setDouble(24,ex.getB_3_1());
            stmt.setDouble(25,ex.getB_3_2());
            stmt.setDouble(26,ex.getB_3_3());
            stmt.setDouble(27,ex.getB_terreno());            
            stmt.setDouble(28,ex.getC_1_0());
            stmt.setDouble(29,ex.getC_1_1());
            stmt.setDouble(30,ex.getC_1_2());
            stmt.setDouble(31,ex.getC_1_3());            
            stmt.setDouble(32,ex.getC_2_0());
            stmt.setDouble(33,ex.getC_2_1());
            stmt.setDouble(34,ex.getC_2_2());
            stmt.setDouble(35,ex.getC_2_3());          
            stmt.setDouble(36,ex.getC_3_0());
            stmt.setDouble(37,ex.getC_3_1());
            stmt.setDouble(38,ex.getC_3_2());
            stmt.setDouble(39,ex.getC_3_3());
            stmt.setDouble(40,ex.getC_terreno());            
            stmt.setDouble(41,ex.getD_1_0());
            stmt.setDouble(42,ex.getD_1_1());
            stmt.setDouble(43,ex.getD_1_2());
            stmt.setDouble(44,ex.getD_1_3());            
            stmt.setDouble(45,ex.getD_2_0());
            stmt.setDouble(46,ex.getD_2_1());
            stmt.setDouble(47,ex.getD_2_2());
            stmt.setDouble(48,ex.getD_2_3());          
            stmt.setDouble(49,ex.getD_3_0());
            stmt.setDouble(50,ex.getD_3_1());
            stmt.setDouble(51,ex.getD_3_2());
            stmt.setDouble(52,ex.getD_3_3());
            stmt.setDouble(53,ex.getD_terreno());            
            stmt.setDouble(54,ex.getE_1_0());
            stmt.setDouble(55,ex.getE_1_1());
            stmt.setDouble(56,ex.getE_1_2());
            stmt.setDouble(57,ex.getE_1_3());            
            stmt.setDouble(58,ex.getE_2_0());
            stmt.setDouble(59,ex.getE_2_1());
            stmt.setDouble(60,ex.getE_2_2());
            stmt.setDouble(61,ex.getE_2_3());          
            stmt.setDouble(62,ex.getE_3_0());
            stmt.setDouble(63,ex.getE_3_1());
            stmt.setDouble(64,ex.getE_3_2());
            stmt.setDouble(65,ex.getE_3_3());
            stmt.setDouble(66,ex.getE_terreno());
            
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public void delete(int id) throws SQLException{
       String delete = "delete from urbano where cod = ?";
       conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(delete);
        stmt.setInt(1, id);
       
        stmt.execute();
            stmt.close();
            conexao.desconectar();
   }
    
   public void alterar(Exercicio ex)throws SQLException{
        String update = "update urbano set a_1_0 = ?, a_1_1 = ?, a_1_2 = ?, a_1_3 = ?, a_2_0 = ?, a_2_1 = ?, a_2_2 = ?, a_2_3 = ?, a_3_0 = ?, a_3_1 = ?, a_3_2 = ?, a_3_3 = ?, a_terreno"
                + "b_1_0 = ?, b_1_1 = ?, b_1_2 = ?, b_1_3 = ?, b_2_0 = ?, b_2_1 = ?, b_2_2 = ?, b_2_3 = ?, b_3_0 = ?, b_3_1 = ?, b_3_2 = ?, b_3_3 = ?, b_terreno"
                + "c_1_0 = ?, c_1_1 = ?, c_1_2 = ?, c_1_3 = ?, c_2_0 = ?, c_2_1 = ?, c_2_2 = ?, c_2_3 = ?, c_3_0 = ?, c_3_1 = ?, c_3_2 = ?, c_3_3 = ?, c_terreno"
                + "d_1_0 = ?, d_1_1 = ?, d_1_2 = ?, d_1_3 = ?, d_2_0 = ?, d_2_1 = ?, d_2_2 = ?, d_2_3 = ?, d_3_0 = ?, d_3_1 = ?, d_3_2 = ?, d_3_3 = ?, d_terreno"
                + "e_1_0 = ?, e_1_1 = ?, e_1_2 = ?, e_1_3 = ?, e_2_0 = ?, e_2_1 = ?, e_2_2 = ?, e_2_3 = ?, e_3_0 = ?, e_3_1 = ?, e_3_2 = ?, e_3_3 = ?, e_terreno"
                + " where cod = ?";

        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
           
            stmt.setInt(1, ex.getExercicio());
            stmt.setDouble(2,ex.getA_1_0());
            stmt.setDouble(3,ex.getA_1_1());
            stmt.setDouble(4,ex.getA_1_2());
            stmt.setDouble(5,ex.getA_1_3());            
            stmt.setDouble(6,ex.getA_2_0());
            stmt.setDouble(7,ex.getA_2_1());
            stmt.setDouble(8,ex.getA_2_2());
            stmt.setDouble(9,ex.getA_2_3());          
            stmt.setDouble(10,ex.getA_3_0());
            stmt.setDouble(11,ex.getA_3_1());
            stmt.setDouble(12,ex.getA_3_2());
            stmt.setDouble(13,ex.getA_3_3());
            stmt.setDouble(14,ex.getA_terreno());            
            stmt.setDouble(15,ex.getB_1_0());
            stmt.setDouble(16,ex.getB_1_1());
            stmt.setDouble(17,ex.getB_1_2());
            stmt.setDouble(18,ex.getB_1_3());            
            stmt.setDouble(19,ex.getB_2_0());
            stmt.setDouble(20,ex.getB_2_1());
            stmt.setDouble(21,ex.getB_2_2());
            stmt.setDouble(22,ex.getB_2_3());          
            stmt.setDouble(23,ex.getB_3_0());
            stmt.setDouble(24,ex.getB_3_1());
            stmt.setDouble(25,ex.getB_3_2());
            stmt.setDouble(26,ex.getB_3_3());
            stmt.setDouble(27,ex.getB_terreno());            
            stmt.setDouble(28,ex.getC_1_0());
            stmt.setDouble(29,ex.getC_1_1());
            stmt.setDouble(30,ex.getC_1_2());
            stmt.setDouble(31,ex.getC_1_3());            
            stmt.setDouble(32,ex.getC_2_0());
            stmt.setDouble(33,ex.getC_2_1());
            stmt.setDouble(34,ex.getC_2_2());
            stmt.setDouble(35,ex.getC_2_3());          
            stmt.setDouble(36,ex.getC_3_0());
            stmt.setDouble(37,ex.getC_3_1());
            stmt.setDouble(38,ex.getC_3_2());
            stmt.setDouble(39,ex.getC_3_3());
            stmt.setDouble(40,ex.getC_terreno());            
            stmt.setDouble(41,ex.getD_1_0());
            stmt.setDouble(42,ex.getD_1_1());
            stmt.setDouble(43,ex.getD_1_2());
            stmt.setDouble(44,ex.getD_1_3());            
            stmt.setDouble(45,ex.getD_2_0());
            stmt.setDouble(46,ex.getD_2_1());
            stmt.setDouble(47,ex.getD_2_2());
            stmt.setDouble(48,ex.getD_2_3());          
            stmt.setDouble(49,ex.getD_3_0());
            stmt.setDouble(50,ex.getD_3_1());
            stmt.setDouble(51,ex.getD_3_2());
            stmt.setDouble(52,ex.getD_3_3());
            stmt.setDouble(53,ex.getD_terreno());            
            stmt.setDouble(54,ex.getE_1_0());
            stmt.setDouble(55,ex.getE_1_1());
            stmt.setDouble(56,ex.getE_1_2());
            stmt.setDouble(57,ex.getE_1_3());            
            stmt.setDouble(58,ex.getE_2_0());
            stmt.setDouble(59,ex.getE_2_1());
            stmt.setDouble(60,ex.getE_2_2());
            stmt.setDouble(61,ex.getE_2_3());          
            stmt.setDouble(62,ex.getE_3_0());
            stmt.setDouble(63,ex.getE_3_1());
            stmt.setDouble(64,ex.getE_3_2());
            stmt.setDouble(65,ex.getE_3_3());
            stmt.setDouble(66,ex.getE_terreno());
            
          stmt.execute();
          stmt.close();
          conexao.desconectar();
   }
   public List<Exercicio> listaTabela(Integer ex) throws SQLException{
        List<Exercicio> lista = new ArrayList<>();
        
        String  select = "select * from urbano e  where e.exercicio = ? order by e.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, ex);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Exercicio e = new Exercicio();
           e.setId(Integer.parseInt(rs.getString("e.cod")));
           e.setExercicio(Integer.parseInt(rs.getString("e.exercicio")));
           e.setA_1_0(Double.parseDouble(rs.getString("e.a_1_0")));
           e.setA_1_1(Double.parseDouble(rs.getString("e.a_1_1")));
           e.setA_1_2(Double.parseDouble(rs.getString("e.a_1_2")));
           e.setA_1_3(Double.parseDouble(rs.getString("e.a_1_3")));
           e.setA_2_0(Double.parseDouble(rs.getString("e.a_2_0")));
           e.setA_2_1(Double.parseDouble(rs.getString("e.a_2_1")));
           e.setA_2_2(Double.parseDouble(rs.getString("e.a_2_2")));
           e.setA_2_3(Double.parseDouble(rs.getString("e.a_2_3")));
           e.setA_3_0(Double.parseDouble(rs.getString("e.a_3_0")));
           e.setA_3_1(Double.parseDouble(rs.getString("e.a_3_1")));
           e.setA_3_2(Double.parseDouble(rs.getString("e.a_3_2")));
           e.setA_3_3(Double.parseDouble(rs.getString("e.a_3_3")));
           e.setA_terreno(Double.parseDouble(rs.getString("e.a_terreno")));
           e.setB_1_0(Double.parseDouble(rs.getString("e.b_1_0")));
           e.setB_1_1(Double.parseDouble(rs.getString("e.b_1_1")));
           e.setB_1_2(Double.parseDouble(rs.getString("e.b_1_2")));
           e.setB_1_3(Double.parseDouble(rs.getString("e.b_1_3")));
           e.setB_2_0(Double.parseDouble(rs.getString("e.b_2_0")));
           e.setB_2_1(Double.parseDouble(rs.getString("e.b_2_1")));
           e.setB_2_2(Double.parseDouble(rs.getString("e.b_2_2")));
           e.setB_2_3(Double.parseDouble(rs.getString("e.b_2_3")));
           e.setB_3_0(Double.parseDouble(rs.getString("e.b_3_0")));
           e.setB_3_1(Double.parseDouble(rs.getString("e.b_3_1")));
           e.setB_3_2(Double.parseDouble(rs.getString("e.b_3_2")));
           e.setB_3_3(Double.parseDouble(rs.getString("e.b_3_3")));
           e.setB_terreno(Double.parseDouble(rs.getString("e.b_terreno")));
           e.setC_1_0(Double.parseDouble(rs.getString("e.c_1_0")));
           e.setC_1_1(Double.parseDouble(rs.getString("e.c_1_1")));
           e.setC_1_2(Double.parseDouble(rs.getString("e.c_1_2")));
           e.setC_1_3(Double.parseDouble(rs.getString("e.c_1_3")));
           e.setC_2_0(Double.parseDouble(rs.getString("e.c_2_0")));
           e.setC_2_1(Double.parseDouble(rs.getString("e.c_2_1")));
           e.setC_2_2(Double.parseDouble(rs.getString("e.c_2_2")));
           e.setC_2_3(Double.parseDouble(rs.getString("e.c_2_3")));
           e.setC_3_0(Double.parseDouble(rs.getString("e.c_3_0")));
           e.setC_3_1(Double.parseDouble(rs.getString("e.c_3_1")));
           e.setC_3_2(Double.parseDouble(rs.getString("e.c_3_2")));
           e.setC_3_3(Double.parseDouble(rs.getString("e.c_3_3")));
           e.setC_terreno(Double.parseDouble(rs.getString("e.c_terreno")));
           e.setD_1_0(Double.parseDouble(rs.getString("e.d_1_0")));
           e.setD_1_1(Double.parseDouble(rs.getString("e.d_1_1")));
           e.setD_1_2(Double.parseDouble(rs.getString("e.d_1_2")));
           e.setD_1_3(Double.parseDouble(rs.getString("e.d_1_3")));
           e.setD_2_0(Double.parseDouble(rs.getString("e.d_2_0")));
           e.setD_2_1(Double.parseDouble(rs.getString("e.d_2_1")));
           e.setD_2_2(Double.parseDouble(rs.getString("e.d_2_2")));
           e.setD_2_3(Double.parseDouble(rs.getString("e.d_2_3")));
           e.setD_3_0(Double.parseDouble(rs.getString("e.d_3_0")));
           e.setD_3_1(Double.parseDouble(rs.getString("e.d_3_1")));
           e.setD_3_2(Double.parseDouble(rs.getString("e.d_3_2")));
           e.setD_3_3(Double.parseDouble(rs.getString("e.d_3_3")));
           e.setD_terreno(Double.parseDouble(rs.getString("e.d_terreno")));
           e.setE_1_0(Double.parseDouble(rs.getString("e.e_1_0")));
           e.setE_1_1(Double.parseDouble(rs.getString("e.e_1_1")));
           e.setE_1_2(Double.parseDouble(rs.getString("e.e_1_2")));
           e.setE_1_3(Double.parseDouble(rs.getString("e.e_1_3")));
           e.setE_2_0(Double.parseDouble(rs.getString("e.e_2_0")));
           e.setE_2_1(Double.parseDouble(rs.getString("e.e_2_1")));
           e.setE_2_2(Double.parseDouble(rs.getString("e.e_2_2")));
           e.setE_2_3(Double.parseDouble(rs.getString("e.e_2_3")));
           e.setE_3_0(Double.parseDouble(rs.getString("e.e_3_0")));
           e.setE_3_1(Double.parseDouble(rs.getString("e.e_3_1")));
           e.setE_3_2(Double.parseDouble(rs.getString("e.e_3_2")));
           e.setE_3_3(Double.parseDouble(rs.getString("e.e_3_3")));
           e.setE_terreno(Double.parseDouble(rs.getString("e.e_terreno")));
           
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
   
    public List<Exercicio> listaExercicios() throws SQLException{
        List<Exercicio> lista = new ArrayList<>();
        String  select = "select * from urbano ex order by ex.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Exercicio ex = new Exercicio();
           ex.setId(Integer.parseInt(rs.getString("ex.cod")));
           ex.setExercicio(Integer.parseInt(rs.getString("ex.exercicio")));           
           lista.add(ex);
        }    
        
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<PlantaString> imprimePlantaGenerica(int exercicio) throws SQLException{
        List<PlantaString> listPlanta = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
   
                        select = "SELECT * FROM rural v INNER JOIN urbano e on v.exercicio = e.exercicio WHERE e.exercicio = ?";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setInt(1,exercicio);
                        rs = stmt.executeQuery();          


                        while(rs.next()){
                            PlantaString e = new PlantaString();
                            e.setExercicio(rs.getString("e.exercicio"));
                            e.setA_1_0(rs.getString("e.a_1_0"));
                            e.setA_1_1(rs.getString("e.a_1_1"));
                            e.setA_1_2(rs.getString("e.a_1_2"));
                            e.setA_1_3(rs.getString("e.a_1_3"));
                            e.setA_2_0(rs.getString("e.a_2_0"));
                            e.setA_2_1(rs.getString("e.a_2_1"));
                            e.setA_2_2(rs.getString("e.a_2_2"));
                            e.setA_2_3(rs.getString("e.a_2_3"));
                            e.setA_3_0(rs.getString("e.a_3_0"));
                            e.setA_3_1(rs.getString("e.a_3_1"));
                            e.setA_3_2(rs.getString("e.a_3_2"));
                            e.setA_3_3(rs.getString("e.a_3_3"));
                            e.setA_terreno(rs.getString("e.a_terreno"));
                            e.setB_1_0(rs.getString("e.b_1_0"));
                            e.setB_1_1(rs.getString("e.b_1_1"));
                            e.setB_1_2(rs.getString("e.b_1_2"));
                            e.setB_1_3(rs.getString("e.b_1_3"));
                            e.setB_2_0(rs.getString("e.b_2_0"));
                            e.setB_2_1(rs.getString("e.b_2_1"));
                            e.setB_2_2(rs.getString("e.b_2_2"));
                            e.setB_2_3(rs.getString("e.b_2_3"));
                            e.setB_3_0(rs.getString("e.b_3_0"));
                            e.setB_3_1(rs.getString("e.b_3_1"));
                            e.setB_3_2(rs.getString("e.b_3_2"));
                            e.setB_3_3(rs.getString("e.b_3_3"));
                            e.setB_terreno(rs.getString("e.b_terreno"));
                            e.setC_1_0(rs.getString("e.c_1_0"));
                            e.setC_1_1(rs.getString("e.c_1_1"));
                            e.setC_1_2(rs.getString("e.c_1_2"));
                            e.setC_1_3(rs.getString("e.c_1_3"));
                            e.setC_2_0(rs.getString("e.c_2_0"));
                            e.setC_2_1(rs.getString("e.c_2_1"));
                            e.setC_2_2(rs.getString("e.c_2_2"));
                            e.setC_2_3(rs.getString("e.c_2_3"));
                            e.setC_3_0(rs.getString("e.c_3_0"));
                            e.setC_3_1(rs.getString("e.c_3_1"));
                            e.setC_3_2(rs.getString("e.c_3_2"));
                            e.setC_3_3(rs.getString("e.c_3_3"));
                            e.setC_terreno(rs.getString("e.c_terreno"));
                            e.setD_1_0(rs.getString("e.d_1_0"));
                            e.setD_1_1(rs.getString("e.d_1_1"));
                            e.setD_1_2(rs.getString("e.d_1_2"));
                            e.setD_1_3(rs.getString("e.d_1_3"));
                            e.setD_2_0(rs.getString("e.d_2_0"));
                            e.setD_2_1(rs.getString("e.d_2_1"));
                            e.setD_2_2(rs.getString("e.d_2_2"));
                            e.setD_2_3(rs.getString("e.d_2_3"));
                            e.setD_3_0(rs.getString("e.d_3_0"));
                            e.setD_3_1(rs.getString("e.d_3_1"));
                            e.setD_3_2(rs.getString("e.d_3_2"));
                            e.setD_3_3(rs.getString("e.d_3_3"));
                            e.setD_terreno(rs.getString("e.d_terreno"));
                            e.setE_1_0(rs.getString("e.e_1_0"));
                            e.setE_1_1(rs.getString("e.e_1_1"));
                            e.setE_1_2(rs.getString("e.e_1_2"));
                            e.setE_1_3(rs.getString("e.e_1_3"));
                            e.setE_2_0(rs.getString("e.e_2_0"));
                            e.setE_2_1(rs.getString("e.e_2_1"));
                            e.setE_2_2(rs.getString("e.e_2_2"));
                            e.setE_2_3(rs.getString("e.e_2_3"));
                            e.setE_3_0(rs.getString("e.e_3_0"));
                            e.setE_3_1(rs.getString("e.e_3_1"));
                            e.setE_3_2(rs.getString("e.e_3_2"));
                            e.setE_3_3(rs.getString("e.e_3_3"));
                            e.setE_terreno(rs.getString("e.e_terreno"));
                            
                            e.setAparecida_salto(rs.getString("v.aparecida_salto"));
                            e.setBarreirinho(rs.getString("v.barreirinho"));
                            e.setCacador(rs.getString("v.cacador"));
                            e.setCerrado(rs.getString("v.cerrado"));
                            e.setFurnas(rs.getString("v.furnas"));
                            e.setHerval(rs.getString("v.herval"));
                            e.setItopava(rs.getString("v.itopava"));
                            e.setQuadro_seda(rs.getString("v.quadro_seda"));
                            e.setLajeado(rs.getString("v.lajeado"));
                            e.setMatao(rs.getString("v.matao"));
                            e.setMorro_chato(rs.getString("v.morro_chato"));
                            e.setMorro_vermelho(rs.getString("v.morro_vermelho"));
                            e.setMorro_azul(rs.getString("v.morro_azul"));
                            e.setPedra_branca(rs.getString("v.pedra_branca"));
                            e.setPonte_alta(rs.getString("v.ponte_alta"));
                            e.setSta_barbara(rs.getString("v.sta_barbara"));
                            e.setSanta_cruz(rs.getString("v.santa_cruz"));
                            e.setDemais_bairros(rs.getString("v.demais_bairros"));
                            
                            listPlanta.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
     return  listPlanta;
}
}
