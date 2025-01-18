package com.guilhermesantos.agendador.infrastructure.repository;

import com.guilhermesantos.agendador.infrastructure.Enuns.StatusNotificacaoEnum;
import com.guilhermesantos.agendador.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasRepository, String> {

        List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataInicial,
                                                                            LocalDateTime dataFinal,
                                                                            StatusNotificacaoEnum status);

        List<TarefasEntity> findByEmailUsuario(String email);
}
