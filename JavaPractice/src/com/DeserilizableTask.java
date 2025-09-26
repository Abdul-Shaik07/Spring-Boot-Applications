package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserilizableTask {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("emp.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = ois.readObject();
			Employee emp =(Employee)object;
			System.out.println(emp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
