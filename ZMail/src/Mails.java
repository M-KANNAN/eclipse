import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Mails {
	
	Integer mailId;
	String to;
	String from;
	String subject;
	String messege;
	Scanner scanner=new Scanner(System.in);
	
	

	public Mails(Integer mailId, String to, String from, String subject, String messege) {
		
		this.mailId=mailId;
		this.to=to;
		this.from=from;
		this.subject=subject;
		this.messege=messege;
	}

	public Mails() {
		
	}

	public void composeMail(String userName) {
		
		System.out.println("******************************");
		System.out.println("-------compose mail----------");
		int i=1;
		while(i <= 4) {
			if(i == 1) {
				mailId= (int)(Math.random()*900+100);
				System.out.println("MailId : "+mailId);
				CreateAccount details=CreateAccount.database.get(userName);
				System.out.println("Enter From Address : "+details.name);
				from=details.name;
				i++;
			}
			else if(i == 2) {
				System.out.println("Enter To Address: ");
				to=scanner.nextLine();
				i++;
				
			}
			else if(i == 3) {
				System.out.println("Enter the Subject minumum 5 characters :");
				subject=scanner.nextLine();
				if(subject.length() < 4) {
					i =3;
				}
				else {
					i++;
				}
				
			}
			else if(i == 4) {
				System.out.println("Enter the Text Message :");
				messege=scanner.nextLine();
				
				// our mail box in send box
				Mails mail=new Mails(mailId,to,from,subject,messege);
				CreateAccount detailsFrom=CreateAccount.database.get(userName);//sender
				LinkedHashMap mailsFrom=detailsFrom.sendMails; //sendbox
				mailsFrom.put(mailId, mail);
				System.out.println("Mailed Successfully");
				
			
				// mail in receiver side
				
				CreateAccount detailsTo=CreateAccount.database.get(to); //receiver
				LinkedHashMap mailsTo=detailsTo.mails;
				mailsTo.put(mailId, mail); // in mail box
				
				i++;

			}
		}
		
		
		
	}

	
	
	public void viewMail(String userName) {
		
		System.out.println("------INBOX-----");
		
		CreateAccount details=CreateAccount.database.get(userName);
		LinkedHashMap<Integer, Mails> mails=details.mails;
//		
//		Iterator<Integer> iterator=mails.keySet().iterator();
//		while(iterator.hasNext()) {
//			int m = iterator.next();
//			Mails output=(Mails) mails.get(m);
//			System.out.println("MessageId : "+output.mailId);
//			System.out.println("From : "+output.from);
//			System.out.println("To : "+output.to);
//			System.out.println("Subject : "+output.subject);
//			System.out.println("Message :"+output.messege);
//		}
		
		for(Entry<Integer, Mails> entry : mails.entrySet()) {
			
			Mails output=entry.getValue();
			System.out.println("MessageId : "+entry.getKey());
			System.out.println("From : "+output.from);
			System.out.println("To : "+output.to);
			System.out.println("Subject : "+output.subject);
			System.out.println("Message :"+output.messege);
	
		}
		
		
	}


	public void viewSentMail(String userName) {
		
		System.out.println("------OUTBOX------");
		CreateAccount details=CreateAccount.database.get(userName);
		LinkedHashMap<Integer, Mails> mails=details.sendMails;
		
//		Iterator<Integer> iterator=mails.keySet().iterator();
//		while(iterator.hasNext()) {
//			int m = iterator.next();
//			Mails output=(Mails) mails.get(m);
//			System.out.println("MessageId : "+output.mailId);
//			System.out.println("From : "+output.from);
//			System.out.println("To : "+output.to);
//			System.out.println("Subject : "+output.subject);
//			System.out.println("Message :"+output.messege);
//		}
		
		
		for(Entry<Integer, Mails> entry : mails.entrySet()) {
			
			Mails output=entry.getValue();
			System.out.println("MessageId : "+entry.getKey());
			System.out.println("From : "+output.from);
			System.out.println("To : "+output.to);
			System.out.println("Subject : "+output.subject);
			System.out.println("Message :"+output.messege);
	
		}
		
	}

	public void deleteMail(String userName) {
		
		CreateAccount details=CreateAccount.database.get(userName);
		LinkedHashMap mails=details.mails;
		System.out.println("Enter the mailId to be deleted :");
		int deleteId=scanner.nextInt();
		mails.remove(deleteId);
		System.out.println("Message deleted Successfully");
		
	}

}
