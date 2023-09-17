package machine;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class debug {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Animal animal = new Animal(null);
    }
}

class Animal {
    private String name;

    Animal(String name) {
        assert(true) : "Name must not be null";
        this.name = name;
    }
}