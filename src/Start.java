import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to EXIT Student App");
			
			int c=Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				//Add Student
				System.out.println("Enter User name:");
				String name=br.readLine();
				
				System.out.println("Enter User phone:");
				String phone=br.readLine();
				
				System.out.println("Enter User City:");
				String city=br.readLine();
				
				//create student object to store student
				Student st=new Student(name, phone, city);
				boolean ans=StudentDao.insertStudentToDB(st);
				
				if(ans)
				{
					System.out.println("Student is Successfully Added!");
				}
				else
				{
					System.out.println("Problem Encountered!");
				}
				
				System.out.println(st);
			}
			else if(c==2)
			{
				//Delete
				System.out.println("Enter the Student Id to Delete record: ");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				
				if(f)
				{
					System.out.println("Deleted Successfully!");
					
				}
				else {
					System.out.println("Something Went Wrong!");
				}
				
			}
			else if(c==3)
			{
				//Display
				StudentDao.showAll();
			}
			else if(c==4)
			{
				//Exit
				break;
			}
			else
			{
				//do nothing
			}

			
		}
		
		System.out.println("Thank you For Using Student Management App!");
		

	}

}
