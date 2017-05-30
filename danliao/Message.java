package danliao;

import java.io.Serializable;

public class Message implements Serializable{
	private String toNam;//接收人的名字
	private String fromName;//发送人的名字
	private String message;//盛放消息的内容
	private int type;//消息类型
	
}
