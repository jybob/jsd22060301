package cn.tedu.boot02.mapper;

import cn.tedu.boot02.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    @Select("select * from product")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Update("update product set title=#{title},price=#{price},num=#{num} where id=#{id}")
    void update(Product product);
}
