package com.github.jimmyfm.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Module implements EntryPoint
{
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private final Messages messages = GWT.create(Messages.class);

	public void onModuleLoad()
	{
		RPCListGrid rls = new RPCListGrid();
		RootPanel.get().add(rls);

		//		greetingService.getDefinition(new AsyncCallback<String>()
		//		{
		//
		//			@Override
		//			public void onSuccess(String arg0)
		//			{
		//				final DataSource rds = new DataSource(JSON.decode(arg0));
		//				rds.setClientOnly(true);
		//
		//				greetingService.getData(new AsyncCallback<ArrayList<HashMap<String, String>>>()
		//				{
		//
		//					@Override
		//					public void onSuccess(ArrayList<HashMap<String, String>> arg0)
		//					{
		//						Record[] cache = new Record[arg0.size()];
		//						for (int i = 0; i < cache.length; i++)
		//						{
		//							cache[i] = new Record(arg0.get(i));
		//						}
		//						rds.setCacheData(cache);
		//					}
		//
		//					@Override
		//					public void onFailure(Throwable arg0)
		//					{
		//						arg0.printStackTrace();
		//					}
		//				});
		//
		//				ListGrid ls = new ListGrid(rds);
		//				ls.setAlternateRecordStyles(true);
		//				ls.setShowAllRecords(true);
		//				ls.setAutoFetchData(true);
		//				ls.setWidth100();
		//				ls.setHeight100();
		//				RootPanel.get().add(ls);
		//
		//
		//			}
		//
		//			@Override
		//			public void onFailure(Throwable arg0)
		//			{
		//				arg0.printStackTrace();
		//			}
		//		});
	}
}
