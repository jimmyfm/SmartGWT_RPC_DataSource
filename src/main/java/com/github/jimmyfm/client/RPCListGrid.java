package com.github.jimmyfm.client;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGrid;

public class RPCListGrid extends ListGrid
{
	protected AsyncCallback<ArrayList<HashMap<String, String>>> getDataCallback = new AsyncCallback<ArrayList<HashMap<String, String>>>()
	{
		@Override
		public void onSuccess(ArrayList<HashMap<String, String>> data)
		{
			Record[] cache = new Record[data.size()];
			for (int i = 0; i < cache.length; i++)
			{
				cache[i] = new Record(data.get(i));
			}
			setData(cache);
		}

		@Override
		public void onFailure(Throwable e)
		{
			throw new RuntimeException(e);
		}
	};

	protected AsyncCallback<String> dsDefCallback = new AsyncCallback<String>()
	{
		@Override
		public void onSuccess(String jsonDataSource)
		{
			rds = new RPCDataSource(jsonDataSource);
			setDataSource(rds);
			listGridService.getData(getDataCallback);
		}

		@Override
		public void onFailure(Throwable e)
		{
			throw new RuntimeException(e);
		}
	};

	private final GreetingServiceAsync listGridService = GWT.create(GreetingService.class);
	private RPCDataSource rds;

	public RPCListGrid()
	{
		this.setAlternateRecordStyles(true);
		this.setShowAllRecords(true);
		this.setAutoFetchData(true);
		this.setWidth100();
		this.setHeight100();

		listGridService.getDefinition(dsDefCallback);
	}

}
