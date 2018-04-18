package com.example.jbs;

import java.io.*;
import java.net.*;

public class MainRunnable implements Runnable {

	private String host = "localhost";
	private int port = 64603;
	private int sendPacketInterval = 1000; // ms

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			i++;
			SendUdp("Hello " + i);
			System.out.println("Send :" + i);
			try {
				Thread.sleep(sendPacketInterval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void SendUdp(String msg) {
		try {

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
