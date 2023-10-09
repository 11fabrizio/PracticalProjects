#include <stdio.h>

typedef struct Nome{
char num[1000];
}Nome;

int main(void) {
  int N;
  scanf("%d",&N);
  Nome V[N],P[N];
  for(int i=0;i<N;i++){
    scanf("%s",V[i].num);
  }

  int a,b,tam;

  for(int i=0;i<N;i++){
    a=0;
    b=0;
    tam=0;
    for(int x=0;V[i].num[x]!='\0';x++){
      if(V[i].num[x]==46){
        a++;
      }
      tam++;
    }
    if(a!=0){
      for(int x=tam-1;x>=0;x--){
        if(V[i].num[x]==48){
          b++;
        }
        else{
          x=-1;
        }
      }
      for(int x=0;x<tam-b;x++){
        P[i].num[x]=V[i].num[x];
      }
    }
    else{
      for(int x=0;V[0].num[x]!='\0';x++){
        P[i].num[x]=V[i].num[x];
      }
    }
  }
  
  for(int i=N-1;i>=0;i--){
    if(P[i].num[0]==46){
      printf("0%s\n",P[i].num);
    }
    else{
      printf("%s\n",P[i].num);
    }   
  }
}