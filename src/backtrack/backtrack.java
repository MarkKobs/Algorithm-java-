package backtrack;

import java.util.Arrays;

/**
 * Created by mk on 2017/10/11.
 * 这是一个最简单的回溯法应用实例，用来解决0-1背包问题
 * 而且是以递归实现的方式，此实现有两个关键点
 * 1.bound 和 constraints 的设置
 * 2.在存储result时从下标0开始，则改成result[t-1]即可
 */
public class backtrack {

    private int n=5;
    private int capacity=10;
    private int weight[] ={2,6,4,1,5};//此二叉树的图共有6层,即 depth = n + 1,但是在创建数组的时候只需要n个即可
    private int value[]={6,9,6,1,4};
    private int result[]=new int[getN()];
    private int totalValue;
    private int totalWeight;
    private int maxValue=0;
    private int maxResult[]=new int[getN()];
    public backtrack(){}//默认构造函数
    public int getN(){
        return n;
    }
    public int getCapacity(){
        return capacity;
    }
    public int gettotalValue(){
        totalValue=0;
        for (int i=0;i<5;i++){
            totalValue=totalValue+result[i]*value[i];
        }
        return totalValue;
    }
    public int gettotalWeight(){
        totalWeight=0;
        for (int i=0;i<5;i++){
            totalWeight=totalWeight+result[i]*weight[i];
        }
        return totalWeight;
    }
    public int getMaxValue(){
        return maxValue;
    }
    public void setMaxValue(int x){
        maxValue=x;
    }
    public void setMaxResult(int maxresult[]){
        System.arraycopy(maxresult,0,maxResult,0,5);
    }
    public int[] getMaxResult(){
        return maxResult;
    }
    public boolean constraint(int t){
        int tempweight=0;
        for(int i=0;i<t;i++){
            tempweight=tempweight+result[i]*weight[i];
        }
        if(tempweight>getCapacity())return false;
        else return true;
    }
    public boolean bound(int t){
        int remain=getCapacity();
        for (int i=0;i<t;i++){
            remain=remain-result[i]*weight[i];
        }
        if (remain<0)return false;
        else return true;
    }
    public void fun(int t){
        if(t>n){
            System.out.print(Arrays.toString(result)+'\t');
            System.out.println("total weight:"+this.gettotalWeight()+" total value:"+this.gettotalValue());
            if(this.gettotalValue() > this.getMaxValue()) {
                this.setMaxValue(this.gettotalValue()); //refresh the max
                this.setMaxResult(this.result);
               }
        }
        else{
            for(int i=0;i<=1;i++){
                result[t-1]=i;
                if(constraint(t)&&bound(t)) fun(t+1);
            }
        }
    }
    public void printMaxResult(){
        System.out.print("max result: "+Arrays.toString(this.getMaxResult())+"\t");
        System.out.println("max value: "+this.getMaxValue());
    }
    public static void main(String []args){
        backtrack b1=new backtrack();
        b1.fun(1);
        b1.printMaxResult();
    }
}
