#include <unistd.h>

/// 仕様
/// パラメータとして渡された文字を標準出力に出力する関数を作成する

void put_char(char c) {
    write(1, &c, 1);
}

int main() {
    put_char('a');
    return 0;
}

/// 出力
/// a%