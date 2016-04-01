package nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class StringCoding {
	public static void main(String[] args) {
		String str = "ABCÖÐ";
		byte[] b1 = str.getBytes();
		for (byte b : b1) {
			System.out.print(Integer.toHexString(b & 0XFF) + " ");
		}
		System.out.println("\n===================");
		try {
			byte[] b2 = str.getBytes("gbk");
			for (byte b : b2) {
				System.out.print(Integer.toHexString(b & 0XFF) + " ");
			}
			System.out.println("\n===================");
			byte[] b3 = str.getBytes("utf-8");
			for (byte b : b3) {
				System.out.print(Integer.toHexString(b & 0XFF) + " ");
			}
			System.out.println("\n==================");
			byte[] b4 = str.getBytes("utf-16be");
			System.out.println("\n=================");
			for (byte b : b4) {
				System.out.print(Integer.toHexString(b & 0XFF) + " ");
			}
			String s1 = new String(b4,"utf-16be");
			System.out.println();
			System.out.println(s1);
			
	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
}
