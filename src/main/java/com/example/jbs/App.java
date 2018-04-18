package com.example.jbs;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.example.jbs.*;

public class App { 
	private static Thread mainThread;

	private static String host = "localhost";
	private static int port = 58939;
	private static int sendPacketInterval = 1000; // ms

	public static void main(String[] args) {
		System.out.println("Please use start stop as background service.");
	}

	public static void start(String[] args) {
		SendUdp("starting ...");

		mainThread = new Thread() {
			public void run() {
				SendUdp("Thread Running");

				int i = 0;
				while (true) {

					i++;
					SendUdp("Hello " + i + ", int=" + Thread.currentThread().isInterrupted());

					try {
						Thread.sleep(sendPacketInterval);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
					if (Thread.currentThread().isInterrupted()) {
						SendUdp("interrupted");
						break;
					}
				}
				SendUdp("loop done");
			}
		};
		mainThread.start();
		SendUdp("start done");
	}

	public static void stop(String[] args) throws Exception {
		SendUdp("stopping ...");
		mainThread.interrupt();
		SendUdp("stop done");
		// System.exit(0);
	}

	public static void SendUdp(String msg) {
		try {
			System.out.println(msg);
			byte[] message = msg.getBytes();

			// Get the Internet address of the specified host
			InetAddress address = InetAddress.getByName(host);

			// Initialize a datagram packet with data and address
			DatagramPacket packet = new DatagramPacket(message, message.length, address, port);

			// Create a datagram socket, send the packet through it, close it.
			DatagramSocket dsocket = new DatagramSocket();
			dsocket.send(packet);
			dsocket.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
