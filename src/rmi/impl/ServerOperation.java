package rmi.impl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.inter.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface{

	protected ServerOperation() throws RemoteException {
		super();		
	}

	@Override
	public String helloTo(String name) throws RemoteException {
		System.err.println(name + " is trying to connect....");		
		return "Server says Hello " + name;
	}
	
	public static void main(String[] args) {
		try {
			Naming.rebind("//localhost/MyServer", new ServerOperation());
			System.err.println("Server ready...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
