package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("d:\\users.txt");
			FileOutputStream fout = new FileOutputStream("d:\\excel.txt");
			//获取输入输出通道
			FileChannel fcin = fin.getChannel();
			FileChannel fcout = fout.getChannel();
			//创建缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(true){
				// clear方法重设缓冲区，使它可以接受读入的数据 
				buffer.clear();
				int r = fcin.read(buffer);
				if(r==-1){
					break;
				}
				// flip方法让缓冲区可以将新读入的数据写入另一个通道   
				buffer.flip();
				fcout.write(buffer);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
