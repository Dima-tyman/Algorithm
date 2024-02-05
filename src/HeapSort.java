public class HeapSort {
    public static void main(String[] args) {

        int[] arr = {2, 5, 9, 20, 14, 12, 11, 13, 5, 6, 7};

        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        //начальная длина массива
        int n = arr.length;

        //преобразование массива в max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }

        //начинаем выкидывать максимальные элементы в конец массива
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //поднимаем максимальный элемент
            heap(arr, i, 0);
        }
    }

    public static void heap(int[] arr, int n, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        //ищем максимальный элемент
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        //если максимальный был изменён, перезаписываем и просеиваем задетое поддерево
        if (root != largest) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heap(arr, n, largest);
        }
    }
}
