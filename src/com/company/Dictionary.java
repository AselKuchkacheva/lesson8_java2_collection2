package com.company;

import java.util.*;

public class Dictionary {

    public static void main (String[] args) {
        TreeMap<String, String[]> dictionary = new TreeMap<>();
        TreeMap<String, String[]> bigDictionary = new TreeMap<>();

        dictionary.put("человек", new String[]{"личность", "персона", "индивидум"});
        dictionary.put("страна", new String[] {"республика", "родина", "государство"});
        dictionary.put("большой", new String[] {"крупный", "огромный", "массивный"});
        dictionary.put("красивый", new String[] {"симпотичный", "привлекательный", "кооз"});

        for (Map.Entry<String, String[]> item: dictionary.entrySet()) {
            System.out.println(item.getKey() +" - "+ Arrays.toString(item.getValue()));
        }
        bigDictionary.putAll(dictionary);
        Set<String> keys = dictionary.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String oldKey = iter.next();
            String[] oldValues = dictionary.get(oldKey);

            for (int i = 0; i < oldValues.length; i++) {
                String newKey = oldValues[i];
                ArrayList<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(oldValues));
                list.remove(newKey);
                list.add(oldKey);
                String[] newValues = new String[list.size()];
                list.toArray(newValues);
                bigDictionary.put(newKey, newValues);
            }
        }
        System.out.println("_______________:");

        for (Map.Entry<String, String[]> item: bigDictionary.entrySet()) {
            System.out.println(item.getKey() +" - "+ Arrays.toString(item.getValue()));
        }

        while(true) {
            System.out.println("\nВведите слово из словоря:");
            Scanner sc = new Scanner(System.in);
            String word = sc.nextLine() ;
            String[] words = word.split(" ");
            for (String a : words) {
                if(bigDictionary.get(a) != null) {
                    String[] synonyms = bigDictionary.get(a);
                    Random r = new Random();
                    int x = r.nextInt(synonyms.length);
                    System.out.print(synonyms[x] + " " );
                } else  {
                    System.out.println("Такого слова нет в словаре!");

                }
            }
        }
    }
}
