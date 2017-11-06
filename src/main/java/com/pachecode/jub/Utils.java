package com.pachecode.jub;



import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ricardo on 4/3/2017.
 */
public class Utils {


   public static String readResourceContents(String fileName) {
      try {
         InputStream fileContents = Utils.class.getClass().getResourceAsStream("/"+fileName);

         if(fileContents == null)
            throw new RuntimeException(String.format("Story %s not found", fileName));

         return IOUtils.toString( fileContents, "UTF-8");

      } catch (IOException e) {
         throw new RuntimeException("Couldn't read resource");
      }
   }

}
