package beans;


public class Cliente {

    private String nome;
    private String telefone;
    private String cpf;
    private int id;

    public Cliente(String nome, String telefone, String cpf, int id) {
        this(nome, telefone, cpf);
        this.id = id;
    }

    public Cliente(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        nome = this.nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        String cliente = " ID [" + this.id + "]";
        cliente += this.nome + "\t CPF (" + this.cpf + " ) \t";
        cliente += "- Tel: {" + this.telefone + "}";
        return cliente;
    }

    public boolean equals(Object o) {
        if (o instanceof Cliente cli) {
            return cli.getCpf().equals(this.cpf);
        } else {
            return false;
        }
    }
}
