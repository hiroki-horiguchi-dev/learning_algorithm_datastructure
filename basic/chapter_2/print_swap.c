#include <unistd.h>
#include <stdio.h>

/// 仕様
/// パラメータとして渡された2つの整数の値を交換する関数を作成

void ft_swap(int *num1, int *num2) {
    int temp = *num1;
    *num1 = *num2;
    *num2 = temp;
}


/// 面倒臭いので write の縛りはなしとする
int main(int argc, char const *argv[])
{
    int num1 = 10;
    int num2 = 20;
    printf("before swap. num1: %d, num2 %d\n", num1, num2);
    /// &variable: variable のメモリ上のアドレス
    /// *variable: variable のメモリ上のアドレスにある変数の値
    /// *variable = &variable: が実行できて、*variable にアドレス上の変数の値が保存される
    ft_swap(&num1, &num2);
    printf("after swap. num1: %d, num2 %d\n", num1, num2);
    return 0;
}

/// 出力
/// before swap. num1: 10, num2 20
/// after swap. num1: 20, num2 10