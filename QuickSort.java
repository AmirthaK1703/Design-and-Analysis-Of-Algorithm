import java.util.*;
class QuickSort{
static int hoarePartition(int[] arr,int low,int high)
{
int pivot=arr[low];
int i=low-1;
int j=high +1;
while(true)
{
do
{
i++;
}while (arr[i] <pivot);
do
{
j--;
}while(arr[j]>pivot);
if(i>=j)
{
return j;
}
int temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
}
}
static void quicksort(int[] arr,int low,int high)
{
if(low<high)
{
int p=hoarePartition(arr,low,high);
quicksort(arr,low,p);
quicksort(arr,p+1,high);
}
}
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of element:");
int n=sc.nextInt();
int[] arr=new int[n];
System.out.println("Enter elements:");
for(int j=0;j<n;j++)
{
   arr[j]=sc.nextInt();
}
quicksort(arr,0,n-1);
System.out.println("Sorted Array:");
for (int num:arr)
{
System.out.print(num +" ");
}
}
}
