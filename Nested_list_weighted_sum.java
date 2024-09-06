// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int depthSum(List<NestedInteger> nestedList){
    if(nestedList == null || nestedList.size() ==0){
        return 0;
    }

    int result = 0;
    Queue<List<NestedInteger>> q = new LinkedList<>();
    q.add(nestedList);
    int depth = 1;

    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i< size; i++){
            List<NestedInteger> curr = q.poll();
            for(NestedInteger el : curr){
                if(el.isInteger()){
                    result += el.getInteger() * depth;
                }
                else{
                    q.add(el.getList());
                }
            }
        }
        depth++;
    }
    return result;
}