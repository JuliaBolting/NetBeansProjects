package Exercicio_12;

/**
 *
 * @author Julia
 */
public class Triangulo {
    private double valorX;
    private double valorY;
    private double valorZ;
    private String tipoTri;
    
    public Triangulo(){}

    public Triangulo(double valorX, double valorY, double valorZ, String tipoTri) {
        this.valorX = valorX;
        this.valorY = valorY;
        this.valorZ = valorZ;
        this.tipoTri = tipoTri;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }

    public double getValorZ() {
        return valorZ;
    }

    public void setValorZ(double valorZ) {
        this.valorZ = valorZ;
    }

    public String getTipoTri() {
        return tipoTri;
    }

    public void setTipoTri(String tipoTri) {
        this.tipoTri = tipoTri;
    }
    
    public boolean verifyIfIsntATri(double X, double Y, double Z){
        if(X > (Y + Z)) return true;
        else if(Y > (X + Z)) return true;
        else return Z > (X + Y);
    }
    
    public String verifyTipoTri(double X, double Y, double Z){
        if (X == Y && Y == Z) return "Equilátero";
        else if (X == Y || X == Z || Y == Z) return "Isóscele";
        else return "Escaleno";
    }

    @Override
    public String toString() {
        return "Triangulo{" + "valorX=" + valorX + ", valorY=" + valorY + ", valorZ=" + valorZ + ", tipoTriangulo=" + tipoTri + '}';
    }
    
}
