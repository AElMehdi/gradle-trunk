package com.aelmehdi;


import java.io.File;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class MyPdfWriterTest {


   @Test
   void should_generate_a_pdf_file() {
      MyPdfWriter.generate("temp");

      File generatedFile = readFile("temp/myPdf.pdf");

      Assertions.assertThat(generatedFile).isNotNull();
   }

   private File readFile(String path) {
      throw new UnsupportedOperationException();
   }
}
