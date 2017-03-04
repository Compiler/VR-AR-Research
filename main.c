
#include "LinkedList.h"


void add(int newVar){
	curSize++;
	if(head == NULL){
		head = malloc(sizeof(node_t));
		head->var = newVar;
		return;
	}
	node_t *ref = head;
	while(head->next != NULL){
		head = head->next;
	}
	head->next = malloc(sizeof(node_t));
	head->next->var= newVar;
	head = ref;
}

void printAll(void){
	printf("Displaying List...\n");
	node_t *ref = head;
	int count = 0;
	while(ref != NULL){
		printf("%d-  %d\n", count++, ref->var);
		ref = ref->next;
	}

}

int get(int index){

	node_t *ref = head;
	int count = 0;
	while(ref != NULL){
		
		if(count == index){
			return ref->var;
		}
		ref = ref->next;
		count++;
	}

	return -1;


}

int size(void){
	return curSize;
