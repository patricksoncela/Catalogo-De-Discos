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
            if (faixa != "") {
                faixas.add(faixa);
            } else {
                break;
            }
        }

        Disco novoDisco = new Disco(titulo, ano, faixas);
        discos.add(novoDisco);
        System.out.println("Disco cadastrado com sucesso.");
        System.out.println("");
    }

    public void cadastrarArtista() {
        System.out.println("Digite o nome do artista:");
        String nomeArtista = scanner.nextLine();
        System.out.println("Digite o gênero musical do artista:");
        String generoArtista = scanner.nextLine();


        Artista novoArtista = new Artista(nomeArtista, generoArtista);
        artistas.add(novoArtista);
        System.out.println("Artista cadastrado com sucesso.");
        System.out.println("");
    }

    public void associarArtistaADisco() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            System.out.println("Primeiro cadastre um disco para que seja possível associá-lo a um artista.");
            System.out.println("");
        } else {
            if (artistas.isEmpty()) {
                System.out.println("Nenhum artista cadastrado.");
                System.out.println("Primeiro cadastre um artista para que seja possível associá-lo a um disco.");
                System.out.println("");
            } else {
                listarDiscos();
                System.out.println("");
            }
        }
    }

    private Disco buscarDisco(String titulo) {
        for (Disco disco : discos) {
            if (disco.getNome().equals(titulo)) {
                return disco;
            }
        }
        return null;
    }

    public void removerDiscoOuArtista() {
        System.out.println("Deseja remover um disco ou um artista? ");
        {
            if (discos.isEmpty()) {
                System.out.println("Nenhum disco cadastrado.");
                System.out.println("");
            } else {
                listarDiscos();
                System.out.println("Digite o titulo do disco que deseja remover: ");
                String titulo = scanner.nextLine();
                Disco disco = buscarDisco(titulo);

                if (disco != null) {
                    discos.remove(disco);
                    System.out.println("Disco removido com sucesso.");
                    System.out.println("Deseja continuar removendo? [s/n]");
                    String continuar = scanner.nextLine();
                    if (continuar.equalsIgnoreCase("s")) {
                        removerDiscoOuArtista();
                    }
                } else {
                    System.out.println("Disco não encontrado.");
                }
            }
        }
    }
}
