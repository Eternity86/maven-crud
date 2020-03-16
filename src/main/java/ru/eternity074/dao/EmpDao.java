package ru.eternity074.dao;

import java.util.List;

import ru.eternity074.entities.Emp;

public interface EmpDao {
	
	public int save(Emp p);
	public int update(Emp p);
	public int delete(int id);
	public Emp getEmpById(int id);
	public List<Emp> getEmployees();
	
//	JdbcTemplate template;
//
//	/**
//	 * @param template the template to set
//	 */
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}
//
//	public int save(Emp p) {
//		String sql = "insert into emp99 (name,salary,designation) value ('"
//				+ p.getName() + "'," + p.getSalary() + ",'" + p.getDesignation()
//				+ "')";
//		return template.update(sql);
//	}
//
//	public int update(Emp p) {
//		String sql = "update emp99 set name='" + p.getName() + "',salary="
//				+ p.getSalary() + ",designation='" + p.getDesignation()
//				+ "' where id=" + p.getId();
//		return template.update(sql);
//	}
//
//	public int delete(int id) {
//		String sql = String.format("delete from emp99 where id=%d", id);
//		return template.update(sql);
//	}
//
//	public Emp getEmpById(int id) {
//		String sql = "select * from emp99 where id=?";
//		return template.queryForObject(sql, new Object[] { id },
//				new BeanPropertyRowMapper<Emp>(Emp.class));
//	}
//
//	public List<Emp> getEmployees() {
//		return template.query("select * from emp99", new RowMapper<Emp>() {
//			public Emp mapRow(ResultSet rs, int row) throws SQLException {
//				Emp e = new Emp();
//				e.setId(rs.getInt(1));
//				e.setName(rs.getString(2));
//				e.setSalary(rs.getFloat(3));
//				e.setDesignation(rs.getString(4));
//				return e;
//			}
//		});
//	}

}
