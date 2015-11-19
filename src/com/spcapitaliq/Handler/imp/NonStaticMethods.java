package com.spcapitaliq.Handler.imp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.spcapitaliq.EventArgs.IEventArgs;
import com.spcapitaliq.Events.IEvent;
import com.spcapitaliq.Handler.IHandler;

public class NonStaticMethods implements IHandler {
	//called instance;
	private Method _m;
	private Object _c;
	private boolean _actived;
	
	/**
	 * Construction
	 * @param c
	 * @param m
	 */
	public NonStaticMethods(Object c, Method m){
		this._c = c;
		this._m = m;
		this._actived = true;
	}
	
	//Invoke registed function
	/**
	 * Invoke this function, if it is enabled
	 * @param e Event information
	 * @param args Argument information
	 * @return return value;
	 * @throws Throwable Any Exception
	 */
	@Override
	public Object Invoke(IEvent e, IEventArgs args) throws Throwable{
		if(!this._actived){
			return null;
		}
		try {
			return this._m.invoke(this._c, e, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
			throw exp;
		}
	}
	
	@Override
	public boolean isActived(){
		return this._actived;
	}
	
	public void enable(){
		this._actived = true;
	}
	
	public void disable(){
		this._actived = false;
	}
}
