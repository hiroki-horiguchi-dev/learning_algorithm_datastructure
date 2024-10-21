#include <stdio.h>

/// パラメータaをbで割り、その商をdivに指定されたintに格納する。 割り算の余りは、 modに指定されたintに格納
void ft_div_mod(int a, int b, int *div, int *mod) {
    *div = a / b;
    *mod = a % b;
}

int main(int argc, char const *argv[])
{
    int test_case_a[5];
    test_case_a[0] = 10;
    test_case_a[1] = 30;
    test_case_a[2] = 55;
    test_case_a[3] = 68;
    test_case_a[4] = 134;

    int test_case_b[5];
    test_case_b[0] = 3;
    test_case_b[1] = 2;
    test_case_b[2] = 5;
    test_case_b[3] = 29;
    test_case_b[4] = 33;
 
    int div;
    int mod;
    for (size_t i = 0; i < 5; i++)
    {
        int a = test_case_a[i];
        int b = test_case_b[i];
        ft_div_mod(a, b , &div, &mod);
        printf("a value is %d, b value is %d, div value is %d, mod value is %d \n", a, b, div, mod);
    }
    return 0;
}
