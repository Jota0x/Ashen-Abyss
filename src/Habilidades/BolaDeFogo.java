package Habilidades;

import java.util.*;
import Entidades.Entidade;

public class BolaDeFogo implements Habilidade {

    @Override
    public String getNome() {
        return "Bola de Fogo";
    }

    @Override
    public int getCustoMana() {
        return 30;
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
        System.out.println(usuario.getNAME() + " lança uma bola de fogo em " + alvo.getNAME() + "!");
        alvo.receberDano(45);
    }

    @Override
    public void executarEmArea(Entidade usuario, List<Entidade> alvos) {
    }

}