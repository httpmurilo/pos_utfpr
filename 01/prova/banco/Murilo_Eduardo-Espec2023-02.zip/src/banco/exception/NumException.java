/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco.exception;

/**
 *
 * @author Pichau
 */
public class NumException extends Exception{
    
    public NumException() {
        super();
    }

    public NumException(String mensagem) {
        super(mensagem);
    }
    
    public static void impMsg() {
        System.out.println("ERRO: Não pode haver Número Negativo para conta!");
    }
}
