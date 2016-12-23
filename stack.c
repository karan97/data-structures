//Implementation of a stack datatype
#include <stdio.h>
#include <stdlib.h>
int MAX = 3;
int stack[3];
int counter = -1;

void displayStack() {
	
	if (counter == -1) {
		printf("Stack is empty\n");
	}

	else {
		printf("The Stack from bottom to top is --> ");
		for (int i = 0; i <= counter; i++)
		{
			printf(" %d", stack[i]);
		}
		printf("\n");
		
	}

}


void push() {

	if (counter == MAX) {
		printf("Stack Overflow\n");
	}

	else {
		counter++;
		printf("Enter the element\n");;
		scanf("%d", &stack[counter]);

	}

}

void pop() {
	if (counter == -1) {
		printf("Stack Underflow\n");
	}

	else {
		printf("%d is popped\n", stack[counter]);
		counter--;
	}

}

void exit_prog() {
	exit(0);
}


void main() {
	int choice;
	printf("This is a stack data-structure\n");
	do {		
		printf("1)Show stack\n2)Push Element\n3)Pop Element\n4)Exit\n");
		scanf("%d" ,&choice);
		switch(choice) {
		case 1 : displayStack();
		break;
		case 2 : push();
		break;
		case 3 : pop();
		break;
		case 4 : exit_prog();
		break;
		default : printf("Invalid choice\n");
		}
	} while(1);	
}