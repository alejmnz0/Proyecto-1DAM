package com.salesianostriana.dam.cinejava.util;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.salesianostriana.dam.cinejava.model.Entrada;

@Component("pdf")
public class TicketPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		List<Entrada> entradas = (List<Entrada>) model.get("entradas");
		
		PdfPTable tabla = new PdfPTable(4);
		
		for (Entrada entrada : entradas) {
			tabla.addCell(entrada.getPase().getFecha().format(formater));
			tabla.addCell(entrada.getPase().getSala().getNombre());
			tabla.addCell("Fila: "+String.valueOf(entrada.getAsiento().getFila()));
			tabla.addCell("Columna: "+String.valueOf(entrada.getAsiento().getColumna()));
		}
		document.add(tabla);
	}

}
