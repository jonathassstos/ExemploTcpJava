/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
public class TCPServer{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1")); //Cria socket associado a uma porta, 
            // define o tamanho da fila (5), ip no qual o socket está associado
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguarda pedido de conexão) que pega o primeiro da fila
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados (onde vai receber os dados)
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados (por onde vai enviar os dados)
            byte[] buf = new byte[20]; // buffer de recepção (pedaço q queremos pegar do fluxo de entrada)

            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(buf); // Operação bloqueante que representa o receive aqui (aguardando chegada de dados) (passagem de parametro por referencia)
            System.out.println("[OK] ]");
            
            String msg = new String(buf); // Mapeando vetor de bytes recebido para String
            
            System.out.println("  Mensagem recebida: "+ msg);
            
            String resp = "Tudo bem?";
            os.write(resp.getBytes()); // write aqui funcionando como send pegando os bytes da resp e enviando
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}