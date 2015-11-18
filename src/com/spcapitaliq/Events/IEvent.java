package com.spcapitaliq.Events;

public interface IEvent {
	
	/*Trigger this event*/
	public void trigger();
	public boolean isActive();
	public boolean enable();
	public boolean disable();
	public void setParam(Object [] params);
	public boolean regist(Methods _m);
	public boolean remove(Methods _m);
	public String getName();
	public void setName(String _n);
	public String [] getParamType();
}
