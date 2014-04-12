package com.readread.inviteKey.delegate;

import java.sql.SQLException;

import com.readread.inviteKey.DAO.InviteKeyDAO;
import com.readread.inviteKey.model.InviteKeyVO;

public class InviteKeyMan {

	final InviteKeyDAO objInviteKeyDAO = new InviteKeyDAO();
	
	public int insertInvite(InviteKeyVO objInviteKeyVO){
		try {
			objInviteKeyDAO.insertInvite(objInviteKeyVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
