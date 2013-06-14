package cn.com.qimingx.dbe.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.qimingx.dbe.FieldDataType;

public class DerbyDBInfoService extends AbstractDBInfoService{
	// Logger
	private static final Log log = LogFactory.getLog(OracleDBInfoService.class);
	
	public String getLimitSQLString(String originalSQL) {
		return null;
	}

	public boolean supportLimit() {
		return false;
	}
	
	//
	public List<String> getSchemas() {
		List<String> schemas = super.getSchemas();

		// 过滤与用户不匹配的其它模式
		try {
			String user = meta.getUserName().toUpperCase();
			if (schemas.indexOf(user) > -1) {
				// 仅返回与用户名称匹配的模式，其它的模式全部丢弃
				schemas.clear();
				schemas.add(user);
			}
		} catch (SQLException e) {
			log.error("meta.getUserName出错：" + e.getMessage());
		}

		return schemas;
	}

	// 重写获取数据类型方法，返回derby特有的数据类型
	public List<FieldDataType> getDataTypes() {
		List<FieldDataType> fdts = new ArrayList<FieldDataType>();
		fdts = super.getDataTypes();
		Iterator<FieldDataType> it = fdts.iterator();
		while (it.hasNext()) {
			FieldDataType fdt = it.next();
			if ("FLOAT".equalsIgnoreCase(fdt.getTypeName())
					|| "CLOB".equalsIgnoreCase(fdt.getTypeName())
					|| "BLOB".equalsIgnoreCase(fdt.getTypeName())) {
				fdt.setResetLength(true);
			}
		}
		return fdts;
	}

}
