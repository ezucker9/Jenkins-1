import java.util.Scanner;

public class Cipher {

    //First Array
   static  char ch[]=new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String args[]){
        Scanner inputInt= new Scanner(System.in);
        Scanner inputString= new Scanner(System.in);
//        char ch[]=new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        System.out.println("Do you want to code or decode? Enter 1 for code or 2 for decode");
        int opt=inputInt.nextInt();
        String sentence;


        switch (opt){
            case 1:
                System.out.println("Enter your sentence all in lowercase with no punctuation:");
                sentence=inputString.nextLine();

                System.out.println("Your message is:");
                System.out.println(encode(sentence));

                break;

            case 2:
                System.out.println("Enter your sentence all in secret code with no punctuation:");
                sentence=inputString.nextLine();

                int arr[]=new int[sentence.length()];


                System.out.println("Your message is:");
                System.out.println(decode(sentence));

                break;
            default:
                System.out.println("Invalid option");

        }

    }

    public static String encode(String sentence){

        char ch1;
        String str="";

        //Second array;
       int arr[]=new int[sentence.length()];

        for(int i=0;i<sentence.length();i++){

            ch1=sentence.charAt(i);

            if(ch1==' ') {

                arr[i]=32;
//                str+=" ";

            }else{

                int index = (int) ch1;
                arr[i]=index - 'a';
//                str+=(index - 'a')+" ";

            }

        }



        for (int symbol : arr) {
            str+=(symbol == 32 ? " ": (symbol ) + " ");
        }

        return str;

    }

    public static String decode(String sentence){

        String str="";
        char ch1;

        //Second array
        String val[]=sentence.split(" ");

        for(int i=0;i < val.length; i++) {

            ch1=sentence.charAt(i);

            if(val[i].isEmpty()) {


                str+=" ";

            }else{

                int index =Integer.parseInt(val[i]);

                str+=ch[index];

            }


        }

        return str; // returning the final string to the main function
    }



}

