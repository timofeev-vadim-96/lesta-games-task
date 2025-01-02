package org.example.tasks;

public class Even {
    private static final char[] EVEN_NUMBS_ARR = {'0','2','4','6','8'};

    /**
     * Через побитовую операцию И между numb и 1. Если numb бит 1, то вернется true (1), итог -> false
     */
    public boolean isEven1(int numb) {
        return (numb & 1) == 0;
    }

    /**
     * Еще один способ - проверить, заканчивается ли число на четную цифру
     */
    public boolean isEven2(int numb) {
        String stringRepresentation = String.valueOf(numb);
        char lastNumb = stringRepresentation.charAt(stringRepresentation.length() - 1);
        for (int i: EVEN_NUMBS_ARR) {
            if (i == lastNumb) {
                return true;
            }
        }

        return false;
    }
}
