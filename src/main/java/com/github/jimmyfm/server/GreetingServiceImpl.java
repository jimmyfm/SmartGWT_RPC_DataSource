package com.github.jimmyfm.server;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.jimmyfm.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService
{

	@Override
	public String getDefinition()
	{
		JSONObject res = new JSONObject();
		res.put("ID", "RPCDataSource");
		res.put("primaryKeys", new JSONArray(new String[] { "a" }));
		JSONArray fields = new JSONArray();
		{
			JSONObject field = new JSONObject();
			field.put("name", "a");
			field.put("primaryKey", "true");
			field.put("title", "First Column");
			field.put("type", "INTEGER");
			field.put("prompt", "Kinda cool");
			fields.put(field);
		}
		{
			JSONObject field = new JSONObject();
			field.put("name", "b");
			field.put("title", "Second Column");
			field.put("type", "FLOAT");
			fields.put(field);
		}
		{
			JSONObject field = new JSONObject();
			field.put("name", "c");
			field.put("title", "Editable one");
			field.put("type", "TEXT");
			field.put("canEdit", true);
			field.put("length", 30);
			fields.put(field);
		}
		res.put("fields", fields);
		return res.toString();
	}
	@Override
	public ArrayList<HashMap<String, String>> getData()
	{
		ArrayList<HashMap<String, String>> res = new ArrayList<>();
		for (int i = 0; i < 100; i++)
		{
			HashMap<String, String> row = new HashMap<>();
			row.put("a", String.valueOf(i));
			row.put("b", String.valueOf(Math.random()));
			res.add(row);
		}
		return res;
	}
}
