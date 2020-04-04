/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Interdicao;
import model.InterdicaoString;
//import org.springframework.scheduling.quartz.CronTriggerBean;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class InterdicaoBD {
    
     Conexao conexao;

    public InterdicaoBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Interdicao cert)throws  SQLException{        
        String insert = "insert into certidao6(protocolo,dataprotocolo,processo,assunto,proprietario,datasistema,exercicio,usuario)"
                 +"values(?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2,cert.getDataProtocolo());
            stmt.setString(3,cert.getProcesso());
            stmt.setString(4,cert.getAssunto());
            stmt.setString(5,cert.getProprietario());
            stmt.setString(6,cert.getDataSistema());            
            stmt.setInt(7,cert.getExercicio());
            stmt.setInt(8,cert.getUsuario());       
            
           
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Interdicao> listaCertidao() throws SQLException{
        List<Interdicao> lista = new ArrayList<>();
        String  select = "select * from certidao6 c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Interdicao c = new Interdicao();
           c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
           c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
           lista.add(c);
        } 
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Interdicao> listaCertidao1(Integer exe) throws SQLException{
        List<Interdicao> lista = new ArrayList<>();
        
        String  select = "select * from certidao6 c where c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Interdicao e = new Interdicao();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setDataProtocolo((rs.getString("c.dataprotocolo")));
           e.setProcesso((rs.getString("c.processo")));
           e.setAssunto((rs.getString("c.assunto")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Interdicao> listaCertidao2(Integer protoc,Integer exe) throws SQLException{
        List<Interdicao> lista = new ArrayList<>();
        
        String  select = "select * from certidao6 c where c.protocolo= ? and c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, protoc);
        stmt.setInt(2, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Interdicao e = new Interdicao();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setDataProtocolo((rs.getString("c.dataprotocolo")));
           e.setProcesso((rs.getString("c.processo")));
           e.setAssunto((rs.getString("c.assunto")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Interdicao> listaCertidao3() throws SQLException{
        List<Interdicao> lista = new ArrayList<>();
        
        String  select = "select * from certidao6 c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Interdicao e = new Interdicao();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setDataProtocolo((rs.getString("c.dataprotocolo")));
           e.setProcesso((rs.getString("c.processo")));
           e.setAssunto((rs.getString("c.assunto")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    
    public List<Interdicao> listaTabela(String procurar, int posCombo) throws SQLException{
        List<Interdicao> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from certidao6 c"
                        + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Interdicao e = new Interdicao();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setProcesso((rs.getString("c.processo")));
                            e.setAssunto((rs.getString("c.assunto")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 2:
                        select = "select * from certidao5 c"
                        + " where c.exercicio like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Interdicao e = new Interdicao();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setProcesso((rs.getString("c.processo")));
                            e.setAssunto((rs.getString("c.assunto")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 3:
                       select = "select * from certidao5 c"
                        + " where c.proprietario like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Interdicao e = new Interdicao();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setProcesso((rs.getString("c.processo")));
                            e.setAssunto((rs.getString("c.assunto")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
                    case 4:
                        select = "select * from certidao5 c"
                        + " where c.insccadastral like ?  order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Interdicao e = new Interdicao();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setProcesso((rs.getString("c.processo")));
                            e.setAssunto((rs.getString("c.assunto")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
                            e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                            listCertidao.add(e);
                        }       
                        stmt.close();
                        conexao.desconectar();
                    break;
        }       
        return  listCertidao;
    }
    public List<InterdicaoString> listaCertidaoString() throws SQLException{
        List<InterdicaoString> lista = new ArrayList<>();
        String  select = "select * from certidao6 c INNER JOIN imoveisint a on c.cod=a.cod_cert order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           InterdicaoString e = new InterdicaoString();
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           e.setProtocolo(rs.getString("c.protocolo"));
           e.setDataProtocolo(rs.getString("c.dataprotocolo"));
           e.setProcesso(rs.getString("c.processo"));
           e.setAssunto((rs.getString("c.assunto")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setExercicio(rs.getString("c.exercicio"));
           
           lista.add(e);
        } 
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
public List<InterdicaoString> listaCertidaoString2(String procurar, int posCombo) throws SQLException{
        List<InterdicaoString> lista = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        
        switch (posCombo){
                case 1:
                    select = "select * from certidao6 c"
                     + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    InterdicaoString c = new InterdicaoString();
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario"))); 
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProcesso((rs.getString("c.processo")));
                                    c.setAssunto((rs.getString("c.assunto")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setDataSistema((rs.getString("c.datasistema")));
                                    c.setExercicio((rs.getString("c.exercicio")));

                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
                 case 2:
                    select = "select * from certidao6 c "
                     + " where c.exercicio like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    InterdicaoString c = new InterdicaoString();
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProcesso((rs.getString("c.processo")));
                                    c.setAssunto((rs.getString("c.assunto")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setDataSistema((rs.getString("c.datasistema")));
                                    c.setExercicio((rs.getString("c.exercicio")));

                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
                 case 3:
                    select = "select * from certidao6 c "
                     + " where c.proprietario like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    InterdicaoString c = new InterdicaoString();
                                    c.setCod(Integer.parseInt(rs.getString("c.cod")));
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProcesso((rs.getString("c.processo")));
                                    c.setAssunto((rs.getString("c.assunto")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setDataSistema((rs.getString("c.datasistema")));
                                    c.setExercicio((rs.getString("c.exercicio")));
                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
                 case 4:
                    select = "select * from certidao6 c "
                     + " where c.datasistema like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       
                        rs = stmt.executeQuery();
                    while(rs.next()){
                                    InterdicaoString c = new InterdicaoString();
                                    c.setCod(Integer.parseInt(rs.getString("c.cod"))); 
                                    c.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
                                    c.setProtocolo((rs.getString("c.protocolo")));  
                                    c.setDataProtocolo((rs.getString("c.dataprotocolo")));
                                    c.setProcesso((rs.getString("c.processo")));
                                    c.setAssunto((rs.getString("c.assunto")));
                                    c.setProprietario((rs.getString("c.proprietario")));
                                    c.setDataSistema((rs.getString("c.datasistema")));
                                    c.setExercicio((rs.getString("c.exercicio")));
                                    lista.add(c);
                    } 
                    stmt.close();
                    conexao.desconectar();
                break;
        }
        return  lista;
    }
}
