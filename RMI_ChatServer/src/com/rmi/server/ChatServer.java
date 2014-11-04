package com.rmi.server;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.rmi.interfaces.ClientInterface;
import com.rmi.interfaces.ServerInterface;

public class ChatServer extends UnicastRemoteObject implements ServerInterface {
	private static final long serialVersionUID = 1L;

	private ArrayList<ClientInterface> clients;
	private ArrayList<String> names;

	// private ArrayList<String> user;

	protected ChatServer() throws RemoteException {
		clients = new ArrayList<ClientInterface>();
		names = new ArrayList<String>();
	}

	@Override
	public synchronized Boolean register(String name, ClientInterface client)
			throws RemoteException {
		this.clients.add(client);
		this.names.add(name);
		int i = 0;
		while (i < this.clients.size()) {
			this.clients.get(i++).onlineUsers(this.names);
		}
		return true;
	}

	@Override
	public synchronized void broadcastMsg(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < clients.size()) {
			clients.get(i++).getMsg(msg);
		}
	}

	@Override
	public Boolean logout(ClientInterface client) throws RemoteException {
		// TODO Auto-generated method stub
		int x = this.clients.indexOf(client);
		this.names.remove(x);
		int i = 0;
		while (i < this.clients.size()) {
			this.clients.get(i++).onlineUsers(this.names);
		}
		return this.clients.remove(client);
	}

	@Override
	public void notification(String message) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
