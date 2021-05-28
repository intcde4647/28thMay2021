package chainofresponsibility;

public class ChainOfResponsibilityWithException {

	public void method1()
	{
		try
		{
		method2();
		}catch(ArithmeticException ex)
		{
			System.out.println(ex);
		}
		}

	private void method2() {
		try
		{
		method3();
		}catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
	}

	private void method3() {
		
		int i=10;
		int j=0;
		try
		{
		int res=i/j;
		}catch(NullPointerException ex)
		{
			System.out.println(ex);
		}
		
		
	}
	
	
}
