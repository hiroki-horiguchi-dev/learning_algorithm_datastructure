#include <unistd.h>

/// 仕様
/// 小文字のアルファベットすべてを、“z”から降順に1行で標準出力に出力する 関数を作成せよ

void print_alphabet() {
    char letter = 'z';

    // ASCII コードでディクリメントして表示
    while ('a' <= letter)
    {
        write(1, &letter, 1);
        letter--;
    }
}

int main() {
    print_alphabet();
    return 0;
}

/// 出力
/// zyxwvutsrqponmlkjihgfedcba%