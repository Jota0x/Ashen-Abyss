package Entidades;

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
    public void setNAME(String name) {
        this.name = name;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setMANA(int mana) {
        this.mana = mana;
    }

    public void setSPEED(int speed) {
        this.speed = speed;
    }

    public void setRESISTENCE(int resistence) {
        this.resistence = resistence;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //getters
    public String getNAME() {
        return this.name;
    }

    public int getHP() {
        return this.hp;
    }

    public int getMANA() {
        return this.mana;
    }

    public int getSPEED() {
        return this.speed;
    }

    public int getRESISTENCE() {
        return this.resistence;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //Calculo simples de dano para teste
    public int calculoDANO(int dano) {
        dano -= resistence;
        return dano;
    }

    public void receberDano(int dano) {

        this.hp = this.hp - calculoDANO(dano);

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
