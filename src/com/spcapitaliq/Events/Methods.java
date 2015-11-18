package com.spcapitaliq.Events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Methods {
	private Method _m;
	private Class<?> _c;
	
	public Methods(Class<?> c, Method m){
		this._c = c;
		this._m = m;
	}
	
	public Object Invoke(Object [] param){
		try {
			return this._m.invoke(this._c.newInstance(), param);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
