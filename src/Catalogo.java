import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    private static List<Disco> discos = new ArrayList<>(); //Cria e inicializa a lista de discos
    private static List<Artista> artistas = new ArrayList<>(); //Cria e inicializa a lista de artistas
    Scanner scanner = new Scanner(System.in);


    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            System.out.println("");
        } else {
            System.out.println("|==== LISTA DE DISCOS ====|");
            for (Disco d : discos) {
                System.out.println(d);
            }
        }
    }

    public void cadastrarDisco() {
        System.out.println("Digite o título do disco:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o ano de lançamento do disco:");
        int ano = scanner.nextInt();
        scanner.nextLine(); //limpar o buffer

        List<String> faixas = new ArrayList<>(); //cria lista de faixas

        System.out.println("Digite as faixas uma por linha (deixe uma linha em branco para finalizar):"); //adiciona faixas até uma linha vazia ser inserida
        while (true) {
            String faixa = scanner.nextLine();
            if (faixa != ""){
                faixas.add(faixa);
            } else {
                break;
            }
        }

        Disco novoDisco = new Disco(titulo, ano, faixas);
        discos.add(novoDisco);
        System.out.println("Disco adicionado com sucesso.");
        System.out.println("");
    }
}
