package com.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
	Boolean register(String name, ClientInterface client) throws RemoteException;

	void broadcastMsg(String msg) throws RemoteException;

	Boolean logout(ClientInterface client) throws RemoteException;
	
	void notification(String message) throws RemoteException;
}
