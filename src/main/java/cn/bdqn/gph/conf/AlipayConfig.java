package cn.bdqn.gph.conf;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016102300742399";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDzbUMKhnoDc3qqNkx/CBhwcwcLLM2JkDp7mLjMACPdXAY4U38KzbG9ih9mPIN59LrE0fMOUDiJ4AjTfpz5bgfe6o2I/9G+2XyXyPYipbiP2GGuADbVAsFW+jz5qLjjcCXxFgnOMfHmhHn/fgMS8eMSOuECabT54C7qI0nXmzFoXj5XPA3Lgd6ZzPFfw3Yw2mRMs0+0FRKGVnwCh136JV5n14XicZfziJCnhGcbhP5U3Lxvt2SK/obkSBF0J972mqqAo63lpC8wemkWtiscljCl5S+4hNMHgtcCuPGZvRxJIX0JsSRa4o1p08dCfG1h77Zb8MJajuA/DOeYgn7OT/LAgMBAAECggEAARLuBLlbGK70HJNfoa6iPOmtVhVvKGPLZ5yPpbZAaurUDP/Y+NMJUTm0PsG+Ryq6Zzvy+9EDnFQiESeTgNpAU9FYI7TLYbKus/jee+c1L4bArq5VI3Rd2p9TGJmqfhwrk5D//uHRjujMeI1zNfZwG86ETMEfYN6kB+NpswZr8HhLWAGlxAAFtX6qlmbY9hpyOomXa6AzMVjRQG0gdILSJKZvFaNZ4bKLe0UMx/9mRGZ3CCEvjGXOYa8eOdTaYxgDP/bjkOHyOOX2eWC7xD3NTVXN8JSU0UTpyIWmAAdKoaurq898l0PZOaRmRsicr9MaPR+VZ744dl9E4QZJD8lqUQKBgQDKsJY8cHybCQHrZsPC8rW+H6rjhK6Qkvj8btgOK8go6Xbl7dOU7iXSjVwOCPp95AiJB+tEJ1JHdRSzqqL8gUZ7nQr0bFRwpWiNz/bPnMWW4YXqbBP3DpVdBKe8tUsSqp2iuV0gEWLN/Qro8LSvMN0giUYaSeg66rqWxVL8Qo+ALwKBgQCmeD2z8fDYD2r+/TRoKmmONTZvYC/BDl9b8xyLKAoO2qr+XFG/zX95+/RTnPPwTng/66PQRM7HB5CaLGYZ5UrmbrLLTWjoE2zV6d1BKcTyO5/qYO/1AEy7E5W4ADCovrYvOUYYJ50dTeJuPDTqGWG4F624aWUjx0iu7KKq7iCXJQKBgA8sTPLVUN6iO/yNQtZTKPvEjxxdEFxORElRWuckq+U0JOxtc0tQ0JAEeQGr9mR6L5FigGAnuWcUAqq4eV8Bpm8WgH1vppqQJ1WGXemIyNnUpBu6X3w9IT1HXe8oeyg4kXhe+/OsmYLmEG0Dp+L9e3A2FoNdSP8wFyu2NdIggXGNAoGBAInmFy8GH33Ln9WkyJH1eEVOPU6bvlNNZZ8Uz7NSsqpFZ9qXfTzGrW/OUEInRUfuqNxChgvTw/rJgHbGirmu4JHsZ33UHTAKT2EQfrEpObVzwO/15zDsU6OxAJhQx/4xJVgPOMpvnk4VI5ovk6HM7s8CBm06GYc+4S3OZp3z7tllAoGBALuwBG50B3aii9vVsHNt3j4L6HGOViHRiuLN+9CmTzLu9kwAyhavljCGui2wlb0NeHVj5ye1hHsOdOhas7uNADb9nAFXPfHAemClSJ92mRhQ8P6n+b3hHe2wGhO1gxoHBmtAZsw3FRjS+ot0Qi6Ocq36mvRh2VcdYuW2vFszugvJ";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:80/gph/success";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://localhost:80/gph/success";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhdmnXdN61CXyEBTqE49IkAUv9Z1azbZGa9MYT+XWPovckjE/KazAFC3EZYxYf4XNqEfUetTKUV1Hyy8KBhJjy5wnvRDE5Z/b5l4UVoQ/x4c0ru+lBteSXcEw8o2ar927Iicry7aC669TBvqxP8aKUOLuzBHdPKmnO5eAazYazhAf5xM1cY5JwtJcJNM3VpzkhPVuXrEDwbzIA7PDh+3jI+VV4acs/yrKJr4s9ZZ192ge4cgTRvr2KMvL9c0ht5YKnY2AVYFa3mt8wkXNHYey3DLVvr6jZGtNu1T5r2HVYNVjTSZGyyAULHPuK86wuJbQhcmMFTDbir/zQ5ifc5gliwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";

	/**     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）     * @param sWord 要写入日志里的文本内容     */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
