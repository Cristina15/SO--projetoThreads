/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso.numerosprimos;

import java.util.Scanner;

/**
 *
 * @author vitoria.csilva15
 */
public class Main {

    public static void main(String[] args) {

        // é primo ou não 
        Scanner scan = new Scanner(System.in);
        int numPrimo = 0;
        int numDivisores = 0;
        
        System.out.println("Digite um número Usuário:" );
        numPrimo = scan.nextInt();

        for (int i = 1; i <= numPrimo; i++) {
            if(numPrimo % i ==0){
                numDivisores++;
                
            }
        }
        if(numDivisores ==2){
            System.out.println("Este número é primo");
        } else{
            System.out.println("Não é primo");
        }
    }
}
