package it.unikey;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers =	Arrays.asList(3,2,1,4,5);
        Collections.sort(numbers, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("number 1");
        for(Integer number : numbers) {
            System.out.println(number);
        }

        List<Integer> numbers2 = Arrays.asList(3,2,1,4,5);
        Collections.sort(numbers2, (Integer o1, Integer o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println("number 2");
        for(Integer number : numbers) {
            System.out.println(number);
        }

        List<Integer> numbers3 = Arrays.asList(3,2,1,4,5);
        Collections.sort(numbers3, (Integer o1, Integer o2) -> o1.compareTo(o2));
        System.out.println("number 3");
        numbers3.forEach(System.out::println);


        List<Integer> numbers4 = Arrays.asList(3,2,1,4,5);
        Collections.sort(numbers4, Integer::compareTo);
        System.out.println("number 4");
        numbers4.forEach(System.out::println);

        List<Integer> numbers5 = Arrays.asList(3,2,1,4,5);
        numbers5.sort(Integer::compareTo);
        System.out.println("number 5");
        numbers5.forEach(System.out::println);

        List<Integer> integers = Arrays.asList(3, 9, 2, 1);

        integers.stream().sorted().forEach(System.out::println);

        List<Persona> personas = new ArrayList<>(Arrays.asList(new Persona("Francesco", "Di Rosa"),
                new Persona("Sara", "Babate"), new Persona("Matteo", "Angelo")));

        personas.stream().sorted(new ComparatoreCognome()).forEach(System.out::println);

        List<String> listString = new ArrayList<>();
        //listString.stream().filter(x -> x.startsWith("C")).forEach(System.out::println);

        String ciao = "ciao cane";
        ciao = ciao.trim().replace(" ", "");
        System.out.println(ciao);

        personas.forEach(x -> System.out.println(x.getCognome()));

        ciao = ciao.substring(0, 1).toUpperCase() + ciao.substring(1);
        System.out.println(ciao);

        Persona[] persone = personas.toArray(new Persona[0]);

        System.out.println(personas.stream().map(x -> x.getNome() + " " + x.getCognome() + " ").collect(Collectors.joining()));


        System.out.println();
        System.out.println(personas.stream().allMatch(x -> x.getCognome().equals("Di Rosa")));
        System.out.println(personas.stream().anyMatch(x -> x.getCognome().equals("Angelo")));


        System.out.println();


        Map<String, List<String>> m = new HashMap<>();

        m.put("Mammifero", Arrays.asList("Cane", "Gatto"));
        m.put("Erbivoro", Arrays.asList("Mucca", "Cavallo"));
        Set<String> setMappa = m.keySet();
        String s1 = "";
        for(String s : setMappa){
            s1 += s + " ";
            for(String s2 : m.get(s)){
                s1 += s2 + " ";
            }
            s1 += "\n";
        }
        System.out.println(s1);
    }
}
