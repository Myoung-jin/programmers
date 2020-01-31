package com.github.prgrms.socialserver.service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.github.prgrms.socialserver.domain.Users;

@Repository
public class JdbcUsersRepository implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	}

	@Override
	public Long save(Users user) {
		// 자동으로 생성 되는 키 리턴 받기
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS(USERID,EMAIL,PASSWD) VALUES(?,?,?);",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPasswd());
			return ps;
		}, keyHolder);

		return (Long)keyHolder.getKeys().get("seq");
	}

	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	// ○ HTTP GET api/users를 호출하면User정보가JSON형태로목록이반환됩니다.(H2DB에서읽어서)
	@Override
	public List<Users> allUsers() {
		return jdbcTemplate.query("select * from users",
				(rs, rowNum) -> new Users(
						rs.getInt("SEQ"),
						rs.getString("USERID"),
						rs.getString("EMAIL"),
						rs.getString("PASSWD"),
						rs.getString("LOGIN_COUNT"),
						rs.getString("LAST_LOGIN_AT")
					)
			);
	}

	@Override
	public Users findById(String userId) {
		return jdbcTemplate.queryForObject("select * from users where USERID = ?"
				, new Object[] {userId},
				(rs, rowNum)-> Optional.of(new Users(
						rs.getInt("SEQ"),
						rs.getString("USERID"),
						rs.getString("EMAIL"),
						rs.getString("PASSWD"),
						rs.getString("LOGIN_COUNT"),
						rs.getString("LAST_LOGIN_AT")
						))
				).orElse(null);
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
