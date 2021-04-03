import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
class Main{

   public static void main(String args[]){
      LinkedHashMap<String, Boolean> softwareEngineers = new LinkedHashMap<>();
      //inserting into LinkedHashMap;
      softwareEngineers.put("Seun Suberu", true);
      softwareEngineers.put("Tony Stark", true);
      softwareEngineers.put("Steve Rogers", false);
      //retrieving value from Key Input
      System.out.println(softwareEngineers.get("Seun Suberu")); //prints true
      System.out.println(softwareEngineers.get("Steve Rogers")); //prints false
      System.out.println(softwareEngineers.get("John Jones")); //prints null
      //Removing key-value pair from LinkedHashMap
      softwareEngineers.remove("Seun Suberu"); 
      //Iterating over values in LinkedHashMap should return remaining key-value pairs in LinkedHashMap
      Set<Map.Entry<String,Boolean>> entrySet = softwareEngineers.entrySet();
      for (Map.Entry<String, Boolean> mapElement : entrySet ) {
         
         String key = mapElement.getKey();

         // Finding the value
         Boolean value = mapElement.getValue();

         // print the key : value pair
         System.out.println(key + " : " + value);
      }

   }
}