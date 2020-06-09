
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.io.IOException;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			System.out.println("Servidor conectado port 12345");

			byte[] input = new byte[1024];
			byte[] output = new byte[1024];
			DatagramPacket packet = new DatagramPacket(input, input.length);
		
			while(true) {
				socket.receive(packet);
				String msg = new String(packet.getData());

				System.out.println(">>: " + msg);
			}
		}catch(SocketException e) { 
			System.err.println("Servidor não conectado");
		}catch(IOException e) {
			System.err.println("erro ao receber mensagem");
		}
	}
}
