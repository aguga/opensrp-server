package org.opensrp.repository.postgres.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.opensrp.domain.postgres.MultiMedia;
import org.opensrp.domain.postgres.MultiMediaExample;
import org.apache.ibatis.session.RowBounds;

public interface MultiMediaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	long countByExample(MultiMediaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int deleteByExample(MultiMediaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int insert(MultiMedia record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int insertSelective(MultiMedia record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	List<MultiMedia> selectByExampleWithRowbounds(MultiMediaExample example, RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	List<MultiMedia> selectByExample(MultiMediaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	MultiMedia selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int updateByExampleSelective(@Param("record") MultiMedia record, @Param("example") MultiMediaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int updateByExample(@Param("record") MultiMedia record, @Param("example") MultiMediaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int updateByPrimaryKeySelective(MultiMedia record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table core.multi_media
	 * @mbg.generated  Wed Mar 14 17:13:39 EAT 2018
	 */
	int updateByPrimaryKey(MultiMedia record);
}