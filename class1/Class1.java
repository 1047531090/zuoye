package class1;

import java.lang.reflect.Constructor;

public class Class1 {
//	public static void main(String[] args) {
		/*
		 * try {
			Class<?> class1 = Class.forName("java.util.HashMap");
			System.out.println(class1.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		/*
		 * //ͨ��һ�������������İ���������
		Class1 class1 = new Class1();
		System.out.println(class1.getClass().getName());*/
		
		
		/*
		 * //ʵ����Class�����
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		
		try {
			//һ�����������ʽ
			class1 = Class.forName("class1.Class1");
			class2 = new Class1().getClass();
			class3 = Class1.class;
			System.out.println("������    "+class1.getName());
			System.out.println("������    "+class2.getName());
			System.out.println("������    "+class3.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
//	}
	    public static void main(String[] args) throws Exception {
	        Class<?> class1 = null;
	        class1 = Class.forName("class1.User");
	        // ��һ�ַ�����ʵ����Ĭ�Ϲ��췽��������set��ֵ
	        User user = (User) class1.newInstance();
	        user.setAge(20);
	        user.setName("Rollen");
	        System.out.println(user);
	        // ��� User [age=20, name=Rollen]
	        // �ڶ��ַ��� ȡ��ȫ���Ĺ��캯�� ʹ�ù��캯����ֵ
	        Constructor<?> cons[] = class1.getConstructors();
	        // �鿴ÿ�����췽����Ҫ�Ĳ���
	        for (int i = 0; i < cons.length; i++) {
	            Class<?> clazzs[] = cons[i].getParameterTypes();
	            System.out.print("cons[" + i + "] (");
	            for (int j = 0; j < clazzs.length; j++) {
	                if (j == clazzs.length - 1)
	                    System.out.print(clazzs[j].getName());
	                else
	                    System.out.print(clazzs[j].getName() + ",");
	            }
	            System.out.println(")");
	        }
	        // ���
	        // cons[0] (java.lang.String)
	        // cons[1] (int,java.lang.String)
	        // cons[2] ()
	        user = (User) cons[0].newInstance("Rollen");
	        System.out.println(user);
	        // ��� User [age=0, name=Rollen]
	        user = (User) cons[1].newInstance(20, "Rollen");
	        System.out.println(user);
	        // ��� User [age=20, name=Rollen]
	    }
	}
	class User {
	    private int age;
	    private String name;
	    public User() {
	        super();
	    }
	    public User(String name) {
	        super();
	        this.name = name;
	    }
	    public User(int age, String name) {
	        super();
	        this.age = age;
	        this.name = name;
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    @Override
	    public String toString() {
	        return "User [age=" + age + ", name=" + name + "]";
	    }
}
