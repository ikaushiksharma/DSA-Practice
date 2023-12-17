/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int* res=(int*)malloc(sizeof(int)*(*returnSize=numsSize));
    int left=0;
    int right=numsSize-1;
    int idx=numsSize-1;
    while(left<=right){
        if(abs(nums[left])>abs(nums[right])){
            res[idx--]=nums[left]*nums[left];
            left++;
        }else{
            res[idx--]=nums[right]*nums[right];
            right--;
        }
    }
    return res;
}