
package trabalhosimulação;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class LeitorJson {

    public DadosSimulacao lerJson(String tipo) {
        DadosSimulacao dadosSimulacao = null;
        String caminhoArquivoJson;

        switch (tipo) {
            case "fcfs":
                caminhoArquivoJson = "C:/Users\\Julia\\OneDrive\\Documentos\\NetBeansProjects\\trabalhoSimulação\\trabalhoSimulação\\src\\escalonamentosJson\\exemplo_sched_fcfs.json";
                break;
            case "rr":
                caminhoArquivoJson = "C:/Users/Julia/OneDrive/Documentos/NetBeansProjects/trabalhoSimulação/trabalhoSimulação/src/escalonamentosJson/exemplo_sched_rr.json";
                break;
            case "rm":
                caminhoArquivoJson = "C:\\Users\\Julia\\OneDrive\\Documentos\\NetBeansProjects\\trabalhoSimulação\\trabalhoSimulação\\src\\escalonamentosJson\\exemplo_sched_rm.json";
                break;
            case "edf":
                caminhoArquivoJson = "C:\\Users\\Julia\\OneDrive\\Documentos\\NetBeansProjects\\trabalhoSimulação\\trabalhoSimulação\\src\\escalonamentosJson\\exemplo_sched_edf.json";
                break;
            default:
                System.out.println("Tipo de escalonamento não reconhecido.");
                return null;
        }

        try (FileReader reader = new FileReader(caminhoArquivoJson)) {
            Type tipoDadosSimulacao = new TypeToken<DadosSimulacao>() {}.getType();
            dadosSimulacao = new Gson().fromJson(reader, tipoDadosSimulacao);
        } catch (IOException e) {
            System.out.println("Caminho incorreto ou erro ao ler o arquivo.");
            e.printStackTrace();
        }

        return dadosSimulacao;
    }
}
