
import Entidades.*;
import Mapa.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    static GeracaoMapa mapa;
    static Ladino ladino;
    static Hollow hollow;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mapa = new GeracaoMapa(10, 10);
        ladino = new Ladino();
        hollow = new Hollow();

        mapa.colocarUnidade(ladino, 1, 1);
        mapa.colocarUnidade(hollow, 7, 7);

        System.out.println("=== Ashen Abyss ===");
        System.out.println("W/A/S/D para mover | Q para sair");

        while (true) {
            mapa.print(List.of(ladino));
            System.out.println("HP: " + ladino.getHP() + " | Mana: " + ladino.getMANA());
            System.out.print("Acao: ");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Saindo do abismo...");
                break;
            }

            mover(input);

            if (ladino.getHP() <= 0) {
                mapa.print(List.of(ladino));
                System.out.println("Você sucumbiu ao abismo...");
                break;
            }
        }

        scanner.close();
    }

    private static void mover(String input) {
        int novoX = ladino.getX();
        int novoY = ladino.getY();

        if (input.equals("W")) {
            novoX = novoX - 1; // sobe no grid
        } else if (input.equals("S")) {
            novoX = novoX + 1; // desce no grid
        } else if (input.equals("A")) {
            novoY = novoY - 1; // esquerda
        } else if (input.equals("D")) {
            novoY = novoY + 1; // direita
        } else {
            System.out.println("Tecla invalida! Use W/A/S/D");
            return;
        }

        boolean moveu = mapa.moverUnidade(ladino, novoX, novoY);

        if (!moveu) {
            System.out.println("Nao e possivel mover para la!");
            return;
        }

        System.out.println("Moveu para (" + novoX + ", " + novoY + ")");

        int distX = Math.abs(ladino.getX() - hollow.getX());
        int distY = Math.abs(ladino.getY() - hollow.getY());

        if (distX <= 1 && distY <= 1 && hollow.getHP() > 0) {
            System.out.println("\n Hollow esta proximo! Combate!");
            ladino.ATK(2, hollow);

            if (hollow.getHP() <= 0) {
                System.out.println("Hollow foi derrotado!");
            } else {
                hollow.ATK(0, ladino);
            }
        }
    }
}
