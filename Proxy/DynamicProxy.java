����interface ProxyInterFace  {  
����	public void proxyMethod();  
����}  
����
����class TargetObject implements ProxyInterFace  {  
����  
����	public void proxyMethod() {  
����		System.out.println("�ұ������ˣ�������");  
����    }  
����}  
����
����class ProxyObject implements InvocationHandler {  
����	//����Ķ���  
����	public Object targetObject;  
����   
����	public void setTargetObject(Object targetObject) {  
����		this.targetObject = targetObject;  
���� }  
����  
���� public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {  
����	 //���ã�����һ��Ŀ����󣬺Ͷ�Ӧ�Ķ������  
����	 System.out.println("����ǰ �������������");  
����	 Object object = method.invoke(targetObject, args);
����	 System.out.println("����� �������������"); 
����	 return object;
���� }  
����}  
����  
����public class DynamicProxy {  
���� public static void main(String[] args) { 
����	//�����Ŀ�����  
����	ProxyInterFace  target = new TargetObject();
����	//������  
����	ProxyObject proxy =  new ProxyObject();
����	proxy.setTargetObject(target);
����	//��Ҫ����������handler
����	InvocationHandler handler = proxy;
����	//�����µĴ������
����    Object newProxyObject = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
����    //�µĴ������ִ�з���
����	((ProxyInterFace)newProxyObject).proxyMethod();
���� }  
����}
//�������н����
//��������ǰ �������������
//�����ұ������ˣ�������
//��������� �������������