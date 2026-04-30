package Mapa;

public enum TipoPiso {

    GRASS(1),
    MOUNTAIN(2),
    WATER(99);

    public final int custoMov;

    TipoPiso(int custoMov) {
        this.custoMov = custoMov;
    }
}
