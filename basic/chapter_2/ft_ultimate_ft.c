#include <unistd.h>

/// 仕様
/// パラメータとして、intへのポインタの9重ポインタを受け取り、 
/// そのintの値を変更する関数を作成

void ft_ultimate_ft(int *********nbr) {
    *********nbr = 20; 
}

void ft_putnbr(int nb)
{
    char c;
    
    // int to str and output
    if (nb > 9) 
        ft_putnbr(nb / 10);
    c = nb % 10 + '0'; 
    write(1, &c, 1);
}

int main(int argc, char const *argv[])
{
    int num = 10;
    write(1, "before: ", 9);
    ft_putnbr(num);
    write(1, "\n", 1);
    int *p1 = &num;
    int **p2 = &p1;
    int ***p3 = &p2;
    int ****p4 = &p3;
    int *****p5 = &p4;
    int ******p6 = &p5;
    int *******p7 = &p6;
    int ********p8 = &p7;
    int *********p9 = &p8;
    ft_ultimate_ft(p9);
    write(1, "after: ", 8);
    ft_putnbr(num);
    write(1, "\n", 1);
    return 0;
}

/// 出力
/// before: 10
/// after: 20

/// 感想
/// ポインタは、定義された関数以外の関数、つまり
/// スコープの外で変数そのものの値を変更することを視覚的にわかりやすくするために存在していると想像
/// プログラムで変数を扱うとき、メモリに保存した値の保存、編集処理と、その値を使って計算等をする処理を分けている感じ
/// 反対に Java, Kotlin は参照渡しなので、全てがメモリに保存した値の保存編集処理になる
