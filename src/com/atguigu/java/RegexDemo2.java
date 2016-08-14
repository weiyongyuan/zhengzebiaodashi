package com.atguigu.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexDemo2 {
	public static void main(String[] args) {
		String str="<td align=\"center\">"
				+ "<img src=\"http://static.ppdai.com/app_themes/images/head/nophoto_120.gif\" alt=\"pdu1300487708\" title=\"pdu1300487708\" width=\"50\" height=\"50\"/><br>"
				+ "<a href=\"/user/pdu1300487708\" target=\"_blank\">pdu1300487708</a>"
				+ "</td>"
				+ "<td valign=\"top\">"
				+ "<p>真实姓名:<a href=\"/blacklistdetail/pdu1300487708\" title=\"罗国华\" target=\"_blank\">罗国华</a></p>"
				+ "<p>手机号码:15988070***</p>"
				+ "</td>"
				+ "<td valign=\"top\">"
				+ "<p>累计借入本金:&#165;675.00</p>"
				+ "<p>最大逾期天数:30</p>"
				+ "</td>";
		String regex="<p>(.*?)</p>";
		String aRegex="<a href=\"/\\w+/(.*?)\">(.*?)</a>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb=new StringBuffer();
		while (matcher.find()) {
			System.out.println(matcher.group());
			sb.append(matcher.group());
		}
		System.out.println("===========");
		//匹配a链接
		Pattern aPattern = Pattern.compile(aRegex);
		Matcher aMatcher = aPattern.matcher(sb);
		while (aMatcher.find()) {
			System.out.println(aMatcher.group());
			String group = aMatcher.group();
			String[] split = group.split("[/ ]+");
			for (String s : split) {
				System.out.println(s);
			}
		}
		System.out.println("===========");
		//String reg="[<p><a href=\"(.*?)+\" title=\".*?\" target=\".*?\"></a></p>]+";
		String reg="[<p></p>]+";
		String replaceAll = sb.toString().replaceAll(reg, "\r\n");
		System.out.println(replaceAll);
	}
	
	@Test
	public void test7(){
		String str="<a href=\"/blacklistdetail/pdu1300487708\" title=\"罗国华\" target=\"_blank\">罗国华</a>";
		String regex="[\\/<> \"]+";
		String[] split = str.split(regex);
		for (String s : split) {
			System.out.println(s);
		}
	}
	
	
	//转换成我要学编程，先把.替换调，再把重复的汉字去掉
	@Test
	public void test6(){
		String str="我我...要..要要....学学...学......编.......编编.....程.程";
		String regex="[.]+";
		str=str.replaceAll(regex, "");
		regex="(.)\\1+";
		str=str.replaceAll(regex,"$1");
		System.out.println(str);
		
	}
	
	@Test
	public void test5(){
		String str=" zhangsan |lisi|wangwu|zhaoliu";
		String regex="[ |.]+";
		String[] arr = str.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
	}
	
	@Test
	public void test4(){
		String str="zhangsan lisi wangwu";
		String str1="zhangsan   lisi    wangwu";
		String str2="zhangsan|lisi|wangwu";
		String str3="zhangsan||lisi||wangwu";
		String str4="zhangsan.lisi.wangwu";
		String str5="zhangsan..lisi....wangwu";
		String regex="[ |.]+";
		String[] arr = str.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("================");
		arr = str1.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("================");
		
		arr = str2.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("================");
		
		arr = str3.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("================");
		
		arr = str4.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("================");
		
		arr = str5.split(regex);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		System.out.println("================");
		
		
		
	}
	
	//(.*)\((.*)\)
	//%(\d+\$)?([-#+ 0,(\<]*)?(\d+)?(\.\d+)?([tT])?([a-zA-Z%])
	
	@Test
	public void test3(){
		String phone="13838673775";
		String regex="(.*)((.*))";
		System.out.println(phone.matches(regex));
	}
	
	@Test
	public void testPhone(){
		String phone="13838673775";
		String phone2="138386737751";
		String phone3="148386737751";
		String phone4="13838673775a";
		String regex="1[3578]\\d{9}";
		System.out.println(phone.matches(regex));
		System.out.println(phone2.matches(regex));
		System.out.println(phone3.matches(regex));
		System.out.println(phone4.matches(regex));
		
	}
	
	@Test
	public void test2(){
		String str="a";
		String str2="ab";
		String str3="a1";
		String str4="a-";
		String str5="";
		String str6="d";
		//只能匹配一个字符，且只能是a|b|c开头，出现0-9次，所以空格也是正确的，如果1,9就错了
		String regex="[abc]{2,9}";
		System.out.println(str.matches(regex));
		System.out.println(str2.matches(regex));
		System.out.println(str3.matches(regex));
		System.out.println(str4.matches(regex));
		System.out.println(str5.matches(regex));
		System.out.println(str6.matches(regex));
	}
	
	@Test
	public void test1(){
		String str="a";
		String str2="ab";
		String str3="a1";
		String str4="a-";
		String str5="";
		String str6="d";
		//只能匹配一个字符，且只能是a|b|c
		String regex="[abc]";
		System.out.println(str.matches(regex));
		System.out.println(str2.matches(regex));
		System.out.println(str3.matches(regex));
		System.out.println(str4.matches(regex));
		System.out.println(str5.matches(regex));
		System.out.println(str6.matches(regex));
	}
}
