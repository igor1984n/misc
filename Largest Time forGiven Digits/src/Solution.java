import java.util.*;

//Given an array of 4 digits, return the largest 24 hour time that can be made.
//        The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
//        Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
//A.length == 4
//0 <= A[i] <= 9
public class Solution {
    public static void main(String[] args) {
        int[] A = {0, 3, 3, 5};
        System.out.println(largestTimeFromDigits(A));
    }

    public static String largestTimeFromDigits(int[] A) {
        return getTimeString(A);
    }

    private static String getTimeString(int[] A) {
        StringBuilder builder = new StringBuilder();
        List<Integer> digits = new ArrayList<>();
        for (int value : A) {
            digits.add(value);
        }

        String delimiter = ":";

        Optional<Integer> firstHourDigit = digits.stream().filter(i -> i < 3).max(Integer::compare);
        if (firstHourDigit.isEmpty()) return "";
        else {
            int firstDigit = firstHourDigit.get();
            digits.remove((Integer) firstDigit);
            if (firstDigit == 2) {
                Optional<Integer> secDig = digits.stream().filter(i -> i < 4).max(Integer::compare);  //проверка на наличие 2 и 3 чисел
                if (secDig.isEmpty()) return "";
                else {
                    digits.remove((Integer) secDig.get());
                }
                Optional<Integer> thirDig = digits.stream().filter(i -> i < 6).max(Integer::compare);
                if (secDig.isEmpty() || thirDig.isEmpty()) {   //если 2 или 3 число отсутствуют
                    digits.add(secDig.get());
                    Optional<Integer> newFirstDigit = digits.stream().filter(i -> i < 2).max(Integer::compare); //первое число вместо 2
                    if (newFirstDigit.isEmpty()) return "";
                    else {
                        firstDigit = newFirstDigit.get();                                                             //присваиваем новое значение первой цифре
                        builder.append(firstDigit);                                                                   //и
                        digits.add(2);                                                                              //добавляем "2" обратно в лист
                        digits.remove((Integer) firstDigit);                                                          //и удаляем новое значение оттуда
//
                        Optional<Integer> firstMinuteDigit = digits.stream().filter(i -> i < 6).max(Integer::compare); //получаем цифру 3
                        if (firstMinuteDigit.isEmpty()) return "";
                        else {
                            int firstMinDigit = firstMinuteDigit.get();
                            digits.remove(firstMinDigit);
                            int secondHourDigit;
                            int lastMinuteDigit;
                            if (digits.get(0) > digits.get(1)) {
                                secondHourDigit = digits.get(0);
                                lastMinuteDigit = digits.get(1);
                            } else {
                                secondHourDigit = digits.get(1);
                                lastMinuteDigit = digits.get(0);
                            }
                            builder.append(secondHourDigit);
                            builder.append(delimiter);
                            builder.append(firstMinDigit);
                            builder.append(lastMinuteDigit);
                            return builder.toString();
                        }
                    }
                } else {
                    builder.append(firstDigit);// 2 и 3 существуют
                    digits.add(secDig.get());
                    Optional<Integer> secondHourDigit = digits.stream().filter(i -> i < 4).max(Integer::compare);
                    if (secondHourDigit.isEmpty()) return "";
                    else {
                        int secHourDigit = secondHourDigit.get();
                        builder.append(secHourDigit);
                        digits.remove((Integer) secHourDigit);
                        builder.append(delimiter);
                        Optional<Integer> firstMinuteDigit = digits.stream().filter(i -> i < 6).max(Integer::compare);
                        if (firstMinuteDigit.isEmpty()) return "";
                        else {
                            builder.append(firstMinuteDigit.get());
                            int firstMinDigit = firstMinuteDigit.get();
                            digits.remove((Integer) firstMinDigit);
                            builder.append(digits.get(0));
                            return builder.toString();
                        }
                    }
                }
            } else { //первая цифра не 2
                builder.append(firstDigit);
                Optional<Integer> secondHourOpt = digits.stream().max(Integer::compare);
                if (secondHourOpt.isEmpty()) return "";
                else {
                    int secondHourDigit = secondHourOpt.get();
                    digits.remove((Integer) secondHourDigit);
                    Optional<Integer> firstMinuteOpt = digits.stream().filter(i -> i < 6).max(Integer::compare);
                    if (firstMinuteOpt.isEmpty()) return "";
                    else {
                        int firstMinDigit = firstMinuteOpt.get();
                        digits.remove((Integer) firstMinDigit);
                        int lastMinuteDigit = digits.get(0);
                        builder.append(secondHourDigit);
                        builder.append(delimiter);
                        builder.append(firstMinDigit);
                        builder.append(lastMinuteDigit);
                        return builder.toString();
                    }
                }
            }
        }
    }
}

// betterSolution
//class Solution {
//    public String largestTimeFromDigits(int[] A) {
//        String res = "";
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                for (int k = 0; k < 4; k++) {
//                    if (i == j || j == k || i == k)
//                        continue;
//                    String HH = A[i] + "" + A[j];
//                    String MM = A[k] + "" + A[6 - i - j - k];
//                    String TIME = HH + ":" + MM;
//                    if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(TIME) < 0)
//                        res = TIME;
//                }
//            }
//        }
//        return res;
//    }
//}


