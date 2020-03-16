package ru.eternity074.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ru.eternity074.entities.Emp;

public class EmpDaoImpl implements EmpDao {
	
	JdbcTemplate template;

	/**
	 * @param template the template to set
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int save(Emp p) {
		String sql = "insert into emp (name,salary,designation) value ('"
				+ p.getName() + "'," + p.getSalary() + ",'" + p.getDesignation()
				+ "')";
		return template.update(sql);
	}

	@Override
	public int update(Emp p) {
		String sql = "update emp set name='" + p.getName() + "',salary="
				+ p.getSalary() + ",designation='" + p.getDesignation()
				+ "' where id=" + p.getId();
		return template.update(sql);
	}

	@Override
	public int delete(int id) {
		String sql = String.format("delete from emp where id=%d", id);
		return template.update(sql);
	}

	@Override
	public Emp getEmpById(int id) {
		String sql = "select * from emp where id=?";
		return template.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	@Override
	public List<Emp> getEmployees() {
		return template.query("select * from emp", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}

}
