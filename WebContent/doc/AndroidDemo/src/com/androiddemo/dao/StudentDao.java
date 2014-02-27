package com.androiddemo.dao;

import com.androiddemo.entity.StudentInfoEntity;

public interface StudentDao {

	/**
	 * 向学生数据库插入一条记录
	 * @param name 学生姓名
	 * @param company 公司名称
	 * @param salary 学生的工资
	 */
	public void insert(String name, String company, int salary);

	/**
	 * 根据学生的id删除数据
	 * @param id 学生的id号码
	 */
	public void delete(int id);

	/**
	 * 更新学员的薪水信息
	 * @param id 学生的id
	 * @param newsalary 新的工资信息
	 */
	public void updateSalary(int id, int newsalary);

	/**
	 * 根据学生是的id查询学生的信息。
	 * @param id
	 * @return 学生信息的对象。 如果返回null代表是没有查询到当前学生
	 */
	public StudentInfoEntity find(int id);

}