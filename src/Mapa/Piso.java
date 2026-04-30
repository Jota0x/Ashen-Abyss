package Mapa;
import Entidades.Entidade;

public class Piso {

    public final int x, y;
    public final TipoPiso tipo;
    public Entidade ocupado;
    public boolean visivel;

    public Piso(int x, int y, TipoPiso tipo) {

        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.ocupado = null;

    }

    public boolean podePisar() {
        return tipo.custoMov < 99 && ocupado == null;
    }

}
