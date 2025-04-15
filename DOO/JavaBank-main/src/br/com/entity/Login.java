package br.com.entity;

public class Login {
    private int id_usuario;
    private String usuario;
    private String senha;
    private String email;
    private int numero_conta;
    private int telefone;
    private Double saldo;
    private String data_criacao;
    private double saque;
    private double deposito;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
        total -= this.saque;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
        total += this.deposito;

    }
    
    public double total(){
        return total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }
    
    public Double makeDeposit(Double deposito){
        return deposito += this.total;
    }
    public Double makeWithdraw(Double saque){
        return saque -= this.total;
    }
}
