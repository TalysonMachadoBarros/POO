package src;
//A empresa “Eventos VIP” organiza eventos e precisa de um sistema para gerenciar convidados,
// mesas, garçons, pedidos e pagamentos. Cada evento possui um tema e exige uma configuração específica para mesas,
// refeições e bebidas. Alguns convidados têm status VIP e recebem serviços especiais e personalizações.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Repositorio repositorio = new Repositorio();
    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private static ArrayList<Garcom> garcons = new ArrayList<>();
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
        ArrayList<Mesa> mesas = cadastrarMesa();



    }

    public static void cadastrarGarcom() {

        System.out.print("Quantos garçons deseja cadastrar? ");
        int numGarcons = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < numGarcons; i++) {
            System.out.print("Nome do garçom " + (i + 1) + ": ");
            String nomeGarcom = entrada.nextLine();
            garcons.add(new Garcom(nomeGarcom));
        }

    }


    public static void cadastrarConvidado() {

        System.out.print("\nQuantos convidados deseja cadastrar? ");
        int numConvidados = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < numConvidados; i++) {
            System.out.print("Nome do convidado " + (i + 1) + ": ");
            String nomeConvidado = entrada.nextLine();

            System.out.print("O convidado é VIP? (S/N): ");
            boolean isVip = entrada.nextLine().equalsIgnoreCase("S");

            Convidado convidado = new Convidado(nomeConvidado, isVip);

            // Associar o convidado a uma mesa
            System.out.println("\nEscolha uma mesa para o convidado:");
            for (Mesa mesa : mesas) {
                System.out.println("Mesa " + mesa);
            }

            System.out.print("Digite o número da mesa: ");
            int mesaEscolhida = entrada.nextInt();
            entrada.nextLine();

            if (mesaEscolhida >= 1 && mesaEscolhida <= mesas.size()) {
                Mesa mesa = mesas.get(mesaEscolhida - 1);
                if (mesa.adicionarConvidado(convidado)) {
                    System.out.println("Não foi possível adicionar o convidado. Tente outra mesa.");
                }
            } else {
                System.out.println("Número de mesa inválido!");
            }
        }

    }


    public static ArrayList<Mesa> cadastrarMesa() {


        System.out.print("\nQuantas mesas deseja cadastrar? ");
        int numMesas = entrada.nextInt();
        entrada.nextLine();

        for (int i = 1;i <= numMesas; i++) {

            System.out.println("Defina o número de cadeiras para a Mesa " + i + " (1 a 8): ");
            int cadeiras = entrada.nextInt();
            entrada.nextLine();

            Mesa mesa = new Mesa(i,cadeiras);

            System.out.println("Deseja definir a decoração da Mesa " + i + "? (sim/no): ");
            String resposta = entrada.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Digite a decoração: ");
                String decoracaoMesa = entrada.nextLine();
                mesa.setDecoracaoMesa(decoracaoMesa);
            }

            mesas.add(mesa);

        }

        //Associar garçons ás mesas
        for (Mesa mesa : mesas) {
            System.out.println("\nEscolha um garçom para a " + mesa);
            for (int i = 0; i < garcons.size(); i++) {
                System.out.println((i + 1) + ". " + garcons.get(i));
            }

            System.out.print("Digite o número do garçom: ");
            int escolha = entrada.nextInt();
            entrada.nextLine();

            if (escolha >= 1 && escolha <= garcons.size()) {
                mesa.atribuirGarcom(garcons.get(escolha - 1));
            } else {
                System.out.println("Escolha inválida!");
            }
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


    //public static void cadastrar() {
     //   int opcaoMenuCad = 1;

      //  System.out.println("--------------------------------------------------");
       // System.out.println("|              Menu de Cadastro                  |");
       // System.out.println("|------------------------------------------------|");
       // System.out.println("|       1-Graçons     ||       2-Convidados      |");
       // System.out.println("|------------------------------------------------|");
       // System.out.println("|                  3-Mesas                       |");
       // System.out.println("--------------------------------------------------");
       // opcaoMenuCad = entrada.nextInt();
       // entrada.nextLine();

       //switch (opcaoMenuCad) {
       //     case 1:
        //        System.out.println("Digite o nome do garcom: ");
        //        String nomeGarcom = entrada.nextLine();
         //       garcom.add(new Garcom(nomeGarcom));
         //       System.out.println("Garcom cadastrado com sucesso!");
          //      break;
       // }
   // }


}
