package bd;

import model.Carga;
import model.Motor;
import model.Passeio;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    public BDVeiculos() {
        cargas = inicializaListaDeCarga();
        veiculoList = inicializaListaDePasseio();

    }

    List<Carga> cargas = new ArrayList<>();
    List<Passeio> veiculoList = new ArrayList<>();

    public List<Carga> getCargas() {
        return cargas;
    }

    public void setCargas(List<Carga> cargas) {
        this.cargas = cargas;
    }

    public List<Passeio> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Passeio> veiculoList) {
        this.veiculoList = veiculoList;
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

}
