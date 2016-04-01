package nio;

public class EncodeDesigner {
	public static void dosomething(String name,CodeFactory cf){
		//1对name进行编码
		//2.存储
		//3.获取
		//4.解码
		//other
	}
}
interface Decode{
	void decode(String name);
}
interface Encode{
	void encode(String name);
}
abstract class CodeFactory{
	public abstract Decode getDecode();
	public abstract Encode getEncode();
}
//抽象工厂设计模式---->创建对象的家族
/*class A{
	public void f(){
		EncodeDesigner.dosomething("zhangsan", new CodeFactory() {
			
			@Override
			public Encode getEncode() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Decode getDecode() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
}*/