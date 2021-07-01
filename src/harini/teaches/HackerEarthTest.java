package harini.teaches;

import java.util.*;
import java.util.stream.Collectors;

public class HackerEarthTest {

    private static final String EQUAL_TO = " = ";

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<String> entityList = Arrays.stream(inputScanner.nextLine().trim().split(",")).collect(Collectors.toList());
        int index = entityList.size() - 1;
        LinkedHashMap<String, String[]> expressionsMap = new LinkedHashMap<String, String[]>();
        while (index > 0) {
            String[] expressions = inputScanner.nextLine().trim().split("=");
            String[] expressionRHS = expressions[1].trim().split(" ");
            expressionsMap.put(expressions[0].trim(), expressionRHS);
            index--;
        }
        inputScanner.close();

        String lowestMagnitudeEntity = findLowestMagnitudeEntity(expressionsMap, entityList);
        Set<String> uniqueRelationships = isEntityRelationshipSame(expressionsMap);

        if(uniqueRelationships.size() == 1
                && lowestMagnitudeEntity.equalsIgnoreCase(uniqueRelationships.stream().findFirst().get())) {
            LinkedHashMap<String, Integer> convertedMap = new LinkedHashMap<>();
            for (Map.Entry<String,String[]> entry : expressionsMap.entrySet()){
                Integer newValue = Integer.parseInt(entry.getValue()[0]);
                convertedMap.put(entry.getKey(), newValue);
            }
            LinkedHashMap<String, Integer> sortedMap = getSortedMapInDescendingOrder(convertedMap);
            handleUniqueRelations(expressionsMap, uniqueRelationships, sortedMap);
        } else {
            LinkedHashMap<String, Integer> convertedMap = convertMapToSameUnit(expressionsMap, lowestMagnitudeEntity);
            LinkedHashMap<String, Integer> sortedMap = getSortedMapInDescendingOrder(convertedMap);
            handleNonUniqueRelations(expressionsMap, entityList, sortedMap);
        }
    }

    private static String findLowestMagnitudeEntity(LinkedHashMap<String, String[]> expressionsMap, List<String> entityList) {
        Set<String> lowestMagnitudeEntity = new HashSet<>();
        entityList.forEach(element -> {if(!expressionsMap.keySet().contains(element)){lowestMagnitudeEntity.add(element);}});
        return  lowestMagnitudeEntity.stream().findFirst().get();
    }

    private static Set<String> isEntityRelationshipSame(LinkedHashMap<String, String[]> expressionsMap) {
        Set<String> uniqueRelation = new HashSet<>();
        expressionsMap.values().forEach(element -> uniqueRelation.add(element[1]));
        return uniqueRelation;
    }

    private static LinkedHashMap<String, Integer> convertMapToSameUnit(LinkedHashMap<String, String[]> expressionsMap,
                                                                        String lowestMagnitudeEntity) {
        LinkedHashMap<String, Integer> convertedMap = new LinkedHashMap<>();
        String previousLowestMagnitudeEntity1 = expressionsMap.entrySet().stream()
                .filter(e -> e.getValue()[1].equalsIgnoreCase(lowestMagnitudeEntity))
                .map(Map.Entry::getKey)
                .findFirst().get();
        Integer previousLowestMagnitudeEntityValue1 = Integer.parseInt(expressionsMap.get(previousLowestMagnitudeEntity1)[0]);
        convertedMap.put(previousLowestMagnitudeEntity1,previousLowestMagnitudeEntityValue1);


        String previousLowestMagnitudeEntity = previousLowestMagnitudeEntity1;
        Integer previousLowestMagnitude = previousLowestMagnitudeEntityValue1;


        int i = expressionsMap.entrySet().size()-1;
        List<Map.Entry<String, String[]>> list = new ArrayList<>(expressionsMap.entrySet());
        while(i >= 0) {
            if(list.get(i).getValue()[1].equalsIgnoreCase(previousLowestMagnitudeEntity)) {
                Integer newValue = previousLowestMagnitude * Integer.parseInt(list.get(i).getValue()[0]);
                convertedMap.put(list.get(i).getKey(), newValue);
                previousLowestMagnitudeEntity = list.get(i).getKey();
                previousLowestMagnitude = newValue;
            }
            i--;
        }
        List<String> list1 = expressionsMap.keySet().stream().filter(element -> !convertedMap.keySet().contains(element)).collect(Collectors.toList());

        Iterator<String> it1 = list1.iterator();
        while(it1.hasNext()) {
            String key1 = it1.next();
            String[] previousLowestMagnitudeEntity2 = expressionsMap.entrySet().stream()
                    .filter(e -> e.getKey().equalsIgnoreCase(key1))
                    .map(Map.Entry::getValue)
                    .findFirst().get();

            Integer previousLowestMagnitudeEntityValue2 = Integer.parseInt(previousLowestMagnitudeEntity2[0] ) * convertedMap.get(previousLowestMagnitudeEntity2[1]);
            convertedMap.put(list1.stream().findFirst().get(),previousLowestMagnitudeEntityValue2);
        }
      return convertedMap;
    }

    private static void handleUniqueRelations(LinkedHashMap<String, String[]> expressionsMap,
                                              Set<String> uniqueRelationships, LinkedHashMap<String, Integer> sortedMap) {
        int previousValue = 0;
        String output = null;
        Iterator<Map.Entry<String,Integer>> it = sortedMap.entrySet().iterator();
        while (it.hasNext()) {
                Map.Entry<String,Integer> entry = it.next();
                if (previousValue == 0 && output == null) {
                    String[] temp = expressionsMap.get(entry.getKey());
                    if (temp[1].equalsIgnoreCase(uniqueRelationships.stream().findFirst().get())) {
                        previousValue = Integer.parseInt(temp[0]);
                    }
                    output = "1" + entry.getKey() + EQUAL_TO;
                    continue;
                }
                String[] temp = expressionsMap.get(entry.getKey());
                int value = 0;
                if (temp[1].equalsIgnoreCase(uniqueRelationships.stream().findFirst().get())) {
                    value = previousValue / (Integer.parseInt(temp[0]));
                    output = output + value + entry.getKey() + EQUAL_TO;
                }
                if (!it.hasNext()) {
                    output = output + previousValue + uniqueRelationships.stream().findFirst().get();
                    break;
                }
        }
        System.out.println(output);
    }

    private static void handleNonUniqueRelations(LinkedHashMap<String, String[]> expressionsMap, List<String> entityList,
                                                 LinkedHashMap<String, Integer> sortedMap) {
        int previousValue = 0;
        String previousEntity = null;
        String output = null;
        for (Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
                if (previousValue == 0) {
                    String[] temp = expressionsMap.get(entry.getKey());
                    previousValue = Integer.parseInt(temp[0]);
                    previousEntity = temp[1];
                    output = "1" + entry.getKey() + EQUAL_TO + previousValue + previousEntity;
                    continue;
                }
                String[] temp = expressionsMap.get(previousEntity);
                if (temp == null) {
                    break;
                }
                int value = previousValue * (Integer.parseInt(temp[0]));
                output = output + EQUAL_TO + value + temp[1];
                previousValue = value;
                previousEntity = temp[1];
        }
        System.out.println(output);
    }

    private static LinkedHashMap<String, Integer> getSortedMapInDescendingOrder(LinkedHashMap<String, Integer> map){
        //convert HashMap into List
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        //sorting the list elements
        list.sort((o1, o2) -> {
            //descending order
            return o2.getValue().compareTo(o1.getValue());
        });
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
