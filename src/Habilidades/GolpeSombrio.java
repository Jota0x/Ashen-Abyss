package Habilidades;

import java.util.*;
import Entidades.Entidade;

public class GolpeSombrio implements Habilidade {

    @Override
    public String getNome() {
        return "Golpe Sombrio";
    }

    @Override
    public int getCustoMana() {
        return 20;
    }

    @Override
    public TipoAlvo getTipoAlvo() {
        return TipoAlvo.UNICO;
    }


    @Override
    public void executar(Entidade usuario, Entidade alvo) {
        if (usuario.getMANA() < getCustoMana()) {
            System.out.println("Mana insuficiente para " + getNome() + "!");
            return;
        }
        usuario.setMANA(usuario.getMANA() - getCustoMana());
        System.out.println(usuario.getNAME() + " invoca as sombras sobre " + alvo.getNAME() + "!");
        alvo.receberDano(35);
    }

    @Override
    public void executarEmArea(Entidade usuario, List<Entidade> alvos) {
    }

}