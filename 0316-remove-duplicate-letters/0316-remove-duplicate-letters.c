char* removeDuplicateLetters(char* s) {
    int last_occurrence[256] = {0};
    int stack[256] = {0};
    int top = -1;
    int visited[256] = {0};

    // Populate last_occurrence array
    for (int i = 0; s[i] != '\0'; ++i) {
        last_occurrence[s[i]] = i;
    }

    // Process the string
    for (int i = 0; s[i] != '\0'; ++i) {
        if (!visited[s[i]]) {
            while (top != -1 && s[i] < stack[top] && i < last_occurrence[stack[top]]) {
                visited[stack[top]] = 0;
                top--;
            }
            stack[++top] = s[i];
            visited[s[i]] = 1;
        }
    }

    // Create the result string
    char* result = (char*)malloc((top + 2) * sizeof(char));
    for (int i = 0; i <= top; ++i) {
        result[i] = stack[i];
    }
    result[top + 1] = '\0';

    return result;
}