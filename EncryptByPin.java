import java.util.Scanner;

public class EncryptByPin
{
	public static void encrypt()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of digits for the Pin you want to generate : ");
		int n = sc.nextInt();                                  
		
		int pin=0;
		String emsg ="";
		System.out.println("Enter any four numbers with "+n+" digits for Pin Generation: ");
		int num1= sc.nextInt();
		int num2= sc.nextInt();
		int num3= sc.nextInt();
		int num4= sc.nextInt();
		System.out.println();
		
		sc.nextLine();
							
		System.out.println("Enter a Message: ");
		String msg= sc.nextLine();
		msg=msg.toLowerCase();         
		msg=msg.replaceAll(" ","");
		int length = msg.length();
		
		int length1 = String.valueOf(num1).length();
		int length2 = String.valueOf(num2).length();
		int length3 = String.valueOf(num3).length();
		int length4 = String.valueOf(num4).length();
		
		if (length1%n==0&&length2%n==0&&length3%n==0&&length4%n==0)
		{
		   int revPin=0;                            
		   for (int i=1;i<=n;i++)
		   {
				int p,q,r,s;
				p=num1%10;
				num1=num1/10;
				q=num2%10;
				num2=num2/10;
				r=num3%10;
				num3=num3/10;
				s=num4%10;
				num4=num4/10;
							
				revPin= (revPin*10)+(Math.min(p, Math.min(q, Math.min(r, s))));
		   }
		   int revPin1 =revPin;
		   
			for(int j = revPin; revPin!=0; revPin=revPin/10)
			{
				int t = revPin%10;
				pin = (pin*10)+t;
			}
				
		System.out.println();	
		                               
		int revPin2 = revPin1;
	 	for (int i = 0; i<length ; i++)
		{
			int p = revPin1%10;
			revPin1=revPin1/10;
			int en=0;
			if(revPin1==0)
			{
				revPin1=revPin2;
			}
			char x = msg.charAt(i);
			en = x+p;
			if(en>122)
			{
				en=(en-122)+96;
			}
	        emsg = emsg +(char)en;
		}
		emsg=emsg.toUpperCase();
		System.out.print("Your generated pin is "+pin+".");
		System.out.println("\nDo remember your pin as you won't be able to decrypt the message without pin");
		System.out.println();
		System.out.println("Your encrypted message is : "+emsg+"\n");
		}
		
		else
		{
			System.out.println("Your Pin couldn't be generated.");
		}
	}
	public static void decrypt()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the pin generated at the time of encryption:");
		int epin = sc.nextInt();
		
		System.out.println("Enter your encrypted message:");
		String emsg = sc.next();
		int revpind=0;
		
		for(int i=epin;epin!=0;epin/=10)
			revpind = (revpind*10)+ (epin%10);
		
		String dmsg = "";
		int copypin = revpind;
		for(int i=0;i<emsg.length();i++)
		{
			char ch = emsg.charAt(i);
			int en = revpind%10;
			revpind/=10;
			if(revpind==0)
				revpind = copypin;
			en = ch-en;
			if(en<65)
			{
				en = en+26;
			}
			dmsg = dmsg + (char)en;
			
		}
		System.out.println("Your original message is:"+dmsg);
	}
	public static void main(String[] args)  
	{
		Scanner sc = new Scanner(System.in);
		int input = 1;
		while(input!=4)
		{
			System.out.println(" __________________________________________________");
			System.out.println("|                                                  |");
			System.out.println("|----------------Encryption Program----------------|");
			System.out.println("|---------1:Ecrypt a message-----------------------|");
			System.out.println("|---------2:Decrypt the message--------------------|");
			System.out.println("|---------3:Exit-----------------------------------|");
			System.out.println("|__________________________________________________|");
			input = sc.nextInt();
			switch(input)
			{
				case 1:	encrypt();
						break;
				case 2: decrypt();
						break;
				case 3: System.exit(0);
			}	
		}
	}
}