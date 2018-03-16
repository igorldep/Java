package exercicio1;

public class Cilindro {
    private float raio;
    private float altura;
    
    private static final float PI = 3.141519f;
    
    public Cilindro(float raio, float altura){
        this.raio = raio;
        this.altura = altura;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public float a_base(){
        return ( PI * raio * raio );
    }
    
    public float a_lateral(){
        return ( 2 * PI * raio * altura );
    }
    
    public float a_total(){
        return ( 2 * a_base() + a_lateral() );
    }

}
