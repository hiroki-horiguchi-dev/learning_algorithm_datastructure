#include <stdio.h>

/// 仕様
/// 文字列の文字の数を返す関数を作成

int ft_strlen(char *str) {
    int length = 0;
    if (str == NULL || *str == '\0') return length;

    while (str[length] != '\0')
    {
        length++;
    }
    return length + 1;
}

int main(int argc, char const *argv[])
{
    char *str1 = "abcdefghijklmn"; /// 15
    printf("result is %d\n", ft_strlen(str1));

    char *str2 = "";
    printf("result is %d\n", ft_strlen(str2));
    return 0;
}

/// 出力
/// result is 15%