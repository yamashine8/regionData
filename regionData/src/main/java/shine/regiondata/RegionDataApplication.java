package shine.regiondata;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import shine.regiondata.model.Region;

@MappedTypes(Region.class)
@MapperScan("shine.regiondata.mapper")
@SpringBootApplication
@EnableCaching
public class RegionDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionDataApplication.class, args);
    }

}
