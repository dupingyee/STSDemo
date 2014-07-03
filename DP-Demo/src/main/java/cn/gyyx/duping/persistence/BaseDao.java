package cn.gyyx.duping.persistence;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDao {

	private final static String resource = "cn/gyyx/duping/persistence/sqlMapConfig.xml";

	protected SqlSessionFactory sessionFactory;

	protected BaseDao() {
		sessionFactory = createSession();
	}

	private SqlSessionFactory createSession() {
		if (sessionFactory == null) {
			if (sessionFactory == null) {
				try {
					sessionFactory = new SqlSessionFactoryBuilder()
							.build(Resources.getResourceAsReader(resource));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sessionFactory;
	}
}
