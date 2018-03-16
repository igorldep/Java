
package esportes; //pacote - minusculo

public class Atleta { //Classe - CamelCase
    private String nome;
    //Visibilidade(public/private/protect*) - Tipo/Classe - nome
    private double altura;
    private double peso;
    /*
     * Atleta com IMC acima do IMC_MAX � considerado acima do peso
     */
    private static final double IMC_MAX = 28;
    
    public Atleta (String nome, double altura, double peso){
        this.altura = altura;
        this.peso = peso;
        this.nome = nome;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public static double getImcMax() {
		return IMC_MAX; //?
	}
	
	public double getIMC(){
		return altura/Math.pow(peso, 2);
	}
	
	public boolean estaAcimaDoPeso(){
		if(getIMC() > Atleta.IMC_MAX){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		String strAtleta = "Nome do Atleta: "+this.nome;
		strAtleta += "peso: " +this.peso;
		if(this.estaAcimaDoPeso()){
			strAtleta += "\n\t Atleta acima do peso!";
		}
		
		return strAtleta;
	}
}
