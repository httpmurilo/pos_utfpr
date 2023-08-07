import model.Carga;
import model.Motor;
import model.Passeio;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int opcaoEscolha;
        List<Carga> cargas = new ArrayList<>();
        List<Passeio> veiculoList = new ArrayList<>();

        veiculoList = inicializaListaDePasseio();
        cargas = inicializaListaDeCarga();


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

    private static List<Carga> inicializaListaDeCarga() {
        List<Carga> cargas;
        Carga c = new Carga("HVE2123","Volks","Saveiro","Preto", Float.valueOf("150"),4,new Motor(1,150),1500,3000);
        Carga c1 = new Carga("HIE2123","Fiat","Strada","Prata", Float.valueOf("140"),4,new Motor(3,350),1865,5478);
        Carga c2 = new Carga("HIE2123","Fiat","Strada","Prata", Float.valueOf("140"),4,new Motor(3,350),1865,5478);
        Carga c3 = new Carga("JE2212","Fiat","Toro","Prata", Float.valueOf("140"),4,new Motor(3,350),1865,5478);
        Carga c4 = new Carga("LOP6971","Fiat","Toro","Preta", Float.valueOf("140"),4,new Motor(3,350),1865,5478);
        Carga c5 = new Carga("GQ54F21","Fiat","S10","Prata", Float.valueOf("210"),4,new Motor(3,500),8541,7487);


        cargas = List.of(c,c1,c2,c3,c4,c5);
        return cargas;
    }

    private static List<Passeio> inicializaListaDePasseio() {
        List<Passeio> veiculoList;
        Passeio p1 = new Passeio("HAD9353", "Fiat", "Punto", "Rosa", Float.valueOf("100.00"), 4, new Motor(1,100), 4);
        Passeio p2 = new Passeio("QFQ4822", "Volskwagem", "Gol", "Preto", Float.valueOf("150.00"), 4, new Motor(3,150), 4);
        Passeio p3 = new Passeio("RGG7449", "Ford", "Fiesta", "Vermelho", Float.valueOf("140.00"), 4, new Motor(1, 100), 4);
        Passeio p4 = new Passeio("GTP2102", "Ford", "KA", "Prata", Float.valueOf("120.00"), 4, new Motor(1, 98), 4);
        Passeio p5 = new Passeio("HVE7235", "Citroen", "C3", "preta", Float.valueOf("120.00"), 4, new Motor(1,90), 4);

        veiculoList = List.of(p1,p2,p3,p4,p5);
        return veiculoList;
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



        if (passeio.getPlaca().equals("placa") && imprimeResultado) {
            System.out.println("Detalhes do veículo : " + passeio.getModelo() + "Marca" + passeio.getMarca());
            return true;
        }

        if (passeio.getPlaca().equals("placa") && !imprimeResultado) {
            System.out.println("Já existe um veículo cadastrado com essa placa.");
            return true;
        }
        return false;
    }

    private static boolean validaSeVeiculoJaExisteOuImprimeResultado(Passeio passeio, boolean imprimeResultado) {

        if (passeio.getPlaca().equals("placa") && imprimeResultado) {
            System.out.println("Detalhes do veículo : " + passeio.getModelo() + "Marca" + passeio.getMarca());
            return true;
        }

        if (passeio.getPlaca().equals("placa") && !imprimeResultado) {
            System.out.println("Ja existe um veiculo (passeio) cadastrado com a placa" + passeio.getPlaca());
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
