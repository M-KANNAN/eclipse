package CricketApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CricketMatch {

	protected HashMap<String, HashMap<Integer, PlayerPojo>> teamDetails = new LinkedHashMap<String, HashMap<Integer, PlayerPojo>>();
	// protected HashMap<Integer, EveryBallScore> playerBowlingDetails =new
	// LinkedHashMap<Integer, EveryBallScore>();
	// protected HashMap<String, HashMap<Integer, EveryBallScore>>
	// teamBowlingDetails=new LinkedHashMap<String,
	// HashMap<Integer,EveryBallScore>>();

	 ArrayList<Integer> arrayList=new ArrayList<Integer>();

	int count = 0;

	public void playerAdder() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		byte count = 1;
		while (count <= 2) {
			HashMap<Integer, PlayerPojo> playerDetails = new LinkedHashMap<Integer, PlayerPojo>(); // 2 hashmap must be
																									// used
			for (int i = 1; i <= 11; i++) {
				PlayerPojo playerPojo = new PlayerPojo();
				playerPojo.setName("PLAYER - " + i);
				playerPojo.setBallFaced(0);
				playerPojo.setScore(0);
				playerPojo.setSmashedFours(0);
				playerPojo.setSmashedSixers(0);
				playerPojo.setAvailableStatus(true);
				playerPojo.setWicketStatus(true);
				playerPojo.setballsBowled(0);
				playerPojo.setRunGivenInBowling(0);
				playerPojo.setWicketTaken(0);

				playerDetails.put(i, playerPojo);
				teamDetails.put("TEAM" + count, playerDetails);
			}
			count++;

		}

		System.out.println();
		System.out.println("Enter a number of overs ");
		int mathOvers = scanner.nextInt();

		System.out.println();
		System.out.println("\t\t  !!! TOSS !!!");
		System.out.println();
		System.out.println("Enter a Team to bat Team1 or Team2 to bat");
		String teamtoBat = scanner.next().toUpperCase();
		System.out.println("Enter a Team to bowl Team1 or Team2 to bat");
		String teamtoBowl = scanner.next().toUpperCase();
		// System.out.println(teamBattingDetails.get(teamtoBat));
		this.cricketMatch(teamtoBat, teamtoBowl, mathOvers);

	}

	private void cricketMatch(String teamtoBat, String teamtoBowl, int mathOvers) {

		Integer strikerPlayer = 1;
		Integer nonStrikerPlayer = 2;
		Integer strikeBowler = 1;
		Integer nonStrikeBowler = null;
		Integer temp = null;

		PlayerPojo batterPojo = null;
		PlayerPojo bowlerPojo = null;

		Scanner scanner = new Scanner(System.in);

		//System.out.println(teamtoBat + " " + teamtoBowl);

		int balls = 1;

		int max = 6;
		int min = 0;
		int range = max - min + 1;

		while (balls <= mathOvers * 6) {

			int runsInTheBall = (int) (Math.random() * range) + min;

			teamDetails.get(teamtoBat).get(strikerPlayer).setAvailableStatus(false);
			teamDetails.get(teamtoBat).get(nonStrikerPlayer).setAvailableStatus(false);

			batterPojo = teamDetails.get(teamtoBat).get(strikerPlayer);
			bowlerPojo = teamDetails.get(teamtoBowl).get(strikeBowler);

			if (balls % 6 != 0) {

				if (runsInTheBall != 5) {

					this.battingFunction(batterPojo, runsInTheBall, balls);
					this.bowlingFunction(bowlerPojo, runsInTheBall, balls);

					if (runsInTheBall % 2 != 0) {
						temp = strikerPlayer;
						strikerPlayer = nonStrikerPlayer;
						nonStrikerPlayer = temp;

					}

				} else {
					this.wicketHandler(batterPojo, bowlerPojo, balls);

					if (balls + 1 < mathOvers * 6) {

						System.out.println("!!! AVAILABLE PLAYERS TO BAT !!!");
						System.out.println("Enter a player ID to play");
						System.out.println();
						for (Integer player : teamDetails.get(teamtoBat).keySet()) {
							if (teamDetails.get(teamtoBat).get(player).getAvailableStatus()
									&& teamDetails.get(teamtoBat).get(player).getWicketStatus()) {
								System.out.print(player + "\t");
							}
						}
						while (true) {
							 if(arrayList.size()<11) {

							strikerPlayer = scanner.nextInt();
							if (teamDetails.get(teamtoBat).get(strikerPlayer).getAvailableStatus()
									&& teamDetails.get(teamtoBat).get(strikerPlayer).getWicketStatus()) {
								break;
							} else {
								System.out.println("!!! Select diffrent player !!!");
								System.out.println();
							}
							}
							else {
								System.out.println();
								System.out.println("\t\t\t ALL OUT");
								break;
								
							}
						}

					}

				}

			} else { // last ball of the over

				if (runsInTheBall != 5) {

					this.battingFunction(batterPojo, runsInTheBall, balls);
					this.bowlingFunction(bowlerPojo, runsInTheBall, balls);

					if (runsInTheBall % 2 == 0) {
						temp = strikerPlayer;
						strikerPlayer = nonStrikerPlayer;
						nonStrikerPlayer = temp;

					}

				} else {
					this.wicketHandler(batterPojo, bowlerPojo, balls);

					if (balls + 1 < mathOvers * 6) {

						System.out.println("!!! AVAILABLE PLAYERS TO BAT !!!");
						System.out.println("Enter a player ID to play");
						System.out.println();
						for (Integer player : teamDetails.get(teamtoBat).keySet()) {
							if (teamDetails.get(teamtoBat).get(player).getAvailableStatus()
									&& teamDetails.get(teamtoBat).get(player).getWicketStatus()) {
								System.out.print(player + "\t");
							}
						}
						while (true) {
							 if(arrayList.size()<11) {

							strikerPlayer = scanner.nextInt();
							if (teamDetails.get(teamtoBat).get(strikerPlayer).getAvailableStatus()
									&& teamDetails.get(teamtoBat).get(strikerPlayer).getWicketStatus()) {
								break;
							} else {
								System.out.println("!!! Select diffrent player !!!");
								System.out.println();
							}
							}
							else {
								System.out.println();
								System.out.println("\t\t\t ALL OUT");
								break;
							}
						}

					}

				}

				// bowler rotation

				if (balls + 1 < mathOvers * 6) {
					System.out.println();
					System.out.println(((balls + 1) / 6) + " Over Finised");
					System.out.println();

					System.out.println("!!! AVAILABLE PLAYERS TO BOWL !!!");
					System.out.println("Enter a player ID to play");
					System.out.println();
					for (Integer player : teamDetails.get(teamtoBowl).keySet()) {
						if (player != strikeBowler) {
							System.out.print(player + "\t");
						}
					}
					nonStrikeBowler = strikeBowler;

					while (true) {
						strikeBowler = scanner.nextInt();
						if (nonStrikeBowler != strikeBowler) {
							break;
						} else {
							System.out.println("!!! TRY DIFFRENT BOWLER !!!");
							System.out.println();
						}
					}
				} else {
					System.out.println();
					System.out.println("\t\t\t INNINGS OVER !!!");
					System.out.println();
				}

			}
			// System.out.println("Balls "+balls);

			++balls;
		}

		if (count < 1) {
			count++;
			 //System.out.println("count "+count);
			arrayList.clear();
			
			this.cricketMatch(teamtoBowl, teamtoBat, mathOvers); // recursive call to team shift
		} else {
			this.matchSummary(teamtoBowl, teamtoBat);//reverse
			this.matchSummary(teamtoBat, teamtoBowl);
			 // result viewer
		}

	}

	private void matchSummary(String teamtoBat, String teamtoBowl) {
		System.out.println();
		System.out.println("\t\t\t"+teamtoBat +" BATTING");
		System.out.println();
		for (Entry<Integer, PlayerPojo> entry2 : teamDetails.get(teamtoBat).entrySet()) {

			System.out.println();
			System.out.print("Name " + entry2.getValue().getName() + " | \t");
			System.out.print("Score " + entry2.getValue().getScore() + " | \t");
			System.out.print("Ball faced " + entry2.getValue().getBallFaced() + " | \t");
			System.out.print("4's Smashed " + entry2.getValue().getSmashedFours() + " | \t");
			System.out.print("6's samsed " + entry2.getValue().getSmashedSixers() + " | \t");
			System.out.print(entry2.getValue().getWicketStatus() ? "NOT OUT" : "OUT");
			System.out.println();
			System.out.println("\t\t\t************************************");
			System.out.println();

		}
		
		System.out.println();
		System.out.println("\t\t\t"+teamtoBowl +" BOWLING");
		System.out.println();
		
		for(Entry<Integer, PlayerPojo> entry2 : teamDetails.get(teamtoBowl).entrySet()) {
			System.out.println();
			System.out.print("Name " + entry2.getValue().getName() + " | \t");
			System.out.print("Balls bowled " + entry2.getValue().getballsBowled() + " | \t");
			System.out.print("Runs given  " + entry2.getValue().getRunGivenInBowling() + " | \t");
			System.out.print("Wicket Taken " + entry2.getValue().getWicketTaken() + " | \t");
			System.out.println();
		}

	}

	private void wicketHandler(PlayerPojo batterPojo, PlayerPojo bowlerPojo, int balls) {

		// ball faced setting
		batterPojo.setBallFaced(batterPojo.getBallFaced() + 1);

		System.out.println();
		System.out.println(" !!! WICKET !!! " + batterPojo.getName() + " taken by bowler " + bowlerPojo.getName()
				+ " in the ball " + balls);
		System.out.println();

		// batter wicket status
		batterPojo.setWicketStatus(false);

		// bowler wicket count
		bowlerPojo.setWicketTaken(bowlerPojo.getWicketTaken() + 1);
		bowlerPojo.setballsBowled(bowlerPojo.getballsBowled() + 1);

	}

	private void bowlingFunction(PlayerPojo bowlerPojo, int runsInTheBall, int balls) {

		bowlerPojo.setballsBowled(bowlerPojo.getballsBowled() + 1);

		bowlerPojo.setRunGivenInBowling(bowlerPojo.getRunGivenInBowling() + runsInTheBall);

	}

	private void battingFunction(PlayerPojo batterPojo, int runsInTheBall, int balls) {

		// run setting
		batterPojo.setScore(batterPojo.getScore() + runsInTheBall);

		// ball faced setting
		batterPojo.setBallFaced(batterPojo.getBallFaced() + 1);

		// boundray setting
		if (runsInTheBall == 4) {
			batterPojo.setSmashedFours(batterPojo.getSmashedFours() + 1);
		} else if (runsInTheBall == 6) {
			batterPojo.setSmashedSixers(batterPojo.getSmashedSixers() + 1);
		}

	}

//	public void playerAdder() {
//		// TODO Auto-generated method stub
//		
//		byte count=1;
//		while(count <= 2) {
//			
//			for(int i=1;i<=11;i++) {
//				PlayerPojo  playerPojo=new PlayerPojo();
//				playerPojo.setName("PLAYER - "+i);
//				playerPojo.setBallFaced(0);
//				playerPojo.setScore(0);
//				playerPojo.setSmashedFours(0);
//				playerPojo.setSmashedSixers(0);
//				playerPojo.setAvailableStatus(true);
//				playerPojo.setWicketStatus(true);
//				
//				hashMap.put(i, playerPojo);
//			}
//			
//			hashMap3.put("TEAM "+count,hashMap);
//			count++;
//			
//		}
//		
//		
//		
//		
//		//this.cricketMatch();
//		
//	}
//
//	private void cricketMatch() {
//		
//		Scanner scanner=new Scanner(System.in);
//		
//		Integer strikerPlayer=1;
//		Integer nonStrikerPlayer=2;
//		Integer temp=null;
//		
//		PlayerPojo playerPojo=null;
//	
//		
//		int balls=1;
//		
//		int max = 6;
//        int min = 0;
//        int range = max - min + 1;
//        
//        System.out.println();
//        System.out.println("Enter a number of overs ");
//        int mathOvers=scanner.nextInt();
//       
//        
//       
//        
//		while(balls <= mathOvers*6) {
//			
//			if(!arrayList.contains(strikerPlayer)) {
//				arrayList.add(strikerPlayer);
//			}
//			
//			//striker status setter
//			
//			hashMap.get(strikerPlayer).setAvailableStatus(false);
//			hashMap.get(nonStrikerPlayer).setAvailableStatus(false);
//			
//			
//			playerPojo = hashMap.get(strikerPlayer);
//			
//			
//			int runsInTheBall= (int)(Math.random() * range) + min;
//			
//			EveryBallScore  ballScore=new EveryBallScore();
//			ballScore.setStrikerName(playerPojo.getName());
//			ballScore.setRunsInBall(runsInTheBall !=5 ? runsInTheBall+" RUNS" : "**OUT**");
//			hashMap2.put(balls, ballScore);
//			
//			
//			if(balls % 6 != 0) {
//				
//				if(runsInTheBall != 5) {
//										
//					this.MatchStart(playerPojo,strikerPlayer,runsInTheBall,balls);
//						
//					if(runsInTheBall % 2 != 0) {
//						temp=strikerPlayer;
//						strikerPlayer=nonStrikerPlayer;
//						nonStrikerPlayer=temp;
//						
//					}
//					
//				}
//				else {
//					this.wicketHandler(strikerPlayer,balls);
//					
//					while(true) {
//						if(arrayList.size()<11) {
//							
//							strikerPlayer=scanner.nextInt();
//							if(hashMap.get(strikerPlayer).getAvailableStatus() && hashMap.get(strikerPlayer).getWicketStatus()) {
//								break;
//							}
//							else {
//								System.out.println("!!! Select diffrent player !!!");
//								System.out.println();
//							}
//						}
//						else {
//							break;
//						}
//					}
//					
//					
//						
//					
//					
//				}
//				
//			}
//			else {//last ball of the over
//				
//				if(runsInTheBall != 5) {
//					
//					//palyerPojo = hashMap.get(strikerPlayer);
//					
//					 // only one changes
//					
//					this.MatchStart(playerPojo,strikerPlayer,runsInTheBall,balls);
//
//						if(runsInTheBall % 2 == 0) {//striker rotate
//							temp=strikerPlayer;
//							strikerPlayer=nonStrikerPlayer;
//							nonStrikerPlayer=temp;
//						
//						}	
//				}
//				else {//striker rotate
//					this.wicketHandler(strikerPlayer,balls);
//					
//					while(true) {
//						if(arrayList.size()<11) {
//							
//							strikerPlayer=scanner.nextInt();
//							if(hashMap.get(strikerPlayer).getAvailableStatus() && hashMap.get(strikerPlayer).getWicketStatus()) {
//								temp=scanner.nextInt();
//								strikerPlayer=nonStrikerPlayer;
//								nonStrikerPlayer=temp;
//								break;
//							}
//							else {
//								System.out.println("!!! Select diffrent player !!!");
//								System.out.println();
//							}
//						}
//						else {
//							break;
//						}
//					}
//					
//					
//					
////					if(arrayList.size() < 11) {
////						temp=scanner.nextInt();
////						strikerPlayer=nonStrikerPlayer; 
////						nonStrikerPlayer=temp;
////					}
////					else {
////						break;
////					}
//					
//				}
//			}
//			++balls;
//			
//		}
//		
//		this.ballBasedResult();
//		
//		this.scoreViewer(nonStrikerPlayer);
//		scanner.close();
//		
//	}
//
//
//	private void ballBasedResult() {
//		
//		 System.out.println();
//			System.out.println("\t\t !!! EVERY BALL BASED RESULT !!!");
//			System.out.println();
//		
//		for(Entry<Integer,EveryBallScore > entry : hashMap2.entrySet()) {
//			//if(!entry.getValue().getRunsInBall().contains("**OUT**")) {
//				System.out.println("Ball : "+entry.getKey()+"\t Striker Name : "+entry.getValue().getStrikerName() +"\t Runs in the Ball : "+entry.getValue().getRunsInBall());
////			}
////			else {
////				System.err.println("Ball : "+entry.getKey()+"\t Striker Name : "+entry.getValue().getStrikerName() +"\t Runs in the Ball : "+entry.getValue().getRunsInBall());
//			//}
//			
//			
//		}
//		
//		
//	}
//
//	private void wicketHandler(Integer strikerPlayer, int balls) {
//		
////		if(!arrayList.contains(strikerPlayer)) {
////			arrayList.add(strikerPlayer);
////		}
//		
//		PlayerPojo palyerPojo = hashMap.get(strikerPlayer);				
//		System.out.println();
//		System.out.println("Ball "+balls+" !!! WICKET !!! "+palyerPojo.getName());
//		System.out.println();
//		//ball faced setting 
//		hashMap.get(strikerPlayer).setBallFaced(palyerPojo.getBallFaced()+1);
//		hashMap.get(strikerPlayer).setWicketStatus(false);
//		if(arrayList.size() <= 10) {
//			System.out.println();
//			System.out.println("!!! AVAILABLE PLAYERS !!!");
//			System.out.println("Enter a player ID to play");
//			
//			for(Entry<Integer, PlayerPojo> entry : hashMap.entrySet()) {
//				if(entry.getValue().getAvailableStatus()  && entry.getValue().getWicketStatus()) {
//					System.out.print(entry.getKey()+"\t");
//				}
//			}
//			
//		}
//		else {
//			System.out.println();
//			System.out.println("!!! ALL OUT !!!");
//			System.out.println();
//		}
//		System.out.println();
//		
//
//	}
//
//	private void MatchStart(PlayerPojo palyerPojo, Integer strikerPlayer, int runsInTheBall, int balls) {
//		
//		//run setting
//		hashMap.get(strikerPlayer).setScore(palyerPojo.getScore()+runsInTheBall);
//		
//		//ball faced setting 
//		hashMap.get(strikerPlayer).setBallFaced(palyerPojo.getBallFaced()+1);
//		
//		//boundray setting
//		if(runsInTheBall == 4) {
//			hashMap.get(strikerPlayer).setSmashedFours(palyerPojo.getSmashedFours()+1);
//		}
//		else if(runsInTheBall == 6) {
//			hashMap.get(strikerPlayer).setSmashedSixers(palyerPojo.getSmashedSixers()+1);
//		}
//		
//		
//		//System.out.println("Ball : "+balls+" \t Striker : "+hashMap.get(strikerPlayer).getName()+" \t Runs scored in the ball : "+runsInTheBall);
//		
//	}
//
//	private synchronized void scoreViewer(Integer nonStrikerPlayer) {
//		System.out.println();
//		System.out.println("\t\t\t !!! SCORE CARD !!!");
//		System.out.println();
//		
//		for(Entry<Integer, PlayerPojo> entry: hashMap.entrySet()) {
//			
//			System.out.println();
//			System.out.print("Name "+entry.getValue().getName()+" | \t");
//			System.out.print("Score "+entry.getValue().getScore()+" | \t");
//			System.out.print("Ball faced "+entry.getValue().getBallFaced()+" | \t");
//			System.out.print("4's Smashed "+entry.getValue().getSmashedFours()+" | \t");
//			System.out.print("6's samsed "+entry.getValue().getSmashedSixers()+" | \t");
//			System.out.println(entry.getKey().equals(nonStrikerPlayer) || entry.getValue().getWicketStatus() ? "NOT OUT" : "OUT" );
//			System.out.println();
//			System.out.println("\t\t\t************************************");
//			System.out.println();
//			
//			
//			
//		}
//		
//	}

}
