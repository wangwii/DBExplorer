package cn.com.qimingx.json;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.com.qimingx.dbe.action.bean.GridTableUpdateInfoBean;
import cn.com.qimingx.dbe.action.bean.PkColumnObject;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class TestJSONEngine {
	public static void main(String[] args) {
		// 测试排查 and 包含
		// testEandI();
		testJsonConvertToBean();
	}

	// 测试JSON转换成Bean
	public static void testJsonConvertToBean() {
		String s = "{'pkList':[{'pk':'F','pkValue':'wang','pkType':12},{'pk':'L','pkValue':'wei','pkType':12}],'type':3,'field':'AGE','value':'5'}";
		JSONObject j = JSONObject.fromObject(s);
		System.out.println(j);

		//Map<String, Class<PkColumnObject>> map = new HashMap<String, Class<PkColumnObject>>(1);
		Map<String, Class<?>> map = new HashMap<String, Class<?>>(1);
		map.put("pkList", PkColumnObject.class);
		Object o = JSONObject.toBean(j, GridTableUpdateInfoBean.class, map);
		
		System.out.println(o);
	}

	public static void testEandI() {
		MyObject obj = new MyObject();
		obj.setAge(28);
		obj.setBirthday(new Date());
		obj.setId(1l);
		obj.setName("Wangwei");
		JSON json = MyJSONUtils.toJsonExclude(obj, "birthday", "id", "age");
		System.out.println("exclude:" + json.toString());

		json = MyJSONUtils.toJsonInclude(obj, "birthday", "age");
		System.out.println("include:" + json.toString());
	}

	public static class MyObject {
		private Long id;
		private String name;
		private Integer age;
		private Date birthday;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
	}
}
