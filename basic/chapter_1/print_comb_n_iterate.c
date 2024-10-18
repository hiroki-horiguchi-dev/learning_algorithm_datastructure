#include <stdio.h>

void print_combinations(int n) {
    if (n <= 0 || 10 <= n) return;
    int combination[10]; // 最大の n = 9 に対応できるように十分なサイズ
    int i;

    for (i = 0; i < n; i++) {
        combination[i] = i;
    }

    while (1) {
        for (i = 0; i < n; i++) {
            printf("%d", combination[i]);
        }
        printf("\n");

        for (i = n - 1; i >= 0; i--) {
            if (combination[i] < 9 - (n - 1 - i)) {
                combination[i]++;
                for (int j = i + 1; j < n; j++) {
                    combination[j] = combination[j - 1] + 1;
                }
                break;
            }
        }

        if (i < 0) {
            break;
        }
    }
}

int main() {
    int n = 3;
    print_combinations(n);
    return 0;
}

/// イテレーションで同様にやれるだろ、と考えて試行錯誤したけど難しかった。。
/// 「動的にループを作る」ロジックがわからなかった。。。悔しい。。
