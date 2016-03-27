package com.github.jimmyfm.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.JSON;

public class RPCDataSource extends DataSource
{

	public RPCDataSource(String jsonDefinition)
	{
		super(JSON.decode(jsonDefinition));
		setClientOnly(true);
	}
}
