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

        Disco d1 = new Disco("Album 1", 2023);  //Disco criado sem faixas, sendo adicionadas posteriormente
        d1.adicionarFaixa("Faixa 1");
        d1.adicionarFaixa("Faixa 2");

        List<String> faixas = new ArrayList<String>();
        faixas.add("Faixa 1");
        faixas.add("Faixa 2");
        faixas.add("Faixa 3");

        Disco d2 = new Disco("Album 2", 2023, faixas);  //Disco criado já com faixas

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