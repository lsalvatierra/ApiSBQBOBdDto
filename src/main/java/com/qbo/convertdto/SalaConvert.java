package com.qbo.convertdto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.qbo.dto.SalaDto;
import com.qbo.model.Sala;

@Component
public class SalaConvert {


	public SalaDto salaToDto(Sala sala) {
		ModelMapper mapper = new ModelMapper();
		SalaDto map = mapper.map(sala, SalaDto.class);
		return map;
	}

	public List<SalaDto> listSalaToDto(List<Sala> salas) {
		return salas
				.stream()
				.map(x -> salaToDto(x))
				.collect(Collectors.toList());
	}
}
