package main;

import java.util.Scanner;

import repositories.AreaVerdeRepository;
import repositories.AvaliacaoRepository;
import repositories.LocalizacaoRepository;

public class Main {
    public static void main(String[] args) {
        LocalizacaoRepository localizacaoRepo = new LocalizacaoRepository();
        AvaliacaoRepository avaliacaoRepo = new AvaliacaoRepository();
        AreaVerdeRepository areaVerdeRepo = new AreaVerdeRepository();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem-vindo ao Mapeamento de Áreas Verdes de Joinville");

        int operacao;

        do {
            System.out.println("Digite a opção que deseja acessar:");
            System.out.println("1 - Listar Áreas Verdes");
            System.out.println("2 - Avaliar Área Verde");
            System.out.println("3 - Ver detalhes de uma Área Verde");
            System.out.println("4 - Cadastrar nova Área Verde");
            System.out.println("0 - Sair");

            operacao = Integer.parseInt(entrada.nextLine());

            switch (operacao) {
//                case 1 -> operacaoListarAreasVerdes(entrada, localizacaoRepo);
//                case 2 -> operacaoAvaliarAreaVerde(entrada, localizacaoRepo);
//                case 3 -> operacaoVerDetalher(entrada, avaliacaoRepo);
                case 4 -> operacaoCadastrarAreaVerde(entrada, areaVerdeRepo);
                case 0 -> System.out.println("Encerrando sessão.");
                default -> System.out.println("Selecione uma opção válida.");
            }
        } while (operacao != 0);
    }

    private static void operacaoCadastrarAreaVerde(Scanner entrada, AreaVerdeRepository AreaVerdeRepo) {
        System.out.println("Cadastro de Áreas Verdes de Joinville");
        System.out.println("Digite o nome da Area Verde");
        String nome = entrada.nextLine();
    }

//    private static void operacaoVerDetalher(Scanner entrada, ContaRepository contaRepository) {
//        System.out.println("Digite o número da conta para sacar:");
//        int numeroConta = Integer.parseInt(entrada.nextLine());
//        Conta contaSaque = contaRepository.buscar(numeroConta);
//        System.out.println("Insira um valor para saque:");
//        double valorSaque = Double.parseDouble(entrada.nextLine());
//
//        contaSaque.sacar(valorSaque);
//    }
//
//    private static void operacaoAvaliarAreaVerde(Scanner entrada, ContaRepository contaRepository) {
//        System.out.println("Digite o número da conta para depósito:");
//        int numeroConta = Integer.parseInt(entrada.nextLine());
//        Conta contaDeposito = contaRepository.buscar(numeroConta);
//        System.out.println("Insira um valor para depósito:");
//        double valorDeposito = Double.parseDouble(entrada.nextLine());
//
//        contaDeposito.depositar(valorDeposito);
//    }
//
//    private static void operacaoListarAreasVerdes(Scanner entrada, ContaRepository contaRepository) {
//        Conta novaConta = new Conta();
//        System.out.println("Digite um nome:");
//        String nome = entrada.nextLine();
//        System.out.println("Digite um sobrenome:");
//        String sobrenome = entrada.nextLine();
//        System.out.println("Digite um CPF:");
//        String cpf = entrada.nextLine();
//
//        Cliente novoCliente = new Cliente(nome, sobrenome, cpf);
//        novaConta.setTitular(novoCliente);
//
//        contaRepository.salvar(novaConta);
//        System.out.printf("Conta cadastrada. Número da conta: %d.%n", novaConta.getNumeroConta());
//    }
}