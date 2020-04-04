package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Lancamentos;

public class LancamentosBD {
    
    Conexao conexao;
    public LancamentosBD() {
       conexao = new Conexao();
        
    }
    
    public List<Lancamentos> buscaLancFiltro(String procurar01,String procurar02, int posCombo01,int posCombo02 ) throws SQLException{
        List<Lancamentos> listLancamentos = new ArrayList<>();
        String select;
        PreparedStatement stmt;
        ResultSet rs;
        if(posCombo01 ==1 && posCombo02 ==1){
                        select = "select * from lancamentos l where l.inscricao like ? and l.inscricao like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==1 && posCombo02 ==2){
                        select = "select * from lancamentos l where l.inscricao like ? and l.proprietario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==1 && posCombo02 ==3){
                        select = "select * from lancamentos l where l.inscricao like ? and l.compromissario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==1 && posCombo02 ==4){
                        select = "select * from lancamentos l where l.inscricao like ? and l.cpf_pro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==1 && posCombo02 ==5){
                        select = "select * from lancamentos l where l.inscricao like ? and l.logradouro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==1 && posCombo02 ==6){
                        select = "select * from lancamentos l where l.inscricao like ? and l.numero like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }
        else if(posCombo01 ==2 && posCombo02 ==1){
                        select = "select * from lancamentos l where l.proprietario like ? and l.inscricao like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        } else if(posCombo01 ==2 && posCombo02 ==2){
                        select = "select * from lancamentos l where l.proprietario like ? and l.proprietario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==2 && posCombo02 ==3){
                        select = "select * from lancamentos l where l.proprietario like ? and l.compromissario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==2 && posCombo02 ==4){
                        select = "select * from lancamentos l where l.proprietario like ? and l.cpf_pro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==2 && posCombo02 ==5){
                        select = "select * from lancamentos l where l.proprietario like ? and l.logradouro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==2 && posCombo02 ==6){
                        select = "select * from lancamentos l where l.proprietario like ? and l.numero like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }
        else if(posCombo01 ==3 && posCombo02 ==1){
                        select = "select * from lancamentos l where l.compromissario like ? and l.inscricao like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        } else if(posCombo01 ==3 && posCombo02 ==2){
                        select = "select * from lancamentos l where l.compromissario like ? and l.proprietario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==3 && posCombo02 ==3){
                        select = "select * from lancamentos l where l.compromissario like ? and l.compromissario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==3 && posCombo02 ==4){
                        select = "select * from lancamentos l where l.compromissario like ? and l.cpf_pro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==3 && posCombo02 ==5){
                        select = "select * from lancamentos l where l.compromissario like ? and l.logradouro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==3 && posCombo02 ==6){
                        select = "select * from lancamentos l where l.compromissario like ? and l.numero like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }
        else if(posCombo01 ==4 && posCombo02 ==1){
                        select = "select * from lancamentos l where l.cpf_pro like ? and l.inscricao like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        } else if(posCombo01 ==4 && posCombo02 ==2){
                        select = "select * from lancamentos l where l.cpf_pro like ? and l.proprietario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==4 && posCombo02 ==3){
                        select = "select * from lancamentos l where l.cpf_pro like ? and l.compromissario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==4 && posCombo02 ==4){
                        select = "select * from lancamentos l where l.cpf_pro like ? and l.cpf_pro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==4 && posCombo02 ==5){
                        select = "select * from lancamentos l where l.cpf_pro like ? and l.logradouro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==4 && posCombo02 ==6){
                        select = "select * from lancamentos l where l.cpf_pro like ? and l.numero like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }
        else if(posCombo01 ==5 && posCombo02 ==1){
                        select = "select * from lancamentos l where l.logradouro like ? and l.inscricao like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        } else if(posCombo01 ==5 && posCombo02 ==2){
                        select = "select * from lancamentos l where l.logradouro like ? and l.proprietario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==5 && posCombo02 ==3){
                        select = "select * from lancamentos l where l.logradouro like ? and l.compromissario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==5 && posCombo02 ==4){
                        select = "select * from lancamentos l where l.logradouro like ? and l.cpf_pro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==5 && posCombo02 ==5){
                        select = "select * from lancamentos l where l.logradouro like ? and l.logradouro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==5 && posCombo02 ==6){
                        select = "select * from lancamentos l where l.logradouro like ? and l.numero like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        } else if(posCombo01 ==6 && posCombo02 ==1){
                        select = "select * from lancamentos l where l.numero like ? and l.inscricao like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        } else if(posCombo01 ==6 && posCombo02 ==2){
                        select = "select * from lancamentos l where l.numero like ? and l.proprietario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==6 && posCombo02 ==3){
                        select = "select * from lancamentos l where l.numero like ? and l.compromissario like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==6 && posCombo02 ==4){
                        select = "select * from lancamentos l where l.numero like ? and l.cpf_pro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==6 && posCombo02 ==5){
                        select = "select * from lancamentos l where l.numero like ? and l.logradouro like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }else if(posCombo01 ==6 && posCombo02 ==6){
                        select = "select * from lancamentos l where l.numero like ? and l.numero like ? order by l.cod asc";
                        conexao.conectar();
                        stmt = conexao.getCon().prepareStatement(select);
                        stmt.setString(1, "%"+procurar01+"%");
                        stmt.setString(2, "%"+procurar02+"%");
                        rs = stmt.executeQuery();

                        while(rs.next()){
                           Lancamentos lanc = new Lancamentos();
                            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
                            lanc.setInscricao(rs.getString("l.inscricao"));
                            lanc.setProprietario(rs.getString("l.proprietario"));
                            lanc.setCompromissario(rs.getString("l.compromissario"));
                            lanc.setCpfPro(rs.getString("l.cpf_pro"));
                            lanc.setCpfPro(rs.getString("l.cpf_com"));
                            lanc.setLogradouro(rs.getString("l.logradouro"));
                            lanc.setNumero(rs.getString("l.numero"));
                            lanc.setBairro(rs.getString("l.bairro"));
                            lanc.setQuadra(rs.getString("l.quadra"));
                            lanc.setLote(rs.getString("l.lote"));
                            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
                            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
                            lanc.setTipo(rs.getString("l.tipo"));
                            lanc.setPadrao(rs.getString("l.padrao"));
                            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
                            listLancamentos.add(lanc);
                        }       
                        stmt.close();
                        conexao.desconectar();
        }                                                                                                                                                                                                 
        return  listLancamentos;
    }
    
    
    public void salvar(Lancamentos l)throws  SQLException{
        String insert = "insert into lancamentos(inscricao, proprietario, cpf_pro, compromissario, cpf_com, logradouro, numero, bairro, cidade, uf, cep, quadra, lote, setor, padrao, tipo, terreno,construcao)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            conexao.conectar();
            
        PreparedStatement stmt = conexao.getCon().prepareStatement(insert);
        stmt.setString(1, l.getBairro());
        stmt.setString(2, l.getCep());
        stmt.setString(3, l.getCidade());
        stmt.setString(4, l.getCompromissario());
        stmt.setString(5, l.getCpfCom());
        stmt.setString(6, l.getCpfPro());
        stmt.setString(7, l.getInscricao());
        stmt.setString(8, l.getLogradouro());
        stmt.setString(9, l.getLote());
        stmt.setString(10, l.getNumero());
        stmt.setString(11, l.getPadrao());
        stmt.setString(12, l.getProprietario());
        stmt.setString(13, l.getQuadra());
        stmt.setString(14, l.getTipo());
        stmt.setString(15, l.getUf());
        stmt.setDouble(16, l.getConstrucao());
        stmt.setDouble(17, l.getTerreno());
        stmt.setInt(18, l.getSetor());
                   
            
        stmt.execute();
        stmt.close();
        conexao.desconectar();
          
    }
    
    public List<Lancamentos> buscaLancamentos(String insc) throws SQLException{
        List<Lancamentos> lancamento = new ArrayList<>();
        
        String select = "select * from lancamentos l where l.inscricao like ? order by l.cod asc";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setString(1, "%"+insc+"%");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Lancamentos lanc = new Lancamentos();
            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
            lanc.setInscricao(rs.getString("l.inscricao"));
            lanc.setProprietario(rs.getString("l.proprietario"));
            lanc.setCompromissario(rs.getString("l.compromissario"));
            lanc.setCpfPro(rs.getString("l.cpf_pro"));
            lanc.setCpfPro(rs.getString("l.cpf_com"));
            lanc.setLogradouro(rs.getString("l.logradouro"));
            lanc.setNumero(rs.getString("l.numero"));
            lanc.setBairro(rs.getString("l.bairro"));
            lanc.setQuadra(rs.getString("l.quadra"));
            lanc.setLote(rs.getString("l.lote"));
            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
            lanc.setTipo(rs.getString("l.tipo"));
            lanc.setPadrao(rs.getString("l.padrao"));
            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
           
            
            
            lancamento.add(lanc);
        }       
        stmt.close();
        conexao.desconectar();
        return  lancamento;
    }
    
    public List<Lancamentos> buscaLancamentos2(Integer cod) throws SQLException{
        List<Lancamentos> lancamento = new ArrayList<>();
        String select = "select * from lancamento l where l.cod = ?";
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(select);
        stmt.setInt(1,cod);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Lancamentos lanc = new Lancamentos();
            lanc.setCod(Integer.parseInt(rs.getString("l.cod")));
            lanc.setInscricao(rs.getString("l.inscricao"));
            lanc.setProprietario(rs.getString("l.proprietario"));
            lanc.setCpfPro(rs.getString("l.cpf_pro"));
            lanc.setCpfPro(rs.getString("l.cpf_com"));
            lanc.setCompromissario(rs.getString("l.compromissario"));
            lanc.setLogradouro(rs.getString("l.logradouro"));
            lanc.setNumero(rs.getString("l.numero"));
            lanc.setBairro(rs.getString("l.bairro"));
            lanc.setQuadra(rs.getString("l.quadra"));
            lanc.setLote(rs.getString("l.lote"));
            lanc.setTerreno(Double.parseDouble(rs.getString("l.terreno")));
            lanc.setConstrucao(Double.parseDouble(rs.getString("l.construcao")));
            lanc.setTipo(rs.getString("l.tipo"));
            lanc.setPadrao(rs.getString("l.padrao"));
            lanc.setSetor(Integer.parseInt(rs.getString("l.setor")));
           
            
            
            lancamento.add(lanc);
        }       
        stmt.close();
        conexao.desconectar();
        return  lancamento;
    }
    
    public void alterar(Lancamentos l)throws SQLException{
        String update = "update lancamentos set nome = ?, login = ?, senha = ?, permissao = ? where id = ?";
        
        conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(update);
        
        stmt.setString(1, l.getBairro());
        stmt.setString(2, l.getCep());
        stmt.setString(3, l.getCidade());
        stmt.setString(4, l.getCompromissario());
        stmt.setString(5, l.getCpfCom());
        stmt.setString(6, l.getCpfPro());
        stmt.setString(7, l.getInscricao());
        stmt.setString(8, l.getLogradouro());
        stmt.setString(9, l.getLote());
        stmt.setString(10, l.getNumero());
        stmt.setString(11, l.getPadrao());
        stmt.setString(12, l.getProprietario());
        stmt.setString(13, l.getQuadra());
        stmt.setString(14, l.getTipo());
        stmt.setString(15, l.getUf());
        stmt.setDouble(16, l.getConstrucao());
        stmt.setDouble(17, l.getTerreno());
        stmt.setInt(18, l.getSetor());
        stmt.setInt(19, l.getCod());
        
        stmt.execute();
        stmt.close();
        conexao.desconectar();
    }
    
    public void delete(int cod) throws SQLException{
       
        String delete = "delete from lancamentos where cod = ?";
       conexao.conectar();
        PreparedStatement stmt = conexao.getCon().prepareStatement(delete);
        stmt.setInt(1, cod);
       
        stmt.execute();
        stmt.close();
        conexao.desconectar();
   }
}
