
 import java.util.Scanner;
 public class cs3110project{
   static int dfa = 0;
   static void startState(char c)
   {
       if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9')
       {
           dfa = 1;
       }
      
      
       else if (c == '.')
       {
           dfa = 10; // go to stae 11 need to make
       }
       // -1 is used to check for any invalid symbol
       else
       {
           dfa = -1; // trap state
       }
    }
   static void state1(char c)
   {
       if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9')
      {
          dfa = 1;  // go back to state 0
      }
    
      else if (c =='.')
      {
          dfa =2; // go to dfa state  2 accept state
        }
      else if (c == 'f' || c == 'F'||c == 'd'|| c == 'D'){
            dfa = 3;   // go to stae 4 accept stae
         }               
       else if (c == 'E' || c == 'e'){
            dfa = 4;   // go to stae 5 accept stae  need to make
         }               
         else if (c == '_'){
            dfa = 11;   // go to stae 5 accept stae  need to make
         }   
      // -1 is used to check for any invalid symbol
      else
      {
          dfa = -1; // trap state
      }
   }
   static void state2(char c)
   {
    
     if  (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
          dfa = 2; //stay in 2 accept
      }
      else if (c == 'f' || c == 'F'||c == 'd'|| c == 'D'){
          dfa = 5; //accept
      }
      else if ( c == 'E'|| c == 'e'){
          dfa = 4;  // reject
      }
      else
      {
          dfa = -1; //trap state
      }
   }
   // function for third state (Q3)of DFA
   static void state3(char c)
   {
    
      {
          dfa = 3; // just an accept state goes nowhere // could add trap state
      }
    
    
   }
   // function for fourth state (Q4) of DFA
   static void state4(char c)
   { if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'|| c == '+'){
      dfa = 7;
         }
     else if (c == '-'){
          dfa = 6;
      }
      else{
          dfa =-1;
      }
   }
   static void state5(char c)
   {
      dfa = 5;
   }
   static void state6(char c)
   {
    if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
        dfa = 8;
           }
    
        else{
            dfa =-1;
        }
   }
   static void state7(char c)
   {
    if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
        dfa = 7;
           }
     else if (c == 'f' || c == 'F'||c == 'd'|| c == 'D'){
            dfa = 5; //accept
        }
        else{
            dfa =-1;
        }
   }
   static void state8(char c)
   {
    if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
        dfa = 8;
           }
        else if (c == 'f' || c == 'F'||c == 'd'|| c == 'D'){
            dfa = 5; //accept
        }
        else{
            dfa =-1;
        }
   }
   static void state9(char c)
   {
    if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
        dfa = 9;
           }
    
        else{
            dfa =-1;
        }
   }
   static void state10(char c)
   {
    if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
        dfa = 2;
           }
    
        else{
            dfa =-1;}
        }
        static void state11(char c)
        {
         if (c == '1'|| c == '2'|| c =='3'||c =='4'||c =='5'|| c == '6'|| c =='7'|| c == '8'|| c =='9'){
             dfa = 1;
                }
          
             else{
                 dfa =-1;}
             }
   public static void main(String[] args) {
    String input;
       Scanner keyboard = new Scanner(System.in);
 System.out.println("Enter a value or press q to quit");
 input = keyboard.nextLine();
 if (input.equals("q")){
   System.exit(0);
 }
 else{
  char strArr[] = input.toCharArray();
  System.out.printf("When input string is: "+input+"\n");
  if (isAccepted(strArr) == 1)
      System.out.printf("ACCEPTED\n" + myStringToFloat(input));
  else
      System.out.printf("REJECTED\n");
 }
   }
  
 public static float myStringToFloat(String input) {
    boolean seenDot = false;
    float divisor = 1.0f;
    char c;
    float ret = 0.0f;
  
    for (int i = 0; i < input.length(); i++) {
        c = input.charAt(i);
        if (c == '.') {
            seenDot = true;
            continue;
        }
        if (c == 'f' || c == 'F')
        continue; 
        if (c =='e'|| c =='E')
        break;
        ret *= 10.0f;
        ret += (float) (c - '0');
        if (seenDot)
            divisor *= 10.0f;
    }
  
    ret /= divisor;
    return ret;
 }
  
 static int isAccepted(char strArr[])
 {
  // store length of string
  int j, len = strArr.length;
  for (j = 0; j < len; j++)
  {
      if (dfa == 0)
          startState(strArr[j]);
      else if (dfa == 1)
          state1(strArr[j]);
      else if (dfa == 2)
          state2(strArr[j]
          );
      else if (dfa == 3)
          state3(strArr[j]);
      else if (dfa == 4)
          state4(strArr[j]);
      else if (dfa ==5)
           state5(strArr[j]);
     else if (dfa == 6)
           state6(strArr[j]);
       else if (dfa == 7)
           state7(strArr[j]
           );
       else if (dfa == 8)
           state8(strArr[j]);
       else if (dfa == 9)
           state9(strArr[j]);
       else if (dfa ==10)
            state10(strArr[j]);
        else if (dfa ==11)
          state11(strArr[j]);
        
      else
          return 0;
  }
  if (dfa == 3 || dfa == 2 || dfa == 5 || dfa ==8 || dfa ==7) // these are accept states
      return 1;
  else
      return 0; 
 }
 }
 