/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300); // cria o terminal de comunicação e pede a conexão na porta 
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            String msg = "Olá, DCOMP!!!";
            byte[] buf = msg.getBytes(); // Obtendo a respresentação em bytes da mensagem

            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf); // write aqui representa o Send
            System.out.println("[OK] ]");
            
            byte[] bresp = new byte[20]; // cria vetor de bytes para capturar a resposta
            is.read(bresp); // read aqui representa o receive  (é bloqueante)
            
            String resp = new String(bresp); // Converte os bytes de resposta em string
            System.out.println(resp);
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}