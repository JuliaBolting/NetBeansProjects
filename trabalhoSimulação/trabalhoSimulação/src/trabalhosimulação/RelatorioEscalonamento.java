
package trabalhosimulação;

import java.util.List;

public class RelatorioEscalonamento {
    private float tempodeEsperaTotal = 0;
    private float tempodeVidaTotal = 0;

    public void imprimirInfo(DadosSimulacao lerDados, List<Tarefa> fila, float tempodeUtilizacao) {
        System.out.println("Tempo de espera e de resposta das tarefas:");

        for (Tarefa tarefa : fila) {
            int turnaroundTime = tarefa.getTempoComputacao() + tarefa.getTempoEspera();
            System.out.println("Tarefa: " + tarefa.getId() + " | Tempo de espera: " + tarefa.getTempoEspera() +
                    " | Turnaround Time: " + turnaroundTime);

            tempodeEsperaTotal += tarefa.getTempoEspera();
            tempodeVidaTotal += turnaroundTime;

            if (tarefa.getContagemDeadlinesP() != 0) {
                System.out.println("Deadline perdido na tarefa " + tarefa.getId());
                System.out.println("Frequência de deadlines perdidos: " +
                        (float) (tarefa.getNumeroD() - 1) / tarefa.getContagemDeadlinesP());
            }

            if (tarefa.getTempoEspera() + tarefa.getTempoComputacao_inicial() > lerDados.getTempoSimulacao()) {
                System.out.println("Tarefa sofreu starvation: " + tarefa.getId());
            }
        }

        Tarefa maiorTempodeEspera = fila.get(0);
        Tarefa menorTempodeEspera = fila.get(0);

        for (Tarefa tarefa : fila) {
            if (tarefa.getTempoEspera() > maiorTempodeEspera.getTempoEspera()) {
                maiorTempodeEspera = tarefa;
            } else if (tarefa.getTempoEspera() < menorTempodeEspera.getTempoEspera()) {
                menorTempodeEspera = tarefa;
            }
        }

        System.out.println("\nTempo de utilização = " + (float) lerDados.getTempoCpu() / lerDados.getTempoSimulacao());
        System.out.println("Produtividade = " + (float) lerDados.getTempoCpu() / lerDados.getTempoSimulacao());
        System.out.println("Waiting Time (avg sys) = " + tempodeEsperaTotal / fila.size());
        System.out.println("Turnaround Time (avg sys) = " + tempodeVidaTotal / fila.size());
        System.out.println("\nMaior e Menor Tempo de Espera: \nTarefa " + maiorTempodeEspera.getId() +
                " (" + maiorTempodeEspera.getTempoEspera() + ")" + " | Tarefa " +
                menorTempodeEspera.getId() + " (" + menorTempodeEspera.getTempoEspera() + ")");

        System.out.println("\nTeste de Escalabilidade: ");
        switch (lerDados.getNomeEscalonador()) {
            case "fcfs", "rr" -> System.out.println("Teste não necessário");
            case "rm" -> System.out.println("U = " + tempodeUtilizacao + " <= " +
                    lerDados.getTarefasqnt() * (Math.pow(2, (float) 1 / lerDados.getTarefasqnt()) - 1));
            case "edf" -> System.out.println("U = " + tempodeUtilizacao + " <= " + 1);
        }

        System.out.println("\nTempo de espera e turnaround time médios de cada tarefa (múltiplas execuções): ");
        for (int i = 1; i <= lerDados.getTarefasqnt(); i++) {
            int aparicoes = 0;
            float somatempodeEspera = 0;
            float somatempodeVida = 0;

            for (Tarefa tarefa : fila) {
                if (tarefa.getId() == i) {
                    somatempodeEspera += tarefa.getTempoEspera();
                    somatempodeVida += (tarefa.getTempoComputacao() + tarefa.getTempoEspera());
                    aparicoes += 1;
                }
            }

            if (aparicoes > 0) {
                System.out.println("Tarefa " + i + " (aparências = " + aparicoes + "): WT avg = " + somatempodeEspera / aparicoes +
                        " | TT avg = " + somatempodeVida / aparicoes);
            }
        }
    }
}