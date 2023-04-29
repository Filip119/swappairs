package sk.fzdp.ciphers.swappairs;

import org.springframework.stereotype.Repository;

@Repository
public class SwappairsService {
	
	public String encode(String text) {
		char[] chars = text.toCharArray();
		
		for(int i = 0; i < chars.length - 1; i += 2) {
			char c = chars[i];
			chars[i] = chars[i + 1];
			chars[i + 1] = c;
		}
		return new String(chars);
	}
	
	public String decode(String text) {
		char[] chars = text.toCharArray();
		
		for(int i = 0; i < chars.length - 1; i += 2) {
			char c = chars[i];
			chars[i] = chars[i + 1];
			chars[i + 1] = c;
		}
		return new String(chars);
	}
}
