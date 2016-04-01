package nio;

import java.nio.IntBuffer;
public class IntBufferDemo01 {
	public static void main(String[] args) {
		IntBuffer buf = IntBuffer.allocate(10);// 开辟10个大小的缓冲区
		System.out.print("1、写入数据之前的position、limit和capacity：") ;
		System.out.println("position = " + buf.position() + "，limit = "
				+ buf.limit() + "，capacity = " + buf.capacity());
		int temp[] = { 5, 7, 9 };	// 定义整型数组
		buf.put(3);		// 向缓冲区写入数据
		buf.put(temp);		// 向缓冲区写入一组数据
		System.out.print("2、写入数据之后的position、limit和capacity：") ;
		System.out.println("position = " + buf.position() + "，limit = "
				+ buf.limit() + "，capacity = " + buf.capacity());
		buf.flip();				// 重设缓冲区
		System.out.print("3、准备输出数据时的position、limit和capacity：") ;
		System.out.println("position = " + buf.position() + "，limit = "
				+ buf.limit() + "，capacity = " + buf.capacity());
		System.out.print("缓冲区中的内容：") ;
		while (buf.hasRemaining()) {	// 只要缓冲区有内容则输出
			int x = buf.get();		// 取出当前内容
			System.out.print(x + "、");		// 输出内容
		}
	}
}
