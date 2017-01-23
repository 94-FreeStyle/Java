package jbw.shop.utils;

import java.util.UUID;

public class ByteID {
	/*生成全球唯一ID
	 * 
	 * 作用�?
	 * 1.作为数据库中字段的唯�?id
	 * 2.作为唯一订单�?
	*/
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
}
