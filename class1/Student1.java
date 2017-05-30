package class1;

import java.lang.reflect.Field;

public class Student1 {
	public static void main(String[] args) {
		Class<Student> student = Student.class;
		System.out.println(studentClass.getName());
		Field[] field = studentClass.getDeclaredFields();
		
		for(Field f:field){
			f.setAccessible(true);
			
			System.out.println(f.getName()+" "+f.isAccessible());
		}
		
		
		
	}
}
