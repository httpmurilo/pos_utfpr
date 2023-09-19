import bd.BDVeiculos;
import exception.VeicExistException;
import exception.VelocException;
import model.Carga;
import model.Motor;
import model.Passeio;
import java.util.Scanner;


import java.util.List;

public class Teste {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int opcaoEscolha;

        BDVeiculos bdVeiculos = new BDVeiculos();

        List<Carga> cargas = bdVeiculos.getCargas();
        List<Passeio> veiculoList = bdVeiculos.getVeiculoList();


        do {
            System.out.println("Sistema de Gestão de Veículos - Menu Inicial");
            System.out.println("1. Cadastrar Veiculo de Passeio");
            System.out.println("2. Cadastrar Veiculo de Carga");
            System.out.println("3. Imprimir Todos os Veiculos de Passeio");
            System.out.println("4. Imprimir Todos os Veiculos de Carga");
            System.out.println("5. Imprimir Veiculo de Passeio pela Placa");
            System.out.println("6. Imprimir Veiculo de Carga pela Placa");
            System.out.println("7. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            opcaoEscolha = scanner.nextInt();

            switch (opcaoEscolha) {
                case 1 -> cadastrarCarro(scanner, veiculoList);
                case 2 -> cadastrarVeiculoDeCarga(scanner, cargas);
                case 3 -> imprimirListaDeVeiculos(veiculoList);
                case 4 -> imprimirListaDeVeiculosDeCarga(cargas);
                case 5 -> validaSeVeiculoJaExisteOuImprimeResultado(scanner, false);
                case 6 -> validaSeVeiculoDeCargaJaExiste(scanner, false);
                case 7 -> System.out.println("Saindo do sistema.");
                default -> System.out.println("Opção inválida. Escolha uma opção válida.");
            }

        } while (opcaoEscolha != 7);

        scanner.close();
    }

    private static void cadastrarVeiculoDeCarga(Scanner scanner, List<Carga> cargas) {

        String deveContinuar = null;
        Scanner scannerCarro = new Scanner(System.in);
        do {
            System.out.print("Digite a placa do carro: ");
            String placa = scannerCarro.nextLine();

            System.out.print("Digite a marca do carro: ");
            String marca = scannerCarro.nextLine();

            System.out.print("Digite o modelo do carro: ");
            String modelo = scannerCarro.nextLine();

            System.out.print("Digite a cor do carro: ");
            String cor = scannerCarro.nextLine();

            System.out.print("Digite a velocidade máxima do carro: ");
            float velocMax = scannerCarro.nextFloat();

            velocMax = validaVelocidade(velocMax, true);

            System.out.print("Digite a quantidade de rodas do carro: ");
            int qtdRodas = scannerCarro.nextInt();

            Motor motor = new Motor();

            System.out.print("Digite a quantidade de passageiros do carro: ");
            int qtdPassageiros = scannerCarro.nextInt();

            System.out.print("Digite a tara do veiculo:  ");
            int tara = scannerCarro.nextInt();


            System.out.print("Digite a carga mmáxima do veículo: ");
            int cargaMaxima = scannerCarro.nextInt();


            Carga carga = new Carga(placa, marca, modelo, cor, velocMax, qtdRodas, motor, cargaMaxima, tara);

            cargas.add(carga);

            System.out.println("Carro cadastrado com sucesso!");

            System.out.print("Deseja cadastrar mais um carro? (SIM/NAO): ");
            deveContinuar = scannerCarro.next().toUpperCase();


        }while (deveContinuar.equals("SIM"));

        System.out.println("Fechando cadastro de carros.");
        scannerCarro.close();
    }

    private static void validarSeCarroJaExisteDuranteOCadastro(List<Passeio> veiculoList) {
        for (Passeio passeio : veiculoList) {
            if (validaSeVeiculoJaExisteOuImprimeResultado(passeio, false)) return;
        }
    }

    private static void cadastrarCarro(Scanner scanner, List<Passeio> veiculoList) {

        String deveContinuar = null;

        Scanner scannerCarro = new Scanner(System.in);
        do {

            System.out.print("Digite a placa do carro: ");
            String placa = scannerCarro.nextLine();

            System.out.print("Digite a marca do carro: ");
            String marca = scannerCarro.nextLine();

            System.out.print("Digite o modelo do carro: ");
            String modelo = scannerCarro.nextLine();

            System.out.print("Digite a cor do carro: ");
            String cor = scannerCarro.nextLine();

            System.out.print("Digite a velocidade máxima do carro: ");
            float velocMax = scannerCarro.nextFloat();

            velocMax = validaVelocidade(velocMax, false);

            System.out.print("Digite a quantidade de rodas do carro: ");
            int qtdRodas = scannerCarro.nextInt();

            Motor motor = new Motor();

            System.out.print("Digite a quantidade de passageiros do carro: ");
            int qtdPassageiros = scannerCarro.nextInt();

            Passeio novoPasseio = new Passeio(placa, marca, modelo, cor, velocMax, qtdRodas, motor, qtdPassageiros);

            validarSeCarroJaExisteDuranteOCadastro(veiculoList);
            veiculoList.add(novoPasseio);

            System.out.println("Carro cadastrado com sucesso!");

            System.out.print("Deseja cadastrar mais um carro? (SIM/NAO): ");
            deveContinuar = scannerCarro.next().toUpperCase();


        }while (deveContinuar.equals("SIM"));

        System.out.println("Fechando cadastro de carros.");
        scannerCarro.close();
    }

    private static float validaVelocidade(float velocMax, boolean isVeiculoDeCarga) {
        if ((velocMax < 80 || velocMax > 110) && !isVeiculoDeCarga) {
            throw new VelocException("A velocidade máxima está fora dos limites brasileiros");
        }

        if ((velocMax < 80 || velocMax > 110) && isVeiculoDeCarga) {
            throw new VelocException("A velocidade máxima está fora dos limites brasileiros");
        }

        if (isVeiculoDeCarga) {
            return Float.valueOf("90");
        } else {
            return Float.valueOf("100");
        }
    }



    private static void imprimirListaDeVeiculosDeCarga(List<Carga> cargas) {
        cargas.forEach(x -> {
            System.out.println("========================= VEICULO CARGA ==========");
            System.out.println("Marca := " + x.getMarca());
            System.out.println("Modelo := " + x.getModelo());
            System.out.println("Placa := " + x.getPlaca());
            System.out.println("Velocidade Maxima := " + x.calcVel(x.getVelocMax()));
            System.out.println("Tara := " + x.getTara());
            System.out.println("Carga maxima := " + x.getCargaMax());
            System.out.println("Potencia do motor := " + x.getMotor().getPotencia());
            System.out.println("Qtd Pistoes motor := " + x.getMotor().getQtdPist());
            System.out.println("========================================");
            System.out.println("");

        });
    }

    private static void imprimirListaDeVeiculos(List<Passeio> veiculoList) {
        veiculoList.forEach(x -> {
                        System.out.println("======================= VEICULO PASSEIO =======================");
                        System.out.println("Marca := " + x.getMarca());
                        System.out.println("Placa :=" + x.getPlaca());
                        System.out.println("Velocidade Maxima :=" + x.calcVel(x.getVelocMax()));
                        System.out.println("Qtd Passageiros :=" + x.getQtdPassageiros());
                        System.out.println("Potencia do Motor :=" + x.getMotor().getPotencia());
                        System.out.println("Qtd Pistoes Motor :=" + x.getMotor().getQtdPist());
                        System.out.println("=========================================");
                        System.out.println("");
        });
    }

    private static boolean validaSeVeiculoJaExisteOuImprimeResultado(Scanner scanner, boolean imprimeResultado) {

        Scanner scannerCarro = new Scanner(System.in);
        System.out.print("Digite a placa do carro: ");
        String placa = scannerCarro.nextLine();
        Passeio passeio = new Passeio(placa, null, null, null, null, null, null, 0);

        boolean encontrouVeiculo = false;


        if (passeio.getPlaca().equals("placa") && imprimeResultado) {
            encontrouVeiculo = true;
            System.out.println("Detalhes do veículo : " + passeio.getModelo() + "Marca" + passeio.getMarca());

            if (encontrouVeiculo == false) {
                throw new VeicExistException("Veiculo não encontrado na listagem");
            }
            return true;
        }

        if (passeio.getPlaca().equals("placa") && !imprimeResultado) {
            System.out.println("Já existe um veículo cadastrado com essa placa.");
            return true;
        }
        return false;
    }

    private static boolean validaSeVeiculoJaExisteOuImprimeResultado(Passeio passeio, boolean imprimeResultado) {

        boolean encontrouVeiculo = false;

        if (passeio.getPlaca().equals("placa") && imprimeResultado) {
            encontrouVeiculo = true;
            System.out.println("Detalhes do veículo : " + passeio.getModelo() + "Marca" + passeio.getMarca());

            if (encontrouVeiculo == false) {
                throw new VeicExistException("Veiculo não encontrado na listagem");
            }

            return true;
        }

        if (passeio.getPlaca().equals("placa") && !imprimeResultado) {
            encontrouVeiculo = true;

            if (encontrouVeiculo == false) {
                throw new VeicExistException("Veiculo não encontrado na listagem");
            }
            return true;
        }
        return false;
    }

    private static boolean validaSeVeiculoDeCargaJaExiste(Scanner scanner, boolean imprimeResultado) {

        Scanner scannerCarro = new Scanner(System.in);
        System.out.print("Digite a placa do veiculo de carga: ");
        String placa = scannerCarro.nextLine();
        Carga carga = new Carga(placa, null, null, null, null, null, null, 0, 0);

        if (carga.getPlaca().equals("placa") && imprimeResultado) {
            System.out.println("Detalhes do veículo : " + carga.getModelo() + "Marca" + carga.getMarca());
            return true;
        }

        if (carga.getPlaca().equals("placa") && !imprimeResultado) {
            System.out.println("Já existe um veículo de carga cadastrado com essa placa.");
            return true;
        }
        return false;
    }

    private static boolean validaSeVeiculoJaExisteOuImprimeResultado(Carga carga, boolean imprimeResultado) {

        if (carga.getPlaca().equals("placa") && imprimeResultado) {
            System.out.println("Detalhes do veículo : " + carga.getModelo() + "Marca" + carga.getMarca());
            return true;
        }

        if (carga.getPlaca().equals("placa") && !imprimeResultado) {
            System.out.println("Já existe um veículo cadastrado com essa placa.");
            return true;
        }
        return false;
    }

}
