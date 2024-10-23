#include <stdio.h>

/// 仕様
/// 与えられた整数の配列の順を逆にして返す関数を作成

void print_rev_int_tab(int *tab, int size) {

   int range = size - 1;
   while (0 <= range) {
        printf("%d\n", tab[range]);
        range--;
   }
}

int main(int argc, char const *argv[])
{
    int numbers[5] = {1,2,3,4,5};
    int length = sizeof(numbers) / sizeof(numbers[0]);

    print_rev_int_tab(numbers, length);
    return 0;
}

/// 出力
/// 5
/// 4
/// 3
/// 2
/// 1