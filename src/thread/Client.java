package thread;
class Client
{
    public Client(Service s) {
        _service = s;
    }    
    public void requestService() {
        _service.sayHello();
    }
    private Service _service;
}
