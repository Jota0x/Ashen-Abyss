package Habilidades;

import Entidades.Entidade;
import java.util.*;

public interface Habilidade {
    String getNome();

    int getCustoMana();

    TipoAlvo getTipoAlvo();

    void executar(Entidade usuario, Entidade alvo); // alvo único

    void executarEmArea(Entidade usuario, List<Entidade> alvos); // área
}
