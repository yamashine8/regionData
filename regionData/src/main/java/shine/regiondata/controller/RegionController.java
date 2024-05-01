package shine.regiondata.controller;

import lombok.AllArgsConstructor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import shine.regiondata.mapper.RegionMapper;
import shine.regiondata.model.Region;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RegionController {

    private final RegionMapper mapper;

    @GetMapping("data")
    @Cacheable("allRegions")
    public List<Region> findAll(){
        return mapper.findAll();
    }

    @PostMapping("insert")
    public String insert(@RequestBody Region region){
        mapper.insertRegion(region);
        return "region inserted";
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable int id){
        mapper.deleteById(id);
        clearCacheById(id);
        return "region deleted by id";
    }

    @DeleteMapping("deleteByRegionName/{regionName}")
    @CacheEvict(value = "regionByRegionName", key = "#regionName")
    public String deleteByRegionName(@PathVariable String regionName){
        mapper.deleteByRegionName(regionName);
        clearCacheByName(regionName);
        return "region deleted by name";
    }

    @DeleteMapping("deleteByRegionShortName/{regionShortName}")
    @CacheEvict(value = "regionByShortName", key = "#regionShortName")
    public String deleteByRegionShortName(@PathVariable String regionShortName){
        mapper.deleteByRegionName(regionShortName);
        clearCacheByShortName(regionShortName);
        return "region deleted by short name";
    }

    @GetMapping("findById/{id}")
    @Cacheable(value = "regionById", key = "#id")
    public Region findById(@PathVariable int id){       
        return mapper.findById(id);
    }

    @GetMapping("findByRegionName/{regionName}")
    @Cacheable(value = "regionByName", key = "#regionName")
    public Region findByRegionName(@PathVariable String regionName){       
        return mapper.findByRegionName(regionName);
    }

    @CacheEvict(value = "regionById", key = "#id")
    public void clearCacheById(int id) {

    }

    @CacheEvict(value = "regionByName", key = "#regionName")
    public void clearCacheByName(String regionName) {
       
    }
    
    @CacheEvict(value = "regionByShortName", key = "#regionShortName")
    public void clearCacheByShortName(String regionShortName) {
       
    }

}
