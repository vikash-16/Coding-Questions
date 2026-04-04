Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack?
A: In this case, return -1.

Q: What should pop do on empty stack?
A: In this case, nothing.

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.




 *********solution::


stack<pair<int,int> >s;
MinStack::MinStack() {
    stack<pair<int, int> >temp;
    s = temp;
}

void MinStack::push(int x) {
    if(s.empty()) {
        s.push(make_pair(x,x));
    }else {
        int m;
        pair<int,int>p = s.top();
        m = min(x,p.second);
        s.push(make_pair(x,m));
    }
}

void MinStack::pop() {
    if(!s.empty())
        s.pop();
}

int MinStack::top() {
    if(s.empty()) {
        return -1;
    }else {
        return s.top().first;
    }
}

int MinStack::getMin() {
    if(s.empty()) {
        return -1;
    }else {
        return s.top().second;
    }
}



