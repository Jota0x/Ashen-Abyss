package Entidades;

public class Piromante extends Entidade {

    public Piromante() {
        super("Piromante", 80, 80, 30, 5);
    }

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
