package com.aelmehdi;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class PdfWriterPdfBoxTest {

   @TempDir
   static File temp;

   @Test
   void should_generate_pdf_file() throws IOException {
      PdfWriterPdfBox.generate(temp.getPath());

      assertThat(new File(temp.getPath() + "/pdfBox.pdf").exists()).isTrue();
   }

   @Test
   void load_an_existing_pdf_file() throws IOException {
      String content = PdfWriterPdfBox.load("pdfToChange.pdf");

      assertThat(content).contains("camisa");
   }
}