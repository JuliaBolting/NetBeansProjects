package Exercicio_11;

/**
 *
 * @author Julia
 */
public class IMC {
    private double peso;
    private double altura;
    private String classificacao;
    
    public IMC(){}

    public IMC(double peso, double altura, String classificacao) {
        this.peso = peso;
        this.altura = altura;
        this.classificacao = classificacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    
    public float calcIMC(double peso, double altura){
        return (float) (peso / (altura * altura));
    }
    
    public String calcClassificacao(double peso, double altura){
        float imc = calcIMC(peso, altura);
        String classif;
        if (imc < 18.5) classif = "MAGREZA";
        else if (imc >= 18.5 && imc <= 24.9) classif = "NORMAL";
        else if (imc >= 25 && imc <= 29.9) classif = "SOBREPESO";
        else if (imc >= 30 && imc <= 39.9) classif = "OBESIDADE";
        else classif = "OBESIDADE GRAVE";
        return classif;
    }

    @Override
    public String toString() {
        return "IMC{" + "peso=" + peso + ", altura=" + altura + ", classificacao=" + classificacao + ", imc=" + calcIMC(peso, altura) + '}';
    }
    
}
