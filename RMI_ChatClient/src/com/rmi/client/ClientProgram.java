package com.rmi.client;

import com.rmi.interfaces.ServerInterface;
import com.rmi.ui.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class ClientProgram {

//    public static String name = null;
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 7480);
        ServerInterface remote = (ServerInterface) reg.lookup("RMI_Chat_Server");
        /*************************************************
        //registering the user for cli
//		System.out.print("Enter name : ");
//		Scanner scan = new Scanner(System.in);
//		String name = scan.nextLine();
//		System.out.println("Welcom "+name);
//		

//		new Thread(new ChatClient("pro", remote)).start();
//        final Home pro = new Home();
//        if (name == null) {
//            Register regi =new Register(null);
//            regi.setVisible(true);
//        }
//        Register regi = new Register(null, remote);
//        regi.setVisible(true);
//        Home home = new Home(remote, "Shak");
//        home.setVisible(true);
        *****************************************************/
        
        //open register page
        RegUser register = new RegUser(remote);
        register.setVisible(true);
    }

}
