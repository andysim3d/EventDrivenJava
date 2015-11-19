package com.spcapitaliq.Handler;

import com.spcapitaliq.EventArgs.IEventArgs;
import com.spcapitaliq.Events.IEvent;

public interface IHandler {
	public Object Invoke(IEvent e, IEventArgs args) throws Throwable;
	public boolean isActived();
	
}
