#include <stdio.h>
#include <stdbool.h>
typedef struct Nome{
char nome[1000];
}Nome;

int main(void) 
{
  Nome palin[1000];
  int a=0, i=0;
  bool verifica[1000];
    do{
      scanf(" %[^\n]",palin[i].nome);
      
      if(palin[i].nome[0]=='F'&&palin[i].nome[1]=='I'&&palin[i].nome[2]=='M'&& palin[i].nome[3]=='\0'){
        a=1;
      }
      else{
        int n=0;
        for(int x=0;palin[i].nome[x]!='\0';x++)
          {
            n++;
          }
        int v=n;
        for(int x=0;x<n/2;x++){
          v--;
          if(palin[i].nome[x]==palin[i].nome[v]){
            if(x==(n/2)-1){
              verifica[i]=true;
            }
          }
          else{
              verifica[i]=false;
              x=n;
            }     
      }
    }
    i++;
    }while(a==0);
    for(int x=0;x<i-1;x++){
      if(verifica[x]==true){
        printf("SIM\n");
      }
      else{
        printf("NAO\n");
      }
    }
}