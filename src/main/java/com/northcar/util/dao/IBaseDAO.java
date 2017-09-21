package com.northcar.util.dao;

import java.util.List;

/**
 * 该接口明确的描述出DAO基础的操作方法
 * @author xjb
 * @param <K> 表示主键类型
 * @param <V> 表示要使用的VO类型
 */
public interface IBaseDAO<K,V> {
	/**
	 * 执行数据的增加操作，调用INSERT语句处理；
	 * @param vo 包含要增加的对象数据，此对象不准为null
	 * @return 返回类型，成功返回true，失败返回false；
	 */
	public boolean doCreate(V vo) ;
	/**
	 * 执行数据的修改操作，调用UPDATE语句处理；
	 * @param vo 包含要修改的对象信息，此对象绝对不允许为空；
	 * @return 返回类型，成功返回true，失败返回false；
	 */
	public boolean doUpdate(V vo) ;
	/**
	 * 执行数据的删除操作，调用delete语句处理
	 * @param id 要删除数据的编号信息;
	 * @return 返回类型，成功返回true，失败返回false
	 */
	public boolean doRemove(K id) ;
	/**
	 * 执行数据的批量删除操作
	 * @param ids 包含所有要删除数据的编号信息；
	 * @return 成功返回true，失败返回false
	 */
	public boolean doRemoveBatch(K [] ids) ;
	/**
	 * 根据ID进行数据的查询操作，使用SELECT语句
	 * @param id 要查询的数据编号，此内容绝对不可以为空
	 * @return 查询一行记录，并且将这行记录的内容转换为VO类对象，如果该记录不存在返回null
	 */
	public V findById(K id) ;
	/**
	 * 查询全部的数据信息，不使用限定查询
	 * @return 由于返回多行的查询记录，所以每行记录都要求封装在VO类对象之中，如果没有返回任何查询结果，该集合长度为0(size()==0)，而不是null
	 */
	public List<V> findAll() ;
	/**
	 * 数据模糊的分页查询操作
	 * @param currentPage 当前所在页，此页数一定要大于0
	 * @param lineSize 每行显示的数据长度，这个长度也就决定了ArrayList初始化的长度
	 * @param column 模糊查询的设置列
	 * @param keyWord 模糊查询关键字
	 * @return 由于返回多行的查询记录，所以每行记录都要求封装在VO类对象之中，如果没有返回任何查询结果，该集合长度为0(size()==0)，而不是null
	 */
	public List<V> findAllSlipt(Integer currentPage,Integer lineSize,String column,String keyWord) ;
	/**
	 * 是进行全部数据统计个数的查询，使用COUNT()函数
	 * @return 表中的全部记录数，如果表中没有记录，返回的就是0
	 */
	public Long getAllCount() ;
	/**
	 * 统计模糊查询的数据量，使用COUNT()函数
	 * @param column 模糊查询的设置列
	 * @param keyWord 模糊查询关键字
	 * @return 表中的全部记录数，如果表中没有记录，返回的就是0
	 */
	public Long getAllCount(String column,String keyWord) ;
	
}
