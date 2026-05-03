package Habilidades;

import java.util.List;

import Entidades.Entidade;

public class Punhalada implements Habilidade {

    @Override
    public String getNome() {
        return "Punhalada";
    }

    @Override
    public int getCustoMana() {
        return 0;
    }

    @Override
    public TipoAlvo getTipoAlvo() {
        return TipoAlvo.UNICO;
    }

    @Override
    public void executar(Entidade usuario, Entidade alvo) {
        System.out.println(usuario.getNAME() + " desfere uma punhalada em " + alvo.getNAME() + "!");
        alvo.receberDano(15);
    }

    @Override
    public void executarEmArea(Entidade usuario, List<Entidade> alvos) {
    }
    
}
