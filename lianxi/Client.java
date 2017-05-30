package lianxi;

public class Client{
	public String name;
	public String bkcard;
	public String key;
	public double balance;

	public Client(String bkcard,String name,String key,double balance){
		this.bkcard=bkcard;
		this.name=name;
		this.key=key;
		this.balance=balance;
	}

	public void info(){
		System.out.println(bkcard+"\t"+name+"\t"+balance);
	}



} 
