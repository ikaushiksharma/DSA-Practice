int longestValidParentheses(char* s) {
    int ans=0;
    int len=strlen(s);
    if(len<2) return 0;
    int* list=malloc(sizeof(int)*(len+1));
    list[0]=-1;
    int cnt_left=0;
    for(int i=0;i<len;i++){
        if(s[i]==')'){
            if(cnt_left>0){
                cnt_left--;
                if(ans<i-list[cnt_left]){
                    ans=i-list[cnt_left];
                }
            }else{
                list[0]=i;
            }
        }else{
            cnt_left++;
            list[cnt_left]=i;
        }
    }
    free(list);
    return ans;
}