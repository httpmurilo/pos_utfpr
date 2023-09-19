/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import banco.exception.NumException;
import banco.model.Endereco;
import banco.model.PessoaFisica;
import banco.model.PessoaJuridica;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Pichau
 */
public class TstConta {
    
    /**
     * @param args the command line arguments
     * @throws banco.exception.NumException
     */
    public static void main(String[] args) throws NumException {
        
        Scanner scanner = new Scanner(System.in);
        PessoaJuridica pj = new PessoaJuridica();

        try {
            
            
            System.out.println("Digite o numero da conta : ");
            Integer numeroConta = scanner.nextInt(); 
            scanner.nextLine();
            pj.setNumeroConta(numeroConta);
            
            System.out.println("Digite o nome da empresa : ");
            String nomeEmpresa = scanner.nextLine(); 
            pj.setNome(nomeEmpresa);
            
            System.out.println("Digite o cnpj : ");
            String cnpj = scanner.nextLine(); 
            pj.setCnpj(new BigInteger(cnpj));
            
            Endereco ender = new Endereco();
            System.out.println("Digite o nome da rua : ");
            String rua = scanner.nextLine(); 
            ender.setRua(rua);
            
            System.out.println("Digite o numero da rua : ");
            Integer numeroRua = scanner.nextInt(); 
            scanner.nextLine();
            
            ender.setNum(numeroRua);
            pj.setEnder(ender);
            
            System.out.println("Digite o cpf do responsavel da empresa : ");
            Integer cpfResponsavel = scanner.nextInt();
            scanner.nextLine();
            
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf(cpfResponsavel);
            
            System.out.println("Digite o nome do responsavel da empresa : ");
            String nomeResponsavel = scanner.nextLine();
            
            pf.setNome(nomeResponsavel);
        } catch (NumException e) {
            NumException.impMsg();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        System.out.println("Pressione Enter para imprimir resultados...");
        scanner.nextLine();
        
        
        System.out.println("Imprimindo resultados");
        System.out.println("==================================");
        System.out.println(pj.getNumeroConta());
        numeroEhPar(pj.getNumeroConta());
        System.out.println(pj.getCnpj());
        System.out.println(pj.getEnder().getRua());
        System.out.println(pj.getResponsavel().getCpf());
        System.out.println(pj.getResponsavel().getCpf());
        System.out.println(pj.getNome());
        nomeEhValido(pj.getNome());
        
    }
    public static void numeroEhPar(Integer numConta) {
        if (numConta % 2 == 0) {
            System.out.println("O número da conta é par.");
        } else {
            System.out.println("O número da conta é ímpar.");
        }
    }  
    
    public static void nomeEhValido(String nome) {
        if (nome.length() >= 5) {
            System.out.println("Nome do responsável válido.");
        } else {
            System.out.println("Nome do responsável inválido.");
        }
    }   
     
    
}
