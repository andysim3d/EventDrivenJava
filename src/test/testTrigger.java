package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.spcapitaliq.EventArgs.IEventArgs;
import com.spcapitaliq.EventArgs.MethodFactory;
import com.spcapitaliq.EventArgs.imp.EventArgs;
import com.spcapitaliq.Events.EventPool;
import com.spcapitaliq.Events.IEvent;
import com.spcapitaliq.Events.imp.Event;
import com.spcapitaliq.Handler.IHandler;
import com.spcapitaliq.Handler.imp.NonStaticMethods;
import com.spcapitaliq.Handler.imp.StaticMethod;

public class testTrigger {

	@Test
	public void test() throws Throwable {
		EventPool pool = new EventPool();
		Event testEvent = new Event("Test");
		pool.regist(testEvent);
		Object [] ppp = new Object[]{(Object)15};
		IEventArgs arg = new EventArgs(ppp);
		testEvent.setParam(arg);
		/*try{
		Method meth = this.getClass().getMethod("triggerFuc", int.class);
		meth.invoke(null, 10);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		*/
		IHandler testMethod = new NonStaticMethods(this, MethodFactory.methodfact("triggerFunc", this));
		IHandler t2 = new StaticMethod(MethodFactory.methodfact("triggerFuc", this));
		testEvent.regist(t2);
		testEvent.regist(testMethod);
		testEvent.trigger();
	}
	
	public int triggerFunc(IEvent e, IEventArgs args){
		System.out.println((int)args.getParams()[0]);
		return (int)args.getParams()[0] * 10;
	}
	
	public static int triggerFuc(IEvent e, IEventArgs args){
		int b = (int)args.getParams()[0];
		System.out.println(1000 );
		return b;
	}

}
