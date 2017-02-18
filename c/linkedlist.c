// Program to manipulate a linked list
#include <stdio.h>
#include <stdlib.h>

int counter = 1;

struct node {
	int data;
	struct node *link;
} *START = NULL, *LAST = NULL;

void showList() {
	struct node *slcurr;
	if(START == NULL ) {
		printf("\nLinked List is Empty\n");
	}
	else {
		slcurr = START;
		do {
			printf("%d -> ", slcurr -> data);
			slcurr = slcurr -> link;
		} while (slcurr != LAST);
		printf("%d", LAST -> data);		
	}
}

void createList() {
	int a,b;
	struct node *ptr, *curr;
	printf("\nEnter the number of nodes to be added \n");
	scanf("%d", &a);
	for (int i = 1; i <= a; i++) {
		printf("Enter the Item\n");
		scanf("%d", &b);
		ptr = (struct node *) malloc(sizeof(struct node));
		ptr -> data = b;
		ptr -> link = NULL;
		if(START == NULL) {
			START = ptr;
			LAST = ptr;
			curr = ptr;
		}
		else {
			curr -> link = ptr;
			LAST = ptr;
			curr = ptr;
			curr -> link = NULL;
		}
		counter++;
	}
}

void insertEnd() {
	if(START == NULL) {
		printf("\nList is Empty\n");
	}
	else {
		int insertData;
		struct node *ienode, *curr;
		printf("Enter the new Element\n");
		scanf("%d", &insertData);
		ienode = (struct node *) malloc(sizeof(struct node));
		ienode -> data = insertData;
		ienode -> link = NULL;
		LAST -> link = ienode;
		LAST = ienode;
		curr = ienode;
		counter++;
	}
}

void insertPostition() {
	int position, insertData;
	struct node *nextNode, *newNode, *curr;
	if(START == NULL) {
		printf("\nList is Empty\n");
	}
	else {
		printf("Enter the Position\n");
		scanf("%d", &position);
		if(position > counter) {
			printf("Invalid Position\n");
		}
		else {
			curr = START;
			for (int i = 1; i < position - 1; i++)
			{
				curr = curr -> link;
			}
			nextNode = curr -> link;
			printf("Enter the new Element\n");
			scanf("%d", &insertData);
			newNode = (struct node *) malloc(sizeof(struct node));
			newNode = (struct node *) malloc(sizeof(struct node));
			newNode -> data = insertData;
			newNode -> link = nextNode;		
			curr -> link = newNode;
			counter++;
		}
	}
}

void deletePosition() {
	int position;
	struct node *nodepos, *curr;
	if(START == NULL) {
		printf("\nList is Empty\n");
	}
	else {
		printf("Enter the position\n");
		scanf("%d", &position);
		if(position > counter) {
			printf("Invalid Position\n");
		}
		else {
			curr = START;
			for (int i = 1; i < position - 1; i++)
			{
				curr = curr -> link;
			}
			nodepos = curr -> link;
			curr -> link = nodepos -> link;
		}
		
	}
}

void exitlist() {
	exit(0);
}

void main() {
	int choice;
	printf("LINKED LIST \n");
	do{
		printf("\nSelect any of the following:\n1)Show Linked List\n2)Create List\n3)Insert in the end\n4)Insert at a position\n5)Delete at a position\n6)Exit\n");
		scanf("%d", &choice);
		switch(choice) {
			case 1: showList();
			break;
			case 2: createList();
			break;
			case 3: insertEnd();
			break;
			case 4: insertPostition();
			break;
			case 5: deletePosition();
			break;
			case 6: exitlist();
			break;
			default: printf("Invalid Choice\n");
		}
	} while(1);
}