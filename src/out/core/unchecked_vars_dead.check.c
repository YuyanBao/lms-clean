/*****************************************
Emitting C Generated Code
*******************************************/
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <stdbool.h>
/**************** Snippet ****************/
void Snippet(int32_t x0) {
  int32_t x1 = x0;
  int32_t x2 = x0 + 5;
  int32_t x3 = x1;
  int32_t x4 = x2;
  foo(&x1, x2);
  printf("%d %d\n", x3, x4);
}
/*****************************************
End of C Generated Code
*******************************************/
int main(int argc, char *argv[]) {
  if (argc != 2) {
    printf("usage: %s <arg>\n", argv[0]);
    return 0;
  }
  Snippet(atoi(argv[1]));
  return 0;
}