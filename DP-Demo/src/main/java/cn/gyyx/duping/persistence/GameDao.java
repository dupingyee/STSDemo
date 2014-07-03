package cn.gyyx.duping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.gyyx.duping.entity.GameInfo;

public class GameDao extends BaseDao {
	private SqlSession session = null;

	public List<GameInfo> queryList() {
		String smtpId = "GameInfo.queryList";
		List<GameInfo> list = null;
		try {
			session = sessionFactory.openSession();
			list = session.selectList(smtpId,null);
			session.close();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return list;
	}
}
