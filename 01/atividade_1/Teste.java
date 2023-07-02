import model.Motor;
import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        Veiculo v1 = new Veiculo("HAD9353", "Fiat", "Punto", "Rosa", Float.valueOf("100.00"), 4, new Motor(1,100));
        Veiculo v2 = new Veiculo("QFQ4822", "Volskwagem", "Gol", "Preto", Float.valueOf("150.00"), 4, new Motor(3,150));
        Veiculo v3 = new Veiculo("RGG7449", "Ford", "Fiesta", "Vermelho", Float.valueOf("140.00"), 4, new Motor(1, 100));
        Veiculo v4 = new Veiculo("GTP2102", "Ford", "KA", "Prata", Float.valueOf("120.00"), 4, new Motor(1, 98));
        Veiculo v5 = new Veiculo("HVE7235", "Citroen", "C3", "preta", Float.valueOf("120.00"), 4, new Motor(1,90));

        List<Veiculo> veiculoList = List.of(v1, v2, v3, v4, v5);

        veiculoList.stream().forEach(x -> System.out.println(x));
    }
}
