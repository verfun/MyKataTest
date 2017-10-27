package com.SG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class CompAerBetaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CompAerBetaApplication.class, args);
		
//		
		
		long debut = System.currentTimeMillis();
		 
		//Traitements...
		int res = 0;
//		saeRepository.cleanMpc(res);
		 
//		TeamRepository tRepo =   ctx.getBean(TeamRepository.class);
//		PlayerRepository pRepo =  ctx.getBean(PlayerRepository.class);
//		MatchRepository mRepo =  ctx.getBean(MatchRepository.class);
//		Team teamA = tRepo.findOne(1l);
//		Team teamB = tRepo.findOne(2l);
		
//		Team teamA = new Team();
//		teamA.setName("tata");
//		Player playerA = new Player();
//		playerA.setFirstName("Djokovic");
//		playerA.setLastName("Novak");
//		playerA.setClassementPosition(2);
//		teamA.setPlayer(playerA);
//		tRepo.save(teamA);
//		 
//		Team teamB = new Team();
//		teamB.setName("toto");
//		Player playerB = new Player();
//		playerB.setFirstName("Rafael");
//		playerB.setLastName("Nadal");
//		playerB.setClassementPosition(1);
//		teamB.setPlayer(playerB);
//		tRepo.save(teamB);
//		ArrayList<String> listOfString = null;
		
//		if(listOfString.isEmpty())
//			System.err.println("uuuuu");
//		else 
//			System.err.println("nnnnnnn");
//		Match match = new Match(teamA, teamB);
//		Match match = new Match(3);
//		mRepo.save(match);
//		System.err.println(teamA.getName());
//		tata(teamA);
//		System.err.println(teamA.getName());
//		System.out.println(System.currentTimeMillis()-debut+" and result => "+res);
	}
	

}
