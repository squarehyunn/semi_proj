package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.JDBCTemplate;
import com.login.dto.UserDto;

public class UserDao extends JDBCTemplate {
	
	public UserDto login(String id, String pw) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM L_MEMBER WHERE USER_ID=? AND USER_PW=? ";
		UserDto dto = new UserDto();

		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			System.out.println("3. query 준비"+sql);
			
			rs = ps.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto.setUser_id(rs.getString(1));
				dto.setUser_pw(rs.getString(2));
				dto.setUser_name(rs.getString(3));
				dto.setNick_name(rs.getString(4));
				dto.setUser_img(rs.getString(5));
				dto.setUser_addr(rs.getString(6));
				dto.setUser_phone(rs.getString(7));
				dto.setUser_email(rs.getString(8));
				dto.setMember(rs.getString(9));
				dto.setBiz_num(rs.getString(10));
				dto.setUser_addr_de(rs.getString(11));
			}

		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			if(dto.getUser_id()!=null) {
				close(rs);
			}
			close(ps);
			close(con);
			System.out.println("5. db 종료\n");
		}
		
		return dto;
	}
	
	public String findId(UserDto dto) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = " SELECT * FROM L_MEMBER WHERE USER_NAME=? AND USER_EMAIL=? ";
		String id="";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUser_name());
			ps.setString(2, dto.getUser_email());
			
			res = ps.executeQuery();
			if(res.next()) {
				id = res.getString("USER_ID");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(res!=null) {close(res);}
			close(ps);
			close(con);
			
		}
		return id;
	}
	
	public UserDto findPw(UserDto dto) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM L_MEMBER WHERE USER_ID=? AND USER_EMAIL=? AND USER_NAME=? ";
		UserDto pw = new UserDto();
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUser_id());
			ps.setString(2, dto.getUser_email());
			ps.setString(3, dto.getUser_name());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				pw.setUser_name(rs.getString("USER_NAME"));
				pw.setUser_pw(rs.getString("USER_PW"));
				pw.setUser_id("1");
			}else {
				pw.setUser_id("0");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				close(rs);
			}
			close(ps);
			close(con);
		}
		return pw;
	}
	
	
}

