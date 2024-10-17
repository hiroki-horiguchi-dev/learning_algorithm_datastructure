#include <unistd.h>

/// 仕様
/// パラメータとして入力された整数に応じて、“N”または、“P”を標準出力に出 力する関数を作成せよ。 
/// nがマイナスの場合は“N”、nがプラスまたは、nullの 場合は、“P”を標準出力に出力すること。

void is_negative(int num) {
    if (num < 0)
    {
        write(1, "N", 1);
    } else if (0 < num)
    {
        write(1, "P", 1);
    }
    write(1, "\n", 1);
}

int main() {
    is_negative(-2);
    is_negative(0);
    is_negative(1);
    is_negative(3);
    return 0;
}

/// 出力
/// N
///
/// P
/// P