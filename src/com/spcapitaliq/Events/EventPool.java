package com.spcapitaliq.Events;

import java.util.Dictionary;
import java.util.Hashtable;

public class EventPool {
	private Dictionary<String, IEvent> _pool;
	public EventPool(){
		this._pool = new Hashtable<String, IEvent>();
	}
	public boolean regist(IEvent e){
		return this._pool.put(e.getName(), e) != null;
	}
	public boolean remove(IEvent e){
		IEvent res = this._pool.get(e.getName());
		if(res != null && res.equals(e)){
			return this._pool.remove(e.getName()) != null;
		}
		return false;
	}
}
