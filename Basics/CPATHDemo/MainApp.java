//MainApp.java
import com.nt.wish.WishMessageGenerator;

public class MainApp
{
	public static void main(String args[]){
          WishMessageGenerator generator=new WishMessageGenerator();
		  System.out.println("result::"+generator.sayHello("raja"));
	}
}