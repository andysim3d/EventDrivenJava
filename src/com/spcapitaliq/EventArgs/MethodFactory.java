package com.spcapitaliq.EventArgs;

import java.lang.reflect.Method;

//import javax.swing.Spring;

import com.spcapitaliq.EventArgs.imp.EventArgs;

import com.spcapitaliq.Events.IEvent;


public class MethodFactory {
	public static Method methodfact(String name, Object src) throws Throwable{
		//static method
		return getMethods(name, src);
	}
	
	private static Method getMethods(String name, Object src) throws Throwable{
		if(src.getClass().equals(Class.class)){
			return ((Class<?>)src).getMethod(name, IEvent.class, IEventArgs.class);
		}
		return (src.getClass().getMethod(name, IEvent.class, IEventArgs.class));
	}
}
