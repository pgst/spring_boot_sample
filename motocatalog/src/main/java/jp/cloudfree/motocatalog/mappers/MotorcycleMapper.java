package jp.cloudfree.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.cloudfree.motocatalog.beans.Motorcycle;

@Mapper
public interface MotorcycleMapper {
    
    /**
     * バイク情報を全件取得する
     * @return バイク情報リスト
     */
    public List<Motorcycle> selectAll();
}
