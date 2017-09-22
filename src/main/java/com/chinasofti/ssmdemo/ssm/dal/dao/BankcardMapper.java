package com.chinasofti.ssmdemo.ssm.dal.dao;

import com.chinasofti.ssmdemo.ssm.dal.entity.Bankcard;
import com.chinasofti.ssmdemo.ssm.dal.entity.BankcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankcardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int countByExample(BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int deleteByExample(BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int insert(Bankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int insertSelective(Bankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    List<Bankcard> selectByExample(BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    Bankcard selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") Bankcard record, @Param("example") BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int updateByExample(@Param("record") Bankcard record, @Param("example") BankcardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int updateByPrimaryKeySelective(Bankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bankcard
     *
     * @mbggenerated Thu Sep 14 11:29:02 CST 2017
     */
    int updateByPrimaryKey(Bankcard record);
}