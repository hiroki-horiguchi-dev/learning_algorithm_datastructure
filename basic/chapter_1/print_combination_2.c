#include <unistd.h>

/// 仕様
/// 00から99まで2つの2桁の数字の異なるすべての組み合わせ(XX XX)を、昇順で 標準出力に出力する関数を作成せよ
void print_combination_two() {
    int i = 0;  
    
    while (i <= 98) {  
        int j = i + 1;  
        
        while (j <= 99) {  
            char digits[5];
            
            digits[0] = '0' + i / 10;
            digits[1] = '0' + i % 10;
            digits[2] = ' ';
            digits[3] = '0' + j / 10;
            digits[4] = '0' + j % 10;
            
            write(1, digits, 5);  
            
            if (i != 98 || j != 99) {
                write(1, ", ", 2);
            }
            
            j++;
        }
        i++;
    }
    write(1, "\n", 1);
}

int main() {
    print_combination_two();
    return 0;
}

/// 出力
/// 00 01, 00 02, 00 03, 00 04 ... 97 98, 97 99, 98 99