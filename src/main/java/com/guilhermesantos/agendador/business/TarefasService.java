package com.guilhermesantos.agendador.business;

import com.guilhermesantos.agendador.business.DTO.TarefasDTO;
import com.guilhermesantos.agendador.business.mapper.TarefasConverter;
import com.guilhermesantos.agendador.infrastructure.Enuns.StatusNotificacaoEnum;
import com.guilhermesantos.agendador.infrastructure.entity.TarefasEntity;
import com.guilhermesantos.agendador.infrastructure.repository.TarefasRepository;
import com.guilhermesantos.agendador.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;
    
    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring());
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.pendente);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
