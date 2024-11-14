package src;


public class Evento {


    private String tema;
    private int quantidadeMenu;
    private int quantidadeMenuVip;


    public Evento(String tema, int quantidadeMenu, int quantidadeMenuVip) {
        this.tema = tema;
        this.quantidadeMenu = quantidadeMenu;
        this.quantidadeMenuVip = quantidadeMenuVip;
    }

    public String getTema() {
        return tema;
    }

    public int getQuantidadeMenu() {
        return quantidadeMenu;
    }

    public int getQuantidadeMenuVip() {
        return quantidadeMenuVip;
    }

}
