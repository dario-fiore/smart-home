package com.dev.smarthome.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dev.smarthome.dto.SettingDto;
import com.dev.smarthome.entity.Setting;

@Mapper
public interface SettingMapper {
	SettingMapper INSTANCE = Mappers.getMapper( SettingMapper.class ); 
 
    @Mapping(source = "name", target = "name")
    @Mapping(source = "port", target = "port")
    @Mapping(source = "icon", target = "icon")
    @Mapping(source = "roles", target = "roles")
    Setting settingDtoToSetting(SettingDto settingDto);
}
