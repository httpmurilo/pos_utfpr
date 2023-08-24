package model;

public abstract class Veiculo {

    public Veiculo() {
    }

    public Veiculo(String placa, String marca, String modelo, String cor, Float velocMax, Integer qtdRodas, model.Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        Motor = motor;
    }

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private Float velocMax;
    private Integer qtdRodas;
    private Motor Motor;
    public abstract float calcVel(float velocMax);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Float getVelocMax() {
        return velocMax;
    }

    public void setVelocMax(Float velocMax) {
        this.velocMax = velocMax;
    }

    public Integer getQtdRodas() {
        return qtdRodas;
    }

    public void setQtdRodas(Integer qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public model.Motor getMotor() {
        return Motor;
    }

    public void setMotor(model.Motor motor) {
        Motor = motor;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", velocMax=" + velocMax +
                ", qtdRodas=" + qtdRodas +
                ", Motor=" + Motor +
                '}';
    }

}
