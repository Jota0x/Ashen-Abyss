package Habilidades;

import java.util.*;
import Entidades.Entidade;

public class Curar implements Habilidade {

    private static final int CURA = 30;

    @Override
    public String getNome() {
        return "Curar";
    }

    @Override
    public int getCustoMana() {
        return 25;
    }

    @Override
    public TipoAlvo getTipoAlvo() {
        return TipoAlvo.PROPRIO;
    }

    @Override
    public void executar(Entidade usuario, Entidade alvo) {
        if (usuario.getMANA() < getCustoMana()) {
            System.out.println("Mana insuficiente para " + getNome() + "!");
            return;
        }
        usuario.setMANA(usuario.getMANA() - getCustoMana());
        alvo.receberCura(CURA);
        System.out.println(usuario.getNAME() + " canaliza energia e cura " + alvo.getNAME() + "!");
    }

    @Override
    public void executarEmArea(Entidade usuario, List<Entidade> alvos) {
    }

}