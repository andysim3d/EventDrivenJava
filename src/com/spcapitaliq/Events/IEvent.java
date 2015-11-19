package com.spcapitaliq.Events;

import com.spcapitaliq.EventArgs.IEventArgs;
import com.spcapitaliq.Handler.imp.NonStaticMethods;

public interface IEvent {
	
	/*Trigger this event*/
	public void trigger();
	public boolean isActive();
	public boolean enable();
	public boolean disable();
	public boolean regist(NonStaticMethods _m);
	public boolean remove(NonStaticMethods _m);
	public String getName();
	public void setName(String _n);
	public String [] getParamType();
	public void setParam(IEventArgs args);
}
