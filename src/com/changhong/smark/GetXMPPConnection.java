package com.changhong.smark;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;

/**
 * @author GWCheng
 *
 */
public class GetXMPPConnection {
	private static String serverName="wyl-PC";
	private static String serverHost="127.0.0.1";
	private static int serverPort=5222;
//	openfire后台密码 admin admin123
	
	public static AbstractXMPPConnection  getConnection(){
		AbstractXMPPConnection connection = null;
		Builder builder = XMPPTCPConnectionConfiguration.builder();
		builder.setSecurityMode(SecurityMode.disabled);
//		XMPPTCPConnectionConfiguration config = builder.setServiceName("gwcheng-pc").setHost("gwcheng-pc").setPort(5222).build();
		XMPPTCPConnectionConfiguration config = builder.setServiceName(serverName).setHost(serverHost).setPort(serverPort).build();
		connection = new XMPPTCPConnection(config);
		return connection;
		
	}
	public static void closeConnection(AbstractXMPPConnection connection){
		if (connection != null) {
			try {
				connection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		AbstractXMPPConnection conn=getConnection();
		System.out.println(conn);
	}
}
