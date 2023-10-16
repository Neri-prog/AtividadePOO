import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class Futebol{
    private String nome;
    public Futebol (String nome){this.nome = nome;}
    public abstract void fazerGol();
    public String getNome(){ return nome;}
}
class Corinthians extends Futebol{
    public Corinthians (String nome){ super(nome);}
    @Override
    public void fazerGol(){
        System.out.println(getNome()+"faz gol todo jogo!");
    }
}
class Santos extends Futebol{
    public Santos(String nome){super(nome);}
    @Override
    public void fazerGol(){
        System.out.println(getNome()+"faz gol todo jogo");
    }
}
public class Main {
    public static void main(String[]args){
        List<Futebol> partidas = new ArrayList<>();
        partidas.add(new Corinthians("Yuri Alberto "));
        partidas.add(new Santos("Marcos Leonardo "));

        List<Futebol> Corinthians = partidas.stream()
                .filter(jogo -> jogo instanceof Corinthians)
                .collect(Collectors.toList());
        List<Futebol> Santos = partidas.stream()
                .filter(jogo -> jogo instanceof Santos)
                .collect(Collectors.toList());

        System.out.println("Jogador na lista:");
        for (Futebol jogo: Corinthians){
            jogo.fazerGol();
        }
        for (Futebol jogo: Santos){
            jogo.fazerGol();
        }
    }
}