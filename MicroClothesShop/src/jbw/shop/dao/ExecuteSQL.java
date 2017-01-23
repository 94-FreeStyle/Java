/**
 * @author Kevin
 * @version 1.0
 * @date 2015.7
 */
package jbw.shop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jbw.shop.domain.Admin;
import jbw.shop.domain.Clothes;
import jbw.shop.domain.Clothes_Order_Map;
import jbw.shop.domain.Clothes_User_Map;
import jbw.shop.domain.Order;
import jbw.shop.domain.RuKuRecord;
import jbw.shop.domain.TuiOrder;
import jbw.shop.domain.User;
import jbw.shop.utils.ByteID;
import jbw.shop.utils.C3P0JDBCUtil;
import jbw.shop.utils.MapBeanMapping;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ExecuteSQL {
	private QueryRunner qr = new QueryRunner(C3P0JDBCUtil.getDataSource());
	private String sql = null;

	// 通过用户名查询管理员
	public Admin queryAdminByName(String name) {
		Admin admin = null;
		sql = "select * from admin where a_name=?";
		ResultSetHandler<Admin> rsh = new BeanHandler<Admin>(Admin.class);
		try {
			admin = qr.query(sql, rsh, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}

	// 验证管理员是否存�?
	public boolean isExitsAdmin(String name) {
		long num = 0;
		sql = "select count(*) from admin where a_name=?";
		try {
			num = (Long) qr.query(sql, new ScalarHandler(), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		if (num == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 通过用户名查询用�?
	public User queryUserByName(String name) {
		User user = null;
		sql = "select * from user where u_name=?";
		ResultSetHandler<User> rsh = new BeanHandler<User>(User.class);
		try {
			user = qr.query(sql, rsh, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("沒有此用�?");
		}
		return user;
	}

	// 判斷數據庫中是否有一條用户記�?
	public boolean isExist(String name) {
		long num = 0;
		sql = "select count(*) from user where u_name=?";
		try {
			num = (Long) qr.query(sql, new ScalarHandler(), name);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		if (num == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 添加�?个用户到数据库中
	public void addUser(User user) {
		sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, user.getU_id(), user.getU_name(),
					user.getU_address(), user.getU_phone(), user.getU_code(),
					user.getU_mail(), user.getU_tax(), user.getU_bankname(),
					user.getU_banknum(), user.getU_glory(), user.getU_pw(),
					user.getU_sex(),user.getU_cmoney(),user.getU_image());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 跟改密碼
	public void updateUserPW(String name, String pw) throws SQLException {
		sql = "update user set u_pw=? where u_name=?";
		qr.update(sql, pw, name);
		System.out.println("Update pw Success!");
	}

	// 查詢衣服記錄總數
	public long getClothesCount() {
		long num = 0;
		sql = "select count(*) from clothes";
		try {
			num = (Long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 分頁查詢衣服
	public List<Clothes> queryByPage(int offset, int len) throws SQLException {
		sql = "select * from clothes limit ?,?";
		return qr.query(sql, new BeanListHandler<Clothes>(Clothes.class),
				offset, len);

	}

	// 组合查询分页显示的数�?
	public long getMCount(Clothes criteria, double mp) {
		long num = 0;

		StringBuilder sb = new StringBuilder(
				"select count(*) from clothes where 1=1");
		List<Object> parmes = new ArrayList<Object>();

		String brand = criteria.getC_brand();
		if (brand != null && !brand.trim().isEmpty()) {
			sb.append(" and c_brand=?");
			parmes.add(brand);
		}
		String color = criteria.getC_color();
		if (color != null && !color.trim().isEmpty()) {
			sb.append(" and c_color like ?");
			parmes.add("%" + color + "%");
		}
		String style = criteria.getC_style();
		if (style != null && !style.trim().isEmpty()) {
			sb.append(" and c_style like ?");
			parmes.add("%" + style + "%");
		}
		double price = criteria.getC_price();
		if (!(price < 0) && (mp > price)) {
			sb.append(" and c_price > ? and c_price < ?");
			parmes.add(price);
			parmes.add(mp);
		}
		try {
			num = (Long) qr.query(sb.toString(), new ScalarHandler(),
					parmes.toArray());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 组合查询分页显示
	public List<Clothes> queryzuByPage(Clothes criteria, double mp, int offset,
			int len) throws SQLException {
		StringBuilder sb = new StringBuilder("select * from clothes where 1=1");
		List<Object> parmes = new ArrayList<Object>();

		String brand = criteria.getC_brand();
		if (brand != null && !brand.trim().isEmpty()) {
			sb.append(" and c_brand=?");
			parmes.add(brand);
		}
		String color = criteria.getC_color();
		if (color != null && !color.trim().isEmpty()) {
			sb.append(" and c_color like ?");
			parmes.add("%" + color + "%");
		}
		String style = criteria.getC_style();
		if (style != null && !style.trim().isEmpty()) {
			sb.append(" and c_style like ?");
			parmes.add("%" + style + "%");
		}

		double price = criteria.getC_price();
		if (!(price < 0) && (mp > price)) {
			sb.append(" and c_price > ? and c_price < ?");
			parmes.add(price);
			parmes.add(mp);
		}
		sb.append(" limit ?,?");
		parmes.add(offset);
		parmes.add(len);
		return qr.query(sb.toString(), new BeanListHandler<Clothes>(
				Clothes.class), parmes.toArray());

	}

	// 判斷购物车中是否有一條服装記�?
	public long isExistClo(String cid) {
		long num = 0;
		sql = "select count(*) from cum where c_id=?";
		try {
			num = (Long) qr.query(sql, new ScalarHandler(), cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 根据ID查询衣服
	public Clothes getClothesById(String id) throws SQLException {
		sql = "select * from clothes where c_id=?";
		ResultSetHandler<Clothes> rsh = new BeanHandler<Clothes>(Clothes.class);
		return qr.query(sql, rsh, id);
	}

	// 添加购物�?
	public void addCart(String id, int num, String packages, String user)
			throws SQLException {
		Clothes_User_Map cum = new Clothes_User_Map();
		User tuser = this.queryUserByName(user);
		cum.setM_id(ByteID.uuid());
		cum.setC_id(id);
		cum.setC_num(num);
		cum.setM_statu(0);
		cum.setPackages(packages);
		sql = "insert into cum values(?,?,?,?,?,?)";
		qr.update(sql, cum.getM_id(), cum.getC_id(), cum.getC_num(),
				tuser.getU_id(), cum.getM_statu(), cum.getPackages());
	}

	// 查询购物车的内容
	public List<Clothes_User_Map> queryAllCart(String uname)
			throws SQLException {
		sql = "select * from cum c,user u where c.u_id=u.u_id and u.u_name=?";
		List<Map<String, Object>> maplist = qr.query(sql, new MapListHandler(),
				uname);
		List<Clothes_User_Map> buList = new ArrayList<Clothes_User_Map>();
		for (Map<String, Object> map : maplist) {
			User user = MapBeanMapping.toBean(map, User.class);
			Clothes clothes = MapBeanMapping.toBean(map, Clothes.class);
			Clothes_User_Map bu = MapBeanMapping.toBean(map,
					Clothes_User_Map.class);
			bu.setUser(user);
			bu.setClothes(clothes);
			buList.add(bu);
		}
		return buList;
	}

	// 写入服装记录
	public void addClothes(Clothes clo) throws SQLException {
		sql = "insert into clothes values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, clo.getC_id(), clo.getC_name(), clo.getC_brand(),
				clo.getC_product(), clo.getC_size(), clo.getC_style(),
				clo.getC_color(), clo.getC_metra(), clo.getC_package(),
				clo.getC_sellednum(), clo.getC_surplusnum(), clo.getC_image(),
				clo.getC_price(), clo.getC_semester(), clo.getC_people(),
				clo.getC_discount());
	}

	// 根据ID查询购物�?
	public Clothes_User_Map getCUMById(String id) throws SQLException {
		sql = "select * from cum where c_id=?";
		ResultSetHandler<Clothes_User_Map> rsh = new BeanHandler<Clothes_User_Map>(
				Clothes_User_Map.class);
		return qr.query(sql, rsh, id);
	}

	// 更新购物�?
	public void updateCart(String id, int num) throws SQLException {
		sql = "update cum set c_num=? where c_id=?";
		qr.update(sql, num, id);
	}

	// 根据cid删除�?条购物车记录
	public void deleteCart(String id) throws SQLException {
		sql = "delete from cum where c_id=?";
		qr.update(sql, id);
	}

	// 保存订单
	public void addOrder(Order or) {
		sql = "insert into orders(o_id,o_tdate,o_money,u_id,o_statu,a_id) values (?,?,?,?,?,?)";
		try {
			qr.update(sql, or.getO_id(), or.getO_tdate(), or.getO_money(),
					or.getU_id(), or.getO_statu(), "101");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 保存订单�?对应的服�?
	public void addOrderClo(Clothes_Order_Map com) {
		sql = "insert into com values(?,?,?,?)";
		try {
			qr.update(sql, com.getM_id(), com.getO_id(), com.getC_id(),
					com.getC_num());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 根据订单号查询订�?
	public Order getOrderById(String id) throws SQLException {
		sql = "select * from orders where o_id=?";
		ResultSetHandler<Order> rsh = new BeanHandler<Order>(Order.class);
		return qr.query(sql, rsh, id);
	}

	// 更新订单状�??
	public void updateOrderStatu(Order order) {
		sql = "update orders set o_statu=? where o_id=?";
		try {
			qr.update(sql, order.getO_statu(), order.getO_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 更新订单支付时间
	public void updateOrderPayTime(Order order) {
		sql = "update orders set o_pdate=? where o_id=?";
		try {
			qr.update(sql, order.getO_pdate(), order.getO_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 更新订单提交时间
	public void updateOrderTiTime(Order order) {
		sql = "update orders set o_tdate=? where o_id=?";
		try {
			qr.update(sql, order.getO_tdate(), order.getO_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 更新订单收货时间
	public void updateOrderShouTime(Order order) {
		sql = "update orders set o_qdate=? where o_id=?";
		try {
			qr.update(sql, order.getO_qdate(), order.getO_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 更新订单发货时间
	public void updateOrderFaTime(Order order) {
		sql = "update orders set o_fdate=? where o_id=?";
		try {
			qr.update(sql, order.getO_fdate(), order.getO_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 根据用户查询用户�?有的订单
	public List<Order> getOrderByUser(String uname) throws SQLException {
		User user = this.queryUserByName(uname);
		sql = "select * from orders where u_id=?";
		ResultSetHandler<List<Order>> rsh = new BeanListHandler<Order>(
				Order.class);
		return qr.query(sql, rsh, user.getU_id());
	}

	// 更新管理员上次登录时�?
	public void updateAdminLoginTime(String name) {
		Admin admin = this.queryAdminByName(name);
		sql = "update admin set a_lt=? where a_id=?";
		try {
			qr.update(sql, new Date(), admin.getA_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询�?有的服装
	public List<Clothes> queryAllClothes() throws SQLException {
		sql = "select * from clothes";
		return qr.query(sql, new BeanListHandler<Clothes>(Clothes.class));

	}

	// 查询�?有的用户
	public List<User> queryAllUser() throws SQLException {
		sql = "select * from user";
		return qr.query(sql, new BeanListHandler<User>(User.class));

	}

	// 查询�?有的订单
	public List<Order> queryAllOrder() throws SQLException {
		sql = "select * from orders";
		return qr.query(sql, new BeanListHandler<Order>(Order.class));

	}

	// 删除�?件服�?
	public void deleteClothes(String cid) {
		sql = "delete from clothes where c_id=?";
		try {
			qr.update(sql, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 删除�?个订�?
	public void deleteOrder(String oid) {
		sql = "delete from orders where o_id=?";
		try {
			qr.update(sql, oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 删除�?个用�?
	public void deleteUser(String uid) {
		sql = "delete from user where u_id=?";
		try {
			qr.update(sql, uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询用户总数
	public long getUserCount() {
		long num = 0;
		sql = "select count(*) from user";
		try {
			num = (Long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 查询订单总数
	public long getOrderCount() {
		long num = 0;
		sql = "select count(*) from orders";
		try {
			num = (Long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 查询待发货订单�?�数
	public long getFaOrderCount() {
		long num = 0;
		sql = "select count(*) from orders where o_statu=1";
		try {
			num = (Long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 查询�?补货衣服总数
	public long getBuClothCount() {
		long num = 0;
		sql = "select count(*) from clothes where c_surplusnum<50";
		try {
			num = (Long) qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	// 更新服裝（在編輯服裝時使用）
	public void updateEditClothes(Clothes cloth) {
		sql = "update clothes set c_name=?,c_image=?,c_brand=?,c_product=?,c_size=?,c_style=?,c_color=?,c_metra=?,c_price=?,c_discount=?,c_semester=?,c_people=?,c_surplusnum=?,c_package=? where c_id=?";
		try {
			qr.update(sql, cloth.getC_name(), cloth.getC_image(),
					cloth.getC_brand(), cloth.getC_product(),
					cloth.getC_size(), cloth.getC_style(), cloth.getC_color(),
					cloth.getC_metra(), cloth.getC_price(),
					cloth.getC_discount(), cloth.getC_semester(),
					cloth.getC_people(), cloth.getC_surplusnum(),
					cloth.getC_package(), cloth.getC_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 根据订单ID查询订单对应的所有商�?
	public List<Clothes_Order_Map> getOrderCloth(String oid)
			throws SQLException {
		sql = "select * from com where o_id=?";
		ResultSetHandler<List<Clothes_Order_Map>> rsh = new BeanListHandler<Clothes_Order_Map>(
				Clothes_Order_Map.class);
		return qr.query(sql, rsh, oid);
	}

	// 更新服装库存
	public void updateKucun(int num, String cid) {
		sql = "update clothes set c_surplusnum=? where c_id=?";
		try {
			qr.update(sql, num, cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询用户购物车中某一件商品的数量
	public Clothes_User_Map getCUMClothNum(String uid, String cid)
			throws SQLException {
		sql = "select * from cum where u_id=? and c_id=?";
		ResultSetHandler<Clothes_User_Map> rsh = new BeanHandler<Clothes_User_Map>(
				Clothes_User_Map.class);
		return qr.query(sql, rsh, uid, cid);
	}

	// 更新用户消费总额
	public void updateUserMon(double num, String uname) {
		sql = "update user set u_cmoney=? where u_name=?";
		try {
			qr.update(sql, num, uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 根据订单ID查询订单对应的所有商�?
	public List<User> getTopUsers() throws SQLException {
		sql = "select * from user order by u_cmoney desc limit 0,5";
		ResultSetHandler<List<User>> rsh = new BeanListHandler<User>(User.class);
		return qr.query(sql, rsh);
	}

	// 保存入库记录
	public void addRuKuRecord(RuKuRecord rkr) {
		sql = "insert into ruku values(?,?,?,?,?)";
		try {
			qr.update(sql, rkr.getR_id(), rkr.getC_id(), rkr.getR_date(),
					rkr.getR_num(), rkr.getA_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询�?有入库记�?
	public List<RuKuRecord> getAllRuKuRecord() throws SQLException {
		sql = "select * from ruku";
		ResultSetHandler<List<RuKuRecord>> rsh = new BeanListHandler<RuKuRecord>(
				RuKuRecord.class);
		return qr.query(sql, rsh);
	}

	// 按状态查询订�?
	public List<Order> getOrderByStatu(int statu) throws SQLException {
		sql = "select * from orders where o_statu=?";
		ResultSetHandler<List<Order>> rsh = new BeanListHandler<Order>(
				Order.class);
		return qr.query(sql, rsh, statu);
	}

	// 更新用户头像
	public void updateUserImg(String img, String uname) {
		sql = "update user set u_image=? where u_name=?";
		try {
			qr.update(sql, img, uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 添加订单发货�?
	public void updateFaHouAdmin(String aid, String oid) {
		sql = "update orders set a_id=? where o_id=?";
		try {
			qr.update(sql, aid, oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 得到�?有的�?进货商品
	public List<Clothes> getAllJiaClothes() throws SQLException {
		sql = "select * from clothes where c_surplusnum < 50";
		ResultSetHandler<List<Clothes>> rsh = new BeanListHandler<Clothes>(
				Clothes.class);
		return qr.query(sql, rsh);
	}

	// 添加�?个�??货记录到数据库中
	public void addTuiHuoRecord(TuiOrder to) {
		sql = "insert into tui values(?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, to.getT_id(), to.getO_id(), to.getT_date(),
					to.getT_reson(), to.getA_id(), to.getT_odate(),
					to.getO_money(), to.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 得到�?有的�?货记�?
	public List<TuiOrder> getAllTuiRecord() throws SQLException {
		sql = "select * from tui";
		ResultSetHandler<List<TuiOrder>> rsh = new BeanListHandler<TuiOrder>(
				TuiOrder.class);
		return qr.query(sql, rsh);
	}

	// 處理�?�?
	public void updateTuiHuo(TuiOrder to) {
		sql = "update tui set a_id=?,t_odate=? where o_id=?";
		try {
			qr.update(sql, to.getA_id(), to.getT_odate(), to.getO_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 根据oid得到�?货记�?
	public TuiOrder getTuiOrder(String oid) throws SQLException {
		sql = "select * from tui where o_id=?";
		ResultSetHandler<TuiOrder> rsh = new BeanHandler<TuiOrder>(
				TuiOrder.class);
		return qr.query(sql, rsh, oid);
	}
}
