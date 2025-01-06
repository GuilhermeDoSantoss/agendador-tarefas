package com.guilhermesantos.agendador.business.mapper;

import com.guilhermesantos.agendador.business.DTO.TarefasDTO;
import com.guilhermesantos.agendador.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity  entity);
}
