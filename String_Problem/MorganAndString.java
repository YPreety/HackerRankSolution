package String_Problem;

import java.util.Scanner;

/*Jack and Daniel are friends. Both of them like letters, especially upper-case ones. 
They are cutting upper-case letters from newspapers, and each one of them has his collection of letters stored in a stack.
One beautiful day, Morgan visited Jack and Daniel. He saw their collections. He wondered what is the lexicographically minimal string 
made of those two collections. He can take a letter from a collection only when it is on the top of the stack. Morgan wants to use all 
of the letters in their collections.
*/
public class MorganAndString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			StringBuilder s1 = new StringBuilder(input.next());
			s1.append("z");
			StringBuilder s2 = new StringBuilder(input.next());
			s2.append("z");
			StringBuilder output = new StringBuilder("");

			int i = 0, j = 0;
			while (i < s1.length() && j < s2.length()) {
				if (s1.charAt(i) < s2.charAt(j)) {
					output.append(s1.charAt(i));
					i++;
				} else if (s1.charAt(i) > s2.charAt(j)) {
					output.append(s2.charAt(j));
					j++;
				} else {
					if (s1.charAt(i) == 'z') {
						i++;
						j++;
						continue;
					}
					int startingI = i;
					int startingJ = j;
					while (s1.charAt(i) == s2.charAt(j)) {
						i++;
						j++;
						if (i >= s1.length() && j >= s2.length()) {
							i = startingI;
							j = startingJ;
							break;
						} else if (i >= s1.length()) {
							char prev = s2.charAt(startingJ);
							while (s2.charAt(startingJ) <= prev) {
								output.append(s2.charAt(startingJ));
								prev = s2.charAt(startingJ);
								startingI++;
							}
							i = startingI;
							j = startingJ;
						} else if (j >= s2.length()) {
							char prev = s1.charAt(startingI);
							while (s1.charAt(startingI) <= prev) {
								output.append(s1.charAt(startingI));
								prev = s1.charAt(startingI);
								startingI++;
							}
							i = startingI;
							j = startingJ;
						}
					}
					if (s1.charAt(i) <= s2.charAt(j)) {
						char prev = s1.charAt(startingI);
						while (s1.charAt(startingI) <= prev) {
							output.append(s1.charAt(startingI));
							prev = s1.charAt(startingI);
							startingI++;
						}
						i = startingI;
						j = startingJ;
					}
					if (s1.charAt(i) > s2.charAt(j)) {
						char prev = s2.charAt(startingJ);
						while (s2.charAt(startingJ) <= prev) {
							output.append(s2.charAt(startingJ));
							prev = s2.charAt(startingJ);
							startingJ++;
						}
						i = startingI;
						j = startingJ;
					}
				}
			}
			while (i < s1.length()) {
				output.append(s1.charAt(i));
				i++;
			}
			while (j < s2.length()) {
				output.append(s2.charAt(j));
				j++;
			}
			System.out.println(output);
		}
	}
}
