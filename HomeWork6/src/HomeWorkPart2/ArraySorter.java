package HomeWorkPart2;

/**
 * Created by Влад on 27.11.2016.
 */
public class ArraySorter {

    Comparable[] bubbleSort(Comparable[] elements, Direction direction) {
        for (int i = elements.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elements[j].compareTo(elements[j + 1]) >= 1) {
                    Comparable tmp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = tmp;
                }
            }
        }
        return elements;
    }

    Comparable[] selectionSort(Comparable[] elements, Direction direction) {
        for (int i = 0; i < elements.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < elements.length; j++)
                if (elements[j].compareTo(elements[index]) >= 1) {
                    index = j;
                }
            Comparable smallerNumber = elements[index];
            elements[index] = elements[i];
            elements[i] = smallerNumber;
        }
        return elements;
    }

    Comparable[] insertionSort(Comparable[] elements, Direction direction) {
        for (int i = 1; i < elements.length; i++) {
            Comparable temp = elements[i];
            int j;
            for (j = i - 1; j >= 0 && (temp.compareTo(elements[j]) <= -1); j--) {
                elements[j + 1] = elements[j];
            }
            elements[j + 1] = temp;
        }
        return elements;
    }

}
