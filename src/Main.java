import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Catalogo catalogo = new Catalogo(); //Instancia o catálogo
    private static Scanner scanner = new Scanner(System.in); //scanner

    public static void main(String[] args) {
        int opcao;

        Disco d1 = new Disco("Graduation", 2007);  //Disco criado sem faixas, sendo adicionadas posteriormente
        Catalogo.discos.add(d1);
        d1.adicionarFaixa("Homecoming");
        d1.adicionarFaixa("I Wonder");
        d1.adicionarFaixa("Flashing Lights");
        Artista kanyeWest = new Artista("Kanye West", "Hip-Hop/Rap");
        Catalogo.artistas.add(kanyeWest);


        List<String> faixas = new ArrayList<String>();
        faixas.add("Death On Two Legs");
        faixas.add("Love Of My Life");
        faixas.add("Bohemian Rhapsody");

        Disco d2 = new Disco("A Night At The Opera", 1975, faixas);  //Disco criado já com faixas
        Catalogo.discos.add(d2);
        Artista queen = new Artista("Queen","Rock");
        Catalogo.artistas.add(queen);

        do {
            Menu.mostrarMenu(); //chama o menu
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    catalogo.listarDiscos();
                    break;
                case 2:
                    catalogo.cadastrarDisco();
                    break;
                case 3:
                    catalogo.cadastrarArtista();
                    break;
                case 4:
                    catalogo.associarArtistaADisco();
                    break;
                case 5:
                    catalogo.editarDiscoOuArtista();
                    break;
                case 6:
                    catalogo.removerDiscoOuArtista();
                    break;
            }
        } while (opcao != 0);
        System.out.println("Saindo...");
    }
}