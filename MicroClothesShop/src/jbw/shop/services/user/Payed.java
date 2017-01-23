package jbw.shop.services.user;

import java.sql.SQLException;
import java.util.Date;

import jbw.shop.dao.ExecuteSQL;
import jbw.shop.domain.Order;
import jbw.shop.utils.PayMentUtils;

public class Payed {
	public String payed(String oid, String uname,String bank) {
		ExecuteSQL esql = new ExecuteSQL();
		double mon=0;
		Order order = null;
		try {
			order = esql.getOrderById(oid);
			 mon= order.getO_money();
			mon = mon + esql.queryUserByName(uname).getU_cmoney();
			esql.updateUserMon(mon, uname);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String p0_Cmd = "Buy";// 业务类型，固定�?�为buy，即“买�?
		String p1_MerId = "10001126856";// 在易宝注册的商号
		String p2_Order = oid;// 订单编号
		String p3_Amt = 0.01+"";// 支付的金�?
		String p4_Cur = "CNY";// 交易种币，固定�?�为CNY，表示人民币
		String p5_Pid = "";// 商品名称
		String p6_Pcat = "";// 商品各类
		String p7_Pdesc = "";// 商品描述
		String p8_Url = "http://localhost/MicroClothesShop/servlet/EPaySeccess";// 电商的返回页面，当支付成功后，易宝会重定向到这个页面
		String p9_SAF = "";// 送货地址
		String pa_MP = "";// 商品扩展信息
		String pd_FrpId = bank;// 支付通道，即选择银行
		String pr_NeedResponse = "1";// 应答机制，固定�?�为1

		// 密钥，由易宝提供，只有商户和易宝知道这个密钥�?
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// 通过上面的参数�?�密钥�?�加密算法，生成hmac�?
		// 参数的顺序是必须的，如果没有值也不能给出null，�?�应该给出空字符串�??
		String hmac = PayMentUtils.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		
		// 把所有参数连接到网关地址后面
		String url = "https://www.yeepay.com/app-merchant-proxy/node";
		url += "?p0_Cmd=" + p0_Cmd + 
				"&p1_MerId=" + p1_MerId +
				"&p2_Order=" + p2_Order + 
				"&p3_Amt=" + p3_Amt + 
				"&p4_Cur=" + p4_Cur + 
				"&p5_Pid=" + p5_Pid + 
				"&p6_Pcat=" + p6_Pcat + 
				"&p7_Pdesc=" + p7_Pdesc + 
				"&p8_Url=" + p8_Url + 
				"&p9_SAF=" + p9_SAF + 
				"&pa_MP=" + pa_MP + 
				"&pd_FrpId=" + pd_FrpId + 
				"&pr_NeedResponse=" + pr_NeedResponse + 
				"&hmac=" + hmac;
//		System.out.println(url);
		// 重定向到网关
		
		
		
		
		
		order.setO_pdate(new Date());
		order.setO_statu(1);
		esql.updateOrderStatu(order);
		esql.updateOrderPayTime(order);
		return url;
	}
}
