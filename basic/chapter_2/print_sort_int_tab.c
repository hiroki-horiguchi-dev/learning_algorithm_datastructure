#include <stdio.h>

/// 仕様
/// ソートを実装せよ

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int *array, int low, int high) {
    int pivot = array[high];  // ピボットを選択（通常は最後の要素）
    int i = low - 1;  // i は小さい値の領域の終わりを指す

    for (int j = low; j < high; j++) {
        if (array[j] < pivot) {
            i++;
            swap(&array[i], &array[j]);
        }
    }

    swap(&array[i + 1], &array[high]);
    return i + 1;
}

void quick_sort(int *array, int low, int high) {
    if (low < high) {
        int pi = partition(array, low, high);
        printf("pi: %d\n", pi);

        quick_sort(array, low, pi - 1);
        quick_sort(array, pi + 1, high);
    }
}

void sort_int_array(int *array, int size) {
    quick_sort(array, 0, size - 1);
}

int main() {
    int numbers[5] = {5, 3, 4, 1, 2};
    int length = sizeof(numbers) / sizeof(numbers[0]);

    print_sort_int_tab(numbers, length);

    printf("Sorted array: ");
    for (int i = 0; i < length; i++) {
        printf("%d ", numbers[i]);
    }
    printf("\n");

    return 0;
}

/// 久しぶりにやったけど全く覚えてなかったし、組めなかった、、エンジニアとしてしょぼいのはこういうところもか。。？