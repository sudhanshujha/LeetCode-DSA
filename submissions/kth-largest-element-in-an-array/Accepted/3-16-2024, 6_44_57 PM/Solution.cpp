// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
public:
    //these functions helps in heapifying the array

int parent(int i) {return (i-1)/2; }
int leftchild(int i) {return 2*i+1;}
int rightchild(int i) {return 2*i+2; }

void shiftdown(vector<int>&nums, int i,int size){
    //all these l,r,i,curr are indexes
    int l = leftchild(i) , r = rightchild(i), curr = i;
    if(l<=size && nums[curr] < nums[l]) curr = l;
    if(r<=size and nums[r] > nums[curr]) curr = r;
    if(curr != i){
        //this means that one of the child has greater value, so we have to shiftdown the current node
        swap(nums[curr],nums[i]);
        shiftdown(nums,curr,size); // now shiftdown further
    }
}
int findKthLargest(vector<int>& nums, int k) {
    // build a heap and then extractmax() k times
    // building heap takes approx O(n) time,
    // so overall compexity will be O(klogn) which is pretty fast
    
    int n = nums.size();
    //first of all, heapify the array
    for(int i=n/2;i>=0;i--){
        shiftdown(nums,i,nums.size()-1); //size meaning last index
    }
    // now run loop k-1 times to find kth largest element
    int size = nums.size()-1; //size is the last index
    for(int i=0;i<k-1;i++){
        swap(nums[0],nums[size]);
        size--;
        shiftdown(nums,0,size); 
    }
    return nums[0];
}
};