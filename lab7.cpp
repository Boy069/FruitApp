#include<stdio.h>
//652021069
int Q[20] , x;
int front = 0;
int rear = -1;

void load(int x) {
	if (rear == 20) {
		printf("Queue is full.\n");
		return;
	}
	Q[++rear] = x;
	printf("Loaded integer value %d into a queue.\n", x);
}

int execute() {
	if (front > rear) {
		printf("Queue is empty.\n");
        return -1;
	}
	int data = Q[front++];
    return data;
}

void show() {
	if (front > rear) {
        printf("Queue is empty.\n");
        return;
    }
    
	printf("Queue Data are:");
    for (int i = front; i <= rear; i++) {
        printf(" %d", Q[i]);
    }
    printf("\n");
}

int main(){
	int name , x;
	while (1) {
		printf("Menu:\n");
        printf("1. Load queue\n");
        printf("2. Execute\n");
        printf("3. Show queue\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &name);
        
        switch (name) {
        	case 1:
        		printf("Enter an integer value: ");
        		scanf("%d",&x);
        		load(x);
        		printf("---------------------------------------------------\n");
				printf("\n");
        		break;
        	case 2:
        		x = execute();
        		if (x != -1) {
                    printf("Executed value: %d\n", x);
                }
                printf("---------------------------------------------------\n");
        		break;
        	case 3:
        		show();
        		printf("\n---------------------------------------------------\n");
				printf("\n");
        		break;	
        	case 4:
				printf("Finish Program <^_^>\n");
                return 0;
            default:
                printf("Invalid choice.\n");	
		}
	}
	return 0;
}
