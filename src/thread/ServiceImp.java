package thread;
class ServiceImp implements Service
{
	//假设有共享数据
    public  void sayHello() {
        System.out.println("Hello World!");
    }
}
