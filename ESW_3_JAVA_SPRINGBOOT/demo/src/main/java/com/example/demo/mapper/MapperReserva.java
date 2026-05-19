package com.example.demo.mapper;

import com.example.demo.Entities.Reserva;
import com.example.demo.DTO.request.ReservaRequestDTO;
import com.example.demo.DTO.response.ReservaresponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapperReserva{
public static Reserva toEntity(ReservaRequestDTO dto){
    Reserva = new Reserva;
    Reserva.setStatus(true());
    Reserva.setDataInicio(dto.datainicio());
    Reserva.setDataFim(dto.datafim());
    Reserva.setCarro(dto.getcarro());
    Reserva.setCliente(dto.getcliente());

    return Reserva;
}

public static ReservaRequestDTO toRequest(){
    
    Reserva.getStatus();
    Reserva.getDataInicio(); 
    Reserva.getDataFim();
    Reserva.getCarro();
    Reserva.getyCliente();
}
}
//em progresso