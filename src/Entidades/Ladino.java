package Entidades;

import Habilidades.*;

public class Ladino extends Entidade {

    // Cosntrutor inicial de Ladino
    public Ladino() {
        super("Ladino", 100, 50, 30, 10);
        adicionarHabilidade(new Punhalada());
        adicionarHabilidade(new GolpeSombrio());
    }

    // Classe ataque para teste
    @Override
    public void ATK(int ataque, Entidade alvo) {

        if (ataque == 1) {
            System.out.println(getNAME() + " Usou ataque 1 em " + alvo.getNAME());
            alvo.receberDano(10);
        } else if (ataque == 2) {
            System.out.println(getNAME() + "Usou ataque 2 em " + alvo.getNAME());
            alvo.receberDano(30);
        } else {
            System.out.println("Opcao invalida");
        }
    }

}
