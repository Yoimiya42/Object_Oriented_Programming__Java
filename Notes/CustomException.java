class MyException extends Exception{
    public MyException(String message){
       super(message); // call the constructor of the parent class
    }
 }
 
 public class CustomException{
    public void customMethod(String code) throws MyException{
       if(!code.equals("5207")){
          throw new MyException("Invalid code.");
       }
    }
 
 
    public static void main(String[] args){
       CustomException obj = new CustomException();
       try{
          obj.customMethod("12334");
       }catch(MyException e){
          System.out.println("Caught custom exception: " + e.getMessage());
       }
    }
 }