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
import model.Confrontante;
//import org.springframework.scheduling.quartz.CronTriggerBean;

/**
 *
 * @author EDVALDO ANTUNES
 */
public class ConfrontanteBD {
    
     Conexao conexao;

    public ConfrontanteBD() {
        conexao = new Conexao();
    }
    
    public void salvar(Confrontante cert)throws  SQLException{        
        String insert = "insert into certidao5(protocolo,dataprotocolo,bairro,rua,insccadastral,proprietario,"
                 + "proprietario1,proprietario2,proprietario3,fundos,direito,esquerdo,datasistema,numero,exercicio,usuario)"
                 +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
            stmt.setInt(1, cert.getProtocolo());
            stmt.setString(2,cert.getDataProtocolo());
            stmt.setString(3,cert.getBairro());
            stmt.setString(4,cert.getRua());
            stmt.setString(5,cert.getInscCadastral());
            stmt.setString(6,cert.getProprietario());
            stmt.setString(7,cert.getProprietario1());
            stmt.setString(8,cert.getProprietario2());
            stmt.setString(9,cert.getProprietario3());
            stmt.setDouble(10,cert.getFundos());
            stmt.setDouble(11,cert.getDireito());
            stmt.setDouble(12,cert.getEsquerdo());
            stmt.setString(13,cert.getDataSistema());
            stmt.setInt(14,cert.getNumero());            
            stmt.setInt(15,cert.getExercicio()); 
            stmt.setInt(16,cert.getUsuario()); 
            
           
            stmt.execute();
            stmt.close();
       conexao.desconectar();
    }
    
    public List<Confrontante> listaCertidao1(Integer exe) throws SQLException{
        List<Confrontante> lista = new ArrayList<>();
        
        String  select = "select * from certidao5 c where c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Confrontante e = new Confrontante();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setDataProtocolo((rs.getString("c.dataprotocolo")));
           e.setBairro((rs.getString("c.bairro")));
           e.setRua((rs.getString("c.rua")));
           e.setInscCadastral((rs.getString("c.insccadastral")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setProprietario1((rs.getString("c.proprietario1")));
           e.setProprietario2((rs.getString("c.proprietario2")));
           e.setProprietario3((rs.getString("c.proprietario3")));
           e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
           e.setDireito(Double.parseDouble(rs.getString("c.direito")));
           e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setNumero(Integer.parseInt(rs.getString("c.numero")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Confrontante> listaCertidao2(Integer protoc,Integer exe) throws SQLException{
        List<Confrontante> lista = new ArrayList<>();
        
        String  select = "select * from certidao5 c where c.protocolo= ? and c.exercicio = ?  order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1, protoc);
        stmt.setInt(2, exe);
        
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Confrontante e = new Confrontante();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setDataProtocolo((rs.getString("c.dataprotocolo")));
           e.setBairro((rs.getString("c.bairro")));
           e.setRua((rs.getString("c.rua")));
           e.setInscCadastral((rs.getString("c.insccadastral")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setProprietario1((rs.getString("c.proprietario1")));
           e.setProprietario2((rs.getString("c.proprietario2")));
           e.setProprietario3((rs.getString("c.proprietario3")));
           e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
           e.setDireito(Double.parseDouble(rs.getString("c.direito")));
           e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setNumero(Integer.parseInt(rs.getString("c.numero")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    public List<Confrontante> listaCertidao3() throws SQLException{
        List<Confrontante> lista = new ArrayList<>();
        
        String  select = "select * from certidao5 c order by c.cod desc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
           Confrontante e = new Confrontante();  
           e.setCod(Integer.parseInt(rs.getString("c.cod")));
           e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
           e.setDataProtocolo((rs.getString("c.dataprotocolo")));
           e.setBairro((rs.getString("c.bairro")));
           e.setRua((rs.getString("c.rua")));
           e.setInscCadastral((rs.getString("c.insccadastral")));
           e.setProprietario((rs.getString("c.proprietario")));
           e.setProprietario1((rs.getString("c.proprietario1")));
           e.setProprietario2((rs.getString("c.proprietario2")));
           e.setProprietario3((rs.getString("c.proprietario3")));
           e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
           e.setDireito(Double.parseDouble(rs.getString("c.direito")));
           e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
           e.setDataSistema((rs.getString("c.datasistema")));
           e.setNumero(Integer.parseInt(rs.getString("c.numero")));
           e.setExercicio(Integer.parseInt(rs.getString("c.exercicio")));
           e.setUsuario(Integer.parseInt(rs.getString("c.usuario")));
           
          
           lista.add(e);
        }    
        stmt.close();
        conexao.desconectar();
        return  lista;
    }
    
    
    public List<Confrontante> listaTabela(String procurar, int posCombo) throws SQLException{
        List<Confrontante> listCertidao = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        switch (posCombo){
                   case 1:
                        select = "select * from certidao5 c"
                        + " where c.protocolo like ? order by c.cod desc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar+"%");                       

                        rs = stmt.executeQuery();

                        while(rs.next()){
                            Confrontante e = new Confrontante();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setRua((rs.getString("c.rua")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setProprietario1((rs.getString("c.proprietario1")));
                            e.setProprietario2((rs.getString("c.proprietario2")));
                            e.setProprietario3((rs.getString("c.proprietario3")));
                            e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
                            e.setDireito(Double.parseDouble(rs.getString("c.direito")));
                            e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
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
                           Confrontante e = new Confrontante();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setRua((rs.getString("c.rua")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setProprietario1((rs.getString("c.proprietario1")));
                            e.setProprietario2((rs.getString("c.proprietario2")));
                            e.setProprietario3((rs.getString("c.proprietario3")));
                            e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
                            e.setDireito(Double.parseDouble(rs.getString("c.direito")));
                            e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
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
                            Confrontante e = new Confrontante();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setRua((rs.getString("c.rua")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setProprietario1((rs.getString("c.proprietario1")));
                            e.setProprietario2((rs.getString("c.proprietario2")));
                            e.setProprietario3((rs.getString("c.proprietario3")));
                            e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
                            e.setDireito(Double.parseDouble(rs.getString("c.direito")));
                            e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
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
                           Confrontante e = new Confrontante();  
                            e.setCod(Integer.parseInt(rs.getString("c.cod")));
                            e.setProtocolo(Integer.parseInt(rs.getString("c.protocolo")));
                            e.setDataProtocolo((rs.getString("c.dataprotocolo")));
                            e.setBairro((rs.getString("c.bairro")));
                            e.setRua((rs.getString("c.rua")));
                            e.setInscCadastral((rs.getString("c.insccadastral")));
                            e.setProprietario((rs.getString("c.proprietario")));
                            e.setProprietario1((rs.getString("c.proprietario1")));
                            e.setProprietario2((rs.getString("c.proprietario2")));
                            e.setProprietario3((rs.getString("c.proprietario3")));
                            e.setFundos(Double.parseDouble(rs.getString("c.fundos")));
                            e.setDireito(Double.parseDouble(rs.getString("c.direito")));
                            e.setEsquerdo(Double.parseDouble(rs.getString("c.esquerdo")));
                            e.setDataSistema((rs.getString("c.datasistema")));
                            e.setNumero(Integer.parseInt(rs.getString("c.numero")));
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
}
