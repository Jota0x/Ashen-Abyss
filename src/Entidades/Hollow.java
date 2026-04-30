package Entidades;

import java.util.Random;

public class Hollow extends Entidade {

    private Random random = new Random();

    public Hollow() {
        super("Hollow", 50, 0, 50, 0);
    }

    @Override
    public void ATK(int quantidade, Entidade alvo) {
        int acao = random.nextInt(100);

        if (acao < 70) {
            System.out.println(getNAME() + " Usou ataque 1 em " + alvo.getNAME());
            alvo.receberDano(20);
        } else {
            System.out.println(getNAME() + " Usou ataque 2 em " + alvo.getNAME());
            alvo.receberDano(50);
        }
    }

}
