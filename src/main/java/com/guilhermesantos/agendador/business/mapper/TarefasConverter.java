package com.guilhermesantos.agendador.business.mapper;

import com.guilhermesantos.agendador.business.DTO.TarefasDTO;
import com.guilhermesantos.agendador.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}