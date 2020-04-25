package com.aelmehdi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MyPdfWriter {

   public static final String DEST = "./target/sasndbox/images/raw_images.pdf";


   public static void generate(String dest) throws FileNotFoundException, DocumentException {
      Document document = new Document(PageSize.A4);

      PdfWriter.getInstance(document, new FileOutputStream(dest + "/myPdf.pdf"));


      document.open();
      document.add(new Paragraph("Hello from the pdf writer"));

      document.close();
   }

}