package exercicio2;

public class Principal {

    public static void main(String[] args) {
        Medico m1 = new Medico(1221646, "MG18845800", "Mauro Lucio Azevedo", "Belo Horizonte", "Minas Gerais", "256545555", "Casado", 23145643, 1252, "Cardiologista");
        Medico m2 = new Medico(1413349, "MG23835621", "Luiz Bruno Coutinho", "Contagem", "Minas Gerais", "244545555", "Solteiro", 13142333, 14452, "Pediatra");
        Pessoa x = new Pessoa(1311656, "MG23845550", "Mateus Rabelo da Silva", "Betim", "Minas Gerais", "233545345", "Casado");
        Paciente p1 = new Paciente (12411646, "MG22845800", "Clark Stark", "Vitoria", "Minas Gerais", "256545335", "Solteiro", 4132341, "UNIMED");
        Paciente p2 = new Paciente (10430646, "MG22435800", "Tony Wayne", "Itu", "São Paulo", "356125335", "Solteiro", 4133211, "UNIMED");
        
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(x.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }

}
