// 652021069
#include<stdio.h>
main(){
	int num,pow[30][30];
	printf("Start with enter the matrix size :");
	scanf("%d",&num);
	for(int i=0;i<num;i++){
		for(int j=0;j<num;j++){
			if(i<=j){
				printf("Enter a value of A[%d,%d]",i+1,j+1);
				scanf("%d",&pow[i][j]);
				area[j][i]=pow[i][j];
			}
		}

	}
		printf("\n");
	for(int i=0;i<num;i++){
		for(int j=0;j<num;j++){
			printf("  %d",pow[i][j]);
		}
		printf("\n");
	}
}
