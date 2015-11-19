package com.spcapitaliq.Events.imp;

import java.util.ArrayList;
import java.util.List;

import com.spcapitaliq.EventArgs.IEventArgs;
import com.spcapitaliq.Events.IEvent;
import com.spcapitaliq.Handler.IHandler;
import com.spcapitaliq.Handler.imp.NonStaticMethods;

public class Event implements IEvent {

	private String _name;
	private List<IHandler> _listener;
	private boolean _active;
	//parameters
	private IEventArgs _args;
	//private Object[] _param;
	
	public Event(String name){
		this._listener = new ArrayList<IHandler>();
		this._name = name;
		this._active = true;
	}
	
	@Override
	public void trigger() {
		// TODO Auto-generated method stub
		runall();
	}
	
	private synchronized void runall(){
		if(!this._active || this._listener == null || this._listener.isEmpty()){
			return;
		}
		for(IHandler _m : _listener){
			try {
				_m.Invoke( this, this._args);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return _active;
	}

	@Override
	public boolean enable() {
		_active = true;
		// TODO Auto-generated method stub
		return _active;
	}

	@Override
	public boolean disable() {
		_active = false;
		// TODO Auto-generated method stub
		return !_active;
	}
	@Override
	public String getName() {
		return _name;
	}
	
	@Override
	public void setName(String _name) {
		this._name = _name;
	}
	@Override
	public void setParam(IEventArgs args) {
		// TODO Auto-generated method stub
		this._args= args;
	}
	@Override
	public boolean regist(IHandler _m) {
		// TODO Auto-generated method stub
		return this._listener.add(_m);
		//return false;
	}
	@Override
	public boolean remove(IHandler _m) {
		// TODO Auto-generated method stub
		return this._listener.remove(_m);
	}

	@Override
	public String[] getParamType() {
		if(this._args == null){
			return null;
		}
		String [] result = this._args.getParamTypes();
		// TODO Auto-generated method stub
		return result;
	}
	

}
