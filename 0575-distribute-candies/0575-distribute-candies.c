int distributeCandies(int* candyType, int candyTypeSize) {
    int arr[200001]={0},nums=0,max=candyTypeSize/2;
    for(int i=0;i<candyTypeSize;i++){
        if(!arr[candyType[i]+100000]){
            arr[candyType[i]+100000]++;
            nums++;
        }
    }
    return max>nums?nums:max;
}