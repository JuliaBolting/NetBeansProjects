package poo_16_08_ex2;

/**
 *
 * @author Julia
 */
public class Temperatura {
    private float celsius;
    
    public Temperatura(){}

    public Temperatura(float celsius) {
        this.celsius = celsius;
    }

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }
    
    public float kelvin(float celsius){
        return celsius + 273;
    }
    
    public float fahren(float celsius){
        return (float) ((celsius * 1.8) + 32);
    }

    @Override
    public String toString() {
        return "Temperatura{" + "celsius=" + celsius + " kelvin=" + kelvin(celsius) + " fahren=" + fahren(celsius) + "}";
    }
    
}
