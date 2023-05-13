package kr.ziz.ecommercemall.interfaces.manager;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerDtoMapper {

  ManagerDto.TokenResponse of(String managerToken);
}
