import java.io.*; 
import java.net.*; 
  
class UDPClient { 
  public static void main(String args[]) throws Exception 
  { 
    /* -=-=-=-=-=-=-=-=-= CAMPOS A SEREM ALTERADOS =-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    String ip = "18.224.220.128"; // Endereço IP do servidor destino.
    int qdeTentativas = 25; // Quantidade de tentativas de envio da mensagem.
    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/

    System.out.println ("Attemping to connect to IP: " + ip + " via UDP port 6000\n");
    int pacotesPerdidos = 0; // Variável para controle de perda de pacotes.
    new Thread();
    
    for (int i = 1; i <= qdeTentativas; i++)
    {
      try 
      {
        String serverHostname = new String (ip);
        DatagramSocket clientSocket = new DatagramSocket(); 
    
        InetAddress IPAddress = InetAddress.getByName(serverHostname);
    
        byte[] sendData = new byte[1024]; 
        byte[] receiveData = new byte[1024];

        String sentence = "Tentativa: " + i;
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6000);
    
        clientSocket.send(sendPacket); 
    
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 

        clientSocket.setSoTimeout(250);

        try
        {
          clientSocket.receive(receivePacket); 
          String modifiedSentence = new String(receivePacket.getData()); 
  
          InetAddress returnIPAddress = receivePacket.getAddress();
    
          int port = receivePacket.getPort();

          System.out.println (sentence + "  |  Success  | RTT: ");

        }
        catch (SocketTimeoutException ste)
        {
          pacotesPerdidos ++;
          System.out.println (sentence + "  |  Timeout Occurred: Packet assumed lost");
        }
    
        clientSocket.close(); 
      }
      catch (UnknownHostException ex) { 
        System.err.println(ex);
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
      Thread.sleep(1000);
    }
    if (qdeTentativas >= 10){
      System.out.println("\nRTT médio: ");
      System.out.println("Taxa de perda de pacotes: " + (pacotesPerdidos * 100) / qdeTentativas + "%");
    }
  } 
} 
