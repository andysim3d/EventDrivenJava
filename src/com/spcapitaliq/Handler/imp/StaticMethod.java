package com.spcapitaliq.Handler.imp;

import java.lang.reflect.Method;

import com.spcapitaliq.EventArgs.IEventArgs;
import com.spcapitaliq.Events.IEvent;
import com.spcapitaliq.Handler.IHandler;
/**
 * For Static Methods only
 * @author pengfei_zhang
 *
 */
public class StaticMethod implements IHandler {

	private Method _m;
	private boolean _actived;
	
	public StaticMethod(Method m){
		this._m = m;
		this._actived = true;
	}
	
	@Override
	public Object Invoke(IEvent e, IEventArgs args) throws Throwable {
		// TODO Auto-generated method stub
		if(!this._actived){
			return null;
		}
		try{
			return this._m.invoke(null, e, args);
		}
		catch(Exception exp){
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
