#include<stdio.h>
addF(){
	int x,y,sum;
	printf("Enter x: ");
	scanf("%d",&x);
	printf("Enter y: ");
	scanf("%d",&y);
	sum=x+y;
	printf("The result of %d + %d = %d",x,y,sum);
}
powF(){
	int x,y,pow=1,i;
	printf("Enter x: ");
	scanf("%d",&x);
	printf("Enter y: ");
	scanf("%d",&y);
	for(int i=1;i<=y;i++){
		pow=x*pow;
	}
	printf("The result of %d ^ %d = %d",x,y,pow);
	
}
divF(){
	int x,y,min;
	printf("Enter x: ");
	scanf("%d",&x);
	printf("Enter y: ");
	scanf("%d",&y);
	min=x/y;
	printf("The result of %d / %d = %d",x,y,min);
}
main(){
	char  menu='1';
	printf("\t--------------------\n");
	printf("\t---- [M E N U] -----\n");
	printf("\t---- 1. A D D ------\n");
	printf("\t--- 2. P O W E R ---\n");
	printf("\t-- 3. D I V I D E --\n");
	printf("\t---- 4. E X I T ----\n");
	printf("\t--------------------\n");
	
	printf("\nchoice: ");
	scanf("%c",&menu);
	do{
		switch(menu){
		case '1':
			addF();
			break;
		case '2':
			powF();
			break;
		case '3':
			divF();
			break;
		case '4':
			printf("EXIT....BYE\n");
			break;
		default:
			printf("Invalid input !! Try again");				
		}
	}while(menu!='4');
	
	return 0;
}
