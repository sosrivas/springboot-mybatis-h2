package com.test.advertiser.mapper;

import com.test.advertiser.domain.Advertiser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdvertiserRepository {

    @Select("select * from advertiser")
    List<Advertiser> findAll();

    @Insert("INSERT INTO ADVERTISER (NAME, contact, CREDITLIMIT) VALUES (#{name},#{contact}, #{creditlimit})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Advertiser advertiser);

    @Update("update advertiser set name=#{name}, contact=#{contact}, creditlimit=#{creditlimit} where id=#{id}")
    public int update(Advertiser advertiser);

    @Select("select * from advertiser where id=#{id}")
    Advertiser findAdviserBy(int id);

    @Delete("DELETE from advertiser where id=#{id}")
    public int deleteById(int id);
}
