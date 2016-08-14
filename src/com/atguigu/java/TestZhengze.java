package com.atguigu.java;
/**
 * 对qq号进行校验；要求5-15,0不能开头，只能是数字
 *TestZhengze.java类：
 *@Author williams
 *2016年4月7日
 */
public class TestZhengze {
	public static void main(String[] args) {
		//checkQQ();
		checkQQ1();
	}
	public static void checkQQ1(){
		String qq="2-4511119";
		String regex="[1-9][0-9]{5,15}";
		boolean flag=qq.matches(regex);
		if (flag) {
			System.out.println(qq);
		}else {
			System.out.println("qq号不合法");
		}
	}
	public static void checkQQ(){
		String qq="023111111111119";
		int len=qq.length();
		if (len>=5&& len<=15) {	//先判断长度
			if (!qq.startsWith("0")){//判断开头
				char[] ch=qq.toCharArray();
					boolean flag=true;
				for (int i = 0; i < ch.length; i++) {//这里需要做标记否则很难判断			
					if (!(ch[i]>='0'&&ch[i]<='9')) {//判断字母
						flag=false;
						break;					
					}
				}	
				if (flag) {
					System.out.println(qq);
				}else {
					System.out.println("不能出现字母");
				}
					
			}else {//如果以0开头
				System.out.println("0开头了");
			}
		}else {
			System.out.println("长度非法");
		}
	}
}

