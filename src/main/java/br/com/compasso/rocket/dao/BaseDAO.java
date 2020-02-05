package br.com.compasso.rocket.dao;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public interface BaseDAO<B> {

	default <T> void serializa(T object, String arquivo) throws IOException {
		ObjectMapper mapper = new XmlMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File(arquivo),object);
	}
	
    B desserealiza()throws IOException;
	
}
