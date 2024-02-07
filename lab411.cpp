#include <stdio.h>
//652021069

int i;
int stLen(char s[]){
	for(i=0;s[i]!='\0';i++);
	return i;
}
int stCmp(char s1[], char s2[]) {
    int i = 0;
    while (s1[i] != '\0' && s2[i] != '\0') {
        if (s1[i] != s2[i]) {
            return 1;
        }
        i++;
    }
    if (s1[i] == s2[i]) {
        return 0;
    }
    return 1;
}

void subSt(char s[],int x, int y){
	int n=0;
	char s2[100];
	for(i=0;s[i]!='\0';i++){
		n++;
	}
	printf("\nNumber of Text1 1st character [1-%d] :",n);
	scanf("%d",&x);
	printf("Number of Text1 2nd character [1-%d] && 2nd>=1st :",n);
	scanf("%d",&y);
	printf("Show Number of characters : ");
	if(x>y){
		printf("Can't display message");
	}
	for(i=(x-1);i<y;i++){
			printf("%c",s[i]);
	}
}
void stConcat(char s1[], char s2[]) {
    printf("\nConcatenated string. [Text1 <-- Text2] : %s%s",s1,s2);
}

int main(){
	char Text1[100],Text2[100];
	int n,compare;
	printf("Enter a string 1 : ");
	gets(Text1);
	n = stLen(Text1);

	printf("Enter a string 2 : ");
	gets(Text2);
	compare = stCmp(Text1,Text2);
	
	printf("\nnumber of characters = %d",n);
	printf("\nCompare = %d",compare);
	
	subSt(Text1,0,0);
	stConcat(Text1,Text2);
	
}
