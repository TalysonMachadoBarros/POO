package src;


public class Evento {


    private String tema;
    public int quantidadeMenu;
    public int quantidadeMenuVip;


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
