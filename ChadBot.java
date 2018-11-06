package chadbot;

import java.io.IOException;

import chadbot.wiki.WikiText;

public class ChadBot {

	public static void main(String[] args) {
		try {
			System.out.println(WikiText.getWikiText("bears"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
