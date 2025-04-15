
package trabalhosimulação;


public class Tarefa {
    private int offset;
    private int tempoComputacao;
    private int tempoPeriodo;
    private int quantum;
    private int deadline;
    private int id;
    private int numeroD;
    private int tempoEspera;
    private int tempoComputacao_inicial;
    private int quantumInicial;
    private int contagemDeadlinesP;

    public Tarefa(int offset, int tempoComputacao, int tempoPeriodo, int quantum, int deadline, int id, int numeroD) {
        this.offset = offset;
        this.tempoComputacao = tempoComputacao;
        this.tempoPeriodo = tempoPeriodo;
        this.quantum = quantum;
        this.deadline = deadline;
        this.id = id;
        this.numeroD = numeroD;
        this.tempoEspera = 0;
        this.tempoComputacao_inicial = tempoComputacao;
        this.quantumInicial = quantum;
        this.contagemDeadlinesP = 0;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTempoComputacao() {
        return tempoComputacao;
    }

    public void setTempoComputacao(int tempoComputacao) {
        this.tempoComputacao = tempoComputacao;
    }

    public int getTempoPeriodo() {
        return tempoPeriodo;
    }

    public void setTempoPeriodo(int tempoPeriodo) {
        this.tempoPeriodo = tempoPeriodo;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroD() {
        return numeroD;
    }

    public void setNumeroD(int numeroD) {
        this.numeroD = numeroD;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public int getTempoComputacao_inicial() {
        return tempoComputacao_inicial;
    }

    public void setTempoComputacao_inicial(int tempoComputacao_inicial) {
        this.tempoComputacao_inicial = tempoComputacao_inicial;
    }

    public int getQuantumInicial() {
        return quantumInicial;
    }

    public void setQuantumInicial(int quantumInicial) {
        this.quantumInicial = quantumInicial;
    }

    public int getContagemDeadlinesP() {
        return contagemDeadlinesP;
    }

    public void setContagemDeadlinesP(int contagemDeadlinesP) {
        this.contagemDeadlinesP = contagemDeadlinesP;
    }
   
    @Override
    public String toString() {
        return "Tarefa{" +
                "  offset=" + offset +
                ", tempoComputacao=" + tempoComputacao +
                ", tempoPeriodo=" + tempoPeriodo +
                ", quantum=" + quantum +
                ", deadline=" + deadline +
                ",id=" + id +
                ", numeroD=" + numeroD +
                ", tempoEspera=" + tempoEspera +
                ", tempoComputacao_inicial=" + tempoComputacao_inicial +
                ", quantumInicial=" + quantumInicial +
                ", contagemDeadlinesP=" + contagemDeadlinesP +
                "\n"+
                '}';
    }
}