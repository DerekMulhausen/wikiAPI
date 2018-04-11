package wikiAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class AdAstraApi {
	private String BaseUrl;
	private String ResponderUrl;
	private String responderParameters;
	
	/*
	 *Constructor sets BaseUrl, ResponderUrl and ResponderParameters properties
	 */
	public AdAstraApi() {
		this.BaseUrl="http://app32mlml/SG757108NOKSQL_1_1/";
		this.ResponderUrl="~api/search/room?action=GET";
		this.responderParameters="fields=RowNumber%2CId%2CRoomName%2CRoomDescription%2CRoomNumber%2CRoomTypeName%2CBuildingCode%2CBuildingName%2CCampusName%2CCapacity%2CBuildingRoomNumberRoomName%2CCanEdit%2CCanDelete&sortOrder=%2BBuildingRoomNumberRoomName";
	}
	public String Login() throws MalformedURLException, IOException{
		/*
		 * Open an HTTP Connection to the Logon.ashx page
		 */
		HttpURLConnection httpcon=(HttpURLConnection) ((new URL(BaseUrl+"Logon.ashx").openConnection()));
		httpcon.setDoOutput(true);
		httpcon.setRequestProperty("Content-Type", "application/json");
		httpcon.setRequestProperty("Accept", "application/json");
		httpcon.setRequestMethod("POST");
		httpcon.connect();
		/*
		 * Output user credentials over HTTP Output Stream
		 */
		byte[] outputBytes="{'username': 'sysadmin', 'password':'apple'}".getBytes("UTF-8");
		OutputStream os=httpcon.getOutputStream();
		os.write(outputBytes);;
		os.close();
		/*
		 * Call Function setCookie and pass the HttpUrlConnection. Set Function
		 * will return a Cookie String used to authenticate user.
		 */
		return setCookie(httpcon);
				
	}
}
