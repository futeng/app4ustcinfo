import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KickRiBaoAss {

	public static void main(String[] args) throws IOException, ParseException {
		
		System.out.println("**********\t国创日报链接获取器 Kick Ri Bao ass v1.0\t**********");
		System.out.println("**\t\t\t\t\t\t\t\t**");
		System.out.println("** 输入查询日报日期，例如：0329，回车后将获取该日报编辑页面。\t**");
		System.out.println("**\t\t\t\t\t\t\t\t**");
		System.out.println("**\t\t\t\t\tifuteng@gmail.com\t**\r\n");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String date = "";
		while(true) {
			System.out.print("日报日期>");
			date = input.readLine();
			if("exit".equals(date)) {
				System.exit(0);
			}
			System.out.println(date+"这天日报的链接地址为："+getLink(date));
		}
	}

	private static String getSuffix(String date) throws ParseException {
		String riBaoDate = TEMPLATE.replace("MMdd", date);
		long linkSuffix = FORMAT.parse(riBaoDate).getTime() / 1000;
		return String.valueOf(linkSuffix);
	}
	
	private static String getLink(String date) throws ParseException {
		return LINK.replace("SUFFIX", getSuffix(date));
	}
	
	private static String TEMPLATE = "2013/MMdd 08:00:00";
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MMdd HH:mm:ss");
	private static String LINK = "http://www.starit.com.cn/in/modules/prj/rep_daily.php?rep_time=SUFFIX";
	
}