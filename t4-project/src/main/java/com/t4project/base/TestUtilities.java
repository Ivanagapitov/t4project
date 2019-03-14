package com.t4project.base;

public class TestUtilities extends BaseTest {

	// Static SLEEP
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected static Object[][] files(){
		return new Object[][] {
			{"index.html"},
			{"load.jpg"},
			{"text.txt"}
		};
		
		}
	}
