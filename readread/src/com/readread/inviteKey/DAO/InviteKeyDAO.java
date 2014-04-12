package com.readread.inviteKey.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.readread.article.dao.BaseDAO;
import com.readread.inviteKey.model.InviteKeyVO;

public class InviteKeyDAO extends BaseDAO{
		public int insertInvite(InviteKeyVO objInviteKeyVO) throws SQLException{
			// 连续数据库
	        Connection conn = null;
	        PreparedStatement ps = null;
	        try {
				conn = this.readGetConnection();
				String insertSQL = "INSERT INTO mysql.read_invitekey (inviteKey, createTime, isUsed)VALUES(?, sysdate(), ?)";
				ps=conn.prepareStatement(insertSQL);
				ps.setString(1, objInviteKeyVO.getInviteKey());
				ps.setInt(2, objInviteKeyVO.getIsUsed());
				return ps.executeUpdate();
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				this.closeCon(conn, ps);
			}
			return 0;
		}
}
