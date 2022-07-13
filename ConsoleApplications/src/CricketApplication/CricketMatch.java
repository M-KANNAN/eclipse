package CricketApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CricketMatch {
	
	protected HashMap<Integer, PlayerPojo> hashMap=new LinkedHashMap<Integer, PlayerPojo>();
	protected HashMap<Integer, EveryBallScore> hashMap2 =new LinkedHashMap<Integer, EveryBallScore>();
	ArrayList<Integer> arrayList=new ArrayList<Integer>();
	

	public void playerAdder() {
		// TODO Auto-generated method stub
		
		
		for(int i=1;i<=11;i++) {
			PlayerPojo  playerPojo=new PlayerPojo();
			playerPojo.setName("PLAYER - "+i);
			playerPojo.setBallFaced(0);
			playerPojo.setScore(0);
			playerPojo.setSmashedFours(0);
			playerPojo.setSmashedSixers(0);
			playerPojo.setStatus(true);
			
			hashMap.put(i, playerPojo);
		}
		
		this.cricketMatch();
		
	}

	private void cricketMatch() {
		
		Scanner scanner=new Scanner(System.in);
		
		Integer strikerPlayer=1;
		Integer nonStrikerPlayer=2;
		Integer temp=null;
		
		PlayerPojo palyerPojo=null;
		
		//striker status setter
		
		hashMap.get(strikerPlayer).setStatus(false);
		hashMap.get(nonStrikerPlayer).setStatus(false);
		
		int balls=1;
		
		int max = 6;
        int min = 0;
        int range = max - min + 1;
        
        System.out.println();
        System.out.println("Enter a number of overs ");
        int mathOvers=scanner.nextInt();
       
        
       
        
		while(balls <= mathOvers*6) {
			
			if(!arrayList.contains(strikerPlayer)) {
				arrayList.add(strikerPlayer);
			}
			
			hashMap.get(strikerPlayer).setStatus(false);
			
			
			
			int runsInTheBall= (int)(Math.random() * range) + min;
			
			EveryBallScore  ballScore=new EveryBallScore();
			
			ballScore.setStrikerName(hashMap.get(strikerPlayer).getName());
			
			ballScore.setRunsInBall(runsInTheBall !=5 ? runsInTheBall+" RUNS" : "!!! WICKET !!!");
			hashMap2.put(balls, ballScore);
			
			
			if(balls % 6 != 0) {
				
				if(runsInTheBall != 5) {
					
					palyerPojo = hashMap.get(strikerPlayer);
					
					this.MatchStart(palyerPojo,strikerPlayer,runsInTheBall,balls);
						
					if(runsInTheBall % 2 != 0) {
						temp=strikerPlayer;
						strikerPlayer=nonStrikerPlayer;
						nonStrikerPlayer=temp;
						
					}
					
				}
				else {
					this.wicketHandler(strikerPlayer,balls);
					
					if(arrayList.size()<11) {
						strikerPlayer=scanner.nextInt();
					}
					else {
						break;
					}
						
					
					
				}
				
			}
			else {//last ball of the over
				
				if(runsInTheBall != 5) {
					
					palyerPojo = hashMap.get(strikerPlayer);
					
					 // only one changes
					
					this.MatchStart(palyerPojo,strikerPlayer,runsInTheBall,balls);

						if(runsInTheBall % 2 == 0) {//striker rotate
							temp=strikerPlayer;
							strikerPlayer=nonStrikerPlayer;
							nonStrikerPlayer=temp;
						
						}	
				}
				else {//striker rotate
					this.wicketHandler(strikerPlayer,balls);
					
					if(arrayList.size() < 11) {
						temp=scanner.nextInt();
						strikerPlayer=nonStrikerPlayer;
						nonStrikerPlayer=temp;
					}
					else {
						break;
					}
					
				}
			}
			++balls;
			
		}
		
		this.ballBasedResult();
		
		this.scoreViewer(nonStrikerPlayer);
		scanner.close();
		
	}


	private void ballBasedResult() {
		
		 System.out.println();
			System.out.println("\t\t !!! EVERY BALL BASED RESULT !!!");
			System.out.println();
		
		for(Entry<Integer,EveryBallScore > entry : hashMap2.entrySet()) {
			if(!entry.getValue().getRunsInBall().contains("!!! WICKET !!!")) {
				System.out.println("Ball : "+entry.getKey()+"\t Striker Name : "+entry.getValue().getStrikerName() +"\t Runs in the Ball : "+entry.getValue().getRunsInBall());
			}
			else {
				System.err.println("Ball : "+entry.getKey()+"\t Striker Name : "+entry.getValue().getStrikerName() +"\t Runs in the Ball : "+entry.getValue().getRunsInBall());
			}
			
			
		}
		
		
	}

	private void wicketHandler(Integer strikerPlayer, int balls) {
		
//		if(!arrayList.contains(strikerPlayer)) {
//			arrayList.add(strikerPlayer);
//		}
		
		PlayerPojo palyerPojo = hashMap.get(strikerPlayer);				
		System.out.println();
		System.out.println("Ball "+balls+" !!! WICKET !!! "+palyerPojo.getName());
		System.out.println();
		//ball faced setting 
		hashMap.get(strikerPlayer).setBallFaced(palyerPojo.getBallFaced()+1);
		if(arrayList.size() <= 10) {
			System.out.println();
			System.out.println("Enetr a player ID to play");
			System.out.println("!!! AVAILABLE PLAYERS !!!");
			for(Integer obj : hashMap.keySet()) {
				if(hashMap.get(obj).setStatus() ) {
					System.out.print(obj+"\t");
				}
				
			}
		}
		else {
			System.out.println();
			System.out.println("!!! ALL OUT !!!");
			System.out.println();
		}
		System.out.println();
		

	}

	private void MatchStart(PlayerPojo palyerPojo, Integer strikerPlayer, int runsInTheBall, int balls) {
		
		//run setting
		hashMap.get(strikerPlayer).setScore(palyerPojo.getScore()+runsInTheBall);
		
		//ball faced setting 
		hashMap.get(strikerPlayer).setBallFaced(palyerPojo.getBallFaced()+1);
		
		//boundray setting
		if(runsInTheBall == 4) {
			hashMap.get(strikerPlayer).setSmashedFours(palyerPojo.getSmashedFours()+1);
		}
		else if(runsInTheBall == 6) {
			hashMap.get(strikerPlayer).setSmashedSixers(palyerPojo.getSmashedSixers()+1);
		}
		
		
		//System.out.println("Ball : "+balls+" \t Striker : "+hashMap.get(strikerPlayer).getName()+" \t Runs scored in the ball : "+runsInTheBall);
		
	}

	private void scoreViewer(Integer nonStrikerPlayer) {
		System.out.println();
		System.out.println("\t\t\t !!! SCORE CARD !!!");
		System.out.println();
		
		for(Entry<Integer, PlayerPojo> entry: hashMap.entrySet()) {
			
			if(!entry.getKey().equals(nonStrikerPlayer)) {
				System.out.println();
				System.out.print("Name "+entry.getValue().getName()+" | \t");
				System.out.print("Score "+entry.getValue().getScore()+" | \t");
				System.out.print("Ball faced "+entry.getValue().getBallFaced()+" | \t");
				System.out.print("4's Smashed "+entry.getValue().getSmashedFours()+" | \t");
				System.out.print("6's samsed "+entry.getValue().getSmashedSixers()+" | \t");
				System.out.println("OUT" );
				System.out.println();
				System.out.println("\t\t************************************");
				System.out.println();
			}
			else {
				
				System.out.println();
				System.err.print("Name "+entry.getValue().getName()+" | \t");
				System.err.print("Score "+entry.getValue().getScore()+" | \t");
				System.err.print("Ball faced "+entry.getValue().getBallFaced()+" | \t");
				System.err.print("4's Smashed "+entry.getValue().getSmashedFours()+" | \t");
				System.err.print("6's samsed "+entry.getValue().getSmashedSixers()+" | \t");
				System.err.println("NOT OUT" );
				System.err.println();
				System.out.println("\t\t************************************");
				System.out.println();
				
			}
			
			
		}
		
	}

}
