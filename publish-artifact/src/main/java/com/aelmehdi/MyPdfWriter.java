package com.aelmehdi;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MyPdfWriter {

   public static final String DEST = "./target/sasndbox/images/raw_images.pdf";


   public static void generate(String dest) throws IOException, DocumentException {
      Document document = new Document(PageSize.A4);

      PdfWriter.getInstance(document, new FileOutputStream(dest + "/myPdf.pdf"));


      document.open();

      document.add(new Paragraph("paragraph 1"));
      document.add(new Paragraph("paragraph 2"));
      document.add(new Paragraph("paragraph 3"));
      document.add(Image.getInstance("src/main/resources/ce.png", false));

      document.close();
   }

   public static void main(String[] args) throws IOException, DocumentException {
      generate("./build");
   }


}