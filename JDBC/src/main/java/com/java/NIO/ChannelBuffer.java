package com.java.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelBuffer {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("input.txt");
			ReadableByteChannel src = fis.getChannel();
			
			FileOutputStream fos = new FileOutputStream("output.txt");
			WritableByteChannel des = fos.getChannel();
			
			copyData(src, des);
			src.close();
			des.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void copyData(ReadableByteChannel src, WritableByteChannel des) {
		 ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
		 
		    try {
				while (src.read(buffer) != -1) 
				{
				  // Prepare the buffer to be drained
				  buffer.flip();
 
				  // Make sure that the buffer was fully drained
				  while (buffer.hasRemaining()) 
				  {
				     des.write(buffer);
				  }
 
				  // Make the buffer empty, ready for filling
				  buffer.clear();

}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

