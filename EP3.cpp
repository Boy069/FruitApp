#include<stdio.h>
main(){
	int i,j,n,num[10][10],max;
	printf("Input #n: ");
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			printf("\nInput X[%d,%d] : ",i+1,j+1);
			scanf("%d",&num[i][j]);
			if(max<num[i][j]){
				max=num[i][j];
			}
		}
		
	}
	printf("\nMaximum number: %d",max);
	return 0;
}
