package src;
//A empresa “Eventos VIP” organiza eventos e precisa de um sistema para gerenciar convidados,
// mesas, garçons, pedidos e pagamentos. Cada evento possui um tema e exige uma configuração específica para mesas,
// refeições e bebidas. Alguns convidados têm status VIP e recebem serviços especiais e personalizações.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Repositorio repositorio = new Repositorio();


    private static ArrayList<Garcom> garcom = new ArrayList<>();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcaoMenu = 1;
        while (opcaoMenu != 0) {
            System.out.println("__________________________________________________"); //50-
            System.out.println("|--                   #Home#                   --|");
            System.out.println("|------------------------------------------------|");
            System.out.println("|--            1- Criar novo Evento            --|");
            System.out.println("|------------------------------------------------|");
            System.out.println("|--             2- Listar Eventos              --|");
            System.out.println("|------------------------------------------------|");
            System.out.println("|--             3- Excluir Evento              --|");
            System.out.println("|------------------------------------------------|");
            System.out.println("|--                 4- Sair                    --|");
            System.out.println("|________________________________________________|");
            opcaoMenu = entrada.nextInt();
            entrada.nextLine();

            switch (opcaoMenu) {
                case 1:
                    criarEvento();
                    break;
                case 2:
                    repositorio.listarEventos();
                    break;
                case 3:
                    excluirEvento();
                    break;
                case 4:
                    System.out.println("Adeus!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }



        }
        ArrayList<Mesa> mesas = definirMesas();




    }

    public static ArrayList<Mesa> definirMesas() {
        ArrayList<Mesa> mesas = new ArrayList<>();
        for (int i = 1;i <= 5; i++) {

            System.out.println("Defina o número de cadeiras para a Mesa " + i + " (1 a 8): ");
            int cadeiras = entrada.nextInt();
            entrada.nextLine();

            Mesa mesa = new Mesa(i,cadeiras);

            System.out.println("Quantos convidados para a mesa " + i + "?");
            int numConvidados = entrada.nextInt();
            entrada.nextLine();

            for (int j = 0; j < numConvidados; j++) {
                System.out.println("Nome do convidado " + (j + 1) + ": ");
                String nomeConvidado = entrada.nextLine();
                System.out.println("O convidado é VIP? (true/false): )");
                boolean isVIP = entrada.nextBoolean();
                entrada.nextLine();

                mesa.addConvidado(new Convidado(nomeConvidado, isVIP));
            }

            System.out.println("Deseja definir a decoração da Mesa " + i + "? (yes/no): ");
            String resposta = entrada.nextLine();
            if (resposta.equalsIgnoreCase("yes")) {
                System.out.println("Digite a decoração: ");
                String decoracaoMesa = entrada.nextLine();
                mesa.setDecoracaoMesa(decoracaoMesa);
            }

            mesas.add(mesa);

        }
        return mesas;
    }




    public static void criarEvento() {
        System.out.println("Digite o tema do evento: ");
        String tema = entrada.nextLine();

        System.out.println("Digite a quantidade de pratos: ");
        int quantidadeMenu = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite a quantidade de pratos VIP: ");
        int quantidadeMenuVIP = entrada.nextInt();
        entrada.nextLine();


        ArrayList<Cardapio> cardapios = new ArrayList<>();
        for (int i = 0; i < quantidadeMenu; i++) {

            System.out.println("Digite o prato " + (i+1) + ": ");
            String nomePrato = entrada.nextLine();


            System.out.println("Digite o valor do prato " + (i+1) + ": ");
            double precoPrato = entrada.nextDouble();
            entrada.nextLine();

            cardapios.add(new Cardapio(nomePrato,precoPrato));

        }

        ArrayList<Cardapio> cardapiosVIP = new ArrayList<>();
        for (int i = 0; i < quantidadeMenuVIP; i++) {

            System.out.println("Digite o prato VIP " + (i+1) + " : ");
            String nomePratoVip = entrada.nextLine();

            System.out.println("Digite o valor do prato VIP " + (i+1) + " : ");
            double precoPratoVip = entrada.nextDouble();
            entrada.nextLine();

            cardapiosVIP.add(new Cardapio(nomePratoVip,precoPratoVip));

        }

        Evento evento = new Evento(tema, cardapios, cardapiosVIP);
        repositorio.registrarEvento(evento);

    }

    public static void excluirEvento() {
        repositorio.listarEventos();
        System.out.println(" Escolha o evento que deseja editar: (Ex: 1)");
        int numeroEvento = entrada.nextInt();

        if (numeroEvento > 0 && numeroEvento <=repositorio.eventos.size()) {
            repositorio.eventos.remove(numeroEvento - 1);
            System.out.println("Evento excluido com sucesso!");
        } else {
            System.out.println("Evento inválido");
        }

    }


    public static void cadastrar() {
        int opcaoMenuCad = 1;

        System.out.println("--------------------------------------------------");
        System.out.println("|              Menu de Cadastro                  |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|       1-Graçons     ||       2-Convidados      |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|                  3-Mesas                       |");
        System.out.println("--------------------------------------------------");
        opcaoMenuCad = entrada.nextInt();
        entrada.nextLine();

        switch (opcaoMenuCad) {
            case 1:
                System.out.println("Digite o nome do garcom: ");
                String nomeGarcom = entrada.nextLine();
                garcom.add(new Garcom(nomeGarcom));
                System.out.println("Garcom cadastrado com sucesso!");
                break;
        }
    }


}
