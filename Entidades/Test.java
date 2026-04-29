
public class Test {

    public static void main(String[] args) {

        Ladino ladino = new Ladino();
        Hollow hollow = new Hollow();

        System.out.println("--- Início do Teste de Combate: Ashen Abyss ---");
        System.out.println(ladino.getNAME() + " vs " + hollow.getNAME());
        System.out.println("-----------------------------------------------");

        // Teste de Ataque do Jogador
        System.out.println("[Turno 1: Jogador]");
        ladino.ATK(2, hollow);

        // Teste de Ataque do Inimigo
        // O Hollow decide sozinho
        System.out.println("\n[Turno 2: Inimigo]");
        hollow.ATK(0, ladino);

        // Verificação de Status Final
        System.out.println("\n-----------------------------------------------");
        System.out.println("Status Finais do Teste:");
        System.out.println(ladino.getNAME() + " HP: " + ladino.getHP() + " | Mana: " + ladino.getMANA());
        System.out.println(hollow.getNAME() + " HP: " + hollow.getHP());

    }
}
