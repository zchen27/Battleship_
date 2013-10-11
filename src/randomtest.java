import java.lang.reflect.*;

public class randomtest
{
	public static void main(String[] s)
	{
		Position p = new Position(1, 2);
		Field[] fields = p.getClass().getDeclaredFields();
		System.out.println(fields.length);
	}
}
