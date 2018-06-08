
/* O progama realiza um calculo de verificação de números primos do 0 ao 99999*/
/* Ultiliza 4 threads chamando a afuncção calculo e uma thread que lista o resultado */
/* As threads ultiliza escalonamento do processador, e foram feitos para uma maquina monoprocessada.*/
/* Ultilizando processosm diferetes em momentos diferentes*/

import java.io.*;

/**
 *
 * @author matheus.jmaia and vitoria.cristina
 */

public class FimThread implements Runnable {
    /*Declaração das threads*/

    static Thread threadCalcula11;
    static Thread threadCalcula13;
    static Thread threadCalcula17;
    static Thread threadCalcula19;
    static Thread threadLista;
    long total = 0;

    public static void main(String[] args) {
        FimThread e = new FimThread();
       /*Estanciando e incicializando as threads*/
        threadCalcula11 = new Thread(e);
        threadCalcula13 = new Thread(e);
        threadCalcula17 = new Thread(e);
        threadCalcula19 = new Thread(e);
        threadLista = new Thread(e);
        threadCalcula11.start();
        threadCalcula13.start();
        threadCalcula17.start();
        threadCalcula19.start();
        threadLista.start();

    }

    public void run() {
        
        /*A nova thread criada irá receber o valo da thread que está em execução*/
        /*Com as 4 threads atuais, cada uma irá realizar a verificação quando tiver seu tempo no processador*/	 
        Thread currentThread = Thread.currentThread();

        if (currentThread == threadCalcula11) {
            calculaPrimos(11);
        }
        if (currentThread == threadCalcula13) {
            calculaPrimos(13);
        }
        if (currentThread == threadCalcula17) {
            calculaPrimos(17);
        }
        if (currentThread == threadCalcula19) {
            calculaPrimos(19);
        } 
        else if (currentThread == threadLista) {
            lista();
        }
    }

    /*Função verifica se o número é primo*/
    public void calculaPrimos(int num) {
        int k, j, i;
        for (i = num; i < 99999; i += 10) {
            k = 0;
            for (j = 3; j * j <= i; j += 2) {
                if (i % j == 0) {
                    k = 1;
                    break;
                }

            }
            if (k == 0) {
                System.out.println("O NÚMERO " + i + " É PRIMO");
                total++;
            }
        }
    }
/*Digitando "resultado" a funcção retorna a quantidade de npumeros primos encontrados*/
    private void lista() {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      String line = "";
        while (!line.equals("resultado")) {
            try {
                line = input.readLine();
            } catch (IOException exception) {
            }
        }
        System.out.println("\n ENCONTRADOS " + total + " NÚMEROS PRIMOS");
        System.exit(0);
    }

}
