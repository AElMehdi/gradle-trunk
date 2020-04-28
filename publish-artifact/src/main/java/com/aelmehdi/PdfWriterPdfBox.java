package com.aelmehdi;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfWriterPdfBox {


   private static final String PDF_FILE_NAME = "/pdfBox.pdf";

   public static void generate(String dest) throws IOException {
      PDDocument pdDocument = new PDDocument();

      pdDocument.save(dest + PDF_FILE_NAME);

      PDPage pdPage = new PDPage();
      pdDocument.addPage(pdPage);
      
      pdDocument.close();
   }
}
