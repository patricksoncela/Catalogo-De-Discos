import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);


    public static void mostrarMenu(){
        System.out.println("|==== CATÁLOGO DE DISCOS ====|");
        System.out.println("1 - Listar discos disponíveis");
        System.out.println("2 - Cadastrar novo disco");
        System.out.println("3 - Cadastrar novo artista");
        System.out.println("4 - Associar um artista a um disco");
        System.out.println("5 - Editar disco ou artista");
        System.out.println("6 - Remover disco ou artista");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma opção: ");
    }
}
