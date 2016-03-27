package com.github.jimmyfm.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService
{
	String getDefinition();

	ArrayList<HashMap<String, String>> getData();

	List<MyPojo> getData2();

	void update(MyPojo obj);
}
