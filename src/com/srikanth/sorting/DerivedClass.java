package com.srikanth.sorting;

import java.io.IOException;

public class DerivedClass extends BaseClass{
	@Override
	public Integer getMyNumber() throws IOException{
		try{
			
		}catch(Exception e){
			throw new IOException(e);
		}
		
		return new Integer(4);
	}
}
