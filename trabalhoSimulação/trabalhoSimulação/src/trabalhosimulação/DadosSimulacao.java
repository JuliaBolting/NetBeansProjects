
package trabalhosimulação;

import java.util.Arrays;


public class DadosSimulacao {
    private int tempoSimulacao;
    private String nomeEscalonador;
    private int tarefasqnt;
    private Tarefa[] tarefas;
    private int tempoCpu;
    
    
    public DadosSimulacao(int tempoSimulacao, String nomeEscalonador, int tarefasqnt, Tarefa[] tarefas, int tempoCpu) {
        this.tempoSimulacao = tempoSimulacao;
        this.nomeEscalonador = nomeEscalonador;
        this.tarefasqnt = tarefasqnt;
        this.tarefas = tarefas;
        this.tempoCpu = tempoCpu;
        
        
    }

    public int getTempoSimulacao() {
        return tempoSimulacao;
    }

    public void setTempoSimulacao(int tempoSimulacao) {
        this.tempoSimulacao = tempoSimulacao;
    }

    public String getNomeEscalonador() {
        return nomeEscalonador;
    }

    public void setNomeEscalonador(String nomeEscalonador) {
        this.nomeEscalonador = nomeEscalonador;
    }

    public int getTarefasqnt() {
        return tarefasqnt;
    }

    public void setTarefasqnt(int tarefasqnt) {
        this.tarefasqnt = tarefasqnt;
    }

    public Tarefa[] getTarefas() {
        return tarefas;
    }

    public void setTarefas(Tarefa[] tarefas) {
        this.tarefas = tarefas;
    }

    public int getTempoCpu() {
        return tempoCpu;
    }

    public void setTempoCpu(int tempoCpu) {
        this.tempoCpu = tempoCpu;
    }

    @Override
    public String toString() {
        return "DadosSimulacao{" +
                " \n tempoSimulacao=" + tempoSimulacao +
                ",\n nomeEscalonador='" + nomeEscalonador + '\'' +
                ",\n tarefasqnt=" + tarefasqnt +
                ",\n tarefas=" + Arrays.toString(tarefas) +
                '}';
    }
}