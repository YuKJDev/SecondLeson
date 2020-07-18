package ru.geekbrains;

public class Lesson2 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 0, 1};
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
//        [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println(" - Исходный массив");
        System.out.println(" ==================");
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
            }
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println(" - Инвертированный массив");
        System.out.println("===========================");

//        2. Задать пустой целочисленный массив размером 8.
//        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arr1 = new int[8];
        int m = 0;
        for (int k = 0; k < arr1.length; k++) {
            arr1[k] = m;
            m += 3;
            System.out.print(arr1[k] + " ");
        }
        System.out.println();
        System.out.println("===========================");

//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
//        и числа меньшие 6 умножить на 2;

        int arr2[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("========================");
//   4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//     и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int size = 10;
        int[][] matrix = new int[size][size];
        int value = 1;
        for (int k = 0; k < matrix.length;)
        {
           for (int j = 0; j < matrix.length; k++, j++) {
               matrix[k][j] = value;

           }
        }
        for (int k = 0; k < matrix.length; k++)
        {
            for (int j = 0; j < matrix.length; j++) {

                System.out.print(matrix[k][j]);
            }
            System.out.println();
        }

/*
 * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
 */
        int [] arr3  = {4,3,6,8,9,2,5,3};
        int max = 0;
        int min = 0;

        for (int i = 0; i < arr3.length; i++) {
           max = (max >= arr3[i]) ? max : arr3[i];

        }
        for (int i = 0; i < arr3.length; i++) {
            min = (arr3[i] <= max) ? arr3[i] : max;
        }

        System.out.println("Максимальный элемент массива = "+ max);
        System.out.println("Минимальный элемент массива = "+ min);
        System.out.println(checkBalance(arrTest));
        doDisplaceArr(arrTest, -3);

    }
    /*
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */

    public static int [] arrTest = {1,2,1,3,1};
    public static boolean checkBalance (int []arrI) {
        for (int i = 0; i < arrI.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) sum += arrI[j];
            for (int j = i; j < arrI.length; j++) sum -= arrI[j];
            if (sum == 0) return true;
        }
            return false;
    }
/*
 * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
 *  или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
 *  Для усложнения задачи нельзя пользоваться вспомогательными массивами.
 */
public static void doDisplaceArr (int [] setArr, int displ ) {
    System.out.println("Начальный массив " );
    for (int i = 0; i < setArr.length; i++)
        System.out.print(setArr[i]);
    System.out.println();
    if (displ > 0) {
       int size = setArr.length;
       for (int i = 0; i < displ; i++) {
           int buf = setArr[size - 1];
           for (int j = size - 1; j > 0; j--) {
               setArr[j] = setArr[j - 1];
           }
           setArr[0] = buf;
       }
       System.out.println("Сдвиг на " + displ + " элементов вправо");
       for (int i = 0; i < setArr.length; i++)
           System.out.print(setArr[i]);
   }
    //------------------ левый сдвиг --------------------- //
   if (displ < 0) {
       int size = setArr.length;
       for (int i = displ; i < 0; i++) {
           int buf = setArr[0];
           for (int j = 0; j < size - 1; j++) {
               setArr[j] = setArr[j + 1];
           }
           setArr[size-1] = buf;
       }
       System.out.println("Сдвиг на " + displ + " элементов влево");
       for (int i = 0; i < setArr.length; i++)
           System.out.print(setArr[i]);
   }
}

}
