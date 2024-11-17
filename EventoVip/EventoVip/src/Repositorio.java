package src;

import java.util.ArrayList;

public class Repositorio {
    public ArrayList<Evento> eventos = new ArrayList<>();



    public void registrarEvento(Evento novoEvento) {
        eventos.add(novoEvento);
        System.out.println("Evento cadastrado com sucesso!");
    }


    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Lista de eventos vazia!");
            return;
        } else {
            for (Evento evento : eventos) {
                System.out.println("--- Evento : " + evento.getTema() + "---");
                System.out.println("-----");
                System.out.println("Pratos Comuns:");
                for (Cardapio cardapio : evento.getCardapios()) {
                    System.out.printf("- %s: R$ %.2f%n", cardapio.getNomePrato(), cardapio.getPrecoPrato());
                }
                System.out.println("-----");
                System.out.println("Pratos VIP: ");
                for (Cardapio cardapio : evento.getCardapiosVIP()) {
                    System.out.printf("- %s: R$ %.2f%n", cardapio.getNomePrato(), cardapio.getPrecoPrato());
                }
                System.out.println("-----");

            }

        }



    }
    //

}
