package com.changhong.smark;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;

import junit.framework.TestCase;

public class SendMessage extends TestCase {
	public void testSendMessage() throws SmackException{
		AbstractXMPPConnection conn = null;
		try {
			conn = GetXMPPConnection.getConnection();
			conn.connect();
			conn.login("user1", "user1");

			// 发送消息
			ChatManager chatmanager = ChatManager.getInstanceFor(conn);
			Chat newChat = chatmanager.createChat("user2@wyl-pc");
			newChat.sendMessage("你好，我是用户1");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetXMPPConnection.closeConnection(conn);;
		}
	}

}
