
package Rsa;

public class RSA {
 public int   a,b,n,e=0,d;
 public String ch;
 public char char5,char4;
 
 RSA(int num1, int num2, String ch ){
   this.a = num1;
   this.b = num2;
   this.ch = ch;
 }
 
  void generate(){
     int p,q,f,i,j,fl=1;
     p=a;
     q=b;
     n=p*q;
     f=(p-1)*(q-1);
     for(i=2;i<f;i++){
         if( n%i!=0 && f%i!=0 ){
             for( j=i-1 ; j>1 ; j-- ){
                 if(i%j==0)
                 {fl=0;break;}
             }
             if(fl==0)
             {fl=1;continue;}
             e=i;
             break;
         }
     }
     for(i=2;;i++){
         if(((i*e)%f)==1){
          d=i;
          break;
         }
     }
 }
  
 void encripte(){
     String ch1 = ch;
     int i;
     for(i=0;i<ch.length();i++){
         char5=ch.charAt(i);
         if(char5=='\0'){System.out.println("nb");break;}
     long a=(long) Math.pow(char5-64, e);
     a=(a%n)+64;
      char4=(char)a;
         System.out.print(char4);
     }
 }
 
 void decripte(){
     String ch1 = ch;
     int i;
     for(i=0;i<ch.length();i++){
         char5=ch.charAt(i);
         if(char5=='\0'){System.out.println("nb");break;}
     long a=(long) Math.pow(char5-64, d);
     a=(a%n)+64;
      char4=(char)a;
         System.out.print(char4);
     }
 }

}