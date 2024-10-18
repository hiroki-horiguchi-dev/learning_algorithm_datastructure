#include <unistd.h>

/// 仕様
/// 小文字のアルファベットすべてを、“a”から昇順に1行で標準出力に出力

void print_alphabet() {
    char letter = 'a';

    // ASCII コードでインクリメントして表示
    while (letter <= 'z')
    {
        // char を write するにはポインタを渡す必要があるので渡す
        write(1, &letter, 1);
        letter++;
    }
}

int main() {
    print_alphabet();
    return 0;
}

/// 出力
/// abcdefghijklmnopqrstuvwxyz%