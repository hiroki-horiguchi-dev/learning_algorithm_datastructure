#include <unistd.h>
#include <limits.h>

/// 仕様
/// パラメータとして、intへのポインタを受け取り、そのintの値を42にする関数を 作成せよ

void ft_putnbr(int nb)
{
    char c;
    
    // int to str and output
    if (nb > 9) 
        ft_putnbr(nb / 10);
    c = nb % 10 + '0'; 
    write(1, &c, 1);
}

void ft_ft(int *nbr) {
    *nbr = 20;
}

int main(int argc, char const *argv[])
{
    int number = 10;
    write(1, "before: ", 9);
    ft_putnbr(number);
    write(1, "\n", 1);
    write(1, "after: ", 8);
    ft_ft(&number);
    ft_putnbr(number);
    write(1, "\n", 1);
    return 0;
}
