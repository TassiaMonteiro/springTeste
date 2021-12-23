package br.com.despachante.despachante_api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public final static String dataBR = "dd/MM/yyyy";
	
	public static String converterDataPadraoBR(LocalDate dataDeCadastro) {
		
		if(dataDeCadastro == null) {
			return "";
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataBR);

		String dataFormatada = dataDeCadastro.format(formatter);
		
		return dataFormatada;
	}

}
