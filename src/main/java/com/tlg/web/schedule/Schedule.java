package com.tlg.web.schedule;

import org.springframework.stereotype.Component;

@Component
public class Schedule {

//	@Scheduled(fixedRate = 5000)
	public void test() {
		System.out.print("OK");
	}

}
