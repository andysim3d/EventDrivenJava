package com.spcapitaliq.Events;

import java.util.ArrayList;
import java.util.List;

public class Event implements IEvent {

	private String _name;
	private List<Methods> _listener;
	private boolean _active;
	//parameters
	private Object[] _param;
	
	public Event(String name){
		this._listener = new ArrayList<Methods>();
		this._name = name;
	}
	
	@Override
	public void trigger() {
		// TODO Auto-generated method stub
		runall();
	}
	private synchronized void runall(){
		if(this._listener == null){
			return;
		}
		for(Methods _m : _listener){
			//pass by params
			_m.Invoke(this._param);
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
	public void setParam(Object[] params) {
		// TODO Auto-generated method stub
		this._param = params;
	}
	@Override
	public boolean regist(Methods _m) {
		// TODO Auto-generated method stub
		return this._listener.add(_m);
		//return false;
	}
	@Override
	public boolean remove(Methods _m) {
		// TODO Auto-generated method stub
		return this._listener.remove(_m);
	}

	@Override
	public String[] getParamType() {
		if(this._param == null){
			return null;
		}
		String [] result = new String[this._param.length];
		// TODO Auto-generated method stub
		for(int i = 0 ; i < result.length; ++i){
			result[i] = this._param[i].getClass().getName();
		}
		return result;
	}
	

}
