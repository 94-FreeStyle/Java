package jbw.shop.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class MapBeanMapping {
	/*
	 * 此类完成Map集合与javaBean的映�?
	 * 
	 * 利用第三方jar有logging.jar和beanUtils�?
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// public static void main(String[] args) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("id", 123);
	// map.put("name", "kevin");
	// map.put("age", 21);
	//
	// // User user=toBean(map, User.class);
	// User user = new User();
	// try {
	// BeanUtils.populate(user, map);
	// System.out.println(user);
	// } catch (IllegalAccessException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (InvocationTargetException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}
