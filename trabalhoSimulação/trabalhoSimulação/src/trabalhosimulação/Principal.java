
package trabalhosimulação;


public class Principal {
 public static void main(String[] args) {

        String nomeEscalonador = "rr";
        DadosSimulacao dadosSimulacao = new LeitorJson().lerJson(nomeEscalonador);

        if (dadosSimulacao == null) {
            System.out.println("Falha ao carregar dados da simulação.");
            return;
        }

        System.out.println("Dados Simulação Carregados: " + dadosSimulacao);

        Escalonamentos escalonamento = new Escalonamentos(dadosSimulacao);

        switch (nomeEscalonador) {
            case "fcfs" -> escalonamento.fcfs();
            case "rr" -> escalonamento.roundRobin();
            case "rm" -> escalonamento.rateMonotonic();
            case "edf" -> escalonamento.earliestDeadlineFirst();
        }
    }
}
