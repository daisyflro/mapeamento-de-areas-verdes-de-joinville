package main;

import java.util.Collections;
import java.util.Scanner;

import models.AreaVerde;
import models.Avaliacao;
import models.Localizacao;
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
                case 1 -> operacaoListarAreasVerdes(areaVerdeRepo);
                case 2 -> operacaoAvaliarAreaVerde(entrada, avaliacaoRepo, areaVerdeRepo);
                case 3 -> operacaoVerDetalher(entrada, areaVerdeRepo);
                case 4 -> operacaoCadastrarAreaVerde(entrada, areaVerdeRepo, localizacaoRepo);
                case 0 -> System.out.println("Encerrando sessão.");
                default -> System.out.println("Selecione uma opção válida.");
            }
        } while (operacao != 0);
    }

    private static void operacaoCadastrarAreaVerde(Scanner entrada, AreaVerdeRepository areaVerdeRepo, LocalizacaoRepository localizacaoRepo) {
        System.out.println("Cadastro de áreas verdes em Joinville");
        System.out.println("Nome");
        String nome = entrada.nextLine();
        System.out.println("Horário de funcionamento");
        String horarioFuncionamento = entrada.nextLine();
        System.out.println("Latitude");
        double latitude = Double.parseDouble(entrada.nextLine());
        System.out.println("Longitude");
        double longitude = Double.parseDouble(entrada.nextLine());
        System.out.println("Atividades disponíveis. Ex: caminhada, ciclismo, parquinho infantil, pedalinho, etc");
        String atividadesDisponiveis = entrada.nextLine();
        System.out.println("Tipo de vegetação. Ex: árvores, arbustos, grama");
        String tipoVegetacao = entrada.nextLine();

        AreaVerde novaAreaVerde = new AreaVerde(nome, tipoVegetacao, horarioFuncionamento, Collections.singletonList(atividadesDisponiveis));
        areaVerdeRepo.salvar(novaAreaVerde);

        Localizacao novaLocalizacao = new Localizacao(novaAreaVerde.getId(), latitude, longitude);
        localizacaoRepo.salvar(novaLocalizacao);

        System.out.println("Área verde cadastrada com sucesso.");
    }

    private static void operacaoVerDetalher(Scanner entrada, AreaVerdeRepository areaVerdeRepository) {
        System.out.println("Informe o ID da área verde que deseja ver os detalhes: ");
        int idAreaVerde = Integer.parseInt(entrada.nextLine());
        AreaVerde areaVerde = areaVerdeRepository.buscar(idAreaVerde);
        if (areaVerde != null) {
            System.out.println(areaVerde.DetalhesToString());
        } else {
            System.out.println("Esse ID não existe.");
        }
    }

    private static void operacaoAvaliarAreaVerde(Scanner entrada, AvaliacaoRepository avaliacaoRepository, AreaVerdeRepository areaVerdeRepository) {
        System.out.println("Central de Avaliação de Áreas Verdes de Joinville\n");

        System.out.println("Informe o ID da área verde  que deseja avaliar: ");
        int idAreaVerde = Integer.parseInt(entrada.nextLine());
        AreaVerde areaVerde = areaVerdeRepository.buscar(idAreaVerde);

        if(areaVerde != null) {

            int notaQualidadeAr = validacaoDadosNota("Dê uma nota de 1 a 5 para qualidade do ar");

            int notaPoluicaoSonoro = validacaoDadosNota("Dê uma nota de 1 a 5 para ausência de poluição sonora");

            int notaQuantidadeArvores = validacaoDadosNota("Dê uma nota de 1 a 5 para quantidade de árvores");

            int notaColetaResiduos = validacaoDadosNota("Dê uma nota de 1 a 5 para coleta de resíduos");

            int notaTransportePublico = validacaoDadosNota("Dê uma nota de 1 a 5 para facilidade de chegar com transporte público");

            Avaliacao novaAvaliacao = new Avaliacao(idAreaVerde, notaQuantidadeArvores, notaQualidadeAr, notaPoluicaoSonoro, notaColetaResiduos, notaTransportePublico);
            avaliacaoRepository.salvar(novaAvaliacao);

            System.out.println("Área avaliada com sucesso.");

        } else {

        System.out.println("Esse ID não  existe.");

        }
    }

    private static void operacaoListarAreasVerdes(AreaVerdeRepository areaVerdeRepo) {
        areaVerdeRepo.listarTodas().forEach(areaVerde -> System.out.println(areaVerde.toString()));
    }

    public static int validacaoDadosNota(String mensagem) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println(mensagem);
            int nota = Integer.parseInt(entrada.nextLine());
            if (nota > 0 && nota < 6) {
                return nota;
            } else {
                System.out.println("Digite uma nota entre 1 e 5");
            }
        }
    }
}