COUNTER from 0 อ่านได้ว่านับเลขอะไร
เรียกใช้ inc เพิ่มค่า
เรียกใช้ reset เพื่อให้ค่าเป็น 0 
จงเขียน class Counter.

public class Counter {

     private int num;
     private int maxval;
    
     public Counter(int max) {
         num = 0;
         maxval = max;
     }
     public int read(){
         return num;
     }
     public void inc(){
        if (num == maxval)
            reset();
        num++;
     }
     
     public void reset(){
        num = 0;
     }
     
}



เขียนโปรแกรมเรียกใช้

public class TestCounter() {
   public static void main(String args[]) {
       Counter cnt1 = new Counter;
       
       for(i=0; i<3; i++;) {
           cnt1.inc();
           System.out.println(c.read() + ",");
       }
   
   }

}
