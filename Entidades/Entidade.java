
public abstract class Entidade {

    private String name;
    private int hp;
    private int mana;
    private int speed;
    private int resistence;
    private int x, y;  //posicao da entidade no mapa

    public Entidade() {
    }

    public Entidade(String name, int hp, int mana, int speed, int resistence) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.speed = speed;
        this.resistence = resistence;

    }

    // setters
    void setNAME(String name) {
        this.name = name;
    }

    void setHP(int hp) {
        this.hp = hp;
    }

    void setMANA(int mana) {
        this.mana = mana;
    }

    void setSPEED(int speed) {
        this.speed = speed;
    }

    void setRESISTENCE(int resistence) {
        this.resistence = resistence;
    }

    //getters
    String getNAME() {
        return this.name;
    }

    int getHP() {
        return this.hp;
    }

    int getMANA() {
        return this.mana;
    }

    int getSPEED() {
        return this.speed;
    }

    int getRESISTENCE() {
        return this.resistence;
    }

    //Calculo simples de dano para teste
    public int calculoDANO(int dano) {
        dano -= resistence;
        return dano;
    }

    public void receberDano(int dano) {

        this.hp = this.hp - dano;

        if (this.hp < 0) {
            this.hp = 0;
        }

        System.out.println(getNAME() + " sentiu o golpe! HP atual: " + getHP());

        if (this.hp == 0) {
            System.out.println("☠️ " + getNAME() + " sucumbiu ao abismo...");
        }
    }

    public abstract void ATK(int ataque, Entidade alvo);

}
