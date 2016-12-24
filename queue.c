#include <stdio.h>
#include <stdlib.h>

int MAX = 32;
int q[32];
int counter = -1;

void displayQueue() {
	if (counter == -1) {
		printf("Queue is Empty\n");
	}
	else {
		printf("The Queue Elements are -> ");
		for (int i = 0; i <= counter; i++) {
			printf("%d ", q[i]);
		}
		printf("\n");
	}

}

void enqueue() {
	if (counter == 32) {
		printf("Queue Overflows\n");
	}
	else {
		counter++;
		printf("Enter the Element to be added\n");
		scanf("%d", &q[counter]);

	}

}

void dequeue() {
	if (counter == -1) {
		printf("The Queue underflows\n");
	}
	else {
		for (int i = 0; i <= counter; i++) {
			q[i] = q[i+1];
		}
		counter-- ;
	}

}

void exit_prog() {
	exit(0);
}

void main() {
	int choice;
	printf("This is a Queue data-structure\n");
	do {		
		printf("1)Show Queue\n2)Enqueue Element\n3)Dequeue Element\n4)Exit\n");
		scanf("%d" ,&choice);
		switch(choice) {
		case 1 : displayQueue();
		break;
		case 2 : enqueue();
		break;
		case 3 : dequeue();
		break;
		case 4 : exit_prog();
		break;
		default : printf("Invalid choice\n");
		}
	} while(1);	
}