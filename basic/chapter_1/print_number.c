#include <unistd.h>
#include <limits.h>

/// 仕様
/// パラメータとして渡された数を標準出力に出力する関数を作成せよ
/// その際、 int型に収まるすべてのパターンを標準出力に出力する

void print_number(int nb) {
    char digit;
    
    if (nb < 0) {
        if (nb == INT_MIN) {
            write(1, "-2147483648", 11);
            return;
        }
        write(1, "-", 1);
        nb = -nb;
    }
    
    if (nb >= 10) {
        print_number(nb / 10);
    }
    
    digit = '0' + (nb % 10);
    write(1, &digit, 1);
}

int main() {
    print_number(INT_MIN);
    write(1, "\n", 1);
    print_number(-123);
    write(1, "\n", 1);
    print_number(123);
    write(1, "\n", 1);
    print_number(INT_MAX);
    return 0;
}

/// 出力
/// -2147483648
/// -123
/// 123
/// 2147483647%  
/// パッと見は理解しにくい
/// write 関数のみしか使えない制限を課しているので再帰関数を用いて出力する

/// 処理の順序で見る(123 が入った場合)
/// 再帰: 123/10 = 12, '0' + (12 % 10) = 2
/// 再帰: 12/10  = 1 , '0' + (1 % 10) = 1
/// '0' + (123 % 10) = 3

/// 出力順は 再帰の1,再帰の2,通常処理の3 の順
