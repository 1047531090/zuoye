package lianxi;

import java.util.*;
public class Bank {
	public static Scanner sc = new Scanner(System.in);
	public static Client[] a = new Client[100];
	public static int cd = 21000;

	public static void main(String[] args) {
		menu();
	}

	//�˵�
	public static void menu(){
		System.out.println("---------------------------------------------");
		System.out.println("---------------------BANK--------------------");
		System.out.println("---------------------------------------------");
		System.out.println("-------------------1.�����˻�----------------");
		System.out.println("-------------------2.��ѯ�˻���Ϣ------------");
		System.out.println("-------------------3.���--------------------");
		System.out.println("-------------------4.ȡ��--------------------");
		System.out.println("-------------------5.�����˻���Ϣ------------");
		System.out.println("-------------------6.ע���˺�----------------");
		System.out.println("-------------------7.�˳�--------------------");
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
			default:System.out.println("��������,����������");menu();
		}
		
	}

	//1.�����˻�
	public static void Input(){
		int i;
		double bac = 0;
		cd = cd + 1;
		String cr = cd + "";
		for(i=0;i<a.length;i++){
			if(a[i]==null){
				System.out.println("����������");
				String v = sc.next();
				System.out.println("����������");
				String h = sc.next();
				Client p = new Client(cr,v,h,bac);
				a[i]=p;
				break;
			}

		}
		System.out.println("�����ɹ����Ƿ�����ֽ�");
		System.out.println("1.��Ǯ");
		System.out.println("2.���ز˵�");
		String t = sc.next();
		switch(t){
			case "1":Cun();break;
			case "2":menu();break;
			default:System.out.println("��������");menu();
		}
		
	}

	//2.��ѯ
	public static void ChaXun(){
		int i;
		System.out.println("1.��ѯȫ���ͻ���Ϣ");
		System.out.println("2.��ѯָ���ͻ���Ϣ");
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
				System.out.println("���������п���");
				String yc = sc.next();
				for(i=0;i<a.length;i++){
					if(a[i]!=null && yc.equals(a[i].bkcard)){
						a[i].info();
					}
				}
				;break;
			default:System.out.println("��������");menu();
		}
		System.out.println("1.������ѯ");
		System.out.println("2.���ز˵�");
		String jf = sc.next();
		switch(jf){
			case "1":ChaXun();break;
			case "2":menu();break;
		}
	}

	//3.���
	public static void Cun(){
		boolean bo = true;
		System.out.println("���������п���:");
		String kh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && kh.equals(a[i].bkcard)){
				while(bo){
					System.out.println("����������:");
					double je = sc.nextDouble();
					a[i].balance = a[i].balance + je;
					System.out.println("���ɹ�");
					System.out.println("1.�������");
					System.out.println("2.���ز˵�");
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

	//ȡ��
	public static void Qu(){
		boolean qu = true;
		System.out.println("���������п���:");
		String kh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && kh.equals(a[i].bkcard)){
				System.out.println("����������");
				String pw = sc.next();
				if(pw.equals(a[i].key)){
					System.out.println("������ȡ����");
					double qj = sc.nextInt();
					if(a[i].balance - qj <0){
						System.out.println("����");
					}else{
						a[i].balance=a[i].balance-qj;
					}
				}else{
					System.out.println("�������");
				}
				break;
			}
		}
		System.out.println("1.���ز˵�");
		System.out.println("2.����ȡ��");
		String jf = sc.next();
		switch(jf){
			case "1":menu();break;
			case "2":Qu();break;
		}
	}

	//�����˻���Ϣ
	public static void Change(){
		boolean pd = false;
		System.out.println("������Ҫ���ĵ��˻�����");
		String zh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && zh.equals(a[i].bkcard)){
				pd = true;
				System.out.println("����������");
				String na = sc.next();
				if(na.equals(a[i].key)){
					System.out.println("1.�޸�����");
					System.out.println("2.�޸�����");
					String xg = sc.next();
					switch(xg){
						case "1":
							System.out.println("����������");
							String nm = sc.next();
							a[i].name=nm;
							break;
						case "2":
							System.out.println("������ԭ����");
							String pnm = sc.next();
							if(pnm.equals(a[i].key)){
								System.out.println("������������");
								String xm = sc.next();
								System.out.println("�ٴ�ȷ������");
								String xxm = sc.next();
								if(xxm.equals(xm)){
									a[i].key=xxm;
								}else{
									System.out.println("���벻��");
								}
								
							}else{
								System.out.println("�������");
							}
							break;
					}
				}else{
					System.out.println("�������");
				}
				break;
			}
			if(pd==false){
				System.out.println("û�д��˺�,��ȷ���˺�������ȷ");
			}
			
		}
		//System.out.println("1.���ز˵�");
		menu();
	}


	//ע��
	public static void Zx(){
		System.out.println("������Ҫע�����˻�����");
		String zh = sc.next();
		for(int i=0;i<a.length;i++){
			if(a[i]!=null && zh.equals(a[i].bkcard)){
				System.out.println("�������˻�����");
				String qr = sc.next();
				if(qr.equals(a[i].key)){
					a[i]=null;
					System.out.println("ע���ɹ�");
					break;
				}else{
					System.out.println("�������");
					break;
				}
			}
		}
		menu();
	}


	//�˳�
	public static void Exit(){
		System.exit(0);
	}



}
