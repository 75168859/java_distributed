package nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo03 {
	public static void main(String[] args) throws Exception {
		File file = new File("d:" + File.separator + "d:\\user.txt");
		FileInputStream input = null;			// 文件输入流
		input = new FileInputStream(file);	// 实例化输入流
		FileChannel fin = null ;		// 声明输入的通道对象
		fin = input.getChannel() ;		// 得到输入文件通道
		MappedByteBuffer mbb = null ;	// 声明文件的内存映射
		mbb = fin.map(FileChannel.MapMode.READ_ONLY, 
				0, file.length()) ;	// 将文件映射到内存中
		byte data[] = new byte[(int) file.length()];	// 开辟字节数组，接收数据
		int foot = 0 ;				// 定义下标
		while(mbb.hasRemaining()){		// 判断是否有数据
			data[foot++] = mbb.get() ;		// 取出数据
		}
		System.out.println(new String(data)) ;	// 显示输入的数据
		fin.close() ;			// 关闭输入通道
		input.close() ;				// 关闭输入流
	}
}
