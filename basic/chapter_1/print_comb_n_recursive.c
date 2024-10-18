#include <unistd.h>
#include <limits.h>

/// 仕様
/// nの数の異なるすべての組み合わせを、昇順で標準出力に出力する関数を作成

void print_comb_recursive(int n, int depth, int start, char *result) {
    if (depth == n) {
        write(1, result, n);
        if (result[0] != '9' - n + 1) {
            write(1, ", ", 2);
        }
        return;
    }

    int i = start;
    while(i <= 9) {
        result[depth] = '0' + i;
        print_comb_recursive(n, depth + 1, i + 1, result);
        i++;
    }
}

void print_comb_n (int n) {
    if (n <= 0 || 10 <= n) return;
    char result[10]; // 最大で9桁分の結果を格納できる配列
    print_comb_recursive(n, 0, 0 ,result);
}

int main() {
    print_comb_n(0);
    print_comb_n(2);
    write(1, "\n", 1);
    print_comb_n(5);
    write(1, "\n", 1);
    print_comb_n(9);
    write(1, "\n", 1);
    print_comb_n(10);
    return 0;
}

/// 出力


/// 感想
/// 自分で思いつけなかったなこの再帰処理。。。depth のところ、微妙い。
/// 処理の流れ(n=2の場合)
/// 再帰関数で考える、
/// 10個の char 要素が入る result配列を定義
/// 