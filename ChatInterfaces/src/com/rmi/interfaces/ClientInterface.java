package com.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClientInterface extends Remote {
	String getMsg(String msg) throws RemoteException;
	void onlineUsers(ArrayList<String> names) throws RemoteException;
}
