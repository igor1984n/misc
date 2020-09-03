import java.util.*;


public class Main {
    public static void main(String[] args) {

        ArrayList<String> numbers = new ArrayList<>(){
            {
                String abc = "ABCEHKMOPTXY";
                for (int j0 = 0; j0 < 12; j0++) {
                    String x = String.valueOf(abc.charAt(j0));
                    for (int i = 0; i < 10; i++) {
                        String n = String.valueOf(i);
                        for (int j1 = 0; j1 < 12; j1++) {
                            String y = String.valueOf(abc.charAt(j1));
                            for (int j2 = 0; j2 < 12; j2++) {
                                String z = String.valueOf(abc.charAt(j2));
                                for (int g = 1001; g <= 1199; g++) {
                                    String r = String.valueOf(g).substring(1);
                                    String number = x + n + n + n + y + z + r;
                                    add(number);
                                }
                            }
                        }
                    }
                }
            }};

        HashSet<String> numSet = new HashSet<>();
        numSet.addAll(numbers);

        TreeSet<String> numTree = new TreeSet<>();
        numTree.addAll(numbers);

        for (;;){
            System.out.println("Введите номер автомобиля");
            Scanner scanner = new Scanner(System.in);
            String privellegedNumber = scanner.nextLine();

            long start = System.nanoTime();
            if (numbers.contains(privellegedNumber))
            {
                long end = System.nanoTime();
                long duration = (end - start);
                System.out.println("Поиск перебором: номер найден, поиск занял " + duration + " нс" );
            }
            else
                {
                    long end = System.nanoTime();
                    long duration = (end - start);
                    System.out.println("Поиск перебором: номер не найден, поиск занял " + duration + " нс");
                }

            long startBin = System.nanoTime();
            int index = Collections.binarySearch(numbers, privellegedNumber);
            if (index >= 0){
                long end = System.nanoTime();
                long duration = (end - startBin);
                System.out.println("Бинарный поиск: номер найден, поиск занял " + duration + " нс");
            }
            else {
                long end = System.nanoTime();
                long duration = (end - startBin);
                System.out.println("Бинарный поиск: номер не найден, поиск занял " + duration + " нс");
            }

            long startHash = System.nanoTime();
            if (numSet.contains(privellegedNumber))
            {
                long endHash = System.nanoTime();
                long duration = endHash - startHash;
                System.out.println("Поиск в HashSet: номер найден, поиск занял  " + duration + " нс");
            }
            else {
                long end = System.nanoTime();
                long duration = end - startHash;
                System.out.println("Поиск в HashSet: номер не найден, поиск занял " + duration + " нс");
            }

            long startTree = System.nanoTime();
            if (numTree.contains(privellegedNumber))
            {
                long end = System.nanoTime();
                long duration = end - startTree;
                System.out.println("Поиск в TreeSet: номер найден, поиск занял " + duration + " нс");
            }
            else {
                long end = System.nanoTime();
                long duration = end - startTree;
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + duration + " нс");
            }
        }
    }
}


