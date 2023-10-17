import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        // Crie as instâncias das garagens de locomotivas e vagões
        GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas();
        GaragemVagoes garagemVagoes = new GaragemVagoes();

        // Criar locomotivas de teste
        Locomotiva locomotiva1 = new Locomotiva(1, 100.0, 5);
        Locomotiva locomotiva2 = new Locomotiva(2, 120.0, 6);
        Locomotiva locomotiva3 = new Locomotiva(3, 90.0, 4);

        // Adicionar as locomotivas à garagem de locomotivas
        garagemLocomotivas.adicionarLocomotiva(locomotiva1);
        garagemLocomotivas.adicionarLocomotiva(locomotiva2);
        garagemLocomotivas.adicionarLocomotiva(locomotiva3);

        // Criar vagões de teste
        Vagao vagao1 = new Vagao(101, 50.0);
        Vagao vagao2 = new Vagao(102, 45.0);
        Vagao vagao3 = new Vagao(103, 60.0);
        Vagao vagao4 = new Vagao(104, 55.0);

        // Adicionar os vagões à garagem de vagões
        garagemVagoes.adicionarVagao(vagao1);
        garagemVagoes.adicionarVagao(vagao2);
        garagemVagoes.adicionarVagao(vagao3);
        garagemVagoes.adicionarVagao(vagao4);

        // Criar composições de trens
        Composicao trem1 = new Composicao(1);
        Composicao trem2 = new Composicao(2);

        // Engatar locomotivas nas composições
        locomotiva1.engatarEmComposicao(trem1);
        locomotiva2.engatarEmComposicao(trem1);
        locomotiva3.engatarEmComposicao(trem2);

        // Adicionar locomotivas e vagões às composições
        trem1.adicionarLocomotiva(locomotiva1);
        trem1.adicionarLocomotiva(locomotiva2);
        trem1.adicionarVagao(vagao1);
        trem1.adicionarVagao(vagao2);
        trem2.adicionarLocomotiva(locomotiva3);
        trem2.adicionarVagao(vagao3);
        trem2.adicionarVagao(vagao4);

        // Adicionar composições ao pátio de composições
        PatioComposicoes patioComposicoes = new PatioComposicoes();
        patioComposicoes.adicionarComposicao(trem1);
        patioComposicoes.adicionarComposicao(trem2);

        // Insira locomotivas e vagões nas garagens (conforme necessário)

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1- Criar um trem");
            System.out.println("2- Editar um trem");
            System.out.println("3- Listar todos os trens criados");
            System.out.println("4- Desfazer um trem");
            System.out.println("5- Salvar em um arquivo texto as configurações");
            System.out.println("6- Carregar as configurações a partir de um arquivo texto");
            System.out.println("7- Fim");

            System.out.printf("Opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o identificador do trem: ");
                    int identificadorTrem = scanner.nextInt();

                    // Crie uma nova composição para representar o trem
                    Composicao novoTrem = new Composicao(identificadorTrem);

                    System.out.print("Informe o identificador da primeira locomotiva: ");
                    int idLocPrimeira = scanner.nextInt();

                    // Verifique se a locomotiva está disponível na garagem
                    Locomotiva primeiraLocomotiva = garagemLocomotivas.listarLocomotivasDisponiveis()
                            .stream()
                            .filter(locomotiva -> locomotiva.getIdLoc() == idLocPrimeira)
                            .findFirst()
                            .orElse(null);

                    if (primeiraLocomotiva != null) {
                        // Engate a primeira locomotiva na composição
                        primeiraLocomotiva.engatarEmComposicao(novoTrem);

                        // Adicione a locomotiva à composição
                        novoTrem.adicionarLocomotiva(primeiraLocomotiva);

                        System.out.println("Trem criado com sucesso!");
                    } else {
                        System.out.println("Locomotiva não encontrada ou não disponível na garagem.");
                    }
                    break;

                case 2: // Editar um trem
                    System.out.print("Informe o identificador do trem a ser editado: ");
                    int identificadorTremEditar = scanner.nextInt();

                    // Encontre a composição correspondente ao identificador informado
                    Composicao tremParaEditar = patioComposicoes.getComposicaoPorIdentificador(identificadorTremEditar);

                    if (tremParaEditar != null) {
                        boolean continuarEdicao = true;

                        while (continuarEdicao) {
                            System.out.println("Escolha uma opção:");
                            System.out.println("1- Inserir uma locomotiva");
                            System.out.println("2- Inserir um vagão");
                            System.out.println("3- Remover o último elemento do trem");
                            System.out.println("4- Listar locomotivas livres");
                            System.out.println("5- Listar vagões livres");
                            System.out.println("6- Encerrar a edição do trem");

                            int opcaoEdicao = scanner.nextInt();

                            switch (opcaoEdicao) {
                                case 1: // Inserir uma locomotiva
                                    System.out.print("Informe o identificador da locomotiva a ser inserida: ");
                                    int idLocomotivaInserir = scanner.nextInt();

                                    // Encontre a locomotiva correspondente na garagem de locomotivas
                                    Locomotiva locomotivaParaInserir = garagemLocomotivas.listarLocomotivasDisponiveis()
                                            .stream()
                                            .filter(locomotiva -> locomotiva.getIdLoc() == idLocomotivaInserir)
                                            .findFirst()
                                            .orElse(null);

                                    if (locomotivaParaInserir != null) {
                                        // Verifique se a locomotiva pode ser inserida na composição
                                        if (tremParaEditar.podeInserirLocomotiva(locomotivaParaInserir)) {
                                            locomotivaParaInserir.engatarEmComposicao(tremParaEditar);
                                            tremParaEditar.adicionarLocomotiva(locomotivaParaInserir);

                                            System.out.println("Locomotiva inserida com sucesso.");

                                        } else {
                                            System.out.println("Não é possível inserir esta locomotiva na composição.");
                                        }

                                    } else {
                                        System.out.println("Locomotiva não encontrada ou não disponível na garagem.");

                                    }
                                    break;

                                case 2: // Inserir um vagão
                                    System.out.print(
                                            "Informe o identificador da composição à qual deseja adicionar o vagão: ");
                                    int idComposicaoInserirVagao = scanner.nextInt();

                                    // Encontre a composição correspondente
                                    Composicao composicaoParaEditar = null;

                                    for (Composicao composicao : patioComposicoes.listarComposicoes()) {
                                        if (composicao.getIdentificador() == idComposicaoInserirVagao) {
                                            composicaoParaEditar = composicao;
                                            break;
                                        }
                                    }

                                    if (composicaoParaEditar != null) {
                                        System.out.print("Informe o identificador do vagão a ser inserido: ");
                                        int idVagaoInserir = scanner.nextInt();

                                        // Encontre o vagão correspondente na garagem de vagões
                                        Vagao vagaoParaInserir = null;

                                        for (Vagao vagao : garagemVagoes.listarVagoesDisponiveis()) {
                                            if (vagao.getIdentificador() == idVagaoInserir) {
                                                vagaoParaInserir = vagao;
                                                break;
                                            }
                                        }

                                        if (vagaoParaInserir != null) {
                                            // Adicione o vagão à composição
                                            composicaoParaEditar.adicionarVagao(vagaoParaInserir);
                                            System.out.println("Vagão inserido com sucesso na composição.");
                                        } else {
                                            System.out.println("Vagão não encontrado ou não disponível na garagem.");
                                        }
                                    } else {
                                        System.out.println("Composição não encontrada.");
                                    }
                                    break;

                                case 3: // Remover o último elemento do trem
                                    List<Locomotiva> locomotivasTrem = tremParaEditar.getLocomotivas();
                                    List<Vagao> vagoesTrem = tremParaEditar.getVagoes();

                                    if (!locomotivasTrem.isEmpty()) {
                                        tremParaEditar
                                                .removerLocomotiva(locomotivasTrem.get(locomotivasTrem.size() - 1));

                                        System.out.println("Última locomotiva removida do trem.");

                                    } else if (!vagoesTrem.isEmpty()) {
                                        tremParaEditar.removerVagao(vagoesTrem.get(vagoesTrem.size() - 1));

                                        System.out.println("Último vagão removido do trem.");

                                    } else {
                                        System.out.println("Não há elementos para remover no trem.");

                                    }

                                    break;

                                case 4: // Listar locomotivas livres
                                    List<Locomotiva> locomotivasLivres = garagemLocomotivas
                                            .listarLocomotivasDisponiveis();

                                    if (locomotivasLivres.isEmpty()) {
                                        System.out.println("Não há locomotivas livres na garagem.");

                                    } else {
                                        System.out.println("Locomotivas livres na garagem:");

                                        for (Locomotiva loc : locomotivasLivres) {
                                            System.out.println(loc);
                                        }
                                    }
                                    break;
                                case 5: // Listar vagões livres
                                    List<Vagao> vagoesLivres = garagemVagoes.listarVagoesDisponiveis();

                                    if (vagoesLivres.isEmpty()) {
                                        System.out.println("Não há vagões livres na garagem.");

                                    } else {
                                        System.out.println("Vagões livres na garagem:");

                                        for (Vagao vagao : vagoesLivres) {
                                            System.out.println(vagao);

                                        }
                                    }
                                    break;

                                case 6: // Encerrar a edição do trem
                                    continuarEdicao = false;
                                    break;

                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println("Trem não encontrado.");

                    }
                    break;

                case 3: // Listar todas as composições (trens) criadas
                    List<Composicao> composicoesCriadas = patioComposicoes.listarComposicoes();

                    if (composicoesCriadas.isEmpty()) {
                        System.out.println("Nenhuma composição foi criada até o momento.");
                    } else {
                        System.out.println("Composições criadas:");
                        for (Composicao composicao : composicoesCriadas) {
                            System.out.println(composicao);
                        }
                    }
                    break;

                case 4: // Desfazer um trem (remover uma composição)
                    System.out.print("Informe o identificador da composição que deseja desfazer: ");
                    int idComposicaoDesfazer = scanner.nextInt();

                    Composicao composicaoParaDesfazer = patioComposicoes
                            .getComposicaoPorIdentificador(idComposicaoDesfazer);

                    if (composicaoParaDesfazer != null) {
                        // Remova a composição do pátio de composições
                        patioComposicoes.removerComposicao(composicaoParaDesfazer);

                        // Libere as locomotivas e vagões da composição
                        for (Locomotiva locomotiva : composicaoParaDesfazer.getLocomotivas()) {
                            locomotiva.desengatar();
                        }
                        for (Vagao vagao : composicaoParaDesfazer.getVagoes()) {
                            vagao.desengatar();
                        }

                        System.out.println("Composição desfeita com sucesso.");
                    } else {
                        System.out.println("Composição não encontrada.");
                    }
                    break;

                case 5: // Salvar as configurações em um arquivo texto
                    try {
                        System.out.print("Informe o nome do arquivo para salvar as configurações: ");
                        String nomeArquivo = scanner.next();

                        FileWriter fileWriter = new FileWriter(nomeArquivo);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        List<Locomotiva> locomotivas = garagemLocomotivas.listarLocomotivasDisponiveis();
                        List<Vagao> vagoes = garagemVagoes.listarVagoesDisponiveis();
                        List<Composicao> composicoes = patioComposicoes.listarComposicoes();

                        for (Locomotiva locomotiva : locomotivas) {
                            bufferedWriter.write(locomotiva.getIdLoc() + "," + locomotiva.getPesoMax() + ","
                                    + locomotiva.getQntVagoes() + ","
                                    + ((locomotiva.getComposicao() != null)
                                            ? locomotiva.getComposicao().getIdentificador()
                                            : -1));
                            bufferedWriter.newLine();
                        }

                        for (Vagao vagao : vagoes) {
                            bufferedWriter.write(vagao.getIdentificador() + "," + vagao.getCapacidadeMaxima() + ","
                                    + ((vagao.getComposicao() != -1) ? vagao.getComposicao() : -1));
                            bufferedWriter.newLine();
                        }

                        for (Composicao composicao : composicoes) {
                            bufferedWriter.write(composicao.getIdentificador() + ",");
                            for (Locomotiva locomotiva : composicao.getLocomotivas()) {
                                bufferedWriter.write("L" + locomotiva.getIdLoc() + ",");
                            }
                            for (Vagao vagao : composicao.getVagoes()) {
                                bufferedWriter.write("V" + vagao.getIdentificador() + ",");
                            }
                            bufferedWriter.newLine();
                        }

                        bufferedWriter.close();
                        System.out.println("Configurações salvas com sucesso no arquivo: " + nomeArquivo);
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar as configurações: " + e.getMessage());
                    }
                    break;

                case 6: // Carregar as configurações a partir de um arquivo texto
                    System.out.print("Informe o nome do arquivo para carregar as configurações: ");
                    String nomeArquivoCarregar = scanner.next();

                    try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoCarregar))) {
                        String linha;

                        while ((linha = reader.readLine()) != null) {
                            String[] partes = linha.split(",");

                            if (partes.length > 0) {
                                String tipoObjeto = partes[0].trim();

                                if ("Locomotiva".equals(tipoObjeto)) {
                                    if (partes.length >= 4) {
                                        int idLoc = Integer.parseInt(partes[1].trim());
                                        double pesoMax = Double.parseDouble(partes[2].trim());
                                        int qntVagoes = Integer.parseInt(partes[3].trim());
                                        int idComposicao = partes.length >= 5 ? Integer.parseInt(partes[4].trim()) : -1;

                                        Locomotiva locomotiva = new Locomotiva(idLoc, pesoMax, qntVagoes);

                                        if (idComposicao != -1) {
                                            Composicao composicao = patioComposicoes
                                                    .getComposicaoPorIdentificador(idComposicao);
                                            if (composicao != null) {
                                                locomotiva.engatarEmComposicao(composicao);
                                            }
                                        }

                                        garagemLocomotivas.adicionarLocomotiva(locomotiva);
                                    }
                                } else if ("Vagao".equals(tipoObjeto)) {
                                    if (partes.length >= 3) {
                                        int idVagao = Integer.parseInt(partes[1].trim());
                                        double capacidadeMaxima = Double.parseDouble(partes[2].trim());
                                        int idComposicao = partes.length >= 4 ? Integer.parseInt(partes[3].trim()) : -1;

                                        Vagao vagao = new Vagao(idVagao, capacidadeMaxima);

                                        if (idComposicao != -1) {
                                            Composicao composicao = patioComposicoes
                                                    .getComposicaoPorIdentificador(idComposicao);
                                            if (composicao != null) {
                                                composicao.adicionarVagao(vagao);
                                            }
                                        }

                                        garagemVagoes.adicionarVagao(vagao);
                                    }
                                } else if ("Composicao".equals(tipoObjeto)) {
                                    if (partes.length >= 2) {
                                        int identificadorComposicao = Integer.parseInt(partes[1].trim());
                                        Composicao composicao = new Composicao(identificadorComposicao);

                                        for (int i = 2; i < partes.length; i++) {
                                            String elemento = partes[i].trim();

                                            if (elemento.startsWith("L")) {
                                                int idLocomotiva = Integer.parseInt(elemento.substring(1));
                                                Locomotiva locomotiva = garagemLocomotivas
                                                        .getLocomotivaPorId(idLocomotiva);

                                                if (locomotiva != null) {
                                                    locomotiva.engatarEmComposicao(composicao);
                                                    composicao.adicionarLocomotiva(locomotiva);
                                                }
                                            } else if (elemento.startsWith("V")) {
                                                int idVagao = Integer.parseInt(elemento.substring(1));
                                                Vagao vagao = garagemVagoes.getVagaoPorId(idVagao);

                                                if (vagao != null) {
                                                    composicao.adicionarVagao(vagao);
                                                }
                                            }
                                        }

                                        patioComposicoes.adicionarComposicao(composicao);
                                    }
                                }
                            }
                        }

                        System.out.println("Configurações carregadas com sucesso do arquivo: " + nomeArquivoCarregar);

                    } catch (IOException e) {
                        System.out.println("Erro ao carregar as configurações: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
