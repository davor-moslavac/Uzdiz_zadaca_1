package org.foi.uzdis.davmoslav.prototype;

import java.util.Hashtable;

public class NatjecateljCache {
	
   private static Hashtable<String, Natjecatelj> shapeMap 
      = new Hashtable<String, Natjecatelj>();

   public static Natjecatelj getShape(String shapeId) {
      Natjecatelj cachedShape = shapeMap.get(shapeId);
      return (Natjecatelj) cachedShape.clone();
   }

   // for each shape run database query and create shape
   // shapeMap.put(shapeKey, shape);
   // for example, we are adding three shapes
   public static void loadCache() {
      Male circle = new Male();
      circle.setId("1");
      shapeMap.put(circle.getId(),circle);

      Female square = new Female();
      square.setId("2");
      shapeMap.put(square.getId(),square);
   }
}