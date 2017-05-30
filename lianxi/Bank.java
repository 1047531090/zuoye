package lianxi;

import java.util.*;
public class Bank {
	public static Scanner sc = new Scanner(System.in);
	public static Client[] a = new Client[100];
	public static int cd = 21000;

	public static void main(String[] args) {
		menu();
	}

	//菜单
	public static void menu(){
		System.out.println("---------------------------------------------");
		System.out.println("---------------------BANK--------------------");
		System.out.println("---------------------------------------------");
		System.out.println("-------------------1.创建账户----------------");
		System.out.println("-------------------2.查询账户信息------------");
		System.out.println("-------------------3.存款--------------------");
		System.out.println("-------------------4.取款--------------------");
		System.out.println("-------------------5.更改账户信息------------");
		System.out.println("-------------------6.注销账号----------------");
		System.out.println("-------------------7.退出--------------------");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		String y = sc.next();
		switch(y){
			case "1":Input();break;
			case "2":ChaXun() ;break;
			case "3":Cun() ;break;
			case "4":Qu() ;break;
			case "5":Change() ;break;
			case "6":Zx() ;break;
			case "7":Exit() ;break;
			default:System.out.println("输入有误,请重新输入");menu();
		}
		
	}

	//1.创建账户
	public static void Input(){
		int i;
		double bac = 0;
		cd = cd + 1;
		String cr = cd + "";
		for(i=0;i<a.length;i++){
			if(a[i]==null){
				System.out.println("请输入姓名");
				String v = sc.next();
				System.out.println("请设置密码");
				String h = sc.next();
				Client p = new Client(cr,v,h,bac);
				a[i]=p;
				break;
			}

		}
		System.out.println("建户成功，是否存入现金？");
		System.out.println("1.存钱");
		System.out.println("2.返回菜单");
		String t = sc.next();
		switch(t){
			case "1":Cun();break;
			case "2":menu();break;
			default:System.out.println("输入有误");menu();
		}
		
	}

	//2.查询
	public static void ChaXun(){
		int i;
		System.out.println("1.查询全部客户信息");
		System.out.println("2.查询指定客户信息");
		String b = sc.next();
		switch(b){
			case "1":
				for(i=0;i<a.length;i++){
					if(a[i]!=null){
						a[i].info();
					}
				}
				;break;
			case "2":
				System.out.println("请输入银行卡号");
				String yc = sc.next();
				for(i=0;i<a.length;i++){
					if(a[i]!=null && yc.equals(a[i].bkcard)){
						a[i].info();
					}
				}
				;break;
			default:System.out.println("输入有误");menu();
		}
		System.out.println("1.继续查询");
		System.out.println("2.返回菜单");
		String jf = sc.next();
		switch(jf){
			case "1":ChaXun();break;
			case "2":menu();break;
		}
	}

	//3.存款
	public static void Cun(){
		boolean bo = true;
		System.out.println("请输入银行卡号:");
		String kh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && kh.equals(a[i].bkcard)){
				while(bo){
					System.out.println("请输入存款金额:");
					double je = sc.nextDouble();
					a[i].balance = a[i].balance + je;
					System.out.println("存款成功");
					System.out.println("1.继续存款");
					System.out.println("2.返回菜单");
					String cf = sc.next();
					switch(cf){
						case "1":bo=true;break;
						case "2":bo=false;break;
					}
				}
				break;
			}
		}
		menu();
	}

	//取款
	public static void Qu(){
		boolean qu = true;
		System.out.println("请输入银行卡号:");
		String kh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && kh.equals(a[i].bkcard)){
				System.out.println("请输入密码");
				String pw = sc.next();
				if(pw.equals(a[i].key)){
					System.out.println("请输入取款金额");
					double qj = sc.nextInt();
					if(a[i].balance - qj <0){
						System.out.println("余额不足");
					}else{
						a[i].balance=a[i].balance-qj;
					}
				}else{
					System.out.println("密码错误");
				}
				break;
			}
		}
		System.out.println("1.返回菜单");
		System.out.println("2.继续取款");
		String jf = sc.next();
		switch(jf){
			case "1":menu();break;
			case "2":Qu();break;
		}
	}

	//更改账户信息
	public static void Change(){
		boolean pd = false;
		System.out.println("请输入要更改的账户号码");
		String zh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && zh.equals(a[i].bkcard)){
				pd = true;
				System.out.println("请输入密码");
				String na = sc.next();
				if(na.equals(a[i].key)){
					System.out.println("1.修改名字");
					System.out.println("2.修改密码");
					String xg = sc.next();
					switch(xg){
						case "1":
							System.out.println("请输入新名");
							String nm = sc.next();
							a[i].name=nm;
							break;
						case "2":
							System.out.println("请输入原密码");
							String pnm = sc.next();
							if(pnm.equals(a[i].key)){
								System.out.println("请输入新密码");
								String xm = sc.next();
								System.out.println("再次确认密码");
								String xxm = sc.next();
								if(xxm.equals(xm)){
									a[i].key=xxm;
								}else{
									System.out.println("密码不符");
								}
								
							}else{
								System.out.println("密码错误");
							}
							break;
					}
				}else{
					System.out.println("密码错误");
				}
				break;
			}
			if(pd==false){
				System.out.println("没有此账号,请确认账号输入正确");
			}
			
		}
		//System.out.println("1.返回菜单");
		menu();
	}


	//注销
	public static void Zx(){
		System.out.println("请输入要注销的账户号码");
		String zh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && zh.equals(a[i].bkcard)){
				System.out.println("请输入账户密码");
				String qr = sc.next();
				if(qr.equals(a[i].key)){
					a[i]=null;
					System.out.println("注销成功");
					break;
				}else{
					System.out.println("密码错误");
					break;
				}
			}
		}
		menu();
	}


	//退出
	public static void Exit(){
		System.exit(0);
	}



}
