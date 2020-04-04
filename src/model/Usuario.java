package model;

public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String confirmaSenha;
    private int layout;
    private int permissao;
    
    public void Cadastrar(String nome, String login,String senha,int layout, int permissao){
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);     
        this.setLayout(layout);
        this.setPermissao(permissao);
    }
    public void verificarBanco(int id,String nome, String login){
       this.setId(id);
       this.setNome(nome);
       this.setLogin(login);
       
    }
    public void alterar(int id,String nome, String login, String senha,int permissao){
        this.setId(id);
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);   
        this.setPermissao(permissao);
    }
     public void alterarTema(int id,int layout){
        this.setId(id);
        this.setLayout(layout);
    }
     public String[] addTable(){
        String[] dados = new String[]{String.valueOf(getId()),getNome(),getLogin(),getSenha()};
        return dados;        
    }
    public boolean camposVazio(String nome,String login, String senha, String confirmaSenha, boolean permissao){
        if(nome.equals(" ") || login.equals(" ") || senha.equals(" ") || confirmaSenha.equals(" ") || permissao==false){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean verificaSenha(String senha, String confirmaSenha){
        
        if(senha.equals(confirmaSenha)){
            return true;
        }
        else{
            return  false;
        }
    }  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
    
    
}
