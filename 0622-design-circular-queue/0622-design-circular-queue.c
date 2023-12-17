


typedef struct {
    int *arr;
    int front;
    int end;
    int k;
} MyCircularQueue;


MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue *q;
    q=malloc(sizeof(MyCircularQueue));
    q->arr=malloc(sizeof(int)*k);
    q->front=-1;
    q->end=-1;
    q->k=k;
    return q;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if(obj->front==-1){
        obj->front=0;
        obj->end=0;
        obj->arr[obj->front]=value;
        return true;
    }
    if((obj->end+1)%obj->k == obj->front){
        return false;
    }else{
        obj->end=(obj->end+1)%(obj->k);
        obj->arr[obj->end]=value;
        return true;
    }
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if(obj->front==-1){
        return false;
    }
    if(obj->front==obj->end){
        obj->front=-1;
        obj->end=-1;
        return true;
    }else{
        obj->front=(obj->front+1)%(obj->k);
        return true;
    }
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if(obj->front==-1){
        return -1;
    }else{
        return obj->arr[obj->front];
    }
}

int myCircularQueueRear(MyCircularQueue* obj) {
    if(obj->front==-1){
        return -1;
    }else{
        return obj->arr[obj->end];
    }
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    if(obj->front==-1){
        return true;
    }else{
        return false;
    }
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    if(obj->front==-1){
        return false;
    }else if((obj->end+1)%obj->k == obj->front){
        return true;
    }else return false;
}

void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj->arr);
    free(obj);
}

/**
 * Your MyCircularQueue struct will be instantiated and called as such:
 * MyCircularQueue* obj = myCircularQueueCreate(k);
 * bool param_1 = myCircularQueueEnQueue(obj, value);
 
 * bool param_2 = myCircularQueueDeQueue(obj);
 
 * int param_3 = myCircularQueueFront(obj);
 
 * int param_4 = myCircularQueueRear(obj);
 
 * bool param_5 = myCircularQueueIsEmpty(obj);
 
 * bool param_6 = myCircularQueueIsFull(obj);
 
 * myCircularQueueFree(obj);
*/