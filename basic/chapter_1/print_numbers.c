#include <unistd.h>

/// 仕様
/// すべての数字を、昇順に1行で標準出力に出力する関数を作成せよ

void print_numbers() {
    char digit = '0';

    while (digit <= '9') {
        write(1, &digit, 1);
        digit++;
    }
}

int main() {
    print_numbers();
    return 0;
}

/// 出力
/// 0123456789%