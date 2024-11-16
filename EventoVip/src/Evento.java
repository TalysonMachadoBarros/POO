package src;


import java.util.ArrayList;

public class Evento {
    private ArrayList<Cardapio> cardapios;
    private ArrayList<Cardapio> cardapiosVIP;
    private String tema;




    public Evento(String tema, ArrayList<Cardapio> cardapios, ArrayList<Cardapio> cardapiosVIP) {
        this.tema = tema;
        this.cardapios = cardapios;
        this.cardapiosVIP = cardapiosVIP;
    }

    public String getTema() {
        return tema;
    }

    public ArrayList<Cardapio> getCardapios() {
        return cardapios;
    }

    public ArrayList<Cardapio> getCardapiosVIP() {
        return cardapiosVIP;
    }

}
