package com.pachecode.jub;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ricardo.pachecosalazar@wnco.com on 9/14/2017.
 */
public class UtilsTest {



   @Test
   public void testUtil() {
      assertNotNull(Utils.readResourceContents("sum_scenario.story"));
   }

}
