
package trabalhosimulação;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Escalonamentos {
    
    private final Tarefa[] tarefas;
    private final Tarefa[] cpu;
    private final DadosSimulacao lerDados;        
    private final RelatorioEscalonamento relatorioE;        
    private float tempodeUtilizacaoSomado = 0;        
    private final List<Tarefa> tarefasProntas;        
    private final List<Tarefa> tarefasFinalizadas;        
 
    public Escalonamentos(DadosSimulacao lerDados) {
        if (lerDados == null || lerDados.getTarefas() == null) {
            throw new IllegalArgumentException("Tarefas não foram inicializadas corretamente.");
        }
        this.tarefas = lerDados.getTarefas();
        this.cpu = new Tarefa[1];
        this.lerDados = lerDados;
        this.relatorioE = new RelatorioEscalonamento();
        this.tarefasProntas = new ArrayList<>();
        this.tarefasFinalizadas = new ArrayList<>();
        
        for (int i = 0; i < tarefas.length; i++) {
            tarefas[i].setId(i + 1);
        }
    }

    public void fcfs() {
        for (int i = 0; i <= lerDados.getTempoSimulacao(); i++) {
            addTarefasProntas(i);

            if (cpu[0] != null) computar(i);
            if (cpu[0] == null && !tarefasProntas.isEmpty()) removedeTarefasProntas();

            imprimir(i);
        }
        relatorioE.imprimirInfo(lerDados, tarefasFinalizadas, 0);
    }

    public void roundRobin() {
        for (int i = 0; i <= lerDados.getTempoSimulacao(); i++) {
            addTarefasProntas(i);

            if (cpu[0] != null) computar(i);
            if (cpu[0] == null && !tarefasProntas.isEmpty()) removedeTarefasProntas();

            imprimir(i);
        }
        relatorioE.imprimirInfo(lerDados, tarefasFinalizadas, 0);
    }

    public void rateMonotonic() {
        for (Tarefa tarefa : tarefas) {
            tempodeUtilizacaoSomado += (float) tarefa.getTempoComputacao() / tarefa.getTempoPeriodo();
        }
        double limiteUtilizacao = lerDados.getTarefasqnt() * (Math.pow(2, 1.0 / lerDados.getTarefasqnt()) - 1);
        if (tempodeUtilizacaoSomado > limiteUtilizacao) {
            System.out.println("Sistema não escalonável.");
            return;
        }

        Arrays.sort(tarefas, Comparator.comparingInt(Tarefa::getTempoPeriodo));

        int tempoAtual = 0;
        cpu[0] = null;

        while (tempoAtual <= lerDados.getTempoSimulacao()) {
            addTarefasProntas(tempoAtual);

            if (cpu[0] != null) {
                computar(tempoAtual);
            }

            if (cpu[0] == null && !tarefasProntas.isEmpty()) {
                removedeTarefasProntas();
            }

            checarDeadlinesPerdidos(tempoAtual);
            imprimir(tempoAtual);

            tempoAtual++;
        }

        relatorioE.imprimirInfo(lerDados, tarefasFinalizadas, tempodeUtilizacaoSomado);
    }

    public void earliestDeadlineFirst() {
        for (Tarefa tarefa : tarefas) {
            tempodeUtilizacaoSomado += (float) tarefa.getTempoComputacao() / tarefa.getTempoPeriodo();
        }
        if (tempodeUtilizacaoSomado > 1) {
            System.out.println("! Warning: The set is NOT scalable");
            return;
        }

        Tarefa aux;
        for (int i = 0; i <= lerDados.getTempoSimulacao(); i++) {
            for (int j = 0; j < lerDados.getTarefasqnt() - 1; j++) {
                if (tarefas[j].getDeadline() > tarefas[j + 1].getDeadline()) {
                    aux = tarefas[j];
                    tarefas[j] = tarefas[j + 1];
                    tarefas[j + 1] = aux;
                }
            }
            addTarefasProntas(i);
            if (cpu[0] != null) computar(i);
            if (cpu[0] == null && !tarefasProntas.isEmpty()) removedeTarefasProntas();

            checarDeadlinesPerdidos(i);
            imprimir(i);
        }
        relatorioE.imprimirInfo(lerDados, tarefasFinalizadas, tempodeUtilizacaoSomado);
    }

    private void checarDeadlinesPerdidos(int i) {
        for (Tarefa tarefa : tarefasProntas) {
            if (tarefa.getDeadline() == 1) {
                tarefa.setContagemDeadlinesP(tarefa.getContagemDeadlinesP() + 1);
                System.out.println("Deadline perdido na tarefa " + tarefa.getId() + " no tempo " + i);
            }
        }
    }

   
    private void computar(int i) {
    cpu[0].setTempoComputacao(cpu[0].getTempoComputacao() - 1);

    if (cpu[0].getQuantum() != 0) {
        cpu[0].setQuantum(cpu[0].getQuantum() - 1);
    }
    lerDados.setTempoCpu(lerDados.getTempoCpu() + 1);

    for (Tarefa tarefa : tarefasProntas) {
        if (tarefa.getOffset() != i && (i - tarefa.getOffset()) % tarefa.getTempoPeriodo() != 0) {
            tarefa.setTempoEspera(tarefa.getTempoEspera() + 1);
        }
    }

    if (cpu[0].getTempoComputacao() == 0) {
        cpu[0].setTempoComputacao(cpu[0].getTempoComputacao_inicial());
        tarefasFinalizadas.add(cpu[0]);
        cpu[0] = null;
    } else {
        switch (lerDados.getNomeEscalonador()) {
            case "fcfs":
                break;
            case "rr":
                tratarRoundRobin();
                break;
            case "rm":
                tratarRateMonotonic();
                break;
            case "edf":
                tratarEarliestDeadlineFirst();
                break;
        }
    }
}
    private void addTarefasProntas(int i) {
      for (Tarefa tarefa : tarefas) {
        if (tarefa.getOffset() == i || (i - tarefa.getOffset()) % tarefa.getTempoPeriodo() == 0) {
            Tarefa tarefaperiodica = new Tarefa(i, tarefa.getTempoComputacao(), tarefa.getTempoPeriodo(), tarefa.getQuantum(),
                    tarefa.getDeadline() * tarefa.getNumeroD(), tarefa.getId(), tarefa.getNumeroD());
            
            tarefasProntas.add(tarefaperiodica);
        }
    }
}

    private void removedeTarefasProntas() {
    cpu[0] = tarefasProntas.remove(0);
   }

    private void tratarRoundRobin() {
        if (cpu[0].getQuantum() == 0) {
            cpu[0].setQuantum(cpu[0].getQuantumInicial());
            tarefasProntas.add(cpu[0]);
            cpu[0] = null;
        }
    }

    private void tratarRateMonotonic() {
        for (Tarefa tarefa : tarefasProntas) {
            if (cpu[0].getTempoPeriodo() > tarefa.getTempoPeriodo()) {
                tarefasProntas.add(cpu[0]);
                cpu[0] = tarefa;
                tarefasProntas.remove(tarefa);
                break;
            }
        }
    }

    private void tratarEarliestDeadlineFirst() {
        for (Tarefa tarefa : tarefasProntas) {
            if (cpu[0].getDeadline() > tarefa.getDeadline()) {
                tarefasProntas.add(cpu[0]);
                cpu[0] = tarefa;
                tarefasProntas.remove(tarefa);
                break;
            }
        }
    }

    private void imprimir(int i) {
        System.out.println("* TEMPO ATUAL: " + i);
        System.out.println("* FILA DE PRONTAS: " + "\n" + tarefasProntas);
        System.out.println("* CPU: " + cpu[0]);
        System.out.println("* FILA DE CONCLUÍDAS: " + "\n" + tarefasFinalizadas);
    }
}