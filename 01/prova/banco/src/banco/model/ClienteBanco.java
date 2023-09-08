/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.model;

import banco.exception.NumException;
import banco.interfaces.Verifica;

/**
 *
 * @author Pichau
 */
public abstract class ClienteBanco  implements Verifica {
    
    private int numeroConta = 0;
    private String nome = "";
    private Endereco ender = new Endereco();
    
    public abstract void verifDoc();

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) throws NumException {
        if (numeroConta > 0) {
            this.numeroConta = numeroConta;
        } else {
            throw new NumException("Número de conta inválido: deve ser positivo.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnder() {
        return ender;
    }

    public void setEnder(Endereco ender) {
        this.ender = ender;
    }
}
