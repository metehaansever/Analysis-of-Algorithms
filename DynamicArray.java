import java.util.Arrays;

public class DynamicArray{
    private int array[];
    private int size;  //array'in boyutu
    private int capacity; //array'in kapasitesi
    
    public DynamicArray(){  //array'i başlatmak için default constructor oluşturulur.
        array = new int[2];
        size = 0;
        capacity = 2;
    }

    // size'ı döndürür
    public int size(){
        return size;
    }
     
    // kapasiteyi döndürür
    public int capacity(){
        return capacity;
    }
     
    // array'i yazdırır.
    public void printElements(){
        System.out.println("elements in array are : "+Arrays.toString(array));
    }   
        
    //Complexity of append => Best Case [Big Omega] => O(1)
    //                     => Worst Case [Big O] => O(n) (resize fonksiyonu kadar)
    public void append(int element){ // sona eleman ekleme
        if(size==capacity)          //kapasiteye ulaşıldıysa arttır
            resize(2);
    
        array[size] = element;
        size++;
    }
    
    //Complexity of resize => O(n)
    public void resize(int multiplier){ //kapasiteyi arttırma
        int temp[] = new int[capacity * multiplier];  //yeni kapasiteli geçici array
        for(int i=0; i<capacity ; i++){             //eski diziyi taşıma işlemi
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * multiplier; 
    }

    //Complexity of remove => O(n)
    public void remove(int index){  //belirli index'i silme
        if(index>=size || index<0){
            System.out.println("No element at this index");
        }
        else{
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
        }
        
    }

    public static void main(String []args){
        DynamicArray arr = new DynamicArray();
        System.out.println("\n ---Append--- \n");
        arr.printElements();
        System.out.println("Size of array : "+arr.size()+"\nCapacity of array : "+arr.capacity());
        arr.append(1);
        arr.append(9);
        arr.append(0);
        arr.append(7);
        arr.append(5);
        arr.printElements();
        System.out.println("Size of array : "+arr.size()+"\nCapacity of array : "+arr.capacity());
        
        System.out.println("\n ---Remove--- \n");
        arr.printElements();
        System.out.println("Size of array : "+arr.size()+"\nCapacity of array : "+arr.capacity());
        arr.remove(4);
        arr.remove(3);
        arr.remove(2);
        arr.remove(1);
        arr.remove(0);
        arr.printElements();
        System.out.println("Size of array : "+arr.size()+"\nCapacity of array : "+arr.capacity());
        
        System.out.println("\n ---Resize--- \n");
        arr.printElements();
        System.out.println("Size of array : "+arr.size()+"\nCapacity of array : "+arr.capacity());
        arr.resize(2);
        arr.resize(2);
        arr.resize(2);
        arr.resize(2);
        arr.resize(2);
        arr.printElements();
        System.out.println("Size of array : "+arr.size()+"\nCapacity of array : "+arr.capacity());
        
    }
}
