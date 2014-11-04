package com.rmi.client;

import com.rmi.interfaces.ClientInterface;
import com.rmi.interfaces.ServerInterface;
import com.rmi.ui.Home;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Core extends UnicastRemoteObject implements ClientInterface {

    private static final long serialVersionUID = 1L;
    String name;
    ServerInterface server;
    ClientInterface me;
    Home object;
    
   

    public Core(String name, ServerInterface server, Home obj) throws RemoteException {
        this.name = name;
        this.server = server;
        this.object=obj;
        server.register(this.name, this);
        me = this;
    }

    //get the msg from teh server and set the msg in the gui 
    @Override
    public String getMsg(String msg) throws RemoteException {
        // TODO Auto-generated method stub
//    	System.out.print(msg);
        object.setMsg(msg);
        return msg;
    }
//register the client app with the server so it can send msges 
    public String regsterClient(String name, ClientInterface client)
            throws RemoteException {
        Boolean stat =  server.register(name, client);
        return null;
    }
//send the msg to sever to broadcast
    public void sendMsg(String msg) throws RemoteException {
        server.broadcastMsg(msg);
    }
//remove the client from the server
    public Boolean logout(String name) throws RemoteException {
    	sendMsg(name+" went away....");
        return server.logout(me);
    }

	@Override
	public void onlineUsers(ArrayList<String> names) throws RemoteException {
		// TODO Auto-generated method stub
//		System.out.print(names.size());
		this.object.setOnlineUser(names);
	}
}
