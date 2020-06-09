
import java.net.DatagramSocket;
import java.net.DatagramPacket; 
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.SocketException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cliente {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();

			Scanner in = new Scanner(System.in);
			DatagramPacket packet;

			ExecutorService executorService = Executors.newCachedThreadPool();
			executorService.execute(new Recebedor(socket));

			while(true) {
				byte[] output = new byte[1024];

				String msg = in.nextLine();
				output = msg.getBytes();
				packet = new DatagramPacket(output, output.length, InetAddress.getLocalHost(), 12345);				

				socket.send(packet);
			}
		}catch(UnknownHostException e) {
			System.err.println("Não foi possivel indentificar o endereço");
		}catch(SocketException e) {
			System.err.println("Não conectado ao servidor");
		}catch(IOException e) {
			System.err.println("Erro no envio de mensagem");
		}
	}
}
