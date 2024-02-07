#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 100

int queue[MAX_SIZE];
int front = 0;
int rear = -1;

void load(int x) {
    if (rear == MAX_SIZE - 1) {
        printf("Queue is full.\n");
        return;
    }
    queue[++rear] = x;
    printf("Loaded integer value %d into a queue.\n", x);
}

int execute() {
    if (front > rear) {
        printf("Queue is empty.\n");
        return -1;
    }
    int data = queue[front++];
    return data;
}

void show() {
    if (front > rear) {
        printf("Queue is empty.\n");
        return;
    }
    printf("Queue Data are:");
    for (int i = front; i <= rear; i++) {
        printf(" %d", queue[i]);
    }
    printf("\n");
}

int main() {
    int choice, value;

    while (1) {
        printf("Menu:\n");
        printf("1. Load queue\n");
        printf("2. Execute\n");
        printf("3. Show queue\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter an integer value: ");
                scanf("%d", &value);
                load(value);
                break;
            case 2:
                value = execute();
                if (value != -1) {
                    printf("Executed value: %d\n", value);
                }
                break;
            case 3:
                show();
                break;
            case 4:
                printf("Finish Program\n");
                return 0;
            default:
                printf("Invalid choice.\n");
        }
    }

    return 0;
}

