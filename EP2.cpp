#include<stdio.h>
main(){
	int i, n, A[10], x, c=0,j=1;
	printf("Input #n: ");
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		printf("Input array[%d]: ",(i+1)); 
		scanf("%d",&A[i]);
	}
	
	printf("Input #x: ");
	scanf("%d",&x);
	for(int j=0;j<n;j++){
		if(A[j]==x){
			c++;
			j++;
			printf("Output: %d occurs %d time(s) at position: %d \n",x,c,j);
		}else{
			printf("Output: %d does not occu\n",x);
		}
	}
	
	return 0;
}
