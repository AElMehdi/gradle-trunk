package com.aelmehdi;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

class MyPdfWriterTest {

   @TempDir
   File temp;

   @Test
   void should_generate_a_pdf_file() throws IOException, DocumentException {
      MyPdfWriter.generate(temp.getPath());


      File generatedPdf = new File(temp, "myPdf.pdf");

      assertThat(readPdf(generatedPdf.toPath().toString())).contains("paragraph");
   }

   @Test
   void should_create_dest_folder_if_does_not_exist() throws IOException, DocumentException {
      String dest = temp + "/newFolder";

      MyPdfWriter.generate(dest);

      File wasCreated = new File(dest);

      assertThat(wasCreated.exists()).isTrue();
   }

   static String readPdf(String path) throws IOException {
      PdfReader reader = new PdfReader(path);

      String pdfContent = PdfTextExtractor.getTextFromPage(reader, 1);


      reader.close();
      return pdfContent;
   }
}
