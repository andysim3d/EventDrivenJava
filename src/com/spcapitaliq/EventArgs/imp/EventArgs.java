package com.spcapitaliq.EventArgs.imp;

import com.spcapitaliq.EventArgs.IEventArgs;

public class EventArgs implements IEventArgs {

	private Object [] _params;
	private String [] _paramTypes;
	
	public EventArgs(Object [] param){
		this._params = param;
		generateType();
	}
	
	public void setParam(Object [] param){
		this._params = param;
		generateType();
	}
	
	private void generateType(){
		if(this._params != null && this._params.length > 0){
			this._paramTypes = new String[this._params.length];
			
			for(int i = 0; i < this._paramTypes.length ; ++i){
				this._paramTypes[i] = this._params[i].getClass().getName();
			}
		}
	}
	
	@Override
	public Object[] getParams() {
		// TODO Auto-generated method stub
		return this._params;
	}

	@Override
	public String[] getParamTypes() {
		// TODO Auto-generated method stub
		return this._paramTypes;
	}

}
