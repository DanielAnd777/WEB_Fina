/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Configuration.java to edit this template
 */
package com.web.Proyecto_Final.PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.web.Proyecto_Final.producto.producto;
import com.web.Proyecto_Final.productoservicio.productoservicio;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPDF {
    
    @Autowired
    private productoservicio productoser;

    @GetMapping("/exportarPDF")
    public void exportarPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Inventario.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        // Crear una tabla para la imagen y el título
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(70);

        // Celda para la imagen
        Image logo = Image.getInstance("src/main/resources/img/cubo.jpg");
        logo.scaleAbsolute(90, 90);
        PdfPCell logoCell = new PdfPCell(logo);
        logoCell.setBorder(Rectangle.NO_BORDER);
        headerTable.addCell(logoCell);

        // Celda para el título
        Font titleFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 32, BaseColor.BLACK);
        PdfPCell titleCell = new PdfPCell(new Phrase("Puzzle Haven", titleFont));
        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleCell.setVerticalAlignment(Element.ALIGN_CENTER);
        titleCell.setBorder(Rectangle.NO_BORDER);
        headerTable.addCell(titleCell);

        document.add(headerTable);

        // Espacio entre el título y la descripción
        document.add(Chunk.NEWLINE);

        // Obtener la fecha y hora actual
        Date fechaHoraActual = new Date();

        // Formatear la fecha y hora en el formato deseado (por ejemplo, "dd/MM/yyyy HH:mm:ss")
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = formato.format(fechaHoraActual);

        Font descriptionFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLACK);
        Paragraph description = new Paragraph("Inventario actual de la empresa Puzzle Haven, Este informe de inventario fue impreso el  " + fechaHoraFormateada, descriptionFont);
        description.setAlignment(Element.ALIGN_CENTER);
        document.add(description);
        document.add(Chunk.NEWLINE);

        PdfPTable table = new PdfPTable(5); // número de columnas
        table.setWidthPercentage(100);

        // Encabezados de la tabla con fondo blanco y texto negro (usando Times New Roman)
        String[] headers = {"Código Producto", "Nombre Producto", "Precio Unitario", "Cantidad Producto", "Edad de Uso"};
        Font headerFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.WHITE);

        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
            cell.setBackgroundColor(BaseColor.BLACK);
            table.addCell(cell);
        }

        // Filas de datos de la base de datos (usando Times New Roman)
        List<producto> productos = productoser.listaproducto();
        Font cellFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);

        for (producto p : productos) {
            table.addCell(new Phrase(String.valueOf(p.getCodigo_Producto()), cellFont));
            table.addCell(new Phrase(p.getNombre_Producto(), cellFont));
            table.addCell(new Phrase(String.valueOf(p.getPrecio_Unitario()), cellFont));
            table.addCell(new Phrase(String.valueOf(p.getCantidad_Producto()), cellFont));
            table.addCell(new Phrase(p.getEdad_de_Uso(), cellFont));
        }

        document.add(table);
        document.close();
    }

}
