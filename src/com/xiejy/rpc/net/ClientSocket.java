package com.xiejy.rpc.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.xiejy.rpc.dto.RPCTransFormObj;

public class ClientSocket {
	public static Object callRemoteService(RPCTransFormObj obj,String host,int port) {
		Object retObject = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			Socket socket = new Socket(host,port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(obj);
			oos.flush();
			ois = new ObjectInputStream(socket.getInputStream());
			retObject = ois.readObject();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  finally {
			if (oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (ois!=null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return retObject;
	}
}
