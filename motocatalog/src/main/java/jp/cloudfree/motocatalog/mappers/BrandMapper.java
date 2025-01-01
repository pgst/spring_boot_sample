package jp.cloudfree.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.cloudfree.motocatalog.beans.Brand;

@Mapper
public interface BrandMapper {

    public List<Brand> selectAll();
}
