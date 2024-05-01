package shine.regiondata.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shine.regiondata.model.Region;

import java.util.List;

@Mapper
public interface RegionMapper {
    @Select("select * from regions")
    List<Region> findAll();

    @Insert("INSERT INTO regions(id, regionName, regionShortName) VALUES (#{id}, #{regionName}, #{regionShortName})")
    void insertRegion(Region region);

    @Delete("delete from regions where id =#{id}")
    void deleteById(int id);
    @Delete("delete from regions where regionName =#{regionName}")
    void deleteByRegionName(String regionName);
    @Delete("delete from regions where regionShortName =#{regionShortName}")
    void deleteByRegionShortName(String regionShortName);

    @Select("select * from regions where id =#{id}")
    Region findById(int id);

    @Select("select * from regions where regionName =#{regionName}")
    Region findByRegionName(String regionName);

}
