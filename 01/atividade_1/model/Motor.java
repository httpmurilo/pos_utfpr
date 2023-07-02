package model;

public class Motor {

    public Motor() {
    }

    public Motor(Integer qtdPist, Integer potencia) {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }

    public Integer getQtdPist() {
        return qtdPist;
    }

    public void setQtdPist(Integer qtdPist) {
        this.qtdPist = qtdPist;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    private Integer qtdPist;
    private Integer potencia;

    @Override
    public String toString() {
        return "Motor{" +
                "qtdPist=" + qtdPist +
                ", potencia=" + potencia +
                '}';
    }
}
