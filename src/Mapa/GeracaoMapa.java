package Mapa;
import Entidades.Entidade;
import java.util.*;

public class GeracaoMapa {

    private final int altura, largura;
    private final Piso[][] mapa;
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public GeracaoMapa(int altura, int largura) {

        this.altura = altura;
        this.largura = largura;
        this.mapa = new Piso[altura][largura];
        geracao();

    }

    private void geracao() {

        Random rng = new Random();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {

                int dado = rng.nextInt(100);

                TipoPiso tipo;

                if (dado < 65) {
                    tipo = TipoPiso.GRASS;
                } else if (dado < 85) {
                    tipo = TipoPiso.MOUNTAIN;
                } else {
                    tipo = TipoPiso.WATER;
                }

                mapa[i][j] = new Piso(i, j, tipo);

            }
        }

    }

    public Piso getPiso(int x, int y) {

        if (x < 0 || x >= altura || y < 0 || y >= largura) {
            return null;
        }

        return mapa[x][y];

    }

    public List<Piso> getVisinhos(Piso piso) {

        List<Piso> result = new ArrayList<>();
        for (int[] d : DIRS) {
            Piso t = getPiso(piso.x + d[0], piso.y + d[1]);
            if (t != null) {
                result.add(t);
            }
        }
        return result;

    }

    public boolean colocarUnidade(Entidade entidade, int x, int y) {

        Piso piso = getPiso(x, y);

        if (piso == null) {
            return false;
        }

        piso.ocupado = entidade;
        entidade.setX(x);
        entidade.setY(y);

        return true;

    }

    public boolean moverUnidade(Entidade entidade, int x, int y) {

        Piso origem = getPiso(entidade.getX(), entidade.getY());
        Piso destino = getPiso(x, y);

        if (destino == null || !destino.podePisar()) {
            return false;
        }
        if (origem != null) {
            origem.ocupado = null;
        }

        destino.ocupado = entidade;
        entidade.setX(x);
        entidade.setY(y);
        return true;
    }

    private void updateFog(List<Entidade> herois) {
        // Apaga tudo
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                mapa[i][j].visivel = false;
            }
        }

        // Revela ao redor de cada herói
        for (Entidade e : herois) {
            int range = 3; // tiles visíveis ao redor
            for (int x = e.getX() - range; x <= e.getX() + range; x++) {
                for (int y = e.getY() - range; y <= e.getY() + range; y++) {
                    Piso t = getPiso(x, y);
                    if (t != null) {
                        t.visivel = true;
                    }
                }
            }
        }
    }

   public void print(List<Entidade> herois) {
    updateFog(herois);
    System.out.println();
    for (int i = 0; i < altura; i++) {
        for (int j = 0; j < largura; j++) {
            Piso p = mapa[i][j];

            if (!p.visivel) {
                System.out.print(" ░ ");
            } else if (p.ocupado != null) {
                if (p.ocupado.getNAME().equals("Hollow")) {
                    System.out.print(" E ");
                } else {
                    System.out.print(" H ");
                }
            } else if (p.tipo == TipoPiso.GRASS) {
                System.out.print(" . ");
            } else if (p.tipo == TipoPiso.MOUNTAIN) {
                System.out.print(" ^ ");
            } else if (p.tipo == TipoPiso.WATER) {
                System.out.print(" ~ ");
            }
        }
        System.out.println();
    }
}

}
