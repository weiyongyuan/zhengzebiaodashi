public class RegexDemo{
	public static void main(String[]args){
		String regex="[1-9][0-9]{4-14}";
		checkQQ("0122434",regex);
	}
	
	public static void checkQQ(String qq,String regex){
		boolean flag=qq.matches(regex);
		if(flag)
			System.out.println("qq is ok");
		else
			System.out.println("qq nonno");
	}
}