package com.spcapitaliq.Events;
import org.junit.Test;

public class testTrigger {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		EventPool pool = new EventPool();
		Event testEvent = new Event("Test");
		pool.regist(testEvent);
		Object [] ppp = new Object[]{(Object)15};
		testEvent.setParam(ppp);
		
		Methods testMethod = new Methods(this.getClass(), this.getClass().getMethod("triggerFunc", int.class));
		testEvent.regist(testMethod);
		testEvent.trigger();
	}
	
	public int triggerFunc(int a){
		System.out.println(a);
		return a * 10;
	}

}
