package ciasAereas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import geo.Cidade;
import geo.Estado;
import util.Console;

public class TelaGerenciaVoos {
    private List<Voo> lstVoos = new ArrayList<Voo>();//podemos inicializar aqui ao inves de no construtor (tem o mesmo efeito)
    private Map <String, CiaAerea> mapCiasAereas;
    private List<Cidade> lstCidades;
    
    public TelaGerenciaVoos(Map<String,CiaAerea> mapCiasAereas,List<Cidade> lstCidades){
        this.mapCiasAereas = mapCiasAereas;
        this.lstCidades = lstCidades;
    }
    
    /**
     * Dentre todas as cidades, escolhe uma.
     * Este metodo deve apresentar um menu. Exemplo de saída:
     * 0. Belo Horizonte/MG
     * 1. São Paulo /SP
     * ... 
     * Escolha a Cidade: 
     * 
     * E o usuario deve escolher um item deste menu. 
     * Dica: para navegar nas cidades faça:  for(int i=0; i< lstCidades.size(); i++)
     * ou seja, para navegar nela, você utiliza o metodo size. Para obter uma cidade do vetor utilize o metodo 
     * get do vetor: lstCidades.get(i)
     * 
     * O número do menu pode ser o índice da lista. Assim, fica simples obter a cidade escohida a partir do que o usuário digitar. 
     * Por exemplo, se o usuário digitar "1" significa que ele deseja a cidade da posição 1 da lista (facilmente retornada pelo metodo get da mesma).
     * 
     *   Não esqueça de não permitir que o usuário digite uma cidade inválida. Enquanto o usuário não digitar uma cidade válida,
     *   o método não terminará sua execução. 
     */
    public Cidade escolheCidade()
    {
        int opcao;

        do{
            for( int i = 0; i < lstCidades.size(); i++ ) {
                System.out.println("\n" + i);
                System.out.println(lstCidades.get(i));
            }

            opcao = Console.readInt("Escolha uma cidade: ");
        }while( opcao > lstCidades.size() || opcao < 0 );

        return lstCidades.get(opcao);
    }
    /**
     *  Imprime um menu de linhas aéreas. Exemplo de saída: 
     *  CEFETAir - Cefet Linhas aéreas blah
     *  VOA - VOA Alto Linhas aéreas 
     *  ...
     *  Escolha a Cia Aérea: 
     *  
     *  Onde VOA e CEFETAir são as siglas de cada uma das linhas aéreas.
     *  Para imprimir cada cia aérea, primeiro extraia os valores do map: mapCiasAereas.values();
     *  Esses values retorna uma coleção (Collection). Utilize o iterador desta coleção para navegar e imprimir as linhas aéreas.
     *  
     *  O usuário deverá escolher as linhas aéreas a partir da sua sigla. Utilize o método get do Map para extrair 
     *  a sigla que o usuário digitou. Por exemplo: mapCiasAereas.get("CEFETAir"); retorna um objeto da classe CiaAerea se a 
     *  chave "CEFETAir" existir, caso contrario retorna null (nulo). 
     *  
     *  Você deve fazer a validação para que o usuário não digite um cia aérea inválida. Enquanto o usuário não digitar uma cia válida,
     *   o método não terminará sua execução. 
     */
    public CiaAerea escolheCiaAerea()
    {
        CiaAerea ca;
        String sigla;
        Collection <CiaAerea> c = mapCiasAereas.values();
        Iterator <CiaAerea> i = c.iterator();

        while( i.hasNext() ){
            ca = i.next();
            System.out.println("\n" + ca);
        }

        do{
            sigla = Console.readString("\nEscolha uma Cia Aerea: ");
        }while( mapCiasAereas.get(sigla) == null );

        return mapCiasAereas.get(sigla);
    }
    /**
     * Este método deve criar um voo e adicioná-lo na lista de voos da seguinte forma:
     * (1) Solicitar ao usuário o número do voo
     * (2) Solicitar ao usuário que escolha a cia aerea (através do método escolheCiaAerea)
     * (3) Solicitar ao usuário que escolha a cidade origem (através do método escolheCidade)
     * (4) Solicitar ao usuário que escolha a cidade destino (através do método escolheCidade)
     * (5) Com esses objetos, crie um voo e o adicione no arraylist (lstVoos)
     */
    public void criaVoo()
    {
        CiaAerea comp;
        Cidade origem, destino;

        int numVoo = Console.readInt("Qual o numero do voo: ");
        comp = this.escolheCiaAerea();
        origem = this.escolheCidade();
        destino = this.escolheCidade();

        lstVoos.add (new Voo(numVoo, comp, origem, destino) );
    }
    /**
     * Metodo que imprime todos os voos cadastrados
     */
    public void imprimeVoos()
    {
        for( Voo v : lstVoos ){
            System.out.println(v);
        }

    }


    private static List<Cidade> criaCidades() {
        //cadastra estados
        Estado estMG = new Estado("Minas Gerais","MG");     
        Estado estSP = new Estado("São Paulo","SP");
        Estado estAM = new Estado("Amazonas","AM");
        
        
        //cria as cidades e as associa aos estados
        List<Cidade> lstCidades = new ArrayList<>();
        lstCidades.add(new Cidade("Belo Horizonte",estMG));
        lstCidades.add(new Cidade("Brumadinho",estMG));
        lstCidades.add(new Cidade("São Paulo",estSP));
        lstCidades.add(new Cidade("Campinas",estSP));
        lstCidades.add(new Cidade("Manaus",estAM));
        return lstCidades;
    }

    private static Map<String, CiaAerea> criaCiasAereas() {
        Map<String,CiaAerea> mapCiasAereas = new HashMap<String, CiaAerea>();
        mapCiasAereas.put("CEFETAir", new CiaAerea("CEFETAir","Cefet Linhas aéreas blah"));
        mapCiasAereas.put("VOA", new CiaAerea("VOA","VOA Alto Linhas aéreas"));
        mapCiasAereas.put("!CAI", new CiaAerea("!CAI", "Não cai Linhas aéreas seguras"));
        return mapCiasAereas;
    }

    private static void exibeTela(List<Cidade> lstCidades, Map<String, CiaAerea> mapCiasAereas) {
        //imprime a tela
        TelaGerenciaVoos tela = new TelaGerenciaVoos(mapCiasAereas, lstCidades);
        
        String resp = "S";
        //resp.equalsIgnoreCase("S") == Se a resposta foi "S" ou "s".
        while(resp.equalsIgnoreCase("S"))
        {
            tela.imprimeVoos();
            tela.criaVoo();
            do{
                resp = Console.readString("Deseja criar mais um voo (S/N)? ");
                if(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N")){
                    System.out.println("Resposta inválida!");
                }
            }
            while(!resp.equalsIgnoreCase("S") && !resp.equalsIgnoreCase("N"));
            System.out.println("\nObrigado por criar um Voo!");
        }
    }
    
    public static void main(String[] args)
    {
        List<Cidade> lstCidades = criaCidades();
        
        Map<String, CiaAerea> mapCiasAereas = criaCiasAereas();
        
        exibeTela(lstCidades, mapCiasAereas);
        
    }
}
