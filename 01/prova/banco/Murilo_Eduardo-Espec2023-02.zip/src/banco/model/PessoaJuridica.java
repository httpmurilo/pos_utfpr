/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.model;

import java.math.BigInteger;

/**
 *
 * @author Pichau
 */
public class PessoaJuridica extends ClienteBanco{
    
    private BigInteger cnpj = BigInteger.ZERO;
    private PessoaFisica responsavel = new PessoaFisica();

    public BigInteger getCnpj() {
        return cnpj;
    }

    public void setCnpj(BigInteger cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaFisica getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(PessoaFisica responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public void verifDoc() {
        if (responsavel.getNome().length()  > 30) {
            System.out.println("Nome inválido para Responsável");
        } else {
            System.out.println("Nome válido para Responsável");
        }
    }

    @Override
    public void validar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
