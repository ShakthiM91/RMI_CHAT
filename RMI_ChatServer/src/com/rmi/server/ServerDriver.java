package com.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServerDriver {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
//		Naming.rebind("RMI_Chat_Server", new ChatServer());
		Registry regis = LocateRegistry.createRegistry(7480);
		regis.bind("RMI_Chat_Server", new ChatServer());
		System.out.println("Power RMI Server Started...........\n\n\n"
				+ "**************************************************************************\n"
				+ "This is a opensource simple chat server running on localhost:7480...."
				+ "Created by Shakthi Manawadu as a project for UCD....\n\n"
				+ "contact @ mail : manawadu.shakthi@gmail.com\n"
				+ "**************************************************************************");
	}
}
