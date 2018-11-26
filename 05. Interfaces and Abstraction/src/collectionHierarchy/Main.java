package collectionHierarchy;

import collectionHierarchy.collections.AddCollectionFunc;
import collectionHierarchy.collections.AddRemoveCollectionFunc;
import collectionHierarchy.collections.MyListFunc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        AddCollectionFunc addCollection = new AddCollection();
        AddRemoveCollectionFunc addRemoveCollection = new AddRemoveCollection();
        MyListFunc list = new MyList();

        int countOfElementsToRemove = Integer.parseInt(reader.readLine());

        Arrays.stream(input).map(addCollection::add).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(input).map(addRemoveCollection::add).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(input).map(list::add).forEach(x -> System.out.print(x + " "));
        System.out.println();

        for (int i = 0; i < countOfElementsToRemove; i++)
            System.out.print(addRemoveCollection.remove() + " ");
        System.out.println();
        for (int i = 0; i < countOfElementsToRemove; i++)
            System.out.print(list.remove() + " ");


    }
}
