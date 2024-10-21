#include <unistd.h>

/// 仕様
/// 文字列を標準出力に出力する関数
/// write を使わせたい問題なので、仕方ないから使う

void print_putstr(char *strs) {
    int i = 0;
    while (strs[i] != '\0')
    {
        write(1, &strs[i], 1);
        i++;
    }
    
}

int main(int argc, char const *argv[])
{
    /// a --> b --> c --> d ... --> n 、メモリ上の連続した char のうち、a のポインタを指す値を *str に保存
    char *strs = "abcdefghijklmn";
    print_putstr(strs);
    return 0;
}

/// 出力
/// abcdefghijklmn%