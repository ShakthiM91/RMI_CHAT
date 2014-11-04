/*
 *  this file used to create the CLI version of this chat app
 * 
 */

//package com.rmi.client;
//
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.Scanner;
//
//import com.rmi.interfaces.ClientInterface;
//import com.rmi.interfaces.ServerInterface;
//
//public class ChatClient extends UnicastRemoteObject implements ClientInterface,
//		Runnable {
//
//	/**
//	 * 
//	 */
//		
//	String name;
//	ServerInterface server;
//	ClientInterface me;
//	String msg;
//
//	public String getMsg() {
//		return msg;
//	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
//
//	protected ChatClient(String name, ServerInterface server)
//			throws RemoteException {
//		this.name = name;
//		this.server = server;
//		server.register(this.name, this);
//		me = this;
//		// getting users array location
//		// int temp = server.findClient(this);
//		// System.out.println("user local : " + temp);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String getMsg(String msg) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println(msg);
//		setMsg(msg);
//		return msg;
//	}
//
//	public String getMessage() {
//		return getMsg();
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
//		String message;
//		while (true) {
//			message = scan.nextLine();
//			if (message.equals("-1")) {
//				System.out.println("Exit");
//				try {
//					Boolean stat = server.logout(me);
//					if (stat) {
//						System.out.println("Goodbye :");
//					}
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} else {
//				try {
//					server.broadcastMsg(name + ":" + message);
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}
//	}
//}
