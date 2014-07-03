package cn.gyyx.duping.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.gyyx.duping.entity.GameInfo;
import cn.gyyx.duping.entity.ServerInfo;

public class ServerDao extends BaseDao {
	private SqlSession session = null;

	public List<ServerInfo> queryListByGameId(int gameId) {
		String smtpId = "ServerInfo.queryListByGameId";
		List<ServerInfo> list = null;
		try {
			session = sessionFactory.openSession();
			list = session.selectList(smtpId, gameId);
			session.close();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return list;
	}
}
