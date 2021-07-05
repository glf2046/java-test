package com.lefeng.CollectionTest;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetTest {

    public static void main(String[] args) {

        NavigableSet<String> ns = new TreeSet<>();
        ns.add("a");
        ns.add("b");
        ns.add("c");
        ns.add("d");
        ns.add("e");
        ns.add("f");
        ns.add("g");

        // Get a reverse view of the navigable set
        NavigableSet<String> reverseNs = ns.descendingSet();

        // Print the normal and reverse views 
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);

        NavigableSet<String> threeOrMore = ns.tailSet("c", true);
        System.out.println("3 or  more:  " + threeOrMore);
        System.out.println("lower(3): " + ns.lower("c"));
        System.out.println("floor(3): " + ns.floor("c"));
        System.out.println("higher(3): " + ns.higher("c"));
        System.out.println("ceiling(3): " + ns.ceiling("c"));

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollLast(): " + ns.pollLast());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("Navigable Set:  " + ns);

        System.out.println("pollFirst(): " + ns.pollFirst());
        System.out.println("pollLast(): " + ns.pollLast());
    }
}
