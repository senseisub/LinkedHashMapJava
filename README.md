<h1>LinkedHashMaps in Java</h1>
<h4>by Seun Suberu</h4>
<h5>Description</h5>
<p>The LinkedHashMap class in Java maintains the functionality
and is very similarly used like the the regular HashMap class but adds
 the ability to maintain insertion order of the elements.</p>
<h5>How it works</h5>
<p>The LinkedHashMap class operates very similar to a regular HashMap. 
The pairs are stored in an array and the key is hashed and an index is 
found using modulus arithmetic and therefore the lookup time is the same. 
The difference between the two are that, in the array, an elements would 
not only hold the key-value pair, but also two references to the "nodes" that 
would be previous and after the element given when it was inserted.</p>
<h5>Examples of how to use LinkedHashMap class</h5>
<p>Initialization</p>

```
    //regular initialization
    LinkedHashMap<keyType, valueType> hashmap = new LinkedHashMap<keyType, valueType>();
    
    //initializing a LinkedHashMap with predetermined capacity
    LinkedHashMap<keyType, valueType> hashmap = new LinkedHashMap<keyType, valueType>(int capacity);
    
    /*initializing a LinkedHashMap with predetermined capacity and determine
     the proportion of filled spaces before LinkedHashMap increases the capacity
    */
    LinkedHashMap<keyType, valueType> hashmap = new LinkedHashMap<keyType, valueType>(int capacity, float fillRatio);

    //Example that creates a LinkedHashMap with String keys and boolean values
    
    LinkedHashMap<String, Boolean> softwareEngineers = new LinkedHashMap<String, Boolean>(10);
    
```

<p>Inserting Pairs</p>

```
    //regular insertion that adds the {"SeunSuberu" : true} pairing
    softwareEngineers.put("SeunSuberu", true);
    
    //incorrect ordering of arguments
    softwareEngineers.put(true, "SeunSuberu"); // throws error
```

<h5>Removing key-value pair:</h5>
```
    //regular deletion that removes the {"SeunSuberu" : true} pairing
    softwareEngineers.remove("SeunSuberu");
    
    //incorrect ordering of arguments
    softwareEngineers.put(true, "SeunSuberu"); // throws error
```

<p>Retrieving value from key input</p>

```
    //regular lookup that finds the value associated with "SeunSuberu"
    softwareEngineers.get("SeunSuberu"); //returns true
    
    softwareEngineers.get("MarkFontenot"); //returns null
```

<p>Iterating over the values in the LinkedHashMap. (Which is in insertion order)</p>

```
    //This is how to iterate over the key-value pairs in a LinkedHashMap.
    //Set<Map.Entry<KeyType, ValueType> ___ = nameOfLinkedHashMap.entrySet(); 
    //gives the iterable data structure in the LinkedHashMap
    
    Set<Map.Entry<String,Boolean>> entrySet = softwareEngineers.entrySet();
    for (Map.Entry<String, Boolean> mapElement : entrySet ) {
        
        String key = mapElement.getKey();

        // Finding the value
        Boolean value = mapElement.getValue();

        // print the key : value pair
        System.out.println(key + " : " + value);
    }
```

<p>The internal mechanism for iterating over the LinkedHashMap</p>

```
    //class attributes
    int capacity;
    EntryObject data = new EntryObject[capacity];
    
    public Set<EntryObject> iterateOver(){
        Set<EntryObject> entrySet;
        EntryObject first;
        
        //FINDS FIRST OBJECT INSERTED, MARKED BY THE FACT IT HAS NO PREVIOUS NODE
        for(EntryObject entry : data){
            if(entry.getPrevious() == null)
                first = entry;
        }
        
        //ITERATES AND ADDS ELEMENTS TO SET IN INSERTION ORDER
        while(first != null){
            entrySet.add(first);
            first = first.getNext();
        }
        
        //RETURNS SET OF ELEMENTS IN INSERTION ORDER
        return entrySet;
    }
```
